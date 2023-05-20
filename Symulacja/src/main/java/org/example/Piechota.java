package org.example;

import java.util.ArrayList;

public class Piechota extends Jednostki implements ParameryJednostek{
    private String skrot;
    private int hp=100;
    private int damage=40;
    private int dlRuchu=1;
    private Atak atak;
    private Ruch ruch;
    private final String nazwaArmii;
    public Piechota(String nazwaArmii, ArrayList<ArrayList<Jednostki>> mapa, int x, int y){
        this.nazwaArmii=nazwaArmii;
        if (Armia.numerKlasy()==1)
            skrot="P";
        if (Armia.numerKlasy()==2)
            skrot="p";
        atak = new Atak(mapa,x,y,damage);
        ruch = new Ruch(mapa,x,y,dlRuchu);
    }
     void obrazenia(int trafienie){
        hp-=trafienie;
    }
    public String toString() {
            return skrot;
    }
}
