package it.ryther.projectriot.API.WhatIsMyMMR;

import com.google.common.base.MoreObjects;

public class MyMMRQueue {
    private long avg;
    private long err;
    private boolean warn;
    private long timestamp;

    public long getAvg() {
        return avg;
    }

    public void setAvg(long avg) {
        this.avg = avg;
    }

    public long getErr() {
        return err;
    }

    public void setErr(long err) {
        this.err = err;
    }

    public boolean isWarn() {
        return warn;
    }

    public void setWarn(boolean warn) {
        this.warn = warn;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("avg", avg)
                .add("err", err)
                .add("warn", warn)
                .add("timestamp", timestamp)
                .toString();
    }
}
