package org.example;

import java.util.ArrayList;

public class LekkaPiechota extends Piechota{
    private String skrot;
    private int hp=70;
    private final int damage=30;
    private final int dlRuchu=1;
    private String nazwaArmii;
    private Atak atak;
    private Ruch ruch;
    public LekkaPiechota(String nazwaArmii, ArrayList<ArrayList<Jednostki>> mapa, int rzad, int kolumna){
        super(nazwaArmii,mapa,rzad,kolumna);
        this.nazwaArmii=nazwaArmii;
        if (Armia.numerKlasy()==1)
            skrot="L";
        if (Armia.numerKlasy()==2)
            skrot="l";
        atak = new Atak(mapa,rzad,kolumna,damage);
        ruch = new Ruch(mapa,rzad,kolumna,dlRuchu);
    }
    public String toString() {
        return skrot;
    }
}
