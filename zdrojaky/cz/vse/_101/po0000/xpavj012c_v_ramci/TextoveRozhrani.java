package cz.vse._101.po0000.xpavj012c_v_ramci;

import cz.vse.adv_framework.game_txt.IGame;
import cz.vse.adv_framework.game_txt.IUI;
import java.util.Scanner;

/**
 *  Class TextoveRozhrani
 *
 *  Toto je uživatelského rozhraní aplikace Adventura
 *  Tato třída vytváří instanci třídy Hra, která představuje logiku aplikace.
 *  Čte vstup zadaný uživatelem a předává tento řetězec logice a vypisuje odpověď logiky na konzoli.
 *  Pokud chcete hrát tuto hru, vytvořte instanci této třídy
 *  a poté na ní vyvolejte metodu "hraj".
 *
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2012/2013
 */

public class TextoveRozhrani implements IUI {
    private Hra hra;

    /**
     *  Vytváří hru.
     */
    public TextoveRozhrani() {
        hra = Hra.getInstance();
    }

    /**
     *  Hlavní metoda hry. Vypíše úvodní text a pak opakuje čtení a zpracování
     *  příkazu od hráče do konce hry (dokud metoda konecHry() z logiky nevrátí
     *  hodnotu true). Nakonec vypíše text epilogu.
     */
    public void hraj() {
        System.out.println(hra.vratUvitani());

        // základní cyklus programu - opakovaně se čtou příkazy a poté
        // se provádějí do konce hry.

        while (!hra.konecHry()) {
            String radek = prectiString();
            System.out.println(hra.zpracujPrikaz(radek));
        }

        System.out.println(hra.vratEpilog());
    }

    /**
     *  Metoda přečte příkaz z příkazového řádku
     *
     *@return    Vrací přečtený příkaz jako instanci třídy String
     */
    private String prectiString() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        return scanner.nextLine();
    }


    /***************************************************************************
     * Spustí komunikaci mezi zadanou hrou a danou instancí
     * mající na starosti komunikaci s uživatelem.
     *
     * @param hra Hra, kterou ma dané UI spustit
     */
    @Override
    public void startGame(IGame hra)
    {
        String prikaz = "";
        for(;;) {
            String odpoved = hra.executeCommand(prikaz);
            System.out.println(odpoved);

            if (! hra.isAlive()) { return; }     //==========>

            System.out.println('>');
            prikaz = prectiString();
        }
    }


    /***************************************************************************
     * Spustí komunikaci mezi implicitní hrou a danou instancí
     * mající na starosti komunikaci s uživatelem.
     */
    @Override
    public void startGame()
    {
        startGame(Hra.getInstance());
    }

}
