package cz.vse.adv_framework.empty_classes;
/* Kodovani UTF-8: Příliš žluťoučký kůň úpěl ďábelské ódy. */

import cz.vse.adv_framework.game_txt.IObject;
import cz.vse.adv_framework.game_txt.IPlace;

import java.util.Collection;



/*******************************************************************************
 * Instance třídy {@code EmptyPlace} představují prostory ve hře.
 * Dosažení prostoru si můžeme představovat jako částečný cíl,
 * kterého se hráč ve hře snaží dosáhnout.
 * Prostory mohou být místnosti, planety, životní etapy atd.
 * Prostory mohou obsahovat různé objekty,
 * které mohou hráči pomoci v dosažení cíle hry.
 *
 * @author    Rudolf PECINOVSKÝ
 * @version   0.00.000
 */
public class EmptyPlace implements IPlace
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
    public EmptyPlace()
    {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí popis prostoru, který daný prostor stručné charakterizuje.
     *
     * @return Popis daného prostoru
     */
    @Override
    public String getDescription()
    {
        //TODO Nedodělané
        throw new UnsupportedOperationException(
                                        "Metoda ještě není implementována");
    }


    /***************************************************************************
     * Vrátí název prostoru.
     *
     * @return Název prostoru
     */
    @Override
    public String getName()
    {
        //TODO Nedodělané
        throw new UnsupportedOperationException(
                                        "Metoda ještě není implementována");
    }


    /***************************************************************************
     * Vrátí kolekci sousedů daného prostoru, tj. kolekci prostorů,
     * do nichž je možno se z tohoto prostoru přesunout příkazem typu
     * {@link Commands.Type#MOVE Commands.Type.MOVE}.
     *
     * @return Kolekce sousedů
     */
    @Override
    public Collection<? extends IPlace> getNeighbors()
    {
        //TODO Nedodělané
        throw new UnsupportedOperationException(
                                        "Metoda ještě není implementována");
    }


    /***************************************************************************
     * Vrátí kolekci objektů nacházejících se v daném prostoru.
     *
     * @return Kolekce objektů nacházejících se v daném prostoru
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
//        EmptyPlace inst = new EmptyPlace();
//    }
//    /** @param args Parametry příkazového řádku - nepoužívané. */
//    public static void main(String[] args)  {  test();  }
}
