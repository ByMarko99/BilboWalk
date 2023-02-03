package com.example.fortheloveofgodcanyoujsutworik;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class PreguntasTest extends AppCompatActivity {
    TextView txtPregunta;
    TextView txtPregunta2;
    TextView textView3;
    TextView txtView;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    Button button,button2;
    CheckBox SanMames;
    CheckBox AzkunaZentroa;
    RadioButton GurinOpila;
    RadioButton Marijaia;
    RadioButton Begoña;
    RadioButton SantoTomas;
    int vuelta = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
        Animation animationScale = AnimationUtils.loadAnimation(this, R.anim.scale);
        txtPregunta = findViewById(R.id.txtPregunta);
        txtPregunta2 = findViewById(R.id.txtPregunta2);

        List<Score> listScore;

        AppDatabase appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "dbPruebas"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build();

        listScore = appDatabase.daoScore().obtenerScore();

        if(listScore.isEmpty()){
            txtPregunta.setText("Last Score=0");
            txtPregunta2.setText("Best Score=0");
        } else {
            listScore = appDatabase.daoScore().obtenerScore();
            int scoren = 0;
            int mayor = 0;
            int mayorconfirmado =0;
            for(int i = 0 ; i <listScore.size(); i++){
                scoren = listScore.get(i).scorenum;
                int v = i-1;
                if(i>0){

                    mayor = listScore.get(v).scorenum;
                    if(mayor>mayorconfirmado){
                        mayorconfirmado=mayor;
                    }
                }
                if(scoren>mayorconfirmado){
                    txtPregunta2.setText("Best Score="+scoren);
                }
                txtPregunta.setText("Last Score="+scoren);
            }
        }
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            // Este boton va a recoger todos los datos de el formulario

            public void onClick(View view) {
                SanMames=findViewById(R.id.SanMames);
                AzkunaZentroa=findViewById(R.id.AzkunaZentroa);
                txtView=findViewById(R.id.texto1);
                textView5=findViewById(R.id.textView5);
                textView6=findViewById(R.id.textView6);
                textView7=findViewById(R.id.textView7);
                GurinOpila=findViewById(R.id.GurinOpila);
                textView3=findViewById(R.id.texto3);
                Marijaia=findViewById(R.id.Marijaia);
                Begoña=findViewById(R.id.Begoña);
                SantoTomas=findViewById(R.id.SantoTomas);


                if(vuelta==2){
                    SanMames.setTextColor(getResources().getColor(R.color.black));
                    AzkunaZentroa.setTextColor(getResources().getColor(R.color.black));
                    GurinOpila.setTextColor(getResources().getColor(R.color.black));
                    Marijaia.setTextColor(getResources().getColor(R.color.black));
                    Begoña.setTextColor(getResources().getColor(R.color.black));
                    SantoTomas.setTextColor(getResources().getColor(R.color.black));
                    vuelta = 0;
                    button.setText("CHECK");

                }
                else if(vuelta==1){
                    txtPregunta.setVisibility(View.INVISIBLE);
                    txtPregunta2.setVisibility(View.INVISIBLE);
                    txtView.setTextColor(getResources().getColor(R.color.black));
                    textView3.setTextColor(getResources().getColor(R.color.black));
                    textView5.setTextColor(getResources().getColor(R.color.black));
                    textView6.setTextColor(getResources().getColor(R.color.black));
                    textView7.setTextColor(getResources().getColor(R.color.black));

                    SanMames.setTextColor(getResources().getColor(R.color.green));
                    AzkunaZentroa.setTextColor(getResources().getColor(R.color.green));
                    GurinOpila.setTextColor(getResources().getColor(R.color.green));
                    Marijaia.setTextColor(getResources().getColor(R.color.green));
                    Begoña.setTextColor(getResources().getColor(R.color.green));
                    SantoTomas.setTextColor(getResources().getColor(R.color.green));

                    button.setText("BERRIRO?");
                    vuelta ++;

                }
                else if(vuelta==0){

                    int a = 0;
                    txtPregunta.setVisibility(View.VISIBLE);
                    txtPregunta2.setVisibility(View.VISIBLE);
                    txtPregunta.startAnimation(animationScale);
                    txtPregunta2.startAnimation(animationScale);
                    txtPregunta.setText("Score: ");
                    if(SanMames.isChecked() && AzkunaZentroa.isChecked()){
                        a++;
                        a++;
                        txtPregunta.setText("Score: "+a);
                        txtView.setTextColor(getResources().getColor(R.color.black));

                    }else if(!SanMames.isChecked() || !AzkunaZentroa.isChecked()){
                        txtView.setTextColor(getResources().getColor(R.color.red));
                        txtView.startAnimation(animShake);
                        txtPregunta.setText("Score: "+a);
                    }
                    if(GurinOpila.isChecked()){
                        a++;
                        a++;
                        txtPregunta.setText("Score: "+a);
                        textView3.setTextColor(getResources().getColor(R.color.black));

                    }else if(!GurinOpila.isChecked()){
                        textView3.setTextColor(getResources().getColor(R.color.red));
                        textView3.startAnimation(animShake);
                        txtPregunta.setText("Score: "+a);

                    }if(Marijaia.isChecked()){
                        a++;
                        a++;
                        txtPregunta.setText("Score: "+a);
                        textView5.setTextColor(getResources().getColor(R.color.black));

                    }else if(!Marijaia.isChecked()){
                        textView5.setTextColor(getResources().getColor(R.color.red));
                        textView5.startAnimation(animShake);
                        txtPregunta.setText("Score: "+a);

                    }if(Begoña.isChecked()){
                        a++;
                        a++;
                        txtPregunta.setText("Score: "+a);
                        textView6.setTextColor(getResources().getColor(R.color.black));

                    }else if(!Begoña.isChecked()){
                        textView6.setTextColor(getResources().getColor(R.color.red));
                        textView6.startAnimation(animShake);
                        txtPregunta.setText("Score: "+a);

                    }if(SantoTomas.isChecked()){
                        a++;
                        a++;
                        txtPregunta.setText("Score: "+a);
                        textView7.setTextColor(getResources().getColor(R.color.black));

                    }else if(!SantoTomas.isChecked()){
                        textView7.setTextColor(getResources().getColor(R.color.red));
                        textView7.startAnimation(animShake);
                        txtPregunta.setText("Score: "+a);

                    }

                    int ides = 0, añad;
                    for(int i = 0 ; i <appDatabase.daoScore().obtenerScore().size(); i++){
                        ides =appDatabase.daoScore().obtenerScore().get(i).id;

                    }
                    añad = ides +1;

                    Score book1 = new Score(añad,a);
                    appDatabase.daoScore().InsertarScore(book1);
                    int scoren = 0;
                    int mayor = 0;
                    int mayorconfirmado =0;
                    for(int i = 0 ; i <appDatabase.daoScore().obtenerScore().size(); i++){
                        scoren =appDatabase.daoScore().obtenerScore().get(i).scorenum;
                        int v = i-1;

                        if(i>0){

                            mayor = appDatabase.daoScore().obtenerScore().get(v).scorenum;
                            if(mayor>mayorconfirmado){
                                mayorconfirmado=mayor;
                            }
                        }
                        if(scoren>mayorconfirmado){
                            txtPregunta2.setText("Best Score="+scoren);
                        }
                        txtPregunta.setText("Last Score="+scoren);

                    }
                    button.setText("ERANTSUNAK");
                    vuelta ++;
                }
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            // Este boton va a recoger todos los datos de el formulario

            public void onClick(View view) {
                appDatabase.daoScore().borrarScore();
                txtPregunta.setText("Last Score=0");
                txtPregunta2.setText("Best Score=0");
            }
        });

    }
}