package com.previsioni.openweatherapi.OpenWeather;

import java.util.Scanner;

public class Città {

    private static String nome;

    // COSTRUTTORE
    public Città (String nome) {

        this.nome = nome;

    }


    public static String getNome() {

        return nome;

    }

    public static void ScegliCittà() {

        System.out.println("inserire una città: ");
        Scanner sc = new Scanner(System.in);
        String NomeCittà = sc.next();
        Città Città1 = new Città(NomeCittà);
        sc.close();
    }
}

