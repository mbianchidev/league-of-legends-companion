package it.ryther.projectriot;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import it.ryther.projectriot.API.SpectatorV4.Spectator;
import it.ryther.projectriot.API.SpectatorV4.SpectatorCall;
import it.ryther.projectriot.API.SpectatorV4.TeamMembers;
import it.ryther.projectriot.API.SummonerV4.Summoner;
import it.ryther.projectriot.API.SummonerV4.SummonerCall;
import it.ryther.projectriot.Models.Match;
import it.ryther.projectriot.Models.TeamMember;

@Route
@UIScope
public class MainView extends VerticalLayout {

    final Grid<TeamMember> blueTeamGrid = new Grid<>(TeamMember.class);
    final Grid<TeamMember> redTeamGrid = new Grid<>(TeamMember.class);

    TextField apiKey = new TextField("Api KEY");
    TextField summonerName = new TextField("Summoner name");

    H1 blueTeamTitle = new H1("Blue Team");
    H1 blueTeamMmr = new H1();
    HorizontalLayout blueTeamTag = new HorizontalLayout(blueTeamTitle, blueTeamMmr);
    VerticalLayout blueTeam = new VerticalLayout(blueTeamTag, blueTeamGrid);

    H1 redTeamTitle = new H1("Red Team");
    H1 redTeamMmr = new H1();
    HorizontalLayout redTeamTag = new HorizontalLayout(redTeamMmr, redTeamTitle);
    VerticalLayout redTeam = new VerticalLayout(redTeamTag, redTeamGrid);

    HorizontalLayout teams = new HorizontalLayout(blueTeam, redTeam);

    Button searchMatch = new Button("Search match", VaadinIcon.CHECK.create());

    public MainView() {
        setSpacing(true);

        add(apiKey);
        add(summonerName);
        summonerName.addKeyPressListener(Key.ENTER, e -> searchSummonerMatch(summonerName.getValue(), apiKey.getValue()));
        add(searchMatch);
        searchMatch.addClickListener(e -> searchSummonerMatch(summonerName.getValue(), apiKey.getValue()));

        blueTeamGrid.removeColumnByKey("aramMmr");

        redTeamGrid.removeColumnByKey("aramMmr");
        blueTeamTitle.getStyle().set("color", "blue");
        blueTeamMmr.getStyle().set("color", "blue");
        blueTeamMmr.getStyle().set("background-color", "lightblue");
        blueTeamMmr.getStyle().set("font-weight", "bold");
        setHorizontalComponentAlignment(Alignment.END, blueTeamTag);

        redTeamTitle.getStyle().set("color", "red");
        redTeamMmr.getStyle().set("color", "red");
        redTeamMmr.getStyle().set("background-color", "lightpink");
        redTeamMmr.getStyle().set("font-weight", "bold");
        setHorizontalComponentAlignment(Alignment.START, redTeamTag);

        setHorizontalComponentAlignment(Alignment.CENTER, teams);
        add(teams);
        teams.setWidthFull();
        teams.setVisible(false);
    }

    void searchSummonerMatch(String summonerName, String apiKey) {
        SummonerCall summonerCall = new SummonerCall();

        summonerCall.setPathVarValue(SummonerCall.PathVars.SUMMONER_NAME, summonerName);
        Summoner summoner = summonerCall.run("https://euw1.api.riotgames.com", apiKey);

        SpectatorCall spectatorCall = new SpectatorCall();

        spectatorCall.setPathVarValue(SpectatorCall.PathVars.ENCRYPTED_SUMMONER_ID, summoner.getId());
        Spectator spectator = spectatorCall.run("https://euw1.api.riotgames.com", apiKey);

        Match match = new Match();

        for (TeamMembers participant : spectator.getParticipants()) {
            match.addParticipant(participant);
        }

        blueTeamGrid.setItems(match.getBlueTeam().getTeamMembers());
        blueTeamMmr.setText(String.valueOf(match.getBlueTeam().getAverageMmr()));

        redTeamGrid.setItems(match.getRedTeam().getTeamMembers());
        redTeamMmr.setText(String.valueOf(match.getRedTeam().getAverageMmr()));

        teams.setVisible(true);
    }
}
