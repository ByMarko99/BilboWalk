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
TextView texto1;
TextView texto2;
TextView texto3;
TextView texto4;
TextView textView9;
TextView textView10;
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
        texto1 = findViewById(R.id.texto1);
        texto2 = findViewById(R.id.texto2);
        texto3 = findViewById(R.id.texto3);
        texto4 = findViewById(R.id.texto4);

        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake); // ESTA ES LA ANIMACION DE SHAKE
        Animation animationScale = AnimationUtils.loadAnimation(this, R.anim.scale); // Y ESTA LA QUE AMPLIA EL TEXTO

        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        BtnCheckear = (Button) findViewById(R.id.BtnCheckear);

        List<ScoreR> listScoreR;

        AppDatabase appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "dbPruebas"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build(); // CARGAMOS LA BASE DE DATOS

        listScoreR = appDatabase.daoScoreR().obtenerScoreR();
        if(listScoreR.isEmpty()){
            textView9.setText("Last Score=0");
            textView10.setText("Best Score=0");
        } else {
            listScoreR = appDatabase.daoScoreR().obtenerScoreR();
            int scr = 0;
            int mayor = 0;
            int mayorf =0;
            // AQUI LO QUE VA A HACER ES COMPROBARNOS SI HAY SCORES Y CUANTOS HAY Y NOS RECOGERA EL ULTIMO Y EL MEJOR INTENTO
            for(int i = 0 ; i <listScoreR.size(); i++){
                scr = listScoreR.get(i).scorenumR;
                int v = i-1;
                if(i>0){

                    mayor = listScoreR.get(v).scorenumR;
                    if(mayor>mayorf){
                        mayorf=mayor;
                    }
                }
                if(scr>mayorf){
                    textView10.setText("Best Score="+scr); // ESTE ES NUESTRO MEJOR INTENTO
                }
                textView9.setText("Last Score="+scr);
                if(listScoreR.get(i).completado==1){ // SI ESTA COMPLETADO NOS DICE PARA VOLVER A HACERLO

                    texto1.setVisibility(View.INVISIBLE);
                    texto3.setVisibility(View.INVISIBLE);
                    texto4.setVisibility(View.INVISIBLE);
                    textView9.setVisibility(View.INVISIBLE);
                    textView10.setVisibility(View.INVISIBLE);
                    Numero1.setVisibility(View.INVISIBLE);
                    Numero2.setVisibility(View.INVISIBLE);
                    Numero3.setVisibility(View.INVISIBLE);
                    Numero4.setVisibility(View.INVISIBLE);
                    BtnCheckear.setVisibility(View.VISIBLE);
                    BtnCheckear.setText("???");
                    texto2.setText("JOKO HAU EGIN DUZU BERRIRO?");
                    texto2.setTextSize(24);
                    texto2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                }else{ // SI NO LA CARGA NORMAL
                    texto1.setVisibility(View.VISIBLE);
                    texto3.setVisibility(View.VISIBLE);
                    texto4.setVisibility(View.VISIBLE);
                    Numero1.setVisibility(View.VISIBLE);
                    Numero2.setVisibility(View.VISIBLE);
                    Numero3.setVisibility(View.VISIBLE);
                    Numero4.setVisibility(View.VISIBLE);
                    BtnCheckear.setVisibility(View.VISIBLE);
                    textView9.setVisibility(View.VISIBLE);
                    textView10.setVisibility(View.VISIBLE);
                    texto2.setText("Hasteko, elikagaiak mahai gainean jarriko ditugu eta Gurin-opila egiten hasiko gara.");
                    texto2.setTextSize(14);
                    texto2.setTextAlignment(View.TEXT_ALIGNMENT_INHERIT);
                    BtnCheckear.setText("CHECK");
                }
            }
        }


        // ESTO COMPRUEBA Y AÑADE SCORES
        BtnCheckear.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view){
            i = 0;
            if(vuelta==2){//VOLVEMOS A EMPEZAR
                BtnCheckear.setText("BERRIRO?");
                vuelta=0;
            }
            else if(vuelta==1){//ESTA VUELTA NOS MUESTRA LAS RESPUESTAS

                Numero1.setText("3");
                Numero2.setText("1");
                Numero3.setText("4");
                Numero4.setText("2");
                vuelta ++;

            }
            else if(vuelta==0) { // ESTA ES LA PRIMERA VUELTA Y NOS MOSTRARA LA ACTIVIDAD DE FORMA
                if(BtnCheckear.getText().equals("???")){
                    texto1.setVisibility(View.VISIBLE);
                    texto3.setVisibility(View.VISIBLE);
                    texto4.setVisibility(View.VISIBLE);
                    Numero1.setVisibility(View.VISIBLE);
                    Numero2.setVisibility(View.VISIBLE);
                    Numero3.setVisibility(View.VISIBLE);
                    Numero4.setVisibility(View.VISIBLE);
                    BtnCheckear.setVisibility(View.VISIBLE);
                    textView9.setVisibility(View.VISIBLE);
                    textView10.setVisibility(View.VISIBLE);
                    texto2.setText("Hasteko, elikagaiak mahai gainean jarriko ditugu eta Gurin-opila egiten hasiko gara.");
                    texto2.setTextSize(14);
                    texto2.setTextAlignment(View.TEXT_ALIGNMENT_INHERIT);
                    BtnCheckear.setText("CHECK");


                }else{
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
                    texto1.setVisibility(View.INVISIBLE);
                    texto3.setVisibility(View.INVISIBLE);
                    texto4.setVisibility(View.INVISIBLE);
                    Numero1.setVisibility(View.INVISIBLE);
                    Numero2.setVisibility(View.INVISIBLE);
                    Numero3.setVisibility(View.INVISIBLE);
                    Numero4.setVisibility(View.INVISIBLE);
                    BtnCheckear.setVisibility(View.INVISIBLE);

                    texto2.startAnimation(animationScale);
                    texto2.setText("🍆💧 OSO ONDO ༼ つ ◕_◕ ༽つ");
                    texto2.setTextSize(24);
                    texto2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                }

                int lalista = 0, aña;
                for(int i = 0 ; i <appDatabase.daoScoreR().obtenerScoreR().size(); i++){
                    lalista =appDatabase.daoScoreR().obtenerScoreR().get(i).idR;
                }
                ScoreR book1 = null;
                aña = lalista +1;
                if(i<4){
                    book1 = new ScoreR(aña,i,0);
                }
                if(i==4){
                    book1 = new ScoreR(aña,i,1);
                }

                appDatabase.daoScoreR().InsertarScoreR(book1);

                int scr = 0;
                int mayor = 0;
                int mayorf =0;

                for(int i = 0 ; i <appDatabase.daoScoreR().obtenerScoreR().size(); i++){
                    scr =appDatabase.daoScoreR().obtenerScoreR().get(i).scorenumR;
                    int v = i-1;

                    if(i>0){

                        mayor = appDatabase.daoScoreR().obtenerScoreR().get(v).scorenumR;
                        if(mayor>mayorf){
                            mayorf=mayor;
                        }
                    }
                    if(scr>mayorf){
                        textView10.setText("Best Score="+scr);
                    }
                    textView9.setText("Last Score="+scr);

                }
                }
            }


        }
    });
    }
}