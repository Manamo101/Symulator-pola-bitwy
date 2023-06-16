package org.example;

import java.util.ArrayList;

/**
 * <p>
 *     Jedna z dostępnych klas jednostek.
 * </p>
 * <p>
 *     Klasa obiektów będących "pionkami" w symulacji.
 *     Dziedziczy po klasie Piechota.
 * </p>
 */
public class LekkaPiechota extends Piechota{
    /**
     * znak reprezentujący tę jednostkę.
     */
    private char skrot;
    /**
     * zmienna przechowująca ilość życia.
     */
    private int hp=70;
    /**
     * zmienna przechowująca siłę ataku.
     */
    private final int damage=30;
    private Atak atak;
    private Ruch ruch;

    /**
     *
     * @param nazwaArmii nazwa armii, do której należy
     * @param mapa referencja do mapy
     * @param rzad 1. parametr mówiący o umiescownieniu jednostki na mapie
     * @param kolumna 2. parametr mówiący o umiescownieniu jednostki na mapie
     * @param liczebnosc referencja do tablicy przechowującej inforamcację o liczebności
     */
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

    /**
     * Przeciążenie metody dziedziczonej.
     * @return znak reprezentujący jednostkę.
     */
    public String toString() {
        return Character.toString(skrot);
    }
}
