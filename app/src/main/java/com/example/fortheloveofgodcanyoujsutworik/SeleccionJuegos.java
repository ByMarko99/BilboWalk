package com.example.fortheloveofgodcanyoujsutworik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SeleccionJuegos extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectgames);
        ImageButton j1 = (ImageButton) findViewById(R.id.imageButtonJ1);
        ImageButton j2 = (ImageButton) findViewById(R.id.imageButtonJ2);
        ImageButton j3 = (ImageButton) findViewById(R.id.imageButtonJ3);
        ImageButton j4 = (ImageButton) findViewById(R.id.imageButtonJ4);
        ImageButton j5 = (ImageButton) findViewById(R.id.imageButtonJ5);
        ImageButton j6 = (ImageButton) findViewById(R.id.imageButtonJ6);
        ImageButton j7 = (ImageButton) findViewById(R.id.imageButtonJ7);

        //Leer la base de datos y cambiar la imagen de los imageButton dependiendo de si el juego esta desbloqueado o no


        //Usado el layout selectgames
        //Utiliza el imageButton para ir a la pantalla de juego
        //El imageButton tiene que tener un listener que llame a la pantalla de juego
        j1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(SeleccionJuegos.this, "j1", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SeleccionJuegos.this, MainActivity.class);
                startActivity(intent);
            }
        });
        j2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(SeleccionJuegos.this, "j2", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SeleccionJuegos.this, MainActivity.class);
                startActivity(intent);   
            }
        });
        j3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(SeleccionJuegos.this, "j3", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SeleccionJuegos.this, MainActivity.class);
                startActivity(intent);   
            }
        });
        j4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(SeleccionJuegos.this, "j4", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SeleccionJuegos.this, MainActivity.class);
                startActivity(intent);   
            }
        });
        j5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(SeleccionJuegos.this, "j5", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SeleccionJuegos.this, MainActivity.class);
                startActivity(intent);   
            }
        });
        j6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(SeleccionJuegos.this, "j6", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SeleccionJuegos.this, MainActivity.class);
                startActivity(intent);   
            }
        });
        j7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(SeleccionJuegos.this, "j7", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SeleccionJuegos.this, MainActivity.class);
                startActivity(intent);   
            }
        });
    }







}
