package it.ryther.projectriot.API.WhatIsMyMMR;

import com.google.common.base.MoreObjects;

public class MyMMRRanked extends MyMMRQueue {
    private String summary;
    private MyMMRTierData[] tierData;
    private MyMMRQueue[] historical;
    private MyMMRHistoricalTierData[] historicalTierData;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public MyMMRTierData[] getTierData() {
        return tierData;
    }

    public void setTierData(MyMMRTierData[] tierData) {
        this.tierData = tierData;
    }

    public MyMMRQueue[] getHistorical() {
        return historical;
    }

    public void setHistorical(MyMMRQueue[] historical) {
        this.historical = historical;
    }

    public MyMMRHistoricalTierData[] getHistoricalTierData() {
        return historicalTierData;
    }

    public void setHistoricalTierData(MyMMRHistoricalTierData[] historicalTierData) {
        this.historicalTierData = historicalTierData;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("summary", summary)
                .add("tierData", tierData)
                .add("historical", historical)
                .add("historicalTierData", historicalTierData)
                .toString();
    }
}
