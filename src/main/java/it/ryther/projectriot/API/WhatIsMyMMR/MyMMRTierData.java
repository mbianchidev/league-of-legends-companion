package it.ryther.projectriot.API.WhatIsMyMMR;

import com.google.common.base.MoreObjects;

public class MyMMRTierData {
    private String name;
    private long avg;
    private long min;
    private long max;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAvg() {
        return avg;
    }

    public void setAvg(long avg) {
        this.avg = avg;
    }

    public long getMin() {
        return min;
    }

    public void setMin(long min) {
        this.min = min;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("avg", avg)
                .add("min", min)
                .add("max", max)
                .toString();
    }
}
