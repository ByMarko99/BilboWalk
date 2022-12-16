package com.example.fortheloveofgodcanyoujsutworik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PreguntasTest extends AppCompatActivity {
    TextView txtPregunta;
    TextView textView3;
    TextView txtView;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    Button button;
    CheckBox SanMames;
    CheckBox AzkunaZentroa;
    RadioButton GurinOpila;
    RadioButton Marijaia;
    RadioButton Begoña;
    RadioButton SantoTomas;
    Button btnNext2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);


        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            // Este boton va a recoger todos los datos de el formulario

            public void onClick(View view) {
                SanMames=findViewById(R.id.SanMames);
                AzkunaZentroa=findViewById(R.id.AzkunaZentroa);
                txtPregunta=findViewById(R.id.txtPregunta);
                txtView=findViewById(R.id.textView);
                textView5=findViewById(R.id.textView5);
                textView6=findViewById(R.id.textView6);
                textView7=findViewById(R.id.textView7);
                GurinOpila=findViewById(R.id.GurinOpila);
                textView3=findViewById(R.id.textView3);
                Marijaia=findViewById(R.id.Marijaia);
                Begoña=findViewById(R.id.Begoña);
                SantoTomas=findViewById(R.id.SantoTomas);


                int i = 0;
                txtPregunta.setText("Score: ");
                if(SanMames.isChecked() && AzkunaZentroa.isChecked()){
                    i++;
                    i++;
                    txtPregunta.setText("Score: "+i);
                    txtView.setTextColor(getResources().getColor(R.color.black));

                }else if(!SanMames.isChecked() || !AzkunaZentroa.isChecked()){
                    txtView.setTextColor(getResources().getColor(R.color.red));
                }
                if(GurinOpila.isChecked()){
                    i++;
                    i++;
                    txtPregunta.setText("Score: "+i);
                    textView3.setTextColor(getResources().getColor(R.color.black));

                }else if(!GurinOpila.isChecked()){
                    textView3.setTextColor(getResources().getColor(R.color.red));

                }if(Marijaia.isChecked()){
                    i++;
                    i++;
                    txtPregunta.setText("Score: "+i);
                    textView5.setTextColor(getResources().getColor(R.color.black));

                }else if(!Marijaia.isChecked()){
                    textView5.setTextColor(getResources().getColor(R.color.red));

                }if(Begoña.isChecked()){
                    i++;
                    i++;
                    txtPregunta.setText("Score: "+i);
                    textView6.setTextColor(getResources().getColor(R.color.black));

                }else if(!Begoña.isChecked()){
                    textView6.setTextColor(getResources().getColor(R.color.red));

                }if(SantoTomas.isChecked()){
                    i++;
                    i++;
                    txtPregunta.setText("Score: "+i);
                    textView7.setTextColor(getResources().getColor(R.color.black));

                }else if(!SantoTomas.isChecked()){
                    textView7.setTextColor(getResources().getColor(R.color.red));

                }

                btnNext2 = findViewById(R.id.btnNext2);
                btnNext2.setOnClickListener(new View.OnClickListener() {
                    // Nos mandara a una pantalla de registro la cual nos dejara crear un usuario
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PreguntasTest.this, Preguntas.class);
                        startActivity(intent);
                    }
                });

            }
        });

    }
}