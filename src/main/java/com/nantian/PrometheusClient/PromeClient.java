package com.nantian.PrometheusClient;


import com.nantian.entity.LabelValuesEntity;
import com.nantian.entity.PromeResultEntity;
import com.nantian.entity.UrlParams;
import com.nantian.enums.PromeInfoEnum;

public class PromeClient {

    private PromeHttpClient client;

    public PromeClient(){
        this(null, null);
    }

    public PromeClient(String url){
        this(url, null);
    }

    public PromeClient(String url, String path){

        if (url != null){
            PromeInfoEnum.URL.setValue(url);
        }

        if (path != null){
            PromeInfoEnum.PATH.setValue(path);
        }

        client = new PromeHttpClient();
    }

    /**
     * 通过GET方式，查询一段时间内的指标值
     * @param params
     * @return
     */
    public PromeResultEntity query_range_get(UrlParams params){

        PromeResultEntity resultEntity = null;

        try{
            resultEntity = httpClient_get(PromeInfoEnum.QUERY_RANGE, params, PromeResultEntity.class);
        }catch (Exception e){
            e.printStackTrace();
            resultEntity.setStatus("error");
            resultEntity.setErrorType("client error");
            resultEntity.setError(e.getMessage());
        }

        return resultEntity;
    }

    /**
     * 通过POST方式，查询一段时间内的指标值
     * @param params
     * @return
     */
    public PromeResultEntity query_range_post(UrlParams params){

        PromeResultEntity resultEntity = null;

        try{
            resultEntity = httpClient_post(PromeInfoEnum.QUERY_RANGE, params, PromeResultEntity.class);
        }catch (Exception e){
            e.printStackTrace();
            resultEntity.setStatus("error");
            resultEntity.setErrorType("client error");
            resultEntity.setError(e.getMessage());
        }

        return resultEntity;
    }

    /**
     * 通过GET方式，查询一个时间点上的指标值
     * @param params
     * @return
     */
    public PromeResultEntity query_get(UrlParams params){

        PromeResultEntity resultEntity = null;

        try{
            resultEntity = httpClient_get(PromeInfoEnum.QUERY, params, PromeResultEntity.class);
        }catch (Exception e){
            e.printStackTrace();
            resultEntity.setStatus("error");
            resultEntity.setErrorType("client error");
            resultEntity.setError(e.getMessage());
        }

        return resultEntity;
        
    }

    /**
     * 通过POST方式，查询一个时间点上的指标值
     * @param params
     * @return
     */
    public PromeResultEntity query_post(UrlParams params){

        PromeResultEntity resultEntity = null;

        try{
            resultEntity = httpClient_post(PromeInfoEnum.QUERY, params, PromeResultEntity.class);
        }catch (Exception e){
            e.printStackTrace();
            resultEntity.setStatus("error");
            resultEntity.setErrorType("client error");
            resultEntity.setError(e.getMessage());
        }

        return resultEntity;
    }

    /**
     * 查询活跃的告警信息
     * @return
     */
    public PromeResultEntity alerts(){

        PromeResultEntity resultEntity = null;

        try{
            resultEntity = httpClient_get(PromeInfoEnum.ALERTS, null, PromeResultEntity.class);
        }catch (Exception e){
            e.printStackTrace();
            resultEntity.setStatus("error");
            resultEntity.setErrorType("client error");
            resultEntity.setError(e.getMessage());
        }

        return resultEntity;

    }

    /**
     * 查询指定标签的值
     * @param labelName
     * @return
     */
    public LabelValuesEntity labelsValue(String labelName){

        LabelValuesEntity entity = null;

        try{

            String path = PromeInfoEnum.LABELS_VALUE.getValue().replace("&labelName&", labelName);
            entity = httpClient_label(path);

        }catch (Exception e){
            e.printStackTrace();
            entity.setStatus("error");
            entity.setErrorType("client error");
            entity.setError(e.getMessage());
        }

        return entity;

    }

    private <T> T httpClient_get(PromeInfoEnum methodType, UrlParams params, Class<T> clazz) throws Exception{

        StringBuilder sb = new StringBuilder();
        sb.append(PromeInfoEnum.URL.getValue());
        sb.append(PromeInfoEnum.PATH.getValue());
        sb.append(methodType.getValue());

        String path = sb.toString();

        return client.get(path, params, clazz);
    }

    private <T> T httpClient_post(PromeInfoEnum methodType, UrlParams params, Class<T> clazz) throws Exception{

        StringBuilder sb = new StringBuilder();
        sb.append(PromeInfoEnum.URL.getValue());
        sb.append(PromeInfoEnum.PATH.getValue());
        sb.append(methodType.getValue());

        String path = sb.toString();

        return client.post(path, params, clazz);

    }

    private LabelValuesEntity httpClient_label(String labelPath) throws Exception{

        StringBuilder sb = new StringBuilder();
        sb.append(PromeInfoEnum.URL.getValue());
        sb.append(PromeInfoEnum.PATH.getValue());
        sb.append(labelPath);

        String path = sb.toString();

        return client.get(path, null, LabelValuesEntity.class);

    }

    public static void main(String[] args){

        UrlParams params = new UrlParams();
        params.setQuery("100 - (avg by (instance) (irate(node_cpu{instance=\"10.10.47.12:9100\", mode=\"idle\"}[5m])) * 100)");
        params.setStart("1560243615");
        params.setEnd("1560244590");
        params.setStep("15");

        PromeClient client = new PromeClient();
//        PromeResultEntity resultEntity = client.query_range_post(params);
//        System.out.println(resultEntity.getStatus());

        LabelValuesEntity entity = client.labelsValue("__name__");
        System.out.println(entity.getStatus());

    }

    /**
     * 关闭请求连接
     */
    public void close(){
        client.close();
    }

}
