/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.po0000.xpecr999_literals;

import cz.vse.adv_framework.game_txt.IBag;

import java.util.ArrayList;
import java.util.Collection;



/*******************************************************************************
 * Instance třídy {@code Hands} reprezentují ruce hráče,
 * které v dané hře zastávají funkci "batohu".
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class Hands implements IBag
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Kapacita batohu -- hráč má dvě ruce. */
    private static final int CAPACITY = 2;

    /** Odkaz na jedináčka. */
    private static final Hands HANDS = new Hands();



//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /** Kolekce objektů nacházejících se právě v "batohu". */
    private final Collection<Thing> objects = new ArrayList<>();



//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Tovární metoda vracející odkaz na jedináčka.
     *
     * @return Odkaz na jedinou existující instanci "batohu" = rukou
     */
    public Hands getInstance()
    {
        return HANDS;
    }


    /***************************************************************************
     * Konstruktor nemusí dělat nic, protože veškeré potřebné inicializace
     * jsou realizovány již v deklaracích.
     */
    private Hands()
    {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí kapacitu batohu, tj. součet vah objektů,
     * které je možno současně uložit do batohu.
     *
     * @return Kapacita batohu
     */
    @Override
    public int getCapacity()
    {
        return CAPACITY;
    }


    /***************************************************************************
     * Vrátí kolekci objektů uložených v batohu.
     *
     * @return Kolekce objektů v batohu
     */
    @Override
    public Collection<Thing> getObjects()
    {
        return objects;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Uvede batoh do počátečního stavu pro start hry..
     */
    public void initialize()
    {
        objects.clear();
    }



//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTING CLASSES AND METHODS ===============================================
//
//    /*************************************************************************
//     * Testing method.
//     */
//    public static void test()
//    {
//        Hands inst = new Hands();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
