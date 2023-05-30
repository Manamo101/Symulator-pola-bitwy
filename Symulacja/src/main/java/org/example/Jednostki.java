package org.example;

public abstract class Jednostki {
    private String skrot;
    private int hp;
    private int damage;
    private int dlRuchu;
    private Atak atak;
    private Ruch ruch;
    abstract void obrazenia(int trafienie);
    abstract void atak();
    abstract void ruszSie();
}
