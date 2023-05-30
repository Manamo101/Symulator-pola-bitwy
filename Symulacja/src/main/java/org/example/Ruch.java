package org.example;

import java.util.ArrayList;

public class Ruch {
    private int dlugosc;
    private Integer[] koordynaty = new Integer[2];
    private ArrayList<ArrayList<Jednostki>> mapa;
    public Ruch(ArrayList<ArrayList<Jednostki>> mapa, int x, int y,int dlugosc){
        this.dlugosc=dlugosc;
        koordynaty[0]=x;
        koordynaty[1]=y;
    }
    Integer[] srodekCiezkosci(){
        Integer[] xy = new Integer[2];
        return xy;

    }

    Integer[] ruszSie(){
        Integer[] xy = new Integer[2];
        return xy;
    }
}
