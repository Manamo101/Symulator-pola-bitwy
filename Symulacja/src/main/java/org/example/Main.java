package org.example;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Armia armia1 = new Armia("dobrzy", 9, 3, new String[]{"P", "P", "P"});
        ArrayList<ArrayList<Jednostki>> mapa = new ArrayList<ArrayList<Jednostki>>();
        /*
          0 1 2
        0 P P P   l l l
        1 P P P   l l l
        2 P P P   l l l
         */
        mapa.add(new ArrayList<Jednostki>());
        mapa.get(0).add(new LekkaPiechota("dobrzy", mapa, 0, 0));
        mapa.get(0).add(new LekkaPiechota("dobrzy", mapa, 0, 1));
        //mapa.get(0).add(new LekkaPiechota("dobrzy", mapa, 0, 2));
        mapa.get(0).add(null);
        mapa.get(0).add(null);
        mapa.get(0).add(null);
        mapa.get(0).add(null);
        mapa.add(new ArrayList<Jednostki>());
        mapa.get(1).add(new LekkaPiechota("dobrzy", mapa, 1, 0));
        mapa.get(1).add(new Piechota("dobrzy", mapa, 1, 1));
        //mapa.get(1).add(new Piechota("dobrzy", mapa, 1, 2));
        mapa.get(1).add(null);
        mapa.get(1).add(null);
        mapa.get(1).add(null);
        mapa.get(1).add(null);
        mapa.add(new ArrayList<Jednostki>());
        mapa.get(2).add(new LekkaPiechota("dobrzy", mapa, 2, 0));
        mapa.get(2).add(new Piechota("dobrzy", mapa, 2, 1));
        //mapa.get(2).add(new Piechota("dobrzy", mapa, 2, 2));
        mapa.get(2).add(null);
        mapa.get(2).add(null);
        mapa.get(2).add(null);
        mapa.get(2).add(null);

        Armia armia2 = new Armia("zli", 9, 3, new String[]{"L", "L", "L"});
        mapa.get(0).add(new Piechota("zli", mapa, 0, 6));
        mapa.get(0).add(new LekkaPiechota("zli", mapa, 0, 7));
        mapa.get(0).add(new Piechota("zli", mapa, 0, 8));

        mapa.get(1).add(new Piechota("zli", mapa, 1, 6));
        mapa.get(1).add(new LekkaPiechota("zli", mapa, 1, 7));
        mapa.get(1).add(new Piechota("zli", mapa, 1, 8));

        mapa.get(2).add(new Piechota("zli", mapa, 2, 6));
        mapa.get(2).add(new LekkaPiechota("zli", mapa, 2, 7));
        mapa.get(2).add(new Piechota("zli", mapa, 2, 8));

        Mapa map = new Mapa(mapa);
        int tura=0;
        int lowerCase=armia2.liczebnosc(), upperCase=armia1.liczebnosc();

        do{
            tura++;
            System.out.println();
            System.out.println("TURA "+tura+".   LICZEBNOSC: "+armia1+" "+upperCase+"; "+armia2+" "+lowerCase);
            lowerCase=0;
            upperCase=0;
            if(tura%2==1){
                for (int j=0; j<mapa.get(0).size(); j++){
                    for (int i=0; i<mapa.size();i++){
                        if (mapa.get(i).get(j)!=null && mapa.get(i).get(j).tura()==tura){
                            char symbol = mapa.get(i).get(j).toString().charAt(0);
                            if (Character.isLowerCase(symbol)) {
                                lowerCase++;
                            }
                            else {
                                upperCase++;
                            }
                            mapa.get(i).get(j).turaWykonana();
                            mapa.get(i).get(j).atak();
                            mapa.get(i).get(j).ruszSie();
                            map.generuj();
                        }
                    }
                }
            }
            else {
                for (int j=mapa.get(0).size()-1; j>=0; j--){
                    for (int i=mapa.size()-1; i>=0;i--){
                        if (mapa.get(i).get(j)!=null && mapa.get(i).get(j).tura()==tura){
                            char symbol = mapa.get(i).get(j).toString().charAt(0);
                            if (Character.isLowerCase(symbol))
                                lowerCase++;
                            else
                                upperCase++;
                            mapa.get(i).get(j).turaWykonana();
                            mapa.get(i).get(j).atak();
                            mapa.get(i).get(j).ruszSie();
                            map.generuj();
                        }
                    }
                }
            }
        }
        while (lowerCase!=0 && upperCase!=0);
        System.out.println("KONIEC");
        System.out.println("ZAKONCZONO PO TURZE "+tura+".   REZULTAT: "+armia1+" "+upperCase+"; "+armia2+" "+lowerCase);
        map.generuj();
    }
}