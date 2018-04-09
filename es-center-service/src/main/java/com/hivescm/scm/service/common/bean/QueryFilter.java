package com.hivescm.scm.service.common.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:
 * @Description: 过滤条件实体
 * @Date: 2018/4/9 14:26
 */
public class QueryFilter {

    public static QueryObject eq(String key, Object value)
    {
        return new QueryObject("eq", key, value);
    }

    public static QueryObject ne(String key, Object value) {
        return new QueryObject("ne", key, value);
    }

    public static QueryObject lt(String key, Object value) {
        return new QueryObject("lt", key, value);
    }

    public static QueryObject lte(String key, Object value) {
        return new QueryObject("lte", key, value);
    }

    public static QueryObject gt(String key, Object value) {
        return new QueryObject("gt", key, value);
    }

    public static QueryObject gte(String key, Object value) {
        return new QueryObject("gte", key, value);
    }

    public static QueryObject like(String key, Object value) {
        return new QueryObject("like", key, value);
    }

    public static QueryObject in(String key, Object value) {
        if (((value instanceof List)) || ((value instanceof Object[]))) {
            return new QueryObject("in", key, value);
        }
        throw new IllegalArgumentException("in方法的value值必须是数组类型或者集合类型");
    }

    public static QueryObject nin(String key, Object value) {
        if (((value instanceof List)) || ((value instanceof Object[]))) {
            return new QueryObject("nin", key, value);
        }
        throw new IllegalArgumentException("nin方法的value值必须是数组类型或者集合类型");
    }

    public static QueryObject and(QueryObject[] baseObjects) {
        List list = new ArrayList();
        for (QueryObject object : baseObjects) {
            list.add(object);
        }
        return new QueryObject(new MultiQueryObject("and", list));
    }

    public static QueryObject or(QueryObject[] baseObjects) {
        List list = new ArrayList();
        for (QueryObject object : baseObjects) {
            list.add(object);
        }
        return new QueryObject(new MultiQueryObject("or", list));
    }
}
