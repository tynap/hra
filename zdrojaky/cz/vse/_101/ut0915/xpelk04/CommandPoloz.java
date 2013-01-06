/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy.
 */
package cz.vse._101.ut0915.xpelk04;





/*******************************************************************************
 * Instance třídy {@code CommandPoloz} představují ...
 *
 * @author  jméno autora
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class CommandPoloz extends ACommand
{
    //== KONSTANTNÍ ATRIBUTY TŘÍDY =============================================
    //== PROMĚNNÉ ATRIBUTY TŘÍDY ===============================================
    //== STATICKÝ INICIALIZAČNÍ BLOK - STATICKÝ KONSTRUKTOR ====================
    //== KONSTANTNÍ ATRIBUTY INSTANCÍ ==========================================
    //== PROMĚNNÉ ATRIBUTY INSTANCÍ ============================================
    //== PŘÍSTUPOVÉ METODY VLASTNOSTÍ TŘÍDY ====================================
    //== OSTATNÍ NESOUKROMÉ METODY TŘÍDY =======================================

    //##########################################################################
    //== KONSTRUKTORY A TOVÁRNÍ METODY =========================================

    /***************************************************************************
     *
     */
    public CommandPoloz()
    {
        super("Poloz", "Příkaz, který položí do místnosti věc z vašich rukou");
    }




    //== ABSTRAKTNÍ METODY =====================================================
    //== PŘÍSTUPOVÉ METODY VLASTNOSTÍ INSTANCÍ =================================
    //== OSTATNÍ NESOUKROMÉ METODY INSTANCÍ ====================================

       @Override
    public String execute(String... arguments)
     {
       if (arguments.length < 2)
        {
            return "Nezadali jste objekt, který chcete položit" + status() ;
        }
     String somethingName = arguments[1];
     Hands HANDS = Hands.getInstance();
     Place currentPlace = Place.getCurrentPlace();
     for (Something something : HANDS.getObjects())
     {
         if (somethingName.equalsIgnoreCase(something.getName()))
         {
                   currentPlace.add(something);
                   HANDS.remove(something);
                   return "Položil(a) jste " + something.getName() + status();
          }
      }

     return "Zadaný předmět nemáte v rukách:" + somethingName + status();
    }
}




    //== SOUKROMÉ A POMOCNÉ METODY TŘÍDY =======================================
    //== SOUKROMÉ A POMOCNÉ METODY INSTANCÍ ====================================
    //== INTERNÍ DATOVÉ TYPY ===================================================
    //== TESTOVACÍ METODY A TŘÍDY ==============================================
    //
    //     /********************************************************************
    //      * Testovací metoda.
    //      */
    //     public static void test()
    //     {
    //         CommandPoloz instance = new CommandPoloz();
    //     }
    //     /** @param args Parametry příkazového řádku - nepoužívané. */
    //     public static void main(String[] args)  {  test();  }

