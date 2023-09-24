package it.ryther.projectriot;

import it.ryther.projectriot.API.SpectatorV4.Spectator;
import it.ryther.projectriot.API.SpectatorV4.SpectatorCall;
import it.ryther.projectriot.API.SummonerV4.Summoner;
import it.ryther.projectriot.API.SummonerV4.SummonerCall;
import it.ryther.projectriot.API.WhatIsMyMMR.MyMMR;
import it.ryther.projectriot.API.WhatIsMyMMR.MyMMRCall;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class IndexController {

    @RequestMapping(value = "/Summoner/{summonerName}", method = GET)
    public String getSummoner(@PathVariable("summonerName") String summonerName) {

        SummonerCall summonerCall = new SummonerCall();

        summonerCall.setPathVarValue(SummonerCall.PathVars.SUMMONER_NAME, summonerName);
        Summoner summoner = summonerCall.run("https://euw1.api.riotgames.com", "");
        return summoner.toString();
    }

    @RequestMapping(value = "/Spectator/{encryptedSummonerId}", method = GET)
    public String getSpectatorInfo(@PathVariable("encryptedSummonerId") String encryptedSummonerId) {

        SpectatorCall spectatorCall = new SpectatorCall();

        spectatorCall.setPathVarValue(SpectatorCall.PathVars.ENCRYPTED_SUMMONER_ID, encryptedSummonerId);
        Spectator spectator = spectatorCall.run("https://euw1.api.riotgames.com", "");
        return spectator.toString();
    }

    @RequestMapping(value = "/Queues", method = GET)
    public String getQueueTypes() {

        return Application.queues.toString();
    }

    @RequestMapping(value = "/MyMMR/{summonerName}", method = GET)
    public String getMyMMR(@PathVariable("summonerName") String summonerName, @RequestHeader(value = "User-Agent") String userAgent) {

        MyMMRCall myMMRCall = new MyMMRCall();

        myMMRCall.setQueryParamValue(MyMMRCall.QueryParams.NAME, summonerName);
        MyMMR myMMR = myMMRCall.run("https://euw.whatismymmr.com", userAgent);
        return myMMR.toString();
    }
}