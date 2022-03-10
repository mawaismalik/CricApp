package com.itroos.cricapp.dbo.repositories;

import android.content.Context;

import com.itroos.cricapp.AppController;
import com.itroos.cricapp.dbo.entities.Players;
import com.itroos.cricapp.dbo.entities.PlayersDao;
import com.itroos.cricapp.dbo.entities.Teams;
import com.itroos.cricapp.dbo.entities.TeamsDao;
import com.itroos.cricapp.helpers.Tools;

import java.util.List;

public class TeamsRepository {

    private TeamsDao teamsDao;
    private Context context;

    public TeamsRepository(Context context){
        this.context = context;
        teamsDao = ((AppController) context.getApplicationContext()).getDaoSession().getTeamsDao();
    }


    //table communication methods
    public List<Teams> getAllTeams() {
        return teamsDao.queryBuilder().list();
    }

    public Long addTeam(Teams team) {
        return teamsDao.insert(team);
    }

}
