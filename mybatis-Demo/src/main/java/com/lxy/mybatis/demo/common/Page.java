package com.lxy.mybatis.demo.common;

public class Page {
    private Integer pageNumber = 1;
    private Integer pageSize = 2;
    private Integer pageOffset = (this.pageNumber - 1) * this.pageSize;
    private String orderColumnName;

    public String getOrderColumnName() {
        return orderColumnName;
    }

    public void setOrderColumnName(String orderColumnName) {
        this.orderColumnName = orderColumnName;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageOffser() {
        pageOffset = (this.pageNumber - 1) * this.pageSize;
        return pageOffset;
    }

    public void setPageOffser(Integer pageOffser) {
        this.pageOffset = pageOffser;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", pageOffser=" + pageOffset +
                ", orderColumnName='" + orderColumnName + '\'' +
                '}';
    }
}
