package com.hivescm.scm.client.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:
 * @Description: 搜索返回实体
 * @Date: 2018/4/9 14:04
 */
@Data
public class ESQueryResponse extends BaseESObject implements Serializable {
    private static final long serialVersionUID = -7636289566082247594L;

    private List<ESDocument> esDocuments;
}
