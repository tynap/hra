package cz.vse.adv_framework.empty_classes;
/* Kodovani UTF-8: Příliš žluťoučký kůň úpěl ďábelské ódy. */

import cz.vse.adv_framework.game_txt.IBag;
import cz.vse.adv_framework.game_txt.IObject;

import java.util.Collection;



/*******************************************************************************
 * Instance třídy {@code EmptyBag} představují úložiště, do nichž si hráči
 * odkládají objekty sebrané v jednotlivých prostorech.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 12.01
 */
public class EmptyBag implements IBag
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public EmptyBag()
    {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí kapacitu batohu, tj. maximální povolený součet vah objektů,
     * které se do něj umístí.
     *
     * @return Kapacita batohu
     */
    @Override
    public int getCapacity()
    {
        //TODO Nedodělané
        throw new UnsupportedOperationException(
                                        "Metoda ještě není implementována");
    }


    /***************************************************************************
     * Vrátí kolekci objektů uložených v batohu.
     *
     * @return Kolekce objektů v batohu
     */
    @Override
    public Collection<? extends IObject> getObjects()
    {
        //TODO Nedodělané
        throw new UnsupportedOperationException(
                                        "Metoda ještě není implementována");
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTING CLASSES AND METHODS ===============================================
//
//    /***************************************************************************
//     * Testovací metoda.
//     */
//    public static void test()
//    {
//        EmptyBag inst = new EmptyBag();
//    }
//    /** @param args Parametry příkazového řádku - nepoužívané. */
//    public static void main(String[] args)  {  test();  }
}
