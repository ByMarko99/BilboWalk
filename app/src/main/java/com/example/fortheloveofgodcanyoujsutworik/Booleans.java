package com.example.fortheloveofgodcanyoujsutworik;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class Booleans {

    @PrimaryKey
    @NotNull
    public int id;
    public boolean visitado;

    public Booleans(int id,boolean visitado){
        this.id=id;
        this.visitado=visitado;
    }

}