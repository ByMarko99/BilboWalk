package com.example.fortheloveofgodcanyoujsutworik;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.Party;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.core.models.Size;
import nl.dionsegijn.konfetti.xml.KonfettiView;

public class SelectImage extends AppCompatActivity {
    ImageButton MarijaiaBtn;
    ImageButton OlentzeroBtn;
    ImageButton BasajaunBtn;
    ImageButton SirenaBtn;
    TextView txtGuia;
    ProgressBar progressBar2;
    ProgressBar progressBar3;
    ProgressBar progressBar4;
    ProgressBar progressBar5;
    private KonfettiView konfettiView = null;
    private Shape.DrawableShape drawableShape = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectimage);
        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);

        final Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_heart);
        drawableShape = new Shape.DrawableShape(drawable, true);

        konfettiView = findViewById(R.id.konfettiView);
        EmitterConfig emitterConfig = new Emitter(5L, TimeUnit.SECONDS).perSecond(50);
        Party party = new PartyFactory(emitterConfig)
                .angle(270)
                .spread(280)
                .setSpeedBetween(1f, 5f)
                .timeToLive(2000L)
                .shapes(new Shape.Rectangle(0.3f), drawableShape)
                .sizes(new Size(12, 8f, 0.5f))
                .position(0.0, 0.0, 1.0, 0.0)
                .build();


        progressBar2=findViewById(R.id.progressBar2);
        progressBar3=findViewById(R.id.progressBar3);
        progressBar4=findViewById(R.id.progressBar4);
        progressBar5=findViewById(R.id.progressBar5);
        txtGuia=findViewById(R.id.txtGuia);
        MarijaiaBtn = findViewById(R.id.MarijaiaBtn);
        MarijaiaBtn.setOnClickListener(new View.OnClickListener() {
            // Este boton va a recoger todos los datos de el formulario
            public void onClick(View view) {
                txtGuia.setVisibility(View.VISIBLE);
                txtGuia.setText("OSO ONDO");
                OlentzeroBtn.setImageResource(R.drawable.happy_emoji);
                BasajaunBtn.setImageResource(R.drawable.happy_emoji);
                SirenaBtn.setImageResource(R.drawable.happy_emoji);
                OlentzeroBtn.setBackgroundResource(R.color.transparent);
                BasajaunBtn.setBackgroundResource(R.color.transparent);
                SirenaBtn.setBackgroundResource(R.color.transparent);

                OlentzeroBtn.startAnimation(animShake);
                SirenaBtn.startAnimation(animShake);
                BasajaunBtn.startAnimation(animShake);

                OlentzeroBtn.setEnabled(false);
                SirenaBtn.setEnabled(false);
                BasajaunBtn.setEnabled(false);

                progressBar2.setVisibility(View.VISIBLE);
                progressBar3.setVisibility(View.INVISIBLE);
                progressBar4.setVisibility(View.INVISIBLE);
                progressBar5.setVisibility(View.INVISIBLE);
                konfettiView.start(party);
               // MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ninios);
               // mediaPlayer.start(); // no need to call prepare(); create() does that for you


            }
        });
        OlentzeroBtn = findViewById(R.id.OlentzeroBtn);
        OlentzeroBtn.setOnClickListener(new View.OnClickListener() {
            // Este boton va a recoger todos los datos de el formulario
            public void onClick(View view) {
                txtGuia.setVisibility(View.VISIBLE);
                txtGuia.setText("EZ !!!! Hau da Olentzero");
                progressBar3.setVisibility(View.VISIBLE);
                progressBar3.startAnimation(animShake);
                progressBar2.setVisibility(View.INVISIBLE);
                progressBar4.setVisibility(View.INVISIBLE);
                progressBar5.setVisibility(View.INVISIBLE);

            }
        });
        BasajaunBtn = findViewById(R.id.BasajaunBtn);
        BasajaunBtn.setOnClickListener(new View.OnClickListener() {
            // Este boton va a recoger todos los datos de el formulario
            public void onClick(View view) {
                txtGuia.setVisibility(View.VISIBLE);
                txtGuia.setText("Ezezez hau da basajaun");
                progressBar4.setVisibility(View.VISIBLE);
                progressBar4.startAnimation(animShake);
                progressBar3.setVisibility(View.INVISIBLE);
                progressBar2.setVisibility(View.INVISIBLE);
                progressBar5.setVisibility(View.INVISIBLE);

            }
        });

        SirenaBtn = findViewById(R.id.SirenaBtn);
        SirenaBtn.setOnClickListener(new View.OnClickListener() {
            // Este boton va a recoger todos los datos de el formulario
            public void onClick(View view) {
                txtGuia.setVisibility(View.VISIBLE);
                txtGuia.setText("Ez!! hau itsasneska da");
                progressBar5.setVisibility(View.VISIBLE);
                progressBar5.startAnimation(animShake);
                progressBar3.setVisibility(View.INVISIBLE);
                progressBar4.setVisibility(View.INVISIBLE);
                progressBar2.setVisibility(View.INVISIBLE);


            }
        });

    }
}