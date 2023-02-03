package com.example.fortheloveofgodcanyoujsutworik;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoScoreR {
    @Query("SELECT * FROM scorer")
    List<ScoreR> obtenerScoreR();

    @Insert
    void InsertarScoreR(ScoreR...scoreRS);

    @Query("DELETE FROM ScoreR")
    void borrarScoreR();


}
