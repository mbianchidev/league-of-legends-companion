package it.ryther.projectriot.Controller;

import it.ryther.projectriot.API.WhatIsMyMMR.MyMMR;
import it.ryther.projectriot.API.WhatIsMyMMR.MyMMRCall;
import it.ryther.projectriot.Models.TeamMember;

public class TeamMemberController {

    public static void setMmr(TeamMember teamMember) {
        MyMMR myMMR = new MyMMRCall().setQueryParamValue(MyMMRCall.QueryParams.NAME, teamMember.getSummonerName()).run("https://euw.whatismymmr.com", "SpringBoot");
        long mmrRanked = myMMR.getRanked() == null ? 0 : myMMR.getRanked().getAvg();
        long mmrNormal = myMMR.getNormal() == null ? 0 : myMMR.getNormal().getAvg();
        long mmrAram = myMMR.getAram() == null ? 0 : myMMR.getAram().getAvg();

        teamMember.setRankedMmr(mmrRanked);
        teamMember.setNormalMmr(mmrNormal);
        teamMember.setAramMmr(mmrAram);
    }

    public static long getHighestMmr(TeamMember teamMember, boolean excludeAram) {
        if (excludeAram) {
            return Math.max(teamMember.getRankedMmr(), teamMember.getNormalMmr());
        } else {
            return Math.max(teamMember.getAramMmr(), Math.max(teamMember.getRankedMmr(), teamMember.getNormalMmr()));
        }
    }
}
