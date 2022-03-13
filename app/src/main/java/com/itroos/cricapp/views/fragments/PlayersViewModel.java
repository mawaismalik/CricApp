package com.itroos.cricapp.views.fragments;

import android.content.Context;

import androidx.lifecycle.ViewModel;


import com.itroos.cricapp.dbo.entities.Matches;
import com.itroos.cricapp.dbo.entities.Players;
import com.itroos.cricapp.dbo.entities.Teams;
import com.itroos.cricapp.dbo.repositories.MatchesRepository;
import com.itroos.cricapp.dbo.repositories.PlayersRepository;
import com.itroos.cricapp.dbo.repositories.TeamsRepository;

import java.util.List;

public class PlayersViewModel extends ViewModel {
    private PlayersRepository repository;
    private TeamsRepository teamsRepository;
    private MatchesRepository matchesRepository;

    public PlayersViewModel(Context context){
        repository = new PlayersRepository(context);
        teamsRepository = new TeamsRepository(context);
        matchesRepository = new MatchesRepository(context);
    }

    public void addPlayer(Players players){
        repository.addPlayer(players);
    }

    public List<Players> getAllPlayer(){
        return repository.getAllPlayers();
    }

    public List<Players> getTeamPlayer(String teamId){
        return repository.getTeamPlayers(teamId);
    }

    public void addTeam(Teams team){
        teamsRepository.addTeam(team);
    }

    public List<Teams> getAllTeams(){
        return teamsRepository.getAllTeams();
    }

    public void  addMatch(Matches matches){
        matchesRepository.addMatch(matches);
    }
}
