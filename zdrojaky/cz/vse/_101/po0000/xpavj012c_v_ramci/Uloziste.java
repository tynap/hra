package cz.vse._101.po0000.xpavj012c_v_ramci;

import cz.vse.adv_framework.game_txt.IBag;
import cz.vse.adv_framework.game_txt.IObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;



public class Uloziste implements IBag
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


    @Override
    public int getCapacity()
    {
        return KAPACITA;
    }


    @Override
    public Collection<? extends IObject> getObjects()
    {
        return Collections.unmodifiableCollection(objekty);
    }
}
