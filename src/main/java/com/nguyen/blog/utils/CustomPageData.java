package com.nguyen.blog.utils;

import java.util.List;

public class CustomPageData <T>{
    private long count;
    private List<T> rows;

    public CustomPageData(long count, List<T> rows) {
        this.count = count;
        this.rows = rows;
    }

    // Getters and setters
    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}


