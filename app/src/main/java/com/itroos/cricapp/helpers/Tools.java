package com.itroos.cricapp.helpers;

import com.itroos.cricapp.data.models.MatchesModel;
import com.itroos.cricapp.data.models.PlayersModel;
import com.itroos.cricapp.data.models.TeamsModel;
import com.itroos.cricapp.dbo.entities.Matches;
import com.itroos.cricapp.dbo.entities.Players;
import com.itroos.cricapp.dbo.entities.Teams;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Tools {

    public static List<PlayersModel> convertPlayersToPojo(List<Players> list) {
        List<PlayersModel> pojoList = new ArrayList<>();

        for (Players table :
                list) {
            PlayersModel playersModel = new PlayersModel();
            playersModel.setPlayerName(table.getPlayerName());
            playersModel.setTeamId(table.getTeamId());
            playersModel.setPlayerNumber(table.getPlayerNumber());
            playersModel.setPlayingEleven(table.getPlayingEleven());
            pojoList.add(playersModel);
        }
        return pojoList;
    }

    public static Players convertPlayerTosave(Players players){
        players.setId(playerIdGenerator());
        return players;
    }


    public static Teams convertTeamToSave(String teamId , String teamName){
        Teams team = new Teams();
        team.setId(teamId);
        team.setTeamName(teamName);
        return team;
    }
    private static String playerIdGenerator() {
        String auditType = "P-";
        String currentTime =  new SimpleDateFormat(Config.dateFormat.ID_DATE, Locale.getDefault()).format(new Date());
        return auditType+currentTime;
    }

    public static String teamIdGenerator() {
        String auditType = "T-";
        String currentTime =  new SimpleDateFormat(Config.dateFormat.ID_DATE, Locale.getDefault()).format(new Date());
        return auditType+currentTime;
    }

    public static String matchIdGenerator() {
        String auditType = "M-";
        String currentTime =  new SimpleDateFormat(Config.dateFormat.ID_DATE, Locale.getDefault()).format(new Date());
        return auditType+currentTime;
    }

    public static List<TeamsModel> convertTeamsToPojo(List<Teams> data) {
        List<TeamsModel> teamsModels = new ArrayList<>();
        for(Teams team : data ){
            TeamsModel model = new TeamsModel();
            model.setTeamName(team.getTeamName());
            model.setNoOfPlayers(11);
            model.setTeamId(team.getId());
            teamsModels.add(model);
        }
        return teamsModels;
    }

    public static List<MatchesModel> convertMatchesToPojo(List<Matches> matchesList) {
        List<MatchesModel> matchesModels = new ArrayList<>();
        for(Matches matches : matchesList ){
            MatchesModel model = new MatchesModel();
            model.setId(matches.getId());
            model.setTeam_a_Id(matches.getTeam_a_Id());
            model.setTeam_b_Id(matches.getTeam_b_Id());
            model.setTeam_a_name(matches.getTeam_a_name());
            model.setTeam_b_name(matches.getTeam_b_name());
            model.setBatter_per_team(matches.getBatter_per_team());
            model.setDate(matches.getDate());
            model.setElected_to(matches.getElected_to());
            model.setMax_over_per_bowler(matches.getMax_over_per_bowler());
            model.setOvers_per_innings(matches.getOvers_per_innings());
            model.setStatus(matches.getStatus());
            model.setSuper_over(matches.getSuper_over());
            model.setToss_winner(matches.getToss_winner());
            model.setTotal_score(matches.getTotal_score());
            matchesModels.add(model);
        }
        return matchesModels;
    }
}
