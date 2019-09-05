package com.thhy.fixedassets.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> {

    private Integer pageNo;

    private Integer pageCount;

    private Integer offSetCount;

    private Integer totalCount;

    private List<T> results = new ArrayList<>();

    private Map<String,Object> values = new HashMap<>();

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

    public Integer getOffSetCount() {
        return offSetCount;
    }

    public void setOffSetCount(Integer offSetCount) {
        this.offSetCount = offSetCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public Map<String, Object> getValues() {
        return values;
    }

    public void setValues(Map<String, Object> values) {
        this.values = values;
    }
}
