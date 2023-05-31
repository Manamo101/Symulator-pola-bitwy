package org.example;

import java.util.ArrayList;

public class Piechota extends Jednostki implements ParameryJednostek{
    private String skrot;
    private int hp=100;
    private int tura=0;
    private final int damage=40;
    private final int dlRuchu=1;
    private Integer[] index;
    private Atak atak;
    private Ruch ruch;
    private String nazwaArmii;
    private ArrayList<ArrayList<Jednostki>> mapa;
    public Piechota(String nazwaArmii, ArrayList<ArrayList<Jednostki>> mapa, int rzad, int kolumna){
        this.mapa=mapa;
        index = new Integer[2];
        index[0]=rzad;
        index[1]=kolumna;
        this.nazwaArmii=nazwaArmii;
        if (Armia.numerKlasy()==1)
            skrot="P";
        else if (Armia.numerKlasy()==2)
            skrot="p";
        else
            skrot="X";
        atak = new Atak(mapa,rzad,kolumna,damage);
        ruch = new Ruch(mapa,rzad,kolumna,dlRuchu);
    }
     public void obrazenia(int trafienie){
        hp-=trafienie;
        if (hp<=0){
            mapa.get(index[0]).set(index[1],null);
            skrot=" ";
        }
    }
    public String toString() {
            return skrot;
    }
    public void atak(){
        atak.atakuj();
    }
    public void ruszSie(){
        index = ruch.ruszSie();
    }
    public int tura(){
        return tura;
    }
    public void turaWykonana(){
        tura++;
    }
}
