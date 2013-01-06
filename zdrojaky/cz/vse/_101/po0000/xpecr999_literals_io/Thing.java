/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.po0000.xpecr999_literals_io;

import cz.vse.adv_framework.game_txt.IObject;



/*******************************************************************************
 * Instance třídy {@code Thing} představují objekty vystupující ve hře.
 * Tato verze očekává, že objednatel objektu předá požadavky na vytvářený objekt
 * buď v parametrech konstruktoru, anebo zavoláním vhodné tovární metody.
 * Nabízí proto veřejné konstruktory i tovární metody.
 * Řešení s továrními metodami lze ale považovat za lepší,
 * protože program žádající o vytvoření objektu je pak srozumitelnější.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class Thing implements IObject
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /** Název objektu. */
    private final String name;

    /** Váha objektu. U nezvednutelných objektů
     *  musí být větší než kapacita batohu. */
    private final int weight;

    /** Informace o tom, je-li objekt alkoholický nápoj, aby se lednička
     *  mohla rozhodnout, zda bude prověřovat plnoletost žadatele. */
    private final boolean alcoholic;



//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Vytvoří nový obyčejný objekt se zadaným názvem.
     *
     * @param name   Název vytvářeného objektu
     * @return Vrátí požadovaný objekt
     */
    public static Thing newOrdinaryThing(String name)
    {
        return new Thing(name, 1, false);
    }


    /***************************************************************************
     * Vytvoří nový těžký, nezvednutelný objekt se zadaným názvem.
     *
     * @param name   Název vytvářeného objektu
     * @return Vrátí požadovaný objekt
     */
    public static Thing newHeavyThing(String name)
    {
        return new Thing(name, Integer.MAX_VALUE, false);
    }


    /***************************************************************************
     * Vytvoří nový objekt se zadaným názvem představující alkoholický nápoj.
     *
     * @param name   Název vytvářeného objektu
     * @return Vrátí požadovaný objekt
     */
    public static Thing newAlcoholicDrink(String name)
    {
        return new Thing(name, 1, true);
    }


    /***************************************************************************
     * Vytvoří nový objekt se zadaným názvem a vahou.
     *
     * @param name   Název vytvářeného objektu
     * @param weight Váha vytvářeného objektu
     */
    public Thing(String name, int weight)
    {
        this(name, weight, false);
    }


    /***************************************************************************
     * Vytvoří nový objekt se zadaným názvem a alkoholičností.
     *
     * @param name      Název vytvářeného objektu
     * @param alcoholic Příznak alkoholičnosti objektu - jedná-li se o
     *                  alkoholický nápoj {@code true}, jinak {@code false}
     */
    public Thing(String name, boolean alcoholic)
    {
        this(name, 1, true);
    }


    /***************************************************************************
     * Vytvoří nový objekt se zadaným názvem a vahou.
     *
     * @param name   Název vytvářeného objektu
     * @param weight Váha vytvářeného objektu
     */
    public Thing(String name, int weight, boolean alcoholic)
    {
        this.name      = name;
        this.weight    = weight;
        this.alcoholic = alcoholic;
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí informaci o tom, představuje-li daný objekt alkoholický nápoj.
     *
     * @return Jedná-li se o alkoholický nápoj, vrátí {@code true},
     *         jinak vrátí {@code false}
     */
    public boolean isAlcoholic()
    {
        return alcoholic;
    }


    /***************************************************************************
     * Vrátí název dané instance.
     *
     * @return Název instance
     */
    @Override
    public String getName()
    {
        return name;
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
        return weight;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
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
//        Thing inst = new Thing();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
