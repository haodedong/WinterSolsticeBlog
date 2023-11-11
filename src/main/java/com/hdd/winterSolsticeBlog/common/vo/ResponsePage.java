package com.hdd.winterSolsticeBlog.common.vo;


import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 分页通用返回体
 *
 * @param <T>
 * @author haodedong
 */
public class ResponsePage<T> {
    private int page;
    private int pages;
    private int size;
    private long total;
    private List<T> pageData;

    public ResponsePage(List<T> data) {
        PageInfo<T> pageInfo = new PageInfo<>(data);
        this.pages = pageInfo.getPages();
        this.page = pageInfo.getPageNum();
        this.size = pageInfo.getPageSize();
        this.total = pageInfo.getTotal();
        this.pageData = data;
    }

    public ResponsePage() {

    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> data) {
        this.pageData = data;
    }
}
