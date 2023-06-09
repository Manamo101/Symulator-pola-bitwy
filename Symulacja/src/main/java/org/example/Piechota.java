package org.example;

import java.util.ArrayList;

public class Piechota extends Jednostki implements ParameryJednostek{
    private char skrot;
    private int hp=100;
    private int tura=1;
    private Integer[] liczebnosc;
    private final int damage=40;
    private Integer[] index;
    private Atak atak;
    private Ruch ruch;
    private String nazwaArmii;
    private ArrayList<ArrayList<Jednostki>> mapa;
    public Piechota(String nazwaArmii, ArrayList<ArrayList<Jednostki>> mapa, int rzad, int kolumna, Integer[] liczebnosc){
        this.mapa=mapa;
        this.liczebnosc=liczebnosc;
        index = new Integer[2];
        index[0]=rzad;
        index[1]=kolumna;
        this.nazwaArmii=nazwaArmii;
        if (Armia.numerKlasy()==1)
            skrot='P';
        else if (Armia.numerKlasy()==2)
            skrot='p';
        else
            skrot='X';
        atak = new Atak(mapa,rzad,kolumna,damage);
        ruch = new Ruch(mapa,rzad,kolumna);
    }
     public void obrazenia(int trafienie){
        hp-=trafienie;
        if (hp<=0){
            mapa.get(index[0]).set(index[1],null);
            skrot=' ';
            liczebnosc[0]--;
        }
    }
    public String toString() {
            return Character.toString(skrot);
    }
    public void atak(){
        atak.atakuj();
    }
    public void ruszSie(){
        index = ruch.ruszSie();
        atak.ustawKoordynaty(index);
    }
    public int tura(){
        return tura;
    }
    public void turaWykonana(){
        tura++;
    }
    public String nazwaArmii(){
    return nazwaArmii;
    }
}
