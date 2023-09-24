package it.ryther.projectriot.API.SpectatorV4;

import com.google.common.base.MoreObjects;

import java.util.List;

public class TeamMembers {
    private long championId;		                                 // The ID of the champion played by this participant
    private Perks perks;		                                     // Perks/Runes Reforged Information
    private long profileIconId;		                                 // The ID of the profile icon used by this participant
    private boolean bot;		                                     // Flag indicating whether or not this participant is a bot
    private long teamId;		                                     // The team ID of this participant, indicating the participant's team
    private String summonerName;		                             // The summoner name of this participant
    private String summonerId;		                                 // The encrypted summoner ID of this participant
    private long spell1Id;		                                     // The ID of the first summoner spell used by this participant
    private long spell2Id;		                                     // The ID of the second summoner spell used by this participant
    private List<GameCustomizationObject> gameCustomizationObjects;  // List of Game Customizations

    public long getChampionId() {
        return championId;
    }

    public void setChampionId(long championId) {
        this.championId = championId;
    }

    public Perks getPerks() {
        return perks;
    }

    public void setPerks(Perks perks) {
        this.perks = perks;
    }

    public long getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(long profileIconId) {
        this.profileIconId = profileIconId;
    }

    public boolean isBot() {
        return bot;
    }

    public void setBot(boolean bot) {
        this.bot = bot;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    public long getSpell1Id() {
        return spell1Id;
    }

    public void setSpell1Id(long spell1Id) {
        this.spell1Id = spell1Id;
    }

    public long getSpell2Id() {
        return spell2Id;
    }

    public void setSpell2Id(long spell2Id) {
        this.spell2Id = spell2Id;
    }

    public List<GameCustomizationObject> getGameCustomizationObjects() {
        return gameCustomizationObjects;
    }

    public void setGameCustomizationObjects(List<GameCustomizationObject> gameCustomizationObjects) {
        this.gameCustomizationObjects = gameCustomizationObjects;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("championId", championId)
                .add("perks", perks)
                .add("profileIconId", profileIconId)
                .add("bot", bot)
                .add("teamId", teamId)
                .add("summonerName", summonerName)
                .add("summonerId", summonerId)
                .add("spell1Id", spell1Id)
                .add("spell2Id", spell2Id)
                .add("gameCustomizationObjects", gameCustomizationObjects)
                .toString();
    }
}
