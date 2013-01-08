/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.ut0915.xpelk04;





/*******************************************************************************
 * Instances of class {@code CommandVymen} represent ...
 *
 * @author  Kristýna PELEŠKOVÁ
 * @version 0.00.0000 — 2013-03-01
 */
public class CommandVymen extends ACommand
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
 public CommandVymen()
    {
            super("vyměň",
            "vymění 1. zadanou věc za 2. zadanou věc z místnosti");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTING CLASSES AND METHODS ===============================================
//
    /*************************************************************************

     * Testing method.
     */
//    public static void test()
//    {
//        CommandVymen inst = new CommandVymen();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }

/****************************************************************************
 *Instance třídy CommandVymen představují příkazy realizující vyměnění věci
 * z vašich rukou za věc z místnosti.
 */
    @Override
    public String execute(String... arguments)
    {
       if (arguments.length < 3)
        {
            return "Nezadali jste objekt, který chcete vyměnit" + status();
        }

    String fromHands = arguments[1];
    String fromPlace = arguments[2];
    Hands HANDS = Hands.getInstance();
    Place currentPlace = Place.getCurrentPlace();

    boolean jeMyš  = false;
    boolean jeVoda = false;

    boolean isFromHands = false;
    boolean isFromPlace = false;



    Something myš = HANDS.chooseSomething("myš");
    if (myš != null)
    {
        jeMyš = true ;
    }



    Something voda = currentPlace.chooseSomething("Voda");
        if (voda != null)
        {
            jeVoda = true;
        }



    if (jeMyš && jeVoda)
    {
        currentPlace.add(myš);
        currentPlace.remove(voda);
        HANDS.remove(myš);
        HANDS.add(voda);
        return

                 "Nakrmil(a) jste hady a odměnou je vám vědro s vodou."
                 + status();
     }

    if (jeMyš && !jeVoda)
    {
        return "V této místnosti nemáte koho nakrmit myší"
                 + status();
    }

    if (!jeMyš && jeVoda)
    {
        return "Nemáte čím nakrmit hady a ti vám nevymění vodu";
    }



     Something isFromPlace1 = currentPlace.chooseSomething(fromPlace);
       if (isFromPlace1 != null)
       {
           isFromPlace = true;

       }

       Something isFromHands1 = HANDS.chooseSomething(fromHands);
       if (isFromHands1 != null)
       {
           isFromHands = true;

       }



    if (isFromHands && isFromPlace)
    {
        currentPlace.add(isFromHands1);
        currentPlace.remove(isFromPlace1);
        HANDS.remove(isFromHands1);
        HANDS.add(isFromPlace1);

        return

                 "Vyměnil(a) jste " + " " + fromHands + " "  + "za " + " "
                 + fromPlace
                 + status();
     }



    if (!isFromHands && isFromPlace)
    {
        return "Zadaný předmět, který chcete vyměnit, nemáte v rukách"
              + status();
    }



    if (isFromHands && !isFromPlace)
     {
         return "Zadaný předmět, který chcete vyměnit za " + fromHands +
                " není v místnosti" + status();
     }

     if (!isFromHands && !isFromPlace)
     {
         return "Nemáte v ruce " + fromHands + "ani není v místnosti " +
                fromPlace + status();
     }


        return "";

    }


}
//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */

