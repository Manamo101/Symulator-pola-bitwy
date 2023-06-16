package org.example;

import java.util.ArrayList;

/**
 <p>
 *     Jedna z dostępnych klas jednostek.
 * </p>
 * <p>
 *     Klasa obiektów będących "pionkami" w symulacji.
 *     Dziedziczy po niej Lekka Piechota.
 * </p>
 */
public class Piechota extends Jednostki implements ParameryJednostek{
    /**
     * znak reprezentujący tę jednostkę.
     */
    private char skrot;
    /**
     * zmienna przechowująca ilość życia.
     */
    private int hp=100;
    /**
     * zmienna przechowująca nr aktualnej tury rozgrywki.
     */
    private int tura=1;
    /**
     * jednoelementowa tablica przechowująca informacje o liczebności armii, do której należy.
     */
    private Integer[] liczebnosc;
    /**
     * zmienna przechowująca siłę ataku.
     */
    private final int damage=40;
    /**
     * dwuelementowa tablica przechowująca inforamacje o jej położeniu na mapie.
     */
    private Integer[] index;
    private Atak atak;
    private Ruch ruch;
    /**
     * zmienna przechowująca nazwę armi, do której należy.
     */
    private String nazwaArmii;
    private ArrayList<ArrayList<Jednostki>> mapa;

    /**
     *
     * @param nazwaArmii nazwa armii, do której należy
     * @param mapa referencja do mapy
     * @param rzad 1. parametr mówiący o umiescownieniu jednostki na mapie
     * @param kolumna 2. parametr mówiący o umiescownieniu jednostki na mapie
     * @param liczebnosc referencja do tablicy przechowującej inforamcację o liczebności
     */
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

    /**
     * Powoduje pomniejszenie ilości życia przez obrażenia otrzymane od przeciwnika.
     * @param trafienie ilość przyjętych obrażeń
     */
     public void obrazenia(int trafienie){
        hp-=trafienie;
        if (hp<=0){
            mapa.get(index[0]).set(index[1],null);
            skrot=' ';
            liczebnosc[0]--;
        }
    }

    /**
     *
     * @return znak reprezentujący jednostkę.
     */
    public String toString() {
            return Character.toString(skrot);
    }

    /**
     * Wywołuje metodę ataku klasy Atak.
     */
    public void atak(){
        atak.atakuj();
    }

    /**
     * Wywołuje metodę ruchu klasy Ruch oraz aktualizuje swoje współrzędne.
     */
    public void ruszSie(){
        index = ruch.ruszSie();
        atak.ustawKoordynaty(index);
    }

    /**
     *
     * @return wartość zmiennej tura.
     */
    public int tura(){
        return tura;
    }

    /**
     * powiększa zmienną tura o 1.
     */
    public void turaWykonana(){
        tura++;
    }

    /**
     *
     * @return nazwę armii, do której przynależy.
     */
    public String nazwaArmii(){
    return nazwaArmii;
    }
}
