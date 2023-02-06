package com.example.fortheloveofgodcanyoujsutworik;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import java.time.Duration;

public class SplashScreen extends Activity {

    private final int DURATION_SPLASH = 2000; // El delay

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Esta es la orientacion de la pantalla
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Esto lo que nos va hacer es que la aplicacion se ponga en pantalla completa

        setContentView(R.layout.activity_splash_screen);
        // Llama a la actividad

        new Handler().postDelayed(new Runnable() {
            // Esto hace un delay y despues nos manda a la pantalla de login
            @Override
            public void run() {
                //Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, DURATION_SPLASH); // Aqui se llama al delay
    }
}