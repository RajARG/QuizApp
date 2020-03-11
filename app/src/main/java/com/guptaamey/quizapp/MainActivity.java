package com.guptaamey.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    Button target;
    Timer timer;
    int size = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        target = findViewById(R.id.circle);
        target.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        int period = 10;
        new CountDownTimer((size*period*10),period) {

            public void onTick(long millisUntilFinished) {
                final Button temp = target;
                final int a = size;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ConstraintLayout.LayoutParams clpm = (ConstraintLayout.LayoutParams) temp.getLayoutParams();
                        clpm.width = a;
                        clpm.height = a;
                        temp.setLayoutParams(clpm);
                    }
                });

                size--;
            }

            public void onFinish() {
                ConstraintLayout.LayoutParams clpm = (ConstraintLayout.LayoutParams) target.getLayoutParams();
                clpm.width = 0;
                clpm.height = 0;
                target.setLayoutParams(clpm);
            }

        }.start();

    }
}