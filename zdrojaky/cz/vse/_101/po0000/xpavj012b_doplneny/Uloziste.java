package cz.vse._101.po0000.xpavj012b_doplneny;

import java.util.ArrayList;
import java.util.Collection;



public class Uloziste
{
    private static final int KAPACITA = 2;

    private final Collection<Vec> objekty = new ArrayList<>();


    boolean pridej(Vec objekt) {
        boolean zvedam = (objekty.size() < KAPACITA)  &&  objekty.add(objekt);
        return zvedam;
    }


    Vec vyjmi(String nazev) {
        nazev = nazev.toLowerCase();
        for (Vec objekt : objekty) {
            if (objekt.getNazev().toLowerCase().equals(nazev)) {
                return objekt;
            }
        }
        return null;
    }
}
