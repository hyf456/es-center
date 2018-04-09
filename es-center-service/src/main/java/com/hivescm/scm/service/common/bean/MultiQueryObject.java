package com.hivescm.scm.service.common.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:
 * @Description: 多条件实体
 * @Date: 2018/4/9 14:26
 */
@Data
public class MultiQueryObject implements Serializable {
    private static final long serialVersionUID = 7834690938850766736L;

    private String flag;
    private List<QueryObject> baseObjectList = new ArrayList();

    public MultiQueryObject() {
    }

    public MultiQueryObject(String flag, List<QueryObject> baseObjectList) {
        this.flag = flag;
        this.baseObjectList = baseObjectList;
    }

    public List<QueryObject> getQueryObjectList() {
        return this.baseObjectList;
    }
}
