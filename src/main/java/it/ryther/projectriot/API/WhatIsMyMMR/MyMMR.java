package it.ryther.projectriot.API.WhatIsMyMMR;

import com.google.common.base.MoreObjects;

public class MyMMR {
    private MyMMRRanked ranked;
    private MyMMRQueue normal;
    private MyMMRQueue aram;

    public MyMMRRanked getRanked() {
        return ranked;
    }

    public void setRanked(MyMMRRanked ranked) {
        this.ranked = ranked;
    }

    public MyMMRQueue getNormal() {
        return normal;
    }

    public void setNormal(MyMMRQueue normal) {
        this.normal = normal;
    }

    public MyMMRQueue getAram() {
        return aram;
    }

    public void setAram(MyMMRQueue aram) {
        this.aram = aram;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("ranked", ranked)
                .add("normal", normal)
                .add("aram", aram)
                .toString();
    }
}
