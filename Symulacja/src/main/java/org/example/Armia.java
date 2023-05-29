package org.example;

public class Armia {
    private static int nr=0;
    private int liczebnosc;
    private int rzedy;
    private String nazwa;
    private String[] jednostkiRzedu;

    public Armia(String nazwa, int liczebnosc, int rzedy, String[] jednostkiRzedu){
        nr++;
        this.nazwa=nazwa;
        this.liczebnosc=liczebnosc;
        this.rzedy=rzedy;
        this.jednostkiRzedu=jednostkiRzedu;
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
}
