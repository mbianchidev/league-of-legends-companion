package it.ryther.projectriot.Models;

public enum TeamName {
    BLUE(100, "blue"),
    RED(200, "red");

    public long teamId;
    public String name;

    TeamName(long teamId, String name) {
        this.teamId = teamId;
        this.name = name;
    }
}
