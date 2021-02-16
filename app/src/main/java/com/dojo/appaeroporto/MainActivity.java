package com.dojo.appaeroporto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    ImageView imagem;
    TextView texto;
    Animation aparece, some;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagem = findViewById(R.id.imagemSeta);
        texto = findViewById(R.id.meuTexto);

        texto.setText("Toque para Continuar.");
        imagem.setVisibility(View.INVISIBLE);

        aparece = new AlphaAnimation(0,1);
        some = new AlphaAnimation(1,0);

        aparece.setDuration(500);
        some.setDuration(500);

        aparece.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imagem.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imagem.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        some.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imagem.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imagem.setVisibility(View.INVISIBLE);
                texto.setText("Toque para Continuar.");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    public void clicouTela(View view){

        if(Math.random()<0.5){
            texto.setText("Siga para Direita.");
            imagem.setScaleX(-1f);
        }else{
            texto.setText("Siga para Esquerda.");
            imagem.setScaleX(1f);
        }

        imagem.startAnimation(aparece);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                imagem.startAnimation(some);
            }
        },2000);
    }
}