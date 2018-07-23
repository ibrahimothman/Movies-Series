package com.ibra.moviesseries.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ibra.moviesseries.data.Contract;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "fav.db";
    public static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CREATE_FAV_TABLE_QUERY = "CREATE TABLE "+ Contract.FavEntry.TABLE_NAME+
                "("+ Contract.FavEntry._ID+" INTEGER PRIMARY KEY , "+
                Contract.FavEntry.TITLE_COL+" TEXT NOT NULL , "+
                Contract.FavEntry.RATE_COL+" TEXT NOT NULL , "+
                Contract.FavEntry.RELEASE_DATE_COL+" TEXT NOT NULL , "+
                Contract.FavEntry.OVERVIEW_COL+" TEXT NOT NULL , "+
                Contract.FavEntry.POSTER_COL+" TEXT NOT NULL ); ";

        db.execSQL(CREATE_FAV_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        final String DROP_FAV_TABLE_QUERY = "DROP TABLE IF EXISTS "+ Contract.FavEntry.TABLE_NAME;
        db.execSQL(DROP_FAV_TABLE_QUERY);
        onCreate(db);
    }
}
