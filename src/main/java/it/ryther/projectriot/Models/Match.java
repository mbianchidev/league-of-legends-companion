package it.ryther.projectriot.Models;

import it.ryther.projectriot.API.SpectatorV4.TeamMembers;

import javax.naming.SizeLimitExceededException;

public class Match {
    private Team blueTeam;
    private Team redTeam;

    public Match() {
        this.blueTeam = new Team(TeamName.BLUE.teamId);
        this.redTeam = new Team(TeamName.RED.teamId);
    }

    public Team getBlueTeam() {
        return blueTeam;
    }

    public Team getRedTeam() {
        return redTeam;
    }

    public void addParticipant(TeamMembers participant) {
        try {
            if (participant.getTeamId() == TeamName.BLUE.teamId) {
                this.blueTeam.addMember(participant.getSummonerName());
            } else if (participant.getTeamId() == TeamName.RED.teamId) {
                this.redTeam.addMember(participant.getSummonerName());
            }
        } catch (SizeLimitExceededException | Team.MemberAlreadyPresentException e) {
            e.printStackTrace();
        }
    }
}
