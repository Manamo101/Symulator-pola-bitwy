package org.example;

import java.util.ArrayList;

import static java.lang.Math.*;
import static java.lang.Math.sqrt;

public class Ruch {
    private int dlugosc;
    private Integer[] koordynaty = new Integer[2];
    private ArrayList<ArrayList<Jednostki>> mapa;
    public Ruch(ArrayList<ArrayList<Jednostki>> mapa, int x, int y,int dlugosc){
        this.dlugosc=dlugosc;
        koordynaty[0]=x;
        koordynaty[1]=y;
        this.mapa=mapa;
    }
    Integer[] srodekCiezkosci(){
        int kolumny = mapa.get(0).size();
        int rzedy = mapa.size();
        int n=0;
        Integer[] xy = new Integer[]{0,0};
        for (int i=1;i<=rzedy;i++)
        {
            for (int j=1;j<=kolumny;j++)
            {
                if (mapa.get(i-1).get(j-1)!=null)
                {
                    n++;
                    xy[0]=xy[0]+i;
                    xy[1]=xy[1]+j;
                }
            }
        }
        xy[0]=xy[0]/n-1;
        xy[1]=xy[1]/n-1;
        return xy;
    }

    Integer[] ruszSie(){
        Integer[] srodekCiezkosci = srodekCiezkosci();
        Integer[] xy = new Integer[]{koordynaty[0],koordynaty[1]};
        double dlMin=9999;
        int kolumny = mapa.get(0).size()-1;
        int rzedy = mapa.size()-1;

        // ruch w prawo
        if (koordynaty[1]+1<=rzedy && mapa.get(koordynaty[0]).get(koordynaty[1]+1)==null){
            double dl = sqrt(pow(srodekCiezkosci[0]-koordynaty[0],2)+pow(srodekCiezkosci[1]-(koordynaty[1]+1),2));
            if (dl<dlMin){
                dlMin=dl;
                xy[0]=koordynaty[0];
                xy[1]=koordynaty[1]+1;
            }
        }
        //ruch w lewo
        if (koordynaty[1]-1>=0 && mapa.get(koordynaty[0]).get(koordynaty[1]-1)==null){
            double dl = sqrt(pow(srodekCiezkosci[0]-koordynaty[0],2)+pow(srodekCiezkosci[1]-(koordynaty[1]-1),2));
            if (dl<dlMin){
                dlMin=dl;
                xy[0]=koordynaty[0];
                xy[1]=koordynaty[1]-1;
            }
        }
        //ruch w gore
        if (koordynaty[0]+1>=0 && mapa.get(koordynaty[0]+1).get(koordynaty[1])==null){
            double dl = sqrt(pow(srodekCiezkosci[0]-(koordynaty[0]+1),2)+pow(srodekCiezkosci[1]-koordynaty[1],2));
            if (dl<dlMin){
                dlMin=dl;
                xy[0]=koordynaty[0]+1;
                xy[1]=koordynaty[1];
            }
        }
        //ruch w dol
        if (koordynaty[0]-1>=0 && mapa.get(koordynaty[0]-1).get(koordynaty[1])==null){
            double dl = sqrt(pow(srodekCiezkosci[0]-(koordynaty[0]-1),2)+pow(srodekCiezkosci[1]-koordynaty[1],2));
            if (dl<dlMin){
                dlMin=dl;
                xy[0]=koordynaty[0]-1;
                xy[1]=koordynaty[1];
            }
        }
        mapa.get(xy[0]).set(xy[1],mapa.get(koordynaty[0]).get(koordynaty[1]));
        mapa.get(koordynaty[0]).set(koordynaty[1],null);
        koordynaty=xy;
        return xy;
    }
}
