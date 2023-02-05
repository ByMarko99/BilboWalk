package com.example.fortheloveofgodcanyoujsutworik;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface DaoBooleans {

    @Query("SELECT * FROM booleans")
    List<Booleans> obtenerBooleans();

    @Query("SELECT visitado FROM booleans WHERE id = :ident")
    boolean obtenerEncontrado(int ident);

    @Insert
    void insertarBoolean(Booleans...booleans);

    @Query("UPDATE booleans SET visitado = :visitado WHERE  id = :ident")
    void actualizarBoolean(boolean visitado, int ident);
}
