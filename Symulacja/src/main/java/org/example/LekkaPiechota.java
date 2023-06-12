package org.example;

import java.util.ArrayList;

public class LekkaPiechota extends Piechota{
    private char skrot;
    private int hp=70;
    private final int damage=30;
    private Atak atak;
    private Ruch ruch;
    public LekkaPiechota(String nazwaArmii, ArrayList<ArrayList<Jednostki>> mapa, int rzad, int kolumna, Integer[] liczebnosc){
        super(nazwaArmii,mapa,rzad,kolumna,liczebnosc);
        if (Armia.numerKlasy()==1)
            skrot='L';
        else if (Armia.numerKlasy()==2)
            skrot='l';
        else
            skrot='Y';
        atak = new Atak(mapa,rzad,kolumna,damage);
        ruch = new Ruch(mapa,rzad,kolumna);
    }
    public String toString() {
        return Character.toString(skrot);
    }
}
