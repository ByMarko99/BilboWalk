package com.example.fortheloveofgodcanyoujsutworik;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(
        entities = {Score.class, Booleans.class, ScoreR.class},
        version = 1
)

public abstract class AppDatabase extends RoomDatabase {
    public abstract DaoScore daoScore();
    public abstract DaoBooleans daoBooleans();
    public abstract DaoScoreR daoScoreR();
}
