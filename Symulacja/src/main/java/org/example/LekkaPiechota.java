package org.example;

import java.util.ArrayList;

public class LekkaPiechota extends Piechota{
    private String skrot;
    private int hp=70;
    private int damage=30;
    protected int dlRuchu=1;
    private final String nazwaArmii;
    private Atak atak;
    private Ruch ruch;
    public LekkaPiechota(String nazwaArmii, ArrayList<ArrayList<Object>> mapa, int x, int y){
        super(nazwaArmii,mapa,x,y);
        this.nazwaArmii=nazwaArmii;
        if (Armia.numerKlasy()==1)
            skrot="L";
        if (Armia.numerKlasy()==2)
            skrot="l";
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
