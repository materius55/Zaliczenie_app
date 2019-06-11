package com.example.zaliczenie_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void Przycisk(View view) {
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.Tabela);
        // w celach optymalizacji
        recyclerView.setHasFixedSize(true);

        // ustawiamy LayoutManagera
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // ustawiamy animatora, który odpowiada za animację dodania/usunięcia elementów listy
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // tworzymy źródło danych - tablicę z artykułami
        ArrayList<Losujemy> liczby=new ArrayList<>();
        for(int i=0;i< 30;++i)
            liczby.add(new Losujemy());

        // tworzymy adapter oraz łączymy go z RecyclerView
        recyclerView.setAdapter(new MyAdapter(liczby,recyclerView));

    }
    }


