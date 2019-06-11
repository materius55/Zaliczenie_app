package com.example.zaliczenie_app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter {
    private ArrayList<Losujemy> mLosujemy = new ArrayList<>();

    // obiekt listy wylosowanych liczb
    private RecyclerView mRecyclerView;

    // implementacja wzorca ViewHolder
    // każdy obiekt tej klasy przechowuje odniesienie do layoutu elementu listy
    // dzięki temu wywołujemy findViewById() tylko raz dla każdego elementu
    private class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView wynik ;


        public MyViewHolder(View pItem) {
            super(pItem);
            wynik = (TextView) pItem.findViewById(R.id.liczba_wiersz);
        }
    }

    // konstruktor adaptera
    public MyAdapter(ArrayList<Losujemy> pArticles, RecyclerView pRecyclerView){
        mLosujemy = pArticles;
        mRecyclerView = pRecyclerView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        // tworzymy layout artykułu oraz obiekt ViewHoldera
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.wiersz_dla_recycler_view, viewGroup, false);

        // dla elementu listy ustawiamy obiekt OnClickListener,
        // który usunie element z listy po kliknięciu na niego
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // odnajdujemy indeks klikniętego elementu
                int positionToDelete = mRecyclerView.getChildAdapterPosition(v);
                // usuwamy element ze źródła danych
                mLosujemy.remove(positionToDelete);
                // poniższa metoda w animowany sposób usunie element z listy
                notifyItemRemoved(positionToDelete);
            }
        });

        // tworzymy i zwracamy obiekt ViewHolder
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        // uzupełniamy layout tabeli liczb
        Losujemy losujemy = mLosujemy.get(i);
        ((MyViewHolder) viewHolder).wynik.setText(losujemy.getWylosowana());
    }

    @Override
    public int getItemCount() {
        return mLosujemy.size();
    }
}

