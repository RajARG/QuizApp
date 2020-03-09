package com.guptaamey.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button target;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        target = findViewById(R.id.circle);
        target.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testSpeed(target);
            }
        });
    }

    void testSpeed(Button b){
        for(int a = 50; a > 5; a--){
            final int size = a;
            final Button temp = b;
            TimerTask t = new TimerTask() {
                @Override
                public void run() {
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) temp.getLayoutParams();
                    layoutParams.width = size;
                    layoutParams.height = size;
                    temp.setLayoutParams(layoutParams);
                }
            };
            new Timer().schedule( t, 250);
        }

    }
}

https://developer.android.com/reference/android/os/CountDownTimer