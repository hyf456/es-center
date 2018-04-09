package com.hivescm.scm.service.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Author:
 * @Description: 返回值
 * @Date: 2018/4/9 14:24
 */
@Data
public class ESResponse implements Serializable {
    private static final long serialVersionUID = -5906644542314715888L;
    private List<Map<String, Object>> esDocuments;
    private Map<String, Object> resultMap;
    private Map<String, List<Map<String, Object>>> countResult;
    private Page pageCondition;

}
