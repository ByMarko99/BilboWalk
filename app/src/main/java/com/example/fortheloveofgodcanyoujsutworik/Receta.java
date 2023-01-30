package com.example.fortheloveofgodcanyoujsutworik;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class Receta extends AppCompatActivity {
Button BtnCheckear;
EditText Numero1;
EditText Numero2;
EditText Numero3;
EditText Numero4;
TextView textView;
TextView textView2;
TextView textView3;
TextView textView4;
TextView txtPregunta;
TextView txtPregunta2;
    int i = 0;
    int vuelta = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receta);
        Numero1 = findViewById(R.id.Numero1);
        Numero2 = findViewById(R.id.Numero2);
        Numero3 = findViewById(R.id.Numero3);
        Numero4 = findViewById(R.id.Numero4);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
        Animation animationScale = AnimationUtils.loadAnimation(this, R.anim.scale);

        txtPregunta = findViewById(R.id.txtPregunta);
        txtPregunta2 = findViewById(R.id.txtPregunta2);

        /*List<Score> listScore;

        AppDatabase appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "dbPruebas"
        ).allowMainThreadQueries().build();

        listScore = appDatabase.daoScore().obtenerScore();
        if(listScore.isEmpty()){
            txtPregunta.setText("Last Score=0");
            txtPregunta2.setText("Best Score=0");
        } else {
            listScore = appDatabase.daoScore().obtenerScore();
            int xd = 0;
            int penis = 0;
            int m =0;
            for(int i = 0 ; i <listScore.size(); i++){
                xd = listScore.get(i).scorenum;
                int v = i-1;
                if(i>0){

                    penis = listScore.get(v).scorenum;
                    if(penis>m){
                        m=penis;
                    }
                }
                if(xd>m){
                    txtPregunta2.setText("Best Score="+xd);
                }
                txtPregunta.setText("Last Score="+xd);
            }
        }*/
        BtnCheckear = (Button) findViewById(R.id.BtnCheckear);
        BtnCheckear.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view){
            i = 0;
            if(vuelta==2){
                BtnCheckear.setText("BERRIRO?");
                vuelta=0;
            }
            else if(vuelta==1){

                Numero1.setText("3");
                Numero2.setText("1");
                Numero3.setText("4");
                Numero4.setText("2");
                vuelta ++;

            }
            else if(vuelta==0) {
                BtnCheckear.setText("CHECK");
                if(Numero1.getText().toString().equals("3")){
                    i++;
                }else{
                    Numero1.setTextColor(Color.parseColor("#f50005"));
                    Numero1.setText(":-(");
                    Numero1.startAnimation(animShake);
                }
                if(Numero2.getText().toString().equals("1")){
                    i++;
                }else{
                    Numero2.setTextColor(Color.parseColor("#f50005"));
                    Numero2.setText(":-(");
                    Numero2.startAnimation(animShake);
                }
                if(Numero3.getText().toString().equals("4")){
                    i++;
                }else{
                    Numero3.setTextColor(Color.parseColor("#f50005"));
                    Numero3.setText(":-(");
                    Numero3.startAnimation(animShake);
                }
                if(Numero4.getText().toString().equals("2")){
                    i++;
                }
                else{
                    Numero4.setTextColor(Color.parseColor("#f50005"));
                    Numero4.setText(":-(");
                    Numero4.startAnimation(animShake);
                }

                if(i == 4 ){
                    textView.setVisibility(View.INVISIBLE);
                    textView3.setVisibility(View.INVISIBLE);
                    textView4.setVisibility(View.INVISIBLE);
                    Numero1.setVisibility(View.INVISIBLE);
                    Numero2.setVisibility(View.INVISIBLE);
                    Numero3.setVisibility(View.INVISIBLE);
                    Numero4.setVisibility(View.INVISIBLE);
                    BtnCheckear.setVisibility(View.INVISIBLE);

                    textView2.startAnimation(animationScale);
                    textView2.setText("🍆💧 OSO ONDO ༼ つ ◕_◕ ༽つ");
                    textView2.setTextSize(24);
                    textView2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                }

                /*int uwu = 0, aña;
                for(int i = 0 ; i <appDatabase.daoScore().obtenerScore().size(); i++){
                    uwu =appDatabase.daoScore().obtenerScore().get(i).id;

                }
                aña = uwu +1;

                Score book1 = new Score(aña,i);
                appDatabase.daoScore().InsertarScore(book1);
                int xd = 0;
                int penis = 0;
                int m =0;
                for(int i = 0 ; i <appDatabase.daoScore().obtenerScore().size(); i++){
                    xd =appDatabase.daoScore().obtenerScore().get(i).scorenum;
                    int v = i-1;

                    if(i>0){

                        penis = appDatabase.daoScore().obtenerScore().get(v).scorenum;
                        if(penis>m){
                            m=penis;
                        }
                    }
                    if(xd>m){
                        txtPregunta.setText("Best Score="+xd);
                    }
                    txtPregunta2.setText("Last Score="+xd);

                }*/
            }


        }
    });
    }
}