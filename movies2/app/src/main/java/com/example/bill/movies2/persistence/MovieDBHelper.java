package com.example.bill.movies2.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bill on 4/18/16.
 */
public class MovieDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "movie.db";

    public MovieDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_MOVIE_TABLE = "CREATE TABLE " + MovieStruct.MovieEntry.TABLE_NAME + " (" +
                MovieStruct.MovieEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MovieStruct.MovieEntry.COLUMN_MOVIE_ID + " INTEGER NOT NULL, " +
                MovieStruct.MovieEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                MovieStruct.MovieEntry.COLUMN_IMAGE + " TEXT, " +
                MovieStruct.MovieEntry.COLUMN_IMAGE2 + " TEXT, " +
                MovieStruct.MovieEntry.COLUMN_OVERVIEW + " TEXT, " +
                MovieStruct.MovieEntry.COLUMN_RATING + " INTEGER, " +
                MovieStruct.MovieEntry.COLUMN_DATE + " TEXT);";

        db.execSQL(SQL_CREATE_MOVIE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MovieStruct.MovieEntry.TABLE_NAME);
        onCreate(db);
    }
}
