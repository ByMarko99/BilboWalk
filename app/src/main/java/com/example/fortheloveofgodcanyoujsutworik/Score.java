package com.example.fortheloveofgodcanyoujsutworik;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class Score {

    @PrimaryKey
    @NotNull
    public int id;
    public int scorenum;

    public Score(int id,int scorenum){
        this.id=id;
        this.scorenum=scorenum;
    }

}

