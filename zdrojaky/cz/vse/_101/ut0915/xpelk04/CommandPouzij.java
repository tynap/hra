/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.ut0915.xpelk04;



/*******************************************************************************
 * Instances of class {@code CommandPouzij} represent ...
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class CommandPouzij extends ACommand
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
    public CommandPouzij()
    {
        super("použij", "Příkaz, který použije vámi vybranou věc a něco " +
                "vám za ní dá/něco se vám otevře atd..");

    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

     @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2)
          {
            return "Nezadali jste objekt, který chcete nastražit" + status();
          }

      String somethingName = arguments[1];
      Hands HANDS = Hands.getInstance();
      Place currentPlace = Place.getCurrentPlace();

      boolean jeVoda    = false;
      boolean jeKarta   = false;

        if (somethingName.toLowerCase().equals("voda") ||
            somethingName.toLowerCase().equals("ošetřovatelova_karta")) {

            Something voda = HANDS.chooseSomething("Voda");
            if (somethingName != null) {
                jeVoda = true;
            }

            Something karta = HANDS.chooseSomething("Ošetřovatelova_karta");
            if (somethingName != null) {
                jeKarta = true;
            }

            if (jeVoda && currentPlace.getName().equals("Sloni"))
            {
                currentPlace.add(Something.newOrdinarySomething(
                        "Ošetřovatelova_karta"));
                HANDS.remove(voda);

                return
            "Osvěžil(a) jste slony a ty se v klidu přesunuly pryč. " +
            "Nyní můžete prohledat kapsy"+
            "\nmrtvému ošetřovateli v rohu."  + status();

            }

            if (jeKarta && currentPlace.getName().equals("Exit")) {
                Game.getInstance().stop();
                return
                "\"Cvak\", slyšíte odedveří, které se pomalu otevírají a vy " +
                "\nbezpečně v plném zdraví vycházíte ze ZOO, spíše jungle a " +
                        "venku" +
                "\n na vás čekají davy novinářů. Děkuji, že jste si úspěšně " +
                "zahrál(a) moji hru.";
            }
        }
        else {
            return "Tento předmět nemůžete použít." + status();
        }


        return "";
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
//        CommandPouzij inst = new CommandPouzij();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
