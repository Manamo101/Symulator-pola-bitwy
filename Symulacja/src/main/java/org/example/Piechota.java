package org.example;

public class Piechota{
    private String skrot;
    private int hp=100;
    private final int damage=20;
    protected int dlRuchu=1;
    private String nazwaArmii;
    public Piechota(String nazwaArmii){
        this.nazwaArmii=nazwaArmii;
        if (Armia.numerKlasy()==1)
            skrot="P";
        if (Armia.numerKlasy()==2)
            skrot="p";
    }

    void obrazenia(int trafienie){
        hp-=trafienie;
    }

    @Override
    public String toString() {
            return skrot;
    }
}
