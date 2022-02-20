package com.itroos.cricapp;

import android.app.Application;
import android.content.res.Resources;


import com.itroos.cricapp.dbo.entities.DaoMaster;
import com.itroos.cricapp.dbo.entities.DaoSession;
import com.itroos.cricapp.dbo.repositories.Migrator;

import org.greenrobot.greendao.database.Database;

public class AppController extends Application {

    public static final boolean ENCRYPTED = false;
    private DaoSession daoSession;
    private static Resources res;
    @Override
    public void onCreate() {
        super.onCreate();
        Migrator helper = new Migrator(this, ENCRYPTED ? "notes-db-encrypted" : "cricapp-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
        DaoMaster.createAllTables(db,true);
        res = getResources();

    }
    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static Resources getRes() {
        return res;
    }
}
