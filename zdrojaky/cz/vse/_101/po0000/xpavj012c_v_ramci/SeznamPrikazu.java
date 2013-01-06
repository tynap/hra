package cz.vse._101.po0000.xpavj012c_v_ramci;

import cz.vse.adv_framework.game_txt.ICommand;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 *  Class SeznamPrikazu - eviduje seznam přípustných příkazů adventury.
 *  Používá se pro rozpoznávání příkazů
 *  a vrácení odkazu na třídu implementující konkrétní příkaz.
 *  Každý nový příkaz (instance implementující rozhraní Prikaz) se
 *  musí do seznamu přidat metodou vlozPrikaz.
 *
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2012/2013
 */
class SeznamPrikazu {
    // mapa pro uložení přípustných příkazů
    private  Map<String,IPrikaz> platnePrikazy;

    private Collection<ICommand> adaptovanePrikazy = new ArrayList<>();



    /**
     * Konstruktor
     */
    SeznamPrikazu() {
        platnePrikazy = new HashMap<>();
    }


    /**
     * Vkládá nový příkaz.
     *
     *@param  prikaz  Instance třídy implementující rozhraní IPrikaz
     */
    public void vlozPrikaz(IPrikaz prikaz) {
        platnePrikazy.put(prikaz.getNazev(),prikaz);
        adaptovanePrikazy.add(new PrikazAdapter(prikaz));
    }

    /**
     * Vrací odkaz na instanci třídy implementující rozhraní IPrikaz,
     * která provádí příkaz uvedený jako parametr.
     *
     *@param  retezec  klíčové slovo příkazu, který chce hráč zavolat
     *@return          instance třídy, která provede požadovaný příkaz
     */
    public IPrikaz vratPrikaz(String retezec) {
        if (platnePrikazy.containsKey(retezec)) {
            return platnePrikazy.get(retezec);
        }
        else {
            return null;
        }
    }

    /**
     * Kontroluje, zda zadaný řetězec je přípustný příkaz.
     *
     *@param  retezec  Řetězec, který se má otestovat, zda je přípustný příkaz
     *@return          Vrací hodnotu true, pokud je zadaný
     *                     řetězec přípustný příkaz
     */
    public boolean jePlatnyPrikaz(String retezec) {
        return platnePrikazy.containsKey(retezec);
    }

    /**
     *  Vrací seznam přípustných příkazů, jednotlivé příkazy jsou odděleny mezerou.
     *
     *  @return     Řetězec, který obsahuje seznam přípustných příkazů
     */
    public String vratNazvyPrikazu() {
        String seznam = "";
        for (String slovoPrikazu : platnePrikazy.keySet()){
            seznam += slovoPrikazu + " ";
        }
        return seznam;
    }


    /**
     *  Vrací seznam příkazů odpovídajících požadavkům rámce.
     *
     *  @return Seznam příkazů odpovídajících požadavkům rámce
     */
    public Collection<ICommand> getAdaptovanePrikazy()
    {
        return Collections.unmodifiableCollection(adaptovanePrikazy);
    }

}
