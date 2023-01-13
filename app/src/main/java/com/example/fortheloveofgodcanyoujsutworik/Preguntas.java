package com.example.fortheloveofgodcanyoujsutworik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Preguntas extends AppCompatActivity {
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    Button btnCheck;
    Button btnNext2;
    TextView Score;
    ImageView NoComer;
    ImageView NoGritar;
    ImageView NoCorrer;
    ImageView Zentro;
    ImageView Silencio;

    TextView respuesta1;
    TextView respuesta2;
    TextView respuesta3;
    TextView respuesta4;
    TextView respuesta5;
    int vuelta = 0;
    // Create an ArrayList object
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preguntas);

        ArrayList<String> data = new ArrayList<>();
        data.add("EZ EGIN OHIU");
        data.add("EZIN DA KORRIKA EGIN");
        data.add("DEBEKATUTA DAGO JATEA");
        data.add("AZKUNA ZENTROTIK ISILTASUNEZ IBILI");
        data.add("ERAIKINA ERRESPETATU");

        NoComer = findViewById(R.id.NoComer);
        NoGritar = findViewById(R.id.NoGritar);
        NoCorrer = findViewById(R.id.NoCorrer);
        Zentro = findViewById(R.id.Zentro);
        Silencio = findViewById(R.id.Silencio);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);
        spinner5 = findViewById(R.id.spinner5);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,data);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,data);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,data);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,data);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,data);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        spinner4.setAdapter(adapter4);
        spinner5.setAdapter(adapter5);
        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);

       // MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.AudioYeah);

        btnNext2 = findViewById(R.id.btnNext2);
        btnNext2.setOnClickListener(new View.OnClickListener() {
            // Nos mandara a una pantalla de registro la cual nos dejara crear un usuario
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Preguntas.this, PreguntasTest.class);
                startActivity(intent);
            }
        });

        btnCheck=findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            // Aqui añade los objetos a cobrar de la factura con sus precios y la cantidad
            @Override
            public void onClick(View view) {
                Score= findViewById(R.id.Score);
                respuesta1= findViewById(R.id.respuesta1);
                respuesta2= findViewById(R.id.respuesta2);
                respuesta3= findViewById(R.id.respuesta3);
                respuesta4= findViewById(R.id.respuesta4);
                respuesta5= findViewById(R.id.respuesta5);

                if(vuelta==2){
                    btnCheck.setText("CHECK");
                    respuesta1.setVisibility(View.INVISIBLE);
                    respuesta2.setVisibility(View.INVISIBLE);
                    respuesta3.setVisibility(View.INVISIBLE);
                    respuesta4.setVisibility(View.INVISIBLE);
                    respuesta5.setVisibility(View.INVISIBLE);
                    vuelta = 0;
                }
                else if(vuelta==1){
                    btnCheck.setText("BERRIRO");
                    respuesta1.setVisibility(View.VISIBLE);
                    respuesta2.setVisibility(View.VISIBLE);
                    respuesta3.setVisibility(View.VISIBLE);
                    respuesta4.setVisibility(View.VISIBLE);
                    respuesta5.setVisibility(View.VISIBLE);

                    NoComer.setBackgroundResource(R.color.asul);
                    NoGritar.setBackgroundResource(R.color.asul);
                    NoCorrer.setBackgroundResource(R.color.asul);
                    Zentro.setBackgroundResource(R.color.asul);
                    Silencio.setBackgroundResource(R.color.asul);

                    vuelta ++;
                }
                else if(vuelta==0){
                    int i = 0;
                    String a = spinner1.getSelectedItem().toString();
                    String b = spinner2.getSelectedItem().toString();
                    String c = spinner3.getSelectedItem().toString();
                    String d = spinner4.getSelectedItem().toString();
                    String e = spinner5.getSelectedItem().toString();

                    if(a.equals("DEBEKATUTA DAGO JATEA")){
                        i++;
                        Score.setText("Score: "+i);
                        Score.setVisibility(View.VISIBLE);
                    }else{
                        Score.setText("Score: "+i);
                        Score.setVisibility(View.VISIBLE);
                        NoComer.setBackgroundResource(R.color.red);
                        NoComer.startAnimation(animShake);

                    }

                    if(b.equals("EZ EGIN OHIU")){
                        i++;
                        Score.setText("Score: "+i);
                        Score.setVisibility(View.VISIBLE);
                    }else{
                        Score.setText("Score: "+i);
                        Score.setVisibility(View.VISIBLE);
                        NoGritar.setBackgroundResource(R.color.red);
                        NoGritar.startAnimation(animShake);
                    }

                    if(c.equals("EZIN DA KORRIKA EGIN")){
                        i++;
                        Score.setText("Score: "+i);
                        Score.setVisibility(View.VISIBLE);
                    }else{
                        Score.setText("Score: "+i);
                        Score.setVisibility(View.VISIBLE);
                        NoCorrer.setBackgroundResource(R.color.red);
                        NoCorrer.startAnimation(animShake);
                    }

                    if(d.equals("ERAIKINA ERRESPETATU")){
                        i++;
                        Score.setText("Score: "+i);
                        Score.setVisibility(View.VISIBLE);
                    }else{
                        Score.setText("Score: "+i);
                        Score.setVisibility(View.VISIBLE);
                        Zentro.setBackgroundResource(R.color.red);
                        Zentro.startAnimation(animShake);
                    }


                    if(e.equals("AZKUNA ZENTROTIK ISILTASUNEZ IBILI")){
                        i++;
                        Score.setText("Score: "+i);
                        Score.setVisibility(View.VISIBLE);
                    }else{
                        Score.setText("Score: "+i);
                        Score.setVisibility(View.VISIBLE);
                        Silencio.setBackgroundResource(R.color.red);
                        Silencio.startAnimation(animShake);
                    }
                    vuelta ++;
                    btnCheck.setText("ERANTZUNAK");

                    if(i==5){
                        Score.setText("OSO ONDO");
                        // mediaPlayer.start();

                    }
                }



            }

        });



    }
}