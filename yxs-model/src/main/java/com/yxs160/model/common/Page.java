package com.yxs160.model.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Page implements Serializable{
    private static final long serialVersionUID = -764782212679203445L;
    private int page = 1;
    private int limit =10;

    private String keyword;
    private Map range = new HashMap();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = (page -1)*limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.page = limit*this.page;
        this.limit = limit;
    }

    public Map getRange() {
        return range;
    }

    public void setRange(Map range) {
        this.range = range;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", limit=" + limit +
                ", keyword='" + keyword + '\'' +
                ", range=" + range +
                '}';
    }
}
