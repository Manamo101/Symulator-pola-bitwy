package org.example;

import java.io.*;
import java.util.ArrayList;

public class Mapa {
    private static int nr = 1;
    private int x = 0;
    private int rzedy, kolumny;
    private NazwaJednostki[] jednostkiKolumny;
    private String nazwa;
    private ArrayList<ArrayList<Jednostki>> mapa;
    private Armia armia1;
    private Armia armia2;

    Mapa(ArrayList<ArrayList<Jednostki>> mapa) {
        this.mapa = mapa;
    }
    public void generuj(int tura) {
        for (int i = 0; i < mapa.size(); i++) {
            for (int j = 0; j < mapa.get(0).size(); j++) {
                if (mapa.get(i).get(j) != null)
                    System.out.print(mapa.get(i).get(j));
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void generujZakonczenie(int tura){
        System.out.println("KONIEC");
        System.out.println("ZAKONCZONO PO TURZE "+tura+".   REZULTAT: "+armia1+" "+armia1.liczebnosc()+"; "+armia2+" "+armia2.liczebnosc());
        for (int i = 0; i < mapa.size(); i++) {
            for (int j = 0; j < mapa.get(0).size(); j++) {
                if (mapa.get(i).get(j) != null)
                    System.out.print(mapa.get(i).get(j));
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void stworzArmie(Armia armia) {
        nazwa = armia.toString();
        kolumny = armia.kolumny();
        rzedy = armia.rzedy();
        jednostkiKolumny = armia.jednostkiKolumny();
        if (nr == 1) {
            armia1 = armia;
            x = kolumny + 5;
            for (int j = 0; j < kolumny; j++) {
                for (int i = 0; i < rzedy; i++) {
                    if (j == 0) {
                        mapa.add(new ArrayList<Jednostki>());
                    }
                    switch (jednostkiKolumny[j]) {
                        case piechota:
                            mapa.get(i).add(new Piechota(nazwa, mapa, i, j, armia.liczebnoscTablica()));
                            break;
                        case lekkaPiechota:
                            mapa.get(i).add(new LekkaPiechota(nazwa, mapa, i, j, armia.liczebnoscTablica()));
                            break;
                    }
                }
            }
            for (int i = 0; i < rzedy; i++) {
                mapa.get(i).add(null);
                mapa.get(i).add(null);
                mapa.get(i).add(null);
                mapa.get(i).add(null);
                mapa.get(i).add(null);

            }
        } else if (nr == 2) {
            armia2 = armia;
            if (mapa.size() < rzedy) {
                for (int i = mapa.size(); i <= rzedy - 1; i++) {
                    mapa.add(new ArrayList<Jednostki>());
                    for (int j = 0; j < x; j++)
                        mapa.get(i).add(null);
                }
            }
            for (int j = 0; j < kolumny; j++) {
                for (int i = 0; i < rzedy; i++) {

                    switch (jednostkiKolumny[j]) {
                        case piechota:
                            mapa.get(i).add(new Piechota(nazwa, mapa, i, j + x, armia.liczebnoscTablica()));
                            break;
                        case lekkaPiechota:
                            mapa.get(i).add(new LekkaPiechota(nazwa, mapa, i, j + x, armia.liczebnoscTablica()));
                            break;
                    }
                }
            }
            if (mapa.size() > rzedy) {
                for (int i = rzedy; i < mapa.size(); i++) {
                    for (int j = 0; j < kolumny; j++)
                        mapa.get(i).add(null);
                }
            }
        } else
            System.out.println("Blad tworzenia armii!!!");
        nr++;
    }

    public void zapisTury(int tura) throws IOException {
        File zapis = new File("zapis.txt");
        FileWriter writer = new FileWriter(zapis, true);
        writer.write("\n");
        writer.write("TURA " + tura + ".    " + "LICZEBNOSC: " + armia1 + " " + armia1.liczebnosc() + ", " + armia2 + " " + armia2.liczebnosc());
        writer.close();
    }

    public void zapis() throws IOException {
        File zapis = new File("zapis.txt");
        FileWriter writer = new FileWriter(zapis, true);
        writer.write("\n");
        for (int i = 0; i < mapa.size(); i++) {
            for (int j = 0; j < mapa.get(0).size(); j++) {
                if (mapa.get(i).get(j) != null)
                    writer.write(mapa.get(i).get(j).toString());
                else
                    writer.write(" ");
            }
            writer.write("\n");
        }
        writer.write("---------------------------");
        writer.close();
    }

    public void zapisKoniec(int tura) throws IOException {
        File zapis = new File("zapis.txt");
        FileWriter writer = new FileWriter(zapis, true);
        writer.write("\n");
        writer.write("KONIEC");
        writer.write("\n");
        writer.write("ZAKONCZONO PO TURZE "+tura+".   REZULTAT: "+armia1+" "+armia1.liczebnosc()+"; "+armia2+" "+armia2.liczebnosc());
        writer.close();
    }
}



