package com.nantian.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JacksonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T json2Object(String json, Class<T> clazz){

        System.out.println("需要转换的json：" + json);

        T t = null;

        try {
            t = objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("jackson 执行失败");
        }

        return t;

    }

    public static String object2Jsonstr(Object obj){

        String objStr = "";
        try {
            objStr = objectMapper.writeValueAsString(obj);

            System.out.println(obj.getClass().getSimpleName() + ":" + objStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return objStr;
    }

    public static Map json2Map(String jsonStr){
        Map map = null;
        System.out.println(jsonStr);
        try{
            map = objectMapper.readValue(jsonStr, Map.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    public static <T> List<T> json2List(String str, Class<T> clazz){

        List<T> result= null;

        JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);

        try {
            result = objectMapper.readValue(str, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
