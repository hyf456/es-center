package com.hivescm.scm.client.common;

/**
 * @Author:
 * @Description: 符号enum
 * @Date: 2018/4/9 14:01
 */
public enum  ConditionExpressionEnum {

    EQUAL(1, "等于"),

    UNEQUAL(2, "不等"),

    GREATER(3, "大于"),

    GREATER_OR_EQUAL(4, "大于等于"),

    LESSER(5, "小于"),

    LESSER_OR_EQUAL(6, "小于等于");

    private int order;
    private String desc;

    private ConditionExpressionEnum(int order, String desc) {
    }

    public int getOrder() {
        return this.order;
    }

    public String getDesc() {
        return this.desc;
    }
}
