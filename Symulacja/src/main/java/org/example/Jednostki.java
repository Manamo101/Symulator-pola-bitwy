package org.example;

public abstract class Jednostki {
    private String skrot;
    private int hp;
    private int damage;
    private Atak atak;
    private Ruch ruch;
    abstract void obrazenia(int trafienie);
    abstract void atak();
    abstract void ruszSie();
    abstract String nazwaArmii();
    abstract public int tura();
    abstract public void turaWykonana();

}
