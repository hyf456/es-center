package com.hivescm.scm.client.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:
 * @Description: 基础实体
 * @Date: 2018/4/9 13:58
 */
@Data
public class BaseESObject implements Serializable {
    private static final long serialVersionUID = 5273467846506715845L;

    private String indexName;
    private String typeName;

}
