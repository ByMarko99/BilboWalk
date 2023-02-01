package com.example.fortheloveofgodcanyoujsutworik;


import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Santotomas extends AppCompatActivity {
    private Spinner spinnerSAN;
    ImageView imageView;
    Button btnComprobar;
    TextView textViewFeliz;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.santotomas);

        ArrayList<String> data = new ArrayList<>();
        data.add("TALOA");
        data.add("SAGARDOA");
        data.add("BARAZKIAK");
        data.add("SANTO TOMASEKO ANIMALIAK");
        data.add("EUSKAL PASTELA");

        spinnerSAN = findViewById(R.id.spinnerSAN);
        imageView = findViewById(R.id.imageView2);
        textViewFeliz = findViewById(R.id.textViewFeliz);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,data);
        spinnerSAN.setAdapter(adapter);

        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
        Animation animationScale = AnimationUtils.loadAnimation(this, R.anim.scale);
        btnComprobar=findViewById(R.id.btnComprobar);
        btnComprobar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String a = spinnerSAN.getSelectedItem().toString();
                if(i==0){
                    if(a.equals("TALOA")){
                        textViewFeliz.setVisibility(View.VISIBLE);
                        textViewFeliz.startAnimation(animationScale);
                        imageView.setImageResource(R.drawable.screenshot_5);
                        textViewFeliz.setVisibility(View.INVISIBLE);
                        i++;
                    }else{

                        imageView.startAnimation(animShake);
                    }

                }else if(i==1){
                    if(a.equals("BARAZKIAK")){
                        textViewFeliz.setVisibility(View.VISIBLE);
                        textViewFeliz.startAnimation(animationScale);
                        imageView.setImageResource(R.drawable.screenshot_2);
                        textViewFeliz.setVisibility(View.INVISIBLE);
                        i++;
                    }else{

                        imageView.startAnimation(animShake);
                    }
                }else if(i==2){
                    if(a.equals("EUSKAL PASTELA")){
                        textViewFeliz.setVisibility(View.VISIBLE);
                        textViewFeliz.startAnimation(animationScale);
                        imageView.setImageResource(R.drawable.screenshot_3);
                        textViewFeliz.setVisibility(View.INVISIBLE);
                        i++;
                    }else{

                        imageView.startAnimation(animShake);
                    }
                }else if(i==3){
                    if(a.equals("SAGARDOA")){
                        textViewFeliz.setVisibility(View.VISIBLE);
                        textViewFeliz.startAnimation(animationScale);
                        imageView.setImageResource(R.drawable.screenshot_4);
                        textViewFeliz.setVisibility(View.INVISIBLE);
                        i++;
                    }else{

                        imageView.startAnimation(animShake);
                    }
                }else if(i==4){
                    if(a.equals("SANTO TOMASEKO ANIMALIAK")){
                        textViewFeliz.setText("GAINDITU DUZU");
                        textViewFeliz.setVisibility(View.VISIBLE);
                        textViewFeliz.startAnimation(animationScale);
                        imageView.setImageResource(R.drawable.happy_emoji);
                        spinnerSAN.setVisibility(View.INVISIBLE);
                        imageView.startAnimation(animShake);
                        btnComprobar.setVisibility(View.INVISIBLE);
                        imageView.setBackgroundResource(R.color.transparent);

                        i++;
                    }else{

                        spinnerSAN.startAnimation(animShake);
                    }
                }
            }
        });
    }
}