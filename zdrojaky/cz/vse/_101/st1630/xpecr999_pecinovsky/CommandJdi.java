/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.st1630.xpecr999_pecinovsky;



/*******************************************************************************
 * Instances of class {@code CommandJdi} represent ...
 *
 * @author  Rudolf PECINOVSKÝ
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
     *
     */
    public CommandJdi()
    {
        super("Jdi", "???");
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
            return "Nebylo zadáno, kam se přesunout";
        }
        String destName = arguments[1];
        Room currentRoom = Room.getCurrentRoom();
        for (Room room : currentRoom.getNeighbors()) {
            if (destName.equalsIgnoreCase(room.getName())) {
                Room.setCurrentRoom(room);
                return "Přesunul(a) jste se do místnosti: " + room.getName();
            }
        }
        return "Zadaný prostor není sousedem aktuální místnosti: " + destName;
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
