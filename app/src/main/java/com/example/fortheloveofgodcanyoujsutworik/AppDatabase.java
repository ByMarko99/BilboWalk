package com.example.fortheloveofgodcanyoujsutworik;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(
        entities = {Score.class,ScoreR.class},
        version = 2
)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DaoScore daoScore();
    public abstract DaoScoreR daoScoreR();
}
