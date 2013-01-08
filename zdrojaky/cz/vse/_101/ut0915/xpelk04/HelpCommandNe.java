/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.ut0915.xpelk04;



/*******************************************************************************
 * Instances of class {@code HelpCommandNe} represent ...
 *
 * @author  Kristýna PELEŠKOVÁ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class HelpCommandNe extends ACommand
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
    public HelpCommandNe()
    {
        super("ne", " ");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

@Override
    public String execute(String... arguments)
    {
        if (arguments.length > 1)
        {
            return "Tento příkaz neznám" + status();
        }


    Place currentPlace = Place.getCurrentPlace();


      if(currentPlace.getName().toLowerCase().equals("voliéra"))
        {
            Game.getInstance().stop();


           return "Odpověděli jste špatně, ptáci se na vás" +
                   " slétli \n a uklovali. Hra pro vás končí." +
                   "Děkuji, že jste si zahrál(a) moji hru." ;

        }

   else {
            return "Tento příkaz neznám" + status(); }

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
//        HelpCommandNe inst = new HelpCommandNe();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
