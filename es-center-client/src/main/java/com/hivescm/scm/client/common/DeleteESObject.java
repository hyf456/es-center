package com.hivescm.scm.client.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author:
 * @Description: 删除对象
 * @Date: 2018/4/9 14:03
 */
@Data
public class DeleteESObject extends BaseESObject implements Serializable {
    private static final long serialVersionUID = -8394350848766801416L;

    private Map<Object, Object> deleteConditions;
}
