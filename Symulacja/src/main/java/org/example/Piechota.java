package org.example;

public class Piechota{
    private int hp=100;
    private final int damage=20;
    protected int dlRuchu=1;
    private String nazwaArmii;

    void obrazenia(int trafienie){
        hp-=trafienie;
    }

    @Override
    public String toString() {
        if (Armia.numerKlasy()==1)
            return "P";
        if (Armia.numerKlasy()==2)
            return "p";
        else
            return "Blad w numerach klas";
    }
}
