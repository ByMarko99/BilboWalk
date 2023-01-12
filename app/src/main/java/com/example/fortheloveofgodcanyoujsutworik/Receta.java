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

public class Receta extends AppCompatActivity {
Button btnComp;
EditText Numero1;
EditText Numero2;
EditText Numero3;
EditText Numero4;
TextView textView;
TextView textView2;
TextView textView3;
TextView textView4;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Numero1 = findViewById(R.id.Numero1);
        Numero2 = findViewById(R.id.Numero2);
        Numero3 = findViewById(R.id.Numero3);
        Numero4 = findViewById(R.id.Numero4);
        btnComp = findViewById(R.id.btnComp);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
            textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
        Animation animationScale = AnimationUtils.loadAnimation(this, R.anim.scale);
        btnComp.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view){
            i = 0;
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
                btnComp.setVisibility(View.INVISIBLE);

                textView2.startAnimation(animationScale);
                textView2.setText("🍆💧 OSO ONDO ༼ つ ◕_◕ ༽つ");
                textView2.setTextSize(24);
                textView2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            }
        }
    });
    }
}