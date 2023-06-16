package org.example;

/**
 * <p>
 *  Klasa reprezentująca daną armię.
 * </p>
 * <p>
 *     Przechowuje ona wszystkie niezbędne dane dotyczące armii.
 * </p>
 */
public class Armia {
    private static int nr=0;
    private Integer[] liczebnosc = new Integer[1];
    private int kolumny;
    private int rzedy;
    private String nazwa;
    private NazwaJednostki[] jednostkiKolumny;

    /**
     * <p>
     *     Tworząc armię należy podać wyszczególnione parametry.
     * </p>
     * @param nazwa nazwa armi
     * @param kolumny ilość kolumn, inaczej szerokość, jaką zajmuje armia
     * @param rzedy ilość rzędów, inaczej dlugość, jaką zajmuje armia
     * @param jednostkiKolumny tablica przechowująca inforamcje jakie jednostki znajdują się w poszczególej kolumnie
     */
    public Armia(String nazwa, int kolumny, int rzedy, NazwaJednostki[] jednostkiKolumny){
        nr++;
        this.nazwa=nazwa;
        this.kolumny=kolumny;
        liczebnosc[0]=kolumny*rzedy;
        this.rzedy=rzedy;
        this.jednostkiKolumny=jednostkiKolumny;
    }

    /**
     * Pomaga przy tworzeniu jednostek.
     * @return zwraca numer klasy, tj. informuje o ilości stworzonych klas Armia
     */
    public static int numerKlasy()
    {
        return nr;
    }

    /**
     * @return zwraca nazwę armii
     */
    public String nazwaArmii(){
        return nazwa;
    }

    /**
     * Przeciążenie metody toString() poprawiająca czystość kodu.
     * @return nazwę armii
     */
    public String toString() {
        return nazwa;
    }

    /**
     * <p>
     * Do dynamicznej zmiany liczebności.
     * </p>
     * <p>
     * Służy do ustawienia jednej referencji do zmiennej liczebości w obrębie jednostek danej armii.
     * </p>
     *
     * @return referencję do talbicy przechowującej informację o liczebości
     */
    public Integer[] liczebnoscTablica(){
        return liczebnosc;
    }

    /**
     *
     * @return liczeność armii
     */
    public int liczebnosc(){
        return liczebnosc[0];
    }

    /**
     *
     * @return ilość kolumn armii
     */
    public int kolumny(){
        return kolumny;
    }
    /**
     *
     * @return ilość rzędów armii
     */
    public int rzedy(){
        return rzedy;
    }
    /**
     *
     * @return tablicę znajujących się jednostek w danej kolumnie
     */
    public NazwaJednostki[] jednostkiKolumny(){
        return jednostkiKolumny;
    }
}
