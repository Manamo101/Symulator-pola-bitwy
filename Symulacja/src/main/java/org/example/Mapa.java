package org.example;

import java.util.ArrayList;

class Mapa {
    private static int nr=1;
    private int x=0;
    ArrayList<ArrayList<Jednostki>> mapa;
    Mapa(ArrayList<ArrayList<Jednostki>> mapa) {
        this.mapa = mapa;
    }

    public void generuj() {
        for (int i = 0; i < mapa.size(); i++) {
            for (int j = 0; j < mapa.get(0).size(); j++) {
                if (mapa.get(i).get(j) != null)
                    System.out.print(mapa.get(i).get(j));
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void stworzArmie(String nazwa, int kolumny, int rzedy, NazwaJednostki[] jednostkiKolumny){
        if (nr==1){
            x=kolumny+3;
            for (int j=0; j<kolumny; j++){
                for (int i=0; i<rzedy; i++){
                    if(j==0){
                        mapa.add(new ArrayList<Jednostki>());
                    }
                    switch (jednostkiKolumny[j]){
                        case piechota:
                            mapa.get(i).add(new Piechota(nazwa,mapa,i,j));
                            break;
                        case lekkaPiechota:
                            mapa.get(i).add(new LekkaPiechota(nazwa,mapa,i,j));
                            break;
                    }
                }
            }
            for (int i=0;i<rzedy;i++){
                mapa.get(i).add(null);
                mapa.get(i).add(null);
                mapa.get(i).add(null);
            }
        }
        else if (nr==2){
            if (mapa.size()<rzedy){
                for(int i=mapa.size(); i<=rzedy-1; i++) {
                    mapa.add(new ArrayList<Jednostki>());
                    for(int j=0; j<x; j++)
                        mapa.get(i).add(null);
                }
            }
            for (int j=0; j<kolumny; j++){
                for (int i=0; i<rzedy;i++){

                    switch (jednostkiKolumny[j]){
                        case piechota:
                            mapa.get(i).add(new Piechota(nazwa,mapa,i,j+x));
                            break;
                        case lekkaPiechota:
                            mapa.get(i).add(new LekkaPiechota(nazwa,mapa,i,j+x));
                            break;
                    }
                }
            }
            if (mapa.size()>rzedy){
                for (int i=rzedy; i<mapa.size();i++){
                    for (int j=0;j<kolumny;j++)
                        mapa.get(i).add(null);
                }
            }
        }
        else
            System.out.println("Blad tworzenia armii!!!");
        nr++;
    }
}