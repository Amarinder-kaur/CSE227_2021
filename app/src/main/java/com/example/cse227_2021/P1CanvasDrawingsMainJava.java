package com.example.cse227_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class P1CanvasDrawingsMainJava extends AppCompatActivity {
P1CircleAnimation p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p1=new P1CircleAnimation(this);
        setContentView(p1);
    }
}