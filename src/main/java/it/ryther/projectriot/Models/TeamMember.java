package it.ryther.projectriot.Models;

public class TeamMember implements Cloneable {
    private String summonerName;
    private long rankedMmr;
    private long normalMmr;
    private long aramMmr;

    public TeamMember(String summonerName) {
        this.summonerName = summonerName;
    }

    public TeamMember(String summonerName, long rankedMmr, long normalMmr, long aramMmr) {
        this.summonerName = summonerName;
        this.rankedMmr = rankedMmr;
        this.normalMmr = normalMmr;
        this.aramMmr = aramMmr;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public long getRankedMmr() {
        return rankedMmr;
    }

    public void setRankedMmr(long rankedMmr) {
        this.rankedMmr = rankedMmr;
    }

    public long getNormalMmr() {
        return normalMmr;
    }

    public void setNormalMmr(long normalMmr) {
        this.normalMmr = normalMmr;
    }

    public long getAramMmr() {
        return aramMmr;
    }

    public void setAramMmr(long aramMmr) {
        this.aramMmr = aramMmr;
    }
}
