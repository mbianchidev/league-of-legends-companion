package it.ryther.projectriot.API.Queues;

import com.google.common.base.MoreObjects;

public class Queue {
    private long queueId;
    private String map;
    private String description;
    private String notes;

    public long getQueueId() {
        return queueId;
    }

    public void setQueueId(long queueId) {
        this.queueId = queueId;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("queueId", queueId)
                .add("map", map)
                .add("description", description)
                .add("notes", notes)
                .toString();
    }
}
