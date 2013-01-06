/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.ut0915.xpelk04;

import cz.vse._101.po0000.xpecr999_literals_io.*;





/*******************************************************************************
 * Instance třídy {@code CommandJdi} představují příkazy
 * realizující standardní přesun.
 * Instance by mohla být definována jako jedináček,
 * ale v dané aplikaci svěřuje tuto starost do ruhou správce příkazů.
 *
 * @author  Kristýna PELEŠKOVÁ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class CommandJdi extends ACommand
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
     * Vytvoří příkaz přesouvající hráče z aktuálního prostoru
     * do prostoru zadaného, přičemž zadaný prostor musí být
     * v danou chvíli sousedem prostoru aktuálního.
     */
    public CommandJdi()
    {
        super("Jdi", "Přesune vás z aktuálního prostoru do zadaného sousedního.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Metoda realizující standardní přesun do sousedního prostoru.
     * V parametru by měly být dvě položky: název příkazu
     * a název cílového prostoru.
     *
     * @param arguments Parametry příkazu - název příkazu a cílového prostoru
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return "Nezadali jste prostor, do kterého se chcete přesunout"
                    + status();
        }
        String destName = arguments[1];
        Place currentRoom = Place.getCurrentPlace();
        for (Place neighbor : currentRoom.getNeighbors()) {
            if (destName.equalsIgnoreCase(neighbor.getName())) {
                Place.setCurrentPlace(neighbor);
                return "Vkročil(a) jste do: "  +
                       neighbor.getName() + status();
            }
        }
        return  "Do zadaného prostoru odtud nemůžete přejít." + destName
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
//        CommandJdi inst = new CommandJdi();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
