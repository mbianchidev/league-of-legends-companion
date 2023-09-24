package it.ryther.projectriot.API.SpectatorV4;

import com.google.common.base.MoreObjects;

import java.util.List;

public class Spectator {
    private long gameId;                          // The ID of the game
    private String gameType;                      // The game type
    private long gameStartTime;                   // The game start time represented in epoch milliseconds
    private long mapId;                           // The ID of the map
    private long gameLength;                      // The amount of time in seconds that has passed since the game started
    private String platformId;                    // The ID of the platform on which the game is being played
    private String gameMode;                      // The game mode
    private List<BannedChampion> bannedChampions; // [BannedChampion]	Banned champion information
    private long gameQueueConfigId;               // The queue type (queue types are documented on the Game Constants page)
    private Observer observers;                   // The observer information
    private List<TeamMembers> participants;      // [CurrentGameParticipant]	The participant information

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public long getGameStartTime() {
        return gameStartTime;
    }

    public void setGameStartTime(long gameStartTime) {
        this.gameStartTime = gameStartTime;
    }

    public long getMapId() {
        return mapId;
    }

    public void setMapId(long mapId) {
        this.mapId = mapId;
    }

    public long getGameLength() {
        return gameLength;
    }

    public void setGameLength(long gameLength) {
        this.gameLength = gameLength;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public List<BannedChampion> getBannedChampions() {
        return bannedChampions;
    }

    public void setBannedChampions(List<BannedChampion> bannedChampions) {
        this.bannedChampions = bannedChampions;
    }

    public long getGameQueueConfigId() {
        return gameQueueConfigId;
    }

    public void setGameQueueConfigId(long gameQueueConfigId) {
        this.gameQueueConfigId = gameQueueConfigId;
    }

    public Observer getObservers() {
        return observers;
    }

    public void setObservers(Observer observers) {
        this.observers = observers;
    }

    public List<TeamMembers> getParticipants() {
        return participants;
    }

    public void setParticipants(List<TeamMembers> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("gameId", gameId)
                .add("gameType", gameType)
                .add("gameStartTime", gameStartTime)
                .add("mapId", mapId)
                .add("gameLength", gameLength)
                .add("platformId", platformId)
                .add("gameMode", gameMode)
                .add("bannedChampions", bannedChampions)
                .add("gameQueueConfigId", gameQueueConfigId)
                .add("observers", observers)
                .add("participants", participants)
                .toString();
    }
}
