package com.example.fortheloveofgodcanyoujsutworik;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    TextView Score;
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


        btnCheck=findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            // Aqui añade los objetos a cobrar de la factura con sus precios y la cantidad
            @Override
            public void onClick(View view) {
                Score= findViewById(R.id.Score);
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
                }

                if(b.equals("EZ EGIN OHIU")){
                    i++;
                    Score.setText("Score: "+i);
                    Score.setVisibility(View.VISIBLE);
                }else{
                    Score.setText("Score: "+i);
                    Score.setVisibility(View.VISIBLE);
                }

                if(c.equals("EZIN DA KORRIKA EGIN")){
                    i++;
                    Score.setText("Score: "+i);
                    Score.setVisibility(View.VISIBLE);
                }else{
                    Score.setText("Score: "+i);
                    Score.setVisibility(View.VISIBLE);
                }

                if(d.equals("ERAIKINA ERRESPETATU")){
                    i++;
                    Score.setText("Score: "+i);
                    Score.setVisibility(View.VISIBLE);
                }else{
                    Score.setText("Score: "+i);
                    Score.setVisibility(View.VISIBLE);
                }


                if(e.equals("AZKUNA ZENTROTIK ISILTASUNEZ IBILI")){
                    i++;
                    Score.setText("Score: "+i);
                    Score.setVisibility(View.VISIBLE);
                }else{
                    Score.setText("Score: "+i);
                    Score.setVisibility(View.VISIBLE);
                }


                if(i==5){
                    Score.setText("OSO ONDO");
                    //MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.fuga_bach);
                    //mediaPlayer.start();

                }


            }

        });



    }
}