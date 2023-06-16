package org.example;

/**
 * Klasa dziedzczona przez wszystkie jednostki.
 *
 * <p>
 *     Zawiera niezbędne zmienne oraz metody do prawidłwego działania jednostek.
 *     Wszystkie klasy jednostek dziedziczą po niej.
 *     Mapa, na której toczy się rozgrywa jest tablicą tej klasy
 * </p>
 */
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
