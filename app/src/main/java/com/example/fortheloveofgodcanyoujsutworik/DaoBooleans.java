package com.example.fortheloveofgodcanyoujsutworik;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface DaoBooleans {

    @Query("SELECT * FROM booleans")
    List<Booleans> obtenerBooleans();

    @Query("SELECT * FROM booleans WHERE id = :ident")
    Booleans obtenerEncontrado(int ident);

    @Insert
    void insertarBoolean(Booleans...booleans);

    @Query("UPDATE booleans SET visitado = :visitado WHERE  id = :ident")
    void actualizarBoolean(boolean visitado, int ident);
}
