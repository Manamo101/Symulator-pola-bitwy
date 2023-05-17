package org.example;

import java.util.ArrayList;

public class Atak {
    private int damage;
    private Integer[] koordynaty = new Integer[2];
    private ArrayList<ArrayList<Object>> mapa;
    public Atak(ArrayList<ArrayList<Object>> mapa, int x, int y, int damage)
    {
        koordynaty[0]=x;
        koordynaty[1]=y;
        this.damage=damage;
        this.mapa=mapa;
    }
    void atakuj(){

    }
    Integer[] znajdzPrzeciwnika(){
        Integer[] xy = new Integer[2];
        return xy;
    }
}
