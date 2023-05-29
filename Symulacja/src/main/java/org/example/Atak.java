package org.example;

import java.util.ArrayList;

public class Atak {
    private int damage;
    private Integer[] koordynaty = new Integer[2];
    private ArrayList<ArrayList<Jednostki>> mapa;
    public Atak(ArrayList<ArrayList<Jednostki>> mapa, int x, int y, int damage)
    {
        koordynaty[0]=x;
        koordynaty[1]=y;
        this.damage=damage;
        this.mapa=mapa;
    }
    void atakuj(){
        Integer[] index=znajdzPrzeciwnika();
        mapa.get(index[0]).get(index[1]).obrazenia(damage);
    }
    void atakuj(int x, int y){
        mapa.get(x).get(y).obrazenia(damage);
    }
    Integer[] znajdzPrzeciwnika(){
        Integer[] xy = new Integer[2];
        return xy;
    }
}
