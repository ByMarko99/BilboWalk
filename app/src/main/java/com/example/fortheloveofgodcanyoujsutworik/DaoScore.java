package com.example.fortheloveofgodcanyoujsutworik;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
//3050
import java.util.List;
@Dao
public interface DaoScore {
    @Query("SELECT * FROM score")
    List<Score> obtenerScore();

    @Insert
    void InsertarScore(Score...scores);

}
