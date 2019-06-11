package com.example.zaliczenie_app;
import java.util.Random;

//klasa generująca losowe liczby w przedziale 10-50

public class Losujemy {
    private  int wylosowana;
    private String wynik;
    public Losujemy() {
        Random rand = new Random();
        wylosowana = rand.nextInt((50 - 10) + 1) + 10;
        wynik = String.valueOf(wylosowana);
    }
        public String getWylosowana() {

            return wynik;
        }
    }

