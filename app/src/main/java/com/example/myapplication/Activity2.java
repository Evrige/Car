package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    TextView tw, t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        t = (TextView) findViewById(R.id.tResult);
        tw = (TextView) findViewById(R.id.tAnswer);
        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("answer").toString();
        tw.setText(name);                //вивід обраної відповіді
        String res = arguments.get("result").toString();//отримання результату
        t.setText(res);                //вивід результату
    }
}
