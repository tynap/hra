/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.ut0915.xpelk04;

import cz.vse._101.po0000.xpecr999_literals_io.*;









/*******************************************************************************
 * Instance třídy {@code CommandVezmi} představují příkazy
 * realizující standardní přesun objektu z prostoru do batohu.
 * Instance by mohla být definována jako jedináček,
 * ale v dané aplikaci svěřuje tuto starost do ruhou správce příkazů.
 *
 * @author  Kristýna PELEŠKOVÁ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class CommandVezmi extends ACommand
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
    public CommandVezmi()
    {
        super("Vezmi", "Příkaz, který sebere věc.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Metoda realizující reakci hry na zadání příkazu
     * pro standardní přesun objektu z prostoru do batohu.
     * V parametru by měly být dvě položky: název příkazu
     * a název přesouvaného objektu.
     *
     * @param arguments Parametry příkazu - název příkazu a přesouvaného objektu
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return "Nezadali jste objekt, který chcete zvednout" + status();
        }
        String somethingName = arguments[1];
        Place currentRoom = Place.getCurrentPlace();
        for (Something something : currentRoom.getObjects()) {
            if (somethingName.equalsIgnoreCase(something.getName())) {
                if (something.getWeight() > 1) {
                    return "Tento objekt nelze zvednou:" + something.getName()
                            + status();
                }
                if (Hands.getInstance().add(something)) {
                    currentRoom.remove(something);
                    return "Zvedl(a) jste " + something.getName() + status();
                }
                return "Máte plné ruce a " + something.getName() +
                       " nemůžete vzít." + status() ;
            }
        }
        return "Zadaný předmět v místnosti není:"  + somethingName
                + status();
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
//        CommandVezmi inst = new CommandVezmi();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
