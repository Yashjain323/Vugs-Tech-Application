package com.yash.vugstech;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.yash.vugstech.MainActivity;
import com.yash.vugstech.R;

import static java.lang.Thread.sleep;

public class splash extends AppCompatActivity {
    ImageView splashimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashimg = (ImageView) findViewById(R.id.splashImg);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.myanim);
        splashimg.startAnimation(myanim);

        Thread mythread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(4000);
                    Intent i = new Intent(splash.this, MainActivity.class);
                    startActivity(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        mythread.start();
    }
}