package com.hivescm.scm.client.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author:
 * @Description: 文档
 * @Date: 2018/4/9 14:03
 */
@Data
public class ESDocument implements Serializable {
    private static final long serialVersionUID = -940039411247361305L;
    private Map<String, String> ukMap;
    private Map<String, Object> dataMap;
}
