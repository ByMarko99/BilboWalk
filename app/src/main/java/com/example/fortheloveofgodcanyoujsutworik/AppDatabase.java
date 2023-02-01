package com.example.fortheloveofgodcanyoujsutworik;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(
        entities = {Score.class,Completado.class},
        version = 1
)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DaoScore daoScore();
    public abstract DaoCompletado daoCompletado();
}
