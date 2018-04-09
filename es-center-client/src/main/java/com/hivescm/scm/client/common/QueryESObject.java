package com.hivescm.scm.client.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:
 * @Description: 搜索实体
 * @Date: 2018/4/9 14:05
 */
@Data
public class QueryESObject extends BaseESObject implements Serializable {
    private static final long serialVersionUID = -6545499203729939355L;

    private int queryRelation;
    private List<SearchCondition> searchConditions;
    private List<String> orderConditions;

}
