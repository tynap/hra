/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.po0000.xpecr999_constants;

import cz.vse.adv_framework.game_txt.IObject;



/*******************************************************************************
 * Instance třídy {@code Thing} představují objekty vystupující ve hře.
 * Tato verze očekává, že objednatel objektu předá požadavky na vytvářený objekt
 * prostřednictvím příznaků v názvu vytvářeného objektu
 * a konstruktor si z těchto příznaků vše potřebné odvodí.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class Thing implements IObject
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Prefix určující, že předmět nepůjde zvednout. */
    public static final char HEAVY = '#';

    /** Prefix určující, že se jedná o alkoholický nápoj. */
    public static final char ALCOHOLIC = '@';



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
     * Vytvoří nový objekt se zadaným názvem
     * a vahou odvozenou od prvního znaku názvu.
     *
     * @param name   Název vytvářeného objektu
     */
    public Thing(String name)
    {
        //Pomocné proměnné, do nichž připravíme hodnotu atributů
        boolean alco = false;
        int     wght = 1;

        //Podle prefixu opravíme připravené hodnoty
        if (name.charAt(0) == HEAVY) {
            name = name.substring(1);
            wght = Integer.MAX_VALUE;
        }
        else if (name.charAt(0) == ALCOHOLIC) {
            name = name.substring(1);
            alco = true;
        }

        //Inicializujeme atributy
        this.name      = name;
        this.weight    = wght;
        this.alcoholic = alco;
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
