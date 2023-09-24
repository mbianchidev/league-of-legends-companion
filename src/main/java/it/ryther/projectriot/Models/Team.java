package it.ryther.projectriot.Models;

import it.ryther.projectriot.Controller.TeamMemberController;

import javax.naming.SizeLimitExceededException;
import java.util.ArrayList;
import java.util.List;

public class Team {

    public static final int TEAM_SIZE = 5;
    private TeamName teamName;
    private List<TeamMember> teamMembers = new ArrayList<>();
    private int effectiveTeamSize;
    private long totalMmr;
    private long averageMmr;

    public Team(long teamId) {
        this.totalMmr = 0;
        this.averageMmr = 0;
        for (TeamName teamName : TeamName.values()) {
            if (teamName.teamId == teamId) this.teamName = teamName;
        }
    }

    public void addMember(String summonerName) throws SizeLimitExceededException, MemberAlreadyPresentException {
        if (teamMembers.size() < TEAM_SIZE) {
            if (!isMemberPresent(summonerName)) {
                TeamMember teamMember = new TeamMember(summonerName);
                this.teamMembers.add(teamMember);
                updateTeamMmr(teamMember);
            } else {
                throw new MemberAlreadyPresentException("Member " + summonerName + " alòready present in team " + this.teamName.name);
            }
        } else {
            throw new SizeLimitExceededException();
        }
    }

    public boolean isMemberPresent(String summonerName) {
        return this.teamMembers.stream().map(TeamMember::getSummonerName).anyMatch(summonerName::equals);
    }

    private void updateTeamMmr(TeamMember member) {
        TeamMemberController.setMmr(member);
        long highestMmr = TeamMemberController.getHighestMmr(member, true);
        if (highestMmr > 0) {
            this.effectiveTeamSize++;
            this.totalMmr += highestMmr;
            this.averageMmr = this.totalMmr / this.effectiveTeamSize;
        }
    }

    public TeamMember getMember(int index) throws IndexOutOfBoundsException {
        return this.teamMembers.get(index);
    }

    public TeamName getTeamName() {
        return teamName;
    }

    public List<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public int getEffectiveTeamSize() {
        return effectiveTeamSize;
    }

    public long getTotalMmr() {
        return totalMmr;
    }

    public long getAverageMmr() {
        return averageMmr;
    }

    public class MemberAlreadyPresentException extends Exception {

        public MemberAlreadyPresentException(String errorMessage) {
            super(errorMessage);
        }
    }
}
