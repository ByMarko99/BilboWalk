package com.example.fortheloveofgodcanyoujsutworik;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoCompletado {
    @Query("SELECT * FROM completado")
    List<Completado> Comple();

    @Insert
    void completar(Completado...completados);
}
