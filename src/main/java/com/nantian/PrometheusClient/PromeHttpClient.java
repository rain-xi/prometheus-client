package com.nantian.PrometheusClient;

import com.nantian.entity.UrlParams;
import com.nantian.utils.JacksonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PromeHttpClient {

    private CloseableHttpClient client;
    private URIBuilder uriBuilder;

    public PromeHttpClient() {
        client = HttpClients.createDefault();
    }

    public <T> T get(String path, UrlParams params, Class<T> clazz) throws Exception{

        T t = null;

        uriBuilder = new URIBuilder(path);
        uriBuilder.addParameters(this.transParams(params));

        HttpGet get = new HttpGet(uriBuilder.build());
        get.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");

        CloseableHttpResponse response = client.execute(get);

        int resultCode = response.getStatusLine().getStatusCode();

        if (resultCode == 200 || resultCode == 400){

            HttpEntity entity = response.getEntity();
            String str = EntityUtils.toString(entity, "UTF-8");
            
            t = JacksonUtil.json2Object(str, clazz);
        }

        return t;

    }

    public <T> T post(String path, UrlParams params, Class<T> clazz) throws Exception {

        T t = null;

        HttpPost post = new HttpPost(path);
        StringEntity entity = new UrlEncodedFormEntity(this.transParams(params), "UTF-8");
        post.setEntity(entity);
        post.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");

        CloseableHttpResponse response = client.execute(post);

        int resultCode = response.getStatusLine().getStatusCode();
        if (resultCode == 200 || resultCode == 400){

            HttpEntity responseEntity = response.getEntity();
            String responseBody = EntityUtils.toString(responseEntity, "UTF-8");

            t = JacksonUtil.json2Object(responseBody, clazz);

        }

        return t;
    }

    private List<NameValuePair> transParams(UrlParams params){

        String jsonStr = JacksonUtil.object2Jsonstr(params);
        Map<String, String> paramMap = JacksonUtil.json2Map(jsonStr);

        List<NameValuePair> nameValuePairs = new ArrayList<>();

        paramMap.forEach((k, y)->{

            NameValuePair valuePair = new BasicNameValuePair(k, y);
            nameValuePairs.add(valuePair);

        });

        return nameValuePairs;
    }

}
