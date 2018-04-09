package com.hivescm.scm.client.convert;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * @Author:
 * @Description: 对象装换
 * @Date: 2018/4/9 13:55
 */
public final class EssearchConvertor {
    private static final String BASIC_DATA_TYPE = "java.";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Map<Object, Object> object2Map(Object obj)
            throws IOException
    {
        return illegal(obj) ? null : (Map)objectMapper.readValue(objectMapper.writeValueAsString(obj), Map.class);
    }

    public static <T> T map2Object(Map<Object, Object> map, Class<T> t)
            throws IOException
    {
        return map == null ? null : objectMapper.readValue(objectMapper.writeValueAsString(map), t);
    }

    public static String object2Json(Object obj)
            throws IOException
    {
        return obj == null ? null : objectMapper.writeValueAsString(obj);
    }

    public static <T> T json2Object(String jsonStr, Class<T> t)
            throws IOException
    {
        return objectMapper.readValue(jsonStr, t);
    }

    private static boolean illegal(Object obj)
    {
        return (null == obj) || (basicDataType(obj));
    }

    private static boolean basicDataType(Object obj)
    {
        return obj.getClass().getName().startsWith("java.");
    }
}
