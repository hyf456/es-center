package com.hivescm.scm.service.common.bean;

import lombok.Data;

import java.beans.ConstructorProperties;
import java.io.Serializable;

/**
 * @Author:
 * @Description: 分页
 * @Date: 2018/4/9 14:25
 */
@Data
public class Page implements Serializable {

    private static final long serialVersionUID = 8837560319353017879L;
    private Integer currentPage;
    private Integer pageSize;
    private Long totalDocs;
    public void setCurrentPage(Integer currentPage)
    {
        this.currentPage = currentPage; }
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }
    public void setTotalDocs(Long totalDocs) { this.totalDocs = totalDocs; }
    public boolean equals(Object o) { if (o == this) return true; if (!(o instanceof Page)) return false; Page other = (Page)o; if (!other.canEqual(this)) return false; Object this$currentPage = getCurrentPage(); Object other$currentPage = other.getCurrentPage(); if (this$currentPage == null ? other$currentPage != null : !this$currentPage.equals(other$currentPage)) return false; Object this$pageSize = getPageSize(); Object other$pageSize = other.getPageSize(); if (this$pageSize == null ? other$pageSize != null : !this$pageSize.equals(other$pageSize)) return false; Object this$totalDocs = getTotalDocs(); Object other$totalDocs = other.getTotalDocs(); return this$totalDocs == null ? other$totalDocs == null : this$totalDocs.equals(other$totalDocs); }
    protected boolean canEqual(Object other) { return other instanceof Page; }
    public int hashCode() { int PRIME = 59; int result = 1; Object $currentPage = getCurrentPage(); result = result * 59 + ($currentPage == null ? 43 : $currentPage.hashCode()); Object $pageSize = getPageSize(); result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode()); Object $totalDocs = getTotalDocs(); return result * 59 + ($totalDocs == null ? 43 : $totalDocs.hashCode()); }
    public String toString() { return "Page(currentPage=" + getCurrentPage() + ", pageSize=" + getPageSize() + ", totalDocs=" + getTotalDocs() + ")"; }
    public Page() {  }
    @ConstructorProperties({"currentPage", "pageSize", "totalDocs"})
    public Page(Integer currentPage, Integer pageSize, Long totalDocs) { this.currentPage = currentPage; this.pageSize = pageSize; this.totalDocs = totalDocs;
    }
}
