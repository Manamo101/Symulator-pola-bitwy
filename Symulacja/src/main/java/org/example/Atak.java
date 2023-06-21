package org.example;

import java.util.ArrayList;

/**
 * <p>
 *     Klasa odpowiedzialna za funkcję ataku.
 * </p>
 * <p>
 *     Jest to klasa wywoływana na potrzeby jednostek, aby posiadały funkcję atakowania przeciwników.
 *     Jest to klasa agregowana.
 * </p>
 */
public class Atak {
    private int damage;
    private Integer[] koordynaty = new Integer[2];
    private ArrayList<ArrayList<Jednostki>> mapa;

    /**
     *
     * @param mapa referencja do mapy
     * @param x współrzędna położenia x
     * @param y współrzędna położenia y
     * @param damage siła ataku
     */
    public Atak(ArrayList<ArrayList<Jednostki>> mapa, int x, int y, int damage)
    {
        koordynaty[0]=x;
        koordynaty[1]=y;
        this.damage=damage;
        this.mapa=mapa;
    }

    /**
     * Wykouje atak na jednostce, tzn. zabiera jej punkty życia.
     */
    public void atakuj(){
        Integer[] index=znajdzPrzeciwnika();
        if(index != null) {
            mapa.get(index[0]).get(index[1]).obrazenia(damage);
        }
    }

    /**
     * Aktualizuje miejce położenia jednostki na mapie.
     * @param koordynaty pozycja aktulanego położenia jednostki
     */
    public void ustawKoordynaty(Integer[] koordynaty){
        this.koordynaty=koordynaty;
    }

    /**
     * Odpowiada za znalezienie przeciwnika w zasięgu ataku, tj. dookoła siebie.
     * @return
     */
    Integer[] znajdzPrzeciwnika() {
        Integer[] xy = new Integer[2];
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int foundX = koordynaty[0] + i;
                int foundY = koordynaty[1] + j;

                if (i == 0 && j == 0) {
                    continue;
                }
                if (foundX >= 0 &&  foundX<mapa.size() && foundY >= 0 &&  foundY<mapa.get(0).size()) {

                    if(mapa.get(foundX).get(foundY) != null){
                        if (mapa.get(foundX).get(foundY).nazwaArmii() != mapa.get(koordynaty[0]).get(koordynaty[1]).nazwaArmii()){
                            xy[0] = foundX;
                            xy[1] = foundY;
                            return xy;
                        }
                    }
                }
            }
        }
        return null;
    }
}
