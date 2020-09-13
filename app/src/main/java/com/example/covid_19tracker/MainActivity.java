package com.example.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

import org.json.JSONArray;
import org.json.JSONStringer;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
        private static int SPLASH_SCREEN=3000;
        Animation animation,animation1;
       ImageView imageAnimation;
        LottieAnimationView animationView;
        Random r;
        Integer  anima[]={
                R.raw.covid,
                R.raw.medicalfront,
                R.raw.stayhomestaysafered,
                R.raw.covid2,
                R.raw.covid3,
                R.raw.covid4,
                R.raw.covid5,
                R.raw.loading
        };

        int pickedImage=0,lastPicked=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        r=new Random();
        animationView=(LottieAnimationView)findViewById(R.id.animationView);
        while (pickedImage==lastPicked) {
            pickedImage=r.nextInt(anima.length);
        }
            lastPicked=pickedImage;
            animationView.setAnimation(anima[pickedImage]);


        animation=AnimationUtils.loadAnimation(this,R.anim.scale);
       // imageAnimation=(ImageView)findViewById(R.id.imageView2);
        animation1= AnimationUtils.loadAnimation(this,R.anim.alpha);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(MainActivity.this, SecondActivity.class));

                finish();

                overridePendingTransition(R.anim.zoom,R.anim.static_animation);
            }
        },SPLASH_SCREEN);
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                        animationView.startAnimation(animation1);
                        imageAnimation.startAnimation(animation1);


            }
        },3200);*/








    }
}
