package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class firstPage extends AppCompatActivity {
Timer time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        time=new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent x=new Intent(firstPage.this,MainActivity.class);
                startActivity(x);
                finish();
            }
        },730);




    }
}