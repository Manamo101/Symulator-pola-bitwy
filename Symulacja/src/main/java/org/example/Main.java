package org.example;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Jednostki>> mapa = new ArrayList<ArrayList<Jednostki>>();
        Mapa map = new Mapa(mapa);
        NazwaJednostki[] grupa1 = new NazwaJednostki[]{NazwaJednostki.piechota,NazwaJednostki.piechota,NazwaJednostki.piechota,NazwaJednostki.piechota};
        Armia armia1 = new Armia("dobrzy", 4, 3, grupa1);
        map.stworzArmie("dobrzy", 4, 3, grupa1);
        NazwaJednostki[] grupa2= new NazwaJednostki[]{NazwaJednostki.lekkaPiechota,NazwaJednostki.lekkaPiechota,NazwaJednostki.piechota};
        Armia armia2 = new Armia("zli", 3, 3, grupa2);
        map.stworzArmie("zli", 3, 3, grupa2);

        int tura=0;
        int lowerCase=armia2.liczebnosc(), upperCase=armia1.liczebnosc();

        do{
            tura++;
            System.out.println();
            System.out.println("TURA "+tura+".   LICZEBNOSC: "+armia1+" "+upperCase+"; "+armia2+" "+lowerCase);
            if (tura==1)
                map.generuj();
            lowerCase=0;
            upperCase=0;
            if(tura%2==1){
                for (int j=0; j<mapa.get(0).size(); j++){
                    for (int i=0; i<mapa.size();i++){
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