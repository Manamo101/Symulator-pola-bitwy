package org.example;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Jednostki>> mapa = new ArrayList<ArrayList<Jednostki>>();
        Mapa map = new Mapa(mapa);

        NazwaJednostki[] grupa1 = new NazwaJednostki[]{NazwaJednostki.piechota,NazwaJednostki.piechota,NazwaJednostki.piechota,NazwaJednostki.piechota};
        int kolumny1=4,rzedy1=3;
        Armia armia1 = new Armia("dobrzy", kolumny1, rzedy1, grupa1);
        map.stworzArmie(armia1);

        NazwaJednostki[] grupa2= new NazwaJednostki[]{NazwaJednostki.lekkaPiechota,NazwaJednostki.lekkaPiechota,NazwaJednostki.piechota};
        int kolumny2=3, rzedy2=3;
        Armia armia2 = new Armia("zli", kolumny2, rzedy2, grupa2);
        map.stworzArmie(armia2);

        int tura=0;
        do{
            tura++;
            System.out.println();
            System.out.println("TURA "+tura+".   LICZEBNOSC: "+armia1+" "+armia1.liczebnosc()+"; "+armia2+" "+armia2.liczebnosc());

            if (tura==1)
                map.generuj();

            if(tura%2==1){
                for (int j=0; j<mapa.get(0).size(); j++){
                    for (int i=0; i<mapa.size();i++){
                        if (mapa.get(i).get(j)!=null && mapa.get(i).get(j).tura()==tura){
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
                            mapa.get(i).get(j).turaWykonana();
                            mapa.get(i).get(j).atak();
                            mapa.get(i).get(j).ruszSie();
                            map.generuj();
                        }
                    }
                }
            }
        }
        while (armia1.liczebnosc()!=0 && armia2.liczebnosc()!=0);
        System.out.println("KONIEC");
        System.out.println("ZAKONCZONO PO TURZE "+tura+".   REZULTAT: "+armia1+" "+armia1.liczebnosc()+"; "+armia2+" "+armia2.liczebnosc());
        map.generuj();
    }
}