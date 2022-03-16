package com.itroos.cricapp.dbo.repositories;

import android.content.Context;

import com.itroos.cricapp.AppController;
import com.itroos.cricapp.dbo.entities.Matches;
import com.itroos.cricapp.dbo.entities.MatchesDao;
import com.itroos.cricapp.dbo.entities.Teams;
import com.itroos.cricapp.dbo.entities.TeamsDao;
import com.itroos.cricapp.helpers.Config;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class MatchesRepository {

    private MatchesDao matchesDao;
    private Context context;

    public MatchesRepository(Context context){
        this.context = context;
        matchesDao = ((AppController) context.getApplicationContext()).getDaoSession().getMatchesDao();
    }


    //table communication methods
    public List<Matches> getAllMatches() {
        return matchesDao.queryBuilder().list();
    }

    public List<Matches> getRecentMatches() {
        return matchesDao.queryBuilder().where((MatchesDao.Properties.Status).eq(Config.Status.On_Going) ).list();
    }

    public Long addMatch(Matches match) {
        return matchesDao.insert(match);
    }

}
