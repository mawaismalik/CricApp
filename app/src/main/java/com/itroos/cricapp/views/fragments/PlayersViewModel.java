package com.itroos.cricapp.views.fragments;

import android.content.Context;

import androidx.lifecycle.ViewModel;


import com.itroos.cricapp.dbo.entities.Players;
import com.itroos.cricapp.dbo.repositories.PlayersRepository;

import java.util.List;

public class PlayersViewModel extends ViewModel {
    private PlayersRepository repository;

    public PlayersViewModel(Context context){
        repository = new PlayersRepository(context);
    }

    public void addPlayer(Players players){
        repository.addPlayer(players);
    }

    public List<Players> getAllPlayer(){
        return repository.getAllPlayers();
    }
}
