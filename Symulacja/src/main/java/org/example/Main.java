package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //deklaracje zmiennych
        ArrayList<ArrayList<Jednostki>> mapa = new ArrayList<ArrayList<Jednostki>>();
        Mapa map = new Mapa(mapa);
        String nazwa1="dobrzy", nazwa2="zli";
        int kolumny1=4,rzedy1=3;
        int kolumny2=3, rzedy2=3;
        Scanner wejscie = new Scanner(System.in);
        NazwaJednostki[] grupa1, grupa2;

        //MENU
        System.out.println("SYMULATOR POLA BITWY");
        System.out.println("Podaj nazwe armii nr 1: ");
        nazwa1 = wejscie.nextLine();
        System.out.println("Podaj ilosc rzedow: ");
        rzedy1 = wejscie.nextInt();
        System.out.println("Podaj ilosc kolumn: ");
        kolumny1 = wejscie.nextInt();
        grupa1 = new NazwaJednostki[kolumny1];
        for (int i=0; i< kolumny1; i++){
            System.out.println("Podaj nazwe jednostki dla " + (i+1) + ". kolumny (Piechota - \"p\", Lekka Piechota - \"l\")");
            char znak = wejscie.next().charAt(0);
            switch (znak){
                case 'p':
                    grupa1[i]=NazwaJednostki.piechota;
                    break;
                case 'l':
                    grupa1[i]=NazwaJednostki.lekkaPiechota;
                    break;
                default:
                    System.out.println("Blad wczytywania jednostek kolumny");
            }
        }
        System.out.println("Podaj nazwe armii nr 2: ");
        wejscie.nextLine();
        nazwa2 = wejscie.nextLine();
        System.out.println("Podaj ilosc rzedow: ");
        rzedy2 = wejscie.nextInt();
        System.out.println("Podaj ilosc kolumn: ");
        kolumny2 = wejscie.nextInt();
        grupa2 = new NazwaJednostki[kolumny2];
        for (int i=0; i< kolumny2; i++){
            System.out.println("Podaj nazwe jednostki dla " + (i+1) + ". kolumny (Piechota - \"p\", Lekka Piechota - \"l\")");
            char znak = wejscie.next().charAt(0);
            switch (znak){
                case 'p':
                    grupa2[i]=NazwaJednostki.piechota;
                    break;
                case 'l':
                    grupa2[i]=NazwaJednostki.lekkaPiechota;
                    break;
                default:
                    System.out.println("Blad wczytywania jednostek kolumny");
            }
        }
        wejscie.close();

        // Tworzenie armi
        Armia armia1 = new Armia(nazwa1, kolumny1, rzedy1, grupa1);
        map.stworzArmie(armia1);
        Armia armia2 = new Armia(nazwa2, kolumny2, rzedy2, grupa2);
        map.stworzArmie(armia2);

        //wyczyszczenie pliku z zapisem
        File zapis = new File("zapis.txt");
        new FileWriter(zapis,false).close();

        //pętla symulacyjna
        int tura=0;
        while (armia1.liczebnosc()!=0 && armia2.liczebnosc()!=0){
            tura++;
            System.out.println();
            System.out.println("TURA "+tura+".   LICZEBNOSC: "+armia1+" "+armia1.liczebnosc()+"; "+armia2+" "+armia2.liczebnosc());
            map.zapisTury(tura);
            if (tura==1){
                map.generuj(tura);
                System.out.println("---------------------------");
                try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
            }
            if(tura%2==1){
                for (int j=0; j<mapa.get(0).size(); j++){
                    for (int i=0; i<mapa.size();i++){
                        if (mapa.get(i).get(j)!=null && mapa.get(i).get(j).tura()==tura){
                            mapa.get(i).get(j).turaWykonana();
                            mapa.get(i).get(j).atak();
                            mapa.get(i).get(j).ruszSie();
                            map.zapis();
                            map.generuj(tura);
                            System.out.println("---------------------------");
                            try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
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
                            map.zapis();
                            map.generuj(tura);
                            System.out.println("---------------------------");
                            try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
                        }
                    }
                }
            }
        }
        map.zapisKoniec(tura);
        map.generujZakonczenie(tura);
        map.zapis();
    }
}