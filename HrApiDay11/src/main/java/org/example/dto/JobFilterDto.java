package org.example.dto;

import jakarta.ws.rs.QueryParam;

public class JobFilterDto {
    private @QueryParam("minsalary") Integer minsalary;
    private @QueryParam("limit") Integer limit;
    private @QueryParam("offset") int offset;

    public Integer getMinsalary() {
        return minsalary;
    }

    public void setMinsalary(Integer minsalary) {
        this.minsalary = minsalary;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
