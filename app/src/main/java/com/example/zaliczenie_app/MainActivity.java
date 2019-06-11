package com.example.zaliczenie_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int wylosowana;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Losowanie(View view) {
        int wylosowana;
        Random rand = new Random();

        wylosowana = rand.nextInt((50-10)+1)+10;

        TextView textView = (TextView)findViewById(R.id.textView2);
        textView.setText(String.valueOf(wylosowana));

    }
}
