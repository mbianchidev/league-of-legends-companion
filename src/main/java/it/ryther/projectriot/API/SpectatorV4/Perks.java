package it.ryther.projectriot.API.SpectatorV4;

import com.google.common.base.MoreObjects;

import java.util.List;

public class Perks {
    private List<Long> perkIds;  // IDs of the perks/runes assigned.
    private long perkStyle;        // Primary runes path
    private long perkSubStyle;     // Secondary runes path

    public List<Long> getPerkIds() {
        return perkIds;
    }

    public void setPerkIds(List<Long> perkIds) {
        this.perkIds = perkIds;
    }

    public long getPerkStyle() {
        return perkStyle;
    }

    public void setPerkStyle(long perkStyle) {
        this.perkStyle = perkStyle;
    }

    public long getPerkSubStyle() {
        return perkSubStyle;
    }

    public void setPerkSubStyle(long perkSubStyle) {
        this.perkSubStyle = perkSubStyle;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("perkIds", perkIds)
                .add("perkStyle", perkStyle)
                .add("perkSubStyle", perkSubStyle)
                .toString();
    }
}
