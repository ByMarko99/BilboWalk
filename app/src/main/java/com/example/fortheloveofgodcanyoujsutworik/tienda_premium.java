package com.example.fortheloveofgodcanyoujsutworik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.processphoenix.ProcessPhoenix;

import java.util.List;

public class tienda_premium extends AppCompatActivity {
    AppDatabase appDatabase;
    Button compra;
    List<Score> listhighscore1 = null;
    List<ScoreR> listhighscore2 = null;
    TextView compraalert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda_premium);
        appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "dbPruebas"
        ).allowMainThreadQueries().build();

        try {
            listhighscore1 = appDatabase.daoScore().obtenerScore();
            listhighscore2 = appDatabase.daoScoreR().obtenerScoreR();

        }
        catch (Exception e){

        }
        compra = findViewById(R.id.compra);
        compraalert = findViewById(R.id.alerta);
        for (int i = 0; i < listhighscore1.size(); i++) {
            if(listhighscore1.get(i).scorenum == 10){

                compraalert.setText("Comprado");


            }
        }
        compra.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for (int i = 0; i < listhighscore1.size(); i++) {
                    if(listhighscore1.get(i).scorenum == 10){
                        appDatabase.daoBooleans().actualizarBoolean(true, 99);
                        compraalert.setText("Comprado");

                        Toast.makeText(getApplicationContext(), "Reiniciando... \n Abre de nuevo la app", Toast.LENGTH_SHORT).show();
                        try { // Fuerza destrozar el fragmento, salta error, el usuario no lo nota
                            // getActivity().getSupportFragmentManager().beginTransaction().remove(HomeFragment.this).commit();
                            //TODO fixed crash // Y el fénix resurgió de sus cenizas
                            ProcessPhoenix.triggerRebirth(getApplicationContext()); //TODO fix de nuevo no funciona

                            //Intent intent2 = new Intent(getActivity(), SplashScreen.class);
                            //ProcessPhoenix.triggerRebirth(getContext(), intent2);
                        } catch (Exception e) {
                            e.printStackTrace();
                            // Intent intent2 = new Intent(getActivity(), SplashScreen.class);
                            // startActivity(intent2);
                        }


                    }else{
                        compraalert.setText("No tienes suficientes puntos en el juego de preguntas");

                    }
                }
                if(listhighscore1 == null || listhighscore1.size() == 0){
                    compraalert.setText("No tienes suficientes puntos en el juego de preguntas");

                }


            }
        });

    }
}