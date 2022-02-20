package com.itroos.cricapp.dbo.repositories;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itroos.cricapp.dbo.entities.DaoMaster;
import com.itroos.cricapp.dbo.entities.UserDao;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Migrator extends DaoMaster.OpenHelper {

    public Migrator(Context context, String name) {
        super(context, name);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by migrating all tables data");

        MigrationHelper.migrate(db,
                UserDao.class);
    }
   /* @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        List<Migration> migrations = getMigrations();

        // Only run migrations past the old version
        for (Migration migration : migrations) {
            if (oldVersion < migration.getVersion()) {
                migration.runMigration(db);
            }
        }
    }*/

    private List<Migration> getMigrations() {
        List<Migration> migrations = new ArrayList<>();
        //migrations.add(new MigrationV2());
        //migrations.add(new MigrationV3());

        // Sorting just to be safe, in case other people add migrations in the wrong order.
        Comparator<Migration> migrationComparator = new Comparator<Migration>() {
            @Override
            public int compare(Migration m1, Migration m2) {
                return m1.getVersion().compareTo(m2.getVersion());
            }
        };
        Collections.sort(migrations, migrationComparator);

        return migrations;
    }

    private static class MigrationV2 implements Migration {

        @Override
        public Integer getVersion() {
            return 2;
        }

        @Override
        public void runMigration(Database db) {
            //Adding new table
            //SMS_TemplateDBDao.createTable(db, false);
        }
    }

    private static class MigrationV3 implements Migration {

        @Override
        public Integer getVersion() {
            return 3;
        }

        @Override
        public void runMigration(Database db) {

            //Adding new table
            //SMS_TemplateDBDao.createTable(db, false);
           // CompaniesStatusCategoryDbDao.createTable(db, true);
           // CompaniesStatusETC_DBDao.createTable(db, true);
            // Add new column to user table
          //  db.execSQL("ALTER TABLE " + CompaniesDbDao.TABLENAME + " ADD COLUMN " + CompaniesDbDao.Properties.Row_No + " LONG");
          //  db.execSQL("ALTER TABLE " + CompaniesDbDao.TABLENAME + " ADD COLUMN " + CompaniesDbDao.Properties.AllCompaniesPaginationPageN + " LONG");
           // db.execSQL("ALTER TABLE " + CompaniesDbDao.TABLENAME + " ADD COLUMN " + CompaniesDbDao.Properties.Registered_PaginationPageNo + " LONG");
           // db.execSQL("ALTER TABLE " + CompaniesDbDao.TABLENAME + " ADD COLUMN " + CompaniesDbDao.Properties.DE_Registered_PaginationPageNo + " LONG");
        }
    }

    private interface Migration {
        Integer getVersion();

        void runMigration(Database db);
    }
}
