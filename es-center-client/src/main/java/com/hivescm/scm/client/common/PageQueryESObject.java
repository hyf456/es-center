package com.hivescm.scm.client.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:
 * @Description: 分页实体
 * @Date: 2018/4/9 14:05
 */
@Data
public class PageQueryESObject extends QueryESObject implements Serializable {

    private static final long serialVersionUID = 2813367872697761050L;
    private int pageSize;
    private int currentPage;
    private int totalPages;
    private int totals;
}
