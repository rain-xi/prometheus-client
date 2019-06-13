package com.nantian;

import com.nantian.PrometheusClient.PromeClient;
import com.nantian.entity.PromeResultEntity;
import com.nantian.entity.UrlParams;
import com.nantian.utils.JacksonUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        String  json = "{\n" +
                "  \"status\": \"success\",\n" +
                "  \"data\": {\n" +
                "    \"resultType\": \"matrix\",\n" +
                "    \"result\": [\n" +
                "      {\n" +
                "        \"metric\": {\n" +
                "          \"instance\": \"10.10.47.12:9100\"\n" +
                "        },\n" +
                "        \"values\": [\n" +
                "          [\n" +
                "            1560243615,\n" +
                "            \"3.2687499999883585\"\n" +
                "          ],\n" +
                "          [\n" +
                "            1560244020,\n" +
                "            \"8.329166666856807\"\n" +
                "          ],\n" +
                "          [\n" +
                "            1560244590,\n" +
                "            \"1.4937499997904524\"\n" +
                "          ]\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";

        PromeResultEntity entity = JacksonUtil.json2Object(json, PromeResultEntity.class);
        System.out.println(entity.getData().getResultType());

        UrlParams params = new UrlParams();
        params.setQuery("100 - (avg by (instance) (irate(node_cpu{instance=\"10.10.47.12:9100\", mode=\"idle\"}[5m])) * 100)");
        params.setStart("1560243615");
        params.setEnd("1560244590");
        params.setStep("15");

        PromeClient client = new PromeClient();
        PromeResultEntity resultEntity = client.query_range_get(params);
        System.out.println(resultEntity.getStatus());



    }
}
