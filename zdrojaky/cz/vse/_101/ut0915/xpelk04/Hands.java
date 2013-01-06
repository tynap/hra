/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.ut0915.xpelk04;

import cz.vse._101.po0000.xpecr999_literals_io.*;
import cz.vse.adv_framework.game_txt.IBag;

import java.util.ArrayList;
import java.util.Collection;



/*******************************************************************************
 * Instance třídy {@code Hands} reprezentují ruce hráče,
 * které v dané hře zastávají funkci "batohu".
 *
 * @author  Kristýna PELEŠKOVÁ
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
    private final Collection<Something> objects = new ArrayList<>();



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
    public static Hands getInstance()
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
    public Collection<Something> getObjects()
    {
        return objects;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================


    public Something chooseSomething(String choosedSomething)
     {
         Something result = null;
         for (Something something : objects)

         {
             if(something.getName().toLowerCase().equals(
                     choosedSomething.toLowerCase()))
               {
                   result = something;
                 }

         }

         if (result != null)
         {
//             objects.remove(result);
             return result;

         }

         else
         {
             return null;
         }
     }


    /***************************************************************************
     * Pokusí se přidat zadaný objekt do batohu.
     * Vrátí informaci o tom, zda se operace zdařila.
     *
     * @param thing Přidávaný objekt
     * @return By-li objekt přidán, vrátí {@code true}, nebyl-li přidán
     *
     */
    boolean add(Something something)
    {
        if (objects.size() + something.getWeight() > CAPACITY) {
            return false;
        }
        objects.add(something);
        return true;
    }

    /***************************************************************************
     * Odebere zadaný objekt z daného prostoru.
     *
     * @param thing Odebíraný objekt
     */
    void remove(Something something)
    {
        objects.remove(something);
    }

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
