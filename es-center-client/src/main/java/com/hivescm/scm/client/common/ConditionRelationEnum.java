package com.hivescm.scm.client.common;

/**
 * @Author:
 * @Description: 与或
 * @Date: 2018/4/9 14:02
 */
public enum  ConditionRelationEnum {
    AND(1, "与"), OR(2, "或");

    private int order;
    private String desc;

    private ConditionRelationEnum(int order, String desc) {
    }

    public int getOrder() {
        return this.order;
    }

    public String getDesc() {
        return this.desc;
    }
}
