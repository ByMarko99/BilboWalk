package com.example.fortheloveofgodcanyoujsutworik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Preguntas extends AppCompatActivity {
    Button button;
    LinearLayout EzJan,EzOhiu,EzKor,Azkuna,Isil;
    TextView tv,succes,succes2;
    int total,fail=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preguntas);

        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
        Animation animationScale = AnimationUtils.loadAnimation(this, R.anim.scale);
        button=findViewById(R.id.button);
        succes= findViewById(R.id.succes);
        succes2= findViewById(R.id.succes2);
        button.setText("EZ OHIU");
        Isil = (LinearLayout) findViewById(R.id.Isil);
        Isil.setOnDragListener(new View.OnDragListener(){

            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                final int action = dragEvent.getAction();
                switch(action){
                    case DragEvent.ACTION_DRAG_STARTED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DRAG_LOCATION:
                        if(button.getText().toString().equals("Isilik")){
                            total = total + 1;
                            Isil.setVisibility(View.INVISIBLE);
                            EzJan.setVisibility(View.INVISIBLE);
                            EzKor.setVisibility(View.INVISIBLE);
                            EzOhiu.setVisibility(View.INVISIBLE);
                            Azkuna.setVisibility(View.INVISIBLE);
                            button.setVisibility(View.INVISIBLE);
                            succes2.setVisibility(View.VISIBLE);
                            succes.setVisibility(View.INVISIBLE);
                            succes2.setText("OSO ONDO");
                            succes2.setTextSize(24);

                        }else{

                            button.startAnimation(animShake);
                        }
                    case DragEvent.ACTION_DROP:{
                        fail = fail +1 ;
                        return (true);
                    }
                    case DragEvent.ACTION_DRAG_ENDED:{
                        break;
                    }
                    default:
                        break;
                }
                return true;
            }
        });

        EzKor = (LinearLayout) findViewById(R.id.EzKor);
        EzKor.setOnDragListener(new View.OnDragListener(){

            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                final int action = dragEvent.getAction();
                switch(action){
                    case DragEvent.ACTION_DRAG_STARTED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DRAG_LOCATION:
                        if(button.getText().toString().equals("Ez egin korrika")){
                            total = total + 1;
                            button.setText("Isilik");
                            succes.setVisibility(View.INVISIBLE);

                        }else{

                            button.startAnimation(animShake);
                        }
                    case DragEvent.ACTION_DROP:{
                        fail = fail +1 ;
                        return (true);
                    }
                    case DragEvent.ACTION_DRAG_ENDED:{
                        break;

                    }
                    default:
                        break;
                }
                return true;
            }
        });

        Azkuna = (LinearLayout) findViewById(R.id.Azkuna);
        Azkuna.setOnDragListener(new View.OnDragListener(){

            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                final int action = dragEvent.getAction();
                switch(action){
                    case DragEvent.ACTION_DRAG_STARTED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DRAG_LOCATION:
                        if(button.getText().toString().equals("Azkuna")){
                            total = total + 1;


                            button.setText("Ez egin korrika");
                            succes.setVisibility(View.INVISIBLE);
                        }else{

                            button.startAnimation(animShake);
                        }
                    case DragEvent.ACTION_DROP:{
                        fail = fail +1 ;
                        return (true);
                    }
                    case DragEvent.ACTION_DRAG_ENDED:{
                        break;
                    }
                    default:
                        break;
                }
                return true;
            }
        });
        EzJan = (LinearLayout) findViewById(R.id.EzJan);
        EzJan.setOnDragListener(new View.OnDragListener(){

            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                final int action = dragEvent.getAction();
                switch(action){
                    case DragEvent.ACTION_DRAG_STARTED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DRAG_LOCATION:
                        if(button.getText().toString().equals("EZ JAN")){
                            total = total + 1;


                            button.setText("Azkuna");
                            succes.setVisibility(View.INVISIBLE);
                        }else{

                            button.startAnimation(animShake);
                        }
                    case DragEvent.ACTION_DROP:{
                        fail = fail +1 ;
                        return (true);
                    }
                    case DragEvent.ACTION_DRAG_ENDED:{

                        break;

                    }
                    default:
                        break;
                }
                return true;
            }
        });
        EzOhiu = findViewById(R.id.Nogri);
        EzOhiu.setOnDragListener(new View.OnDragListener(){

            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                final int action = dragEvent.getAction();
                switch(action){
                    case DragEvent.ACTION_DRAG_STARTED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DRAG_LOCATION:
                        if(button.getText().toString().equals("EZ OHIU")){
                            total = total + 1;


                            button.setText("EZ JAN");
                            succes.setVisibility(View.INVISIBLE);
                        }else{
                            button.startAnimation(animShake);
                        }
                    case DragEvent.ACTION_DROP:{
                        fail = fail +1 ;
                        return (true);
                    }
                    case DragEvent.ACTION_DRAG_ENDED:{
                        break;
                    }
                    default:
                        break;
                }
                return true;
            }
        });



        button.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(button);
                view.startDrag(data,shadow,null,0);

                return false;
            }
        });


    }
}