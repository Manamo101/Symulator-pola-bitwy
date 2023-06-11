package org.example;

import java.util.ArrayList;

class Mapa {
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
}