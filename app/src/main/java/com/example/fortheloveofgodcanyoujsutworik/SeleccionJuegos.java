package com.example.fortheloveofgodcanyoujsutworik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.room.Room;

import java.util.List;

public class SeleccionJuegos extends AppCompatActivity {
    ImageButton j1;
    ImageButton j2;
    ImageButton j3;
    ImageButton j4;
    ImageButton j5;
    ImageButton j6;
    AppDatabase appDatabase;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectgames);

        j1 = findViewById(R.id.imageButtonJ1);
        j2 = findViewById(R.id.imageButtonJ2);
        j3 = findViewById(R.id.imageButtonJ3);
        j4 = findViewById(R.id.imageButtonJ4);
        j5 = findViewById(R.id.imageButtonJ5);
        j6 = findViewById(R.id.imageButtonJ6);

        //Leer la base de datos y cambiar la imagen de los imageButton dependiendo de si el juego esta desbloqueado o no



        appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "dbPruebas"
        ).allowMainThreadQueries().build();





        if(appDatabase.daoBooleans().obtenerEncontrado(0)){
            j1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.azkunatxartelak));
        }

        if(appDatabase.daoBooleans().obtenerEncontrado(1)) {
            j2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.galdetegia));

        }

        if(appDatabase.daoBooleans().obtenerEncontrado(2)) {
            j3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nordamarijaia));

        }

        if(appDatabase.daoBooleans().obtenerEncontrado(3)) {
            j4.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.happy_emoji));

        }

        if(appDatabase.daoBooleans().obtenerEncontrado(4)) {
            j5.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.basajaun2));

        }
        if(appDatabase.daoBooleans().obtenerEncontrado(5)) {
            j6.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.happy_emoji));

        }
        //El imageButton tiene que tener un listener que llame a la pantalla de juego
        j1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(appDatabase.daoBooleans().obtenerEncontrado(0)){
                    Intent intent = new Intent(SeleccionJuegos.this, Preguntas.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Juego no desbloqueado aún", Toast.LENGTH_SHORT).show();
                }
                //If (!Desbloqueado){
                //Toast.makeText(SeleccionJuegos.this, "j1", Toast.LENGTH_SHORT).show();
                //}

            }
        });
        j2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(SeleccionJuegos.this, "j2", Toast.LENGTH_SHORT).show();
                if(appDatabase.daoBooleans().obtenerEncontrado(1)){
                    Intent intent = new Intent(SeleccionJuegos.this, PreguntasTest.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Juego no desbloqueado aún", Toast.LENGTH_SHORT).show();
                }
            }
        });
        j3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(appDatabase.daoBooleans().obtenerEncontrado(2)){
                    Intent intent = new Intent(SeleccionJuegos.this, SelectImage.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Juego no desbloqueado aún", Toast.LENGTH_SHORT).show();
                }
            }
        });
        j4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(appDatabase.daoBooleans().obtenerEncontrado(3)){
                    Intent intent = new Intent(SeleccionJuegos.this, Santotomas.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Juego no desbloqueado aún", Toast.LENGTH_SHORT).show();
                }
            }
        });
        j5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(appDatabase.daoBooleans().obtenerEncontrado(4)){
                    Intent intent = new Intent(SeleccionJuegos.this, Receta.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Juego no desbloqueado aún", Toast.LENGTH_SHORT).show();
                }
            }
        });
        j6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(appDatabase.daoBooleans().obtenerEncontrado(5)){
                    Intent intent = new Intent(SeleccionJuegos.this, PuzzleActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Juego no desbloqueado aún", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
