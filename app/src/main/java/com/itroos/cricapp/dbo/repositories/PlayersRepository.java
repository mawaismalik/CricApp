package com.itroos.cricapp.dbo.repositories;

import android.content.Context;

import com.itroos.cricapp.AppController;
import com.itroos.cricapp.dbo.entities.Players;
import com.itroos.cricapp.dbo.entities.PlayersDao;
import com.itroos.cricapp.helpers.Tools;

import java.util.List;

public class PlayersRepository {

    private PlayersDao playersDao;
    private Context context;

    public PlayersRepository(Context context){
        this.context = context;
        playersDao = ((AppController) context.getApplicationContext()).getDaoSession().getPlayersDao();
    }


    //table communication methods
    public List<Players> getAllPlayers() {
        return playersDao.queryBuilder().list();
    }

    public Long addPlayer(Players players) {
        return playersDao.insert(Tools.convertPlayerTosave(players));
    }

}
