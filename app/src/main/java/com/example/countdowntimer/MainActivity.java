package com.example.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    TextView txtTimer;
    TextView timeElapsed;
    Button rstBtn;
    private final long startTime=10*1000;
    private final long interval = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTimer=(TextView) findViewById(R.id.txt_timer);
        timeElapsed=(TextView) findViewById(R.id.txt_time_elapsed);
        rstBtn=(Button) findViewById(R.id.btn_rst);

        CountDownTimer countDownTimer=new CountDownTimer(startTime,interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                txtTimer.setText("Time :"+ millisUntilFinished/1000 );
                timeElapsed.setText("Time Elapsed: "+(startTime-millisUntilFinished)/1000);
            }

            @Override
            public void onFinish() {
                txtTimer.setText("Tame Mukkiya");

            }
        };
        countDownTimer.start();

        rstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                countDownTimer.start();
            }
        });
    }
}