package com.myopttest.opttest.domain;

public class PageObject {

    private Integer pageNo;

    private Integer pageCount;

    private Integer pageTotal;

    private Integer pageOffSetCount;

    private Object result;

    public PageObject(Integer pageNo, Integer pageCount){
        this.pageNo = pageNo;
        this.pageCount = pageCount;
        this.pageOffSetCount = (pageNo - 1) * pageCount;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageOffSetCount() {
        return pageOffSetCount;
    }

    public void setPageOffSetCount(Integer pageOffSetCount) {
        this.pageOffSetCount = pageOffSetCount;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
