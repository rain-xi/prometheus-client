package com.nantian.PrometheusClient;

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

}
