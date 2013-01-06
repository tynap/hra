/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.po0000.xpecr999_literals_cmd2;



/*******************************************************************************
 * Instance třídy {@code CommandVezmi} představují příkazy
 * realizující standardní přesun objektu z prostoru do batohu.
 * Instance by mohla být definována jako jedináček,
 * ale v dané aplikaci svěřuje tuto starost do ruhou správce příkazů.
 *
 * @author  Rudolf PECINOVSKÝ
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
        super("Vezmi", "");
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
            return "Nebylo zadáno co mám vzít";
        }
        String thingName = arguments[1];
        Room currentRoom = Room.getCurrentRoom();
        for (Thing thing : currentRoom.getObjects()) {
            if (thingName.equalsIgnoreCase(thing.getName())) {
                if (thing.getWeight() > 1) {
                    return "Zadaný předmět nejde zvednout: " + thing.getName();
                }
                if (Hands.getInstance().add(thing)) {
                    currentRoom.remove(thing);
                    return "Vzal(a) jste předmět: " + thing.getName();
                }
                return "Předmět se již do batohu nevejde: " + thing.getName();
            }
        }
        return "Zadaný předmět v místnosti není: " + thingName;
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
