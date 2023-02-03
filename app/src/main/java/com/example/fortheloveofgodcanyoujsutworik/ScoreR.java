package com.example.fortheloveofgodcanyoujsutworik;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class ScoreR {

    @PrimaryKey
    @NotNull
    public int idR;
    public int scorenumR;
    public int completado;

    public ScoreR(int idR, int scorenumR, int completado) {
        this.idR=idR;
        this.scorenumR=scorenumR;
        this.completado=completado;
    }

@Ignore
    public ScoreR() {

    }
}