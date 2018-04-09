package com.hivescm.scm.client.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:
 * @Description:
 * @Date: 2018/4/9 14:00
 */
@Data
public class ComplicatedESQuery extends BaseESObject implements Serializable {
    private static final long serialVersionUID = 6437472638136278317L;

    private boolean leftGroupStart;
    private boolean leftGroupOver;
    private int expression;
    private String fieldName;
    private String fieldValue;
    private boolean rightGroupEnd;
    private boolean rightGroupOver;
    private ComplicatedESQuery nextCondition;

    public static class Builder
    {
        public static Builder builder()
        {
            return null;
        }
    }
}
