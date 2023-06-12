package org.example;

public class Armia {
    private static int nr=0;
    private Integer[] liczebnosc = new Integer[1];
    private int kolumny;
    private int rzedy;
    private String nazwa;
    private NazwaJednostki[] jednostkiKolumny;

    public Armia(String nazwa, int kolumny, int rzedy, NazwaJednostki[] jednostkiKolumny){
        nr++;
        this.nazwa=nazwa;
        this.kolumny=kolumny;
        liczebnosc[0]=kolumny*rzedy;
        this.rzedy=rzedy;
        this.jednostkiKolumny=jednostkiKolumny;
    }
    public static int numerKlasy()
    {
        return nr;
    }
    public String nazwaArmii(){
        return nazwa;
    }
    public String toString() {
        return nazwa;
    }
    public Integer[] liczebnoscTablica(){
        return liczebnosc;
    }
    public int liczebnosc(){
        return liczebnosc[0];
    }
    public int kolumny(){
        return kolumny;
    }
    public int rzedy(){
        return rzedy;
    }
    public NazwaJednostki[] jednostkiKolumny(){
        return jednostkiKolumny;
    }
}
