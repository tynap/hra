/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.vse._101.po0000.xpavj012c_v_ramci;

import cz.vse.adv_framework.game_txt.IObject;


/*******************************************************************************
 * Instance třídy Vec představují předměty v adventuře, návrh je velmi jednoduchý
 * a odpovídá pouze podmímce z obecného zadání, že některé věci lze odnést a jiné ne.
 *
 * @author    Pavlíčková
 * @version   0.1
 */
public class Vec implements IObject
{
    //== Datové atributy (statické i instancí)======================================
    private String nazev;
    private boolean prenositelnost;
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor pro vytvoření věci
     *
     *  @param nazev
     *  @param prenositelnost
     */
    public Vec(String nazev, boolean prenositelnost)
    {
        this.nazev = nazev;
        this.prenositelnost = prenositelnost;
    }

    //== Nesoukromé metody (instancí i třídy) ==================================

    /***************************************************************************
     *  Metoda vrací název věci
     *
     *  @return název věci
     */
    public String getNazev(){
        return nazev;
    }

    /***************************************************************************
     *  Metoda vrací informaci o tom, zda lze předmět z prostoru ve hře odnést
     *
     *  @return přenositelnost
     */
    public boolean jePrenositelna(){
        return prenositelnost;
    }


    /***************************************************************************
     * Vrátí váhu objektu, resp. charakteristiku jí odpovídající.
     * Objekty, které není možno zvednout, vrací -1.
     *
     * @return Váha objektu nebo hodnota -1 charakterizující,
     *         že daný objekt není možno zvednou a umístit do batohu.
     */
    @Override
    public int getWeight()
    {
        return prenositelnost ? 1 : Integer.MAX_VALUE;
    }


    /***************************************************************************
     * Vrátí název dané instance.
     *
     * @return Název instance
     */
    @Override
    public String getName()
    {
        return nazev;
    }

    //== Soukromé metody (instancí i třídy) ====================================

}
