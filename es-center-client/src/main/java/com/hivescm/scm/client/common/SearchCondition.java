package com.hivescm.scm.client.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:
 * @Description: 搜索参数实体
 * @Date: 2018/4/9 14:06
 */
@Data
public class SearchCondition implements Serializable {
    private static final long serialVersionUID = 7465211994665306666L;

    private String fieldName;
    private String fieldValue;
    private int expression;

    public SearchCondition()
    {
    }

    public SearchCondition(String fieldName, String fieldValue, int expression)
    {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.expression = expression;
    }
}
