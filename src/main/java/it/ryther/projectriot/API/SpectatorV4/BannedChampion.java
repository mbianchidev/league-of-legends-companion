package it.ryther.projectriot.API.SpectatorV4;

import com.google.common.base.MoreObjects;

public class BannedChampion {
    private int pickTurn;	 //The turn during which the champion was banned
    private long championId; //The ID of the banned champion
    private long teamId;	 //The ID of the team that banned the champion

    public int getPickTurn() {
        return pickTurn;
    }

    public void setPickTurn(int pickTurn) {
        this.pickTurn = pickTurn;
    }

    public long getChampionId() {
        return championId;
    }

    public void setChampionId(long championId) {
        this.championId = championId;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("pickTurn", pickTurn)
                .add("championId", championId)
                .add("teamId", teamId)
                .toString();
    }
}
