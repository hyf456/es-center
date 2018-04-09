package com.hivescm.scm.client.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author:
 * @Description: 保存实体
 * @Date: 2018/4/9 14:06
 */
@Data
public class SaveESObject extends BaseESObject implements Serializable {
    private static final long serialVersionUID = -8243407744202552841L;

    private String operateType;
    private Map<String, String> ukMap;
    private Map<String, Object> dataMap;
    private Map<String, Class> typeMap;

}
