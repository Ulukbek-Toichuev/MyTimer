package com.example.mytimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int sec = 0;
    private boolean isRunning = false;
    private TextView textViewTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTimer = findViewById(R.id.textViewTimer);
        runtime();
    }

    public void onClickStartTimer(View view){
        isRunning = true;
    }

    public void onClickPauseTimer(View view){
        isRunning = false;
    }

    public void onClickThrowOffTimer(View view){
        isRunning = false;
        sec = 0;
    }

    private void runtime(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hour = sec / 3600;
                int min = (sec % 3600) / 60;
                int sec1 = sec % 60;

                String time = String.format(Locale.getDefault(),"%d: %02d: %02d", hour, min, sec1);
                textViewTimer.setText(time);

                if (isRunning){
                    sec++;
                }
                handler.postDelayed(this, 1000);
            }
        });

    }
}
