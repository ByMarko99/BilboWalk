package com.example.fortheloveofgodcanyoujsutworik;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class Completado {

    @PrimaryKey
    @NotNull
    public boolean comp;

    public Completado(boolean comp){
        this.comp=comp;
    }

}

