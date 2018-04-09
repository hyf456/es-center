package com.hivescm.scm.service.common.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:
 * @Description: 条件对象
 * @Date: 2018/4/9 14:27
 */
@Data
public class QueryObject implements Serializable {
    private static final long serialVersionUID = -6432584160678093811L;

    private String flag;
    private String key;
    private Object value;
    private MultiQueryObject multiQueryObject;

    public QueryObject()
    {
    }

    public QueryObject(String flag, String key, Object value)
    {
        this.flag = flag;
        this.key = key;
        this.value = value;
    }

    public QueryObject(MultiQueryObject multiQueryObject) {
        this.multiQueryObject = multiQueryObject;
    }

}
