package it.ryther.projectriot.API.WhatIsMyMMR;

import com.google.common.base.MoreObjects;

public class MyMMRHistoricalTierData extends MyMMRTierData {
    private long avgCount;

    public long getAvgCount() {
        return avgCount;
    }

    public void setAvgCount(long avgCount) {
        this.avgCount = avgCount;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("avgCount", avgCount)
                .toString();
    }
}
