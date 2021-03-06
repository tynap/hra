package cz.vse._101.ut0915.xpelk04;

/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy.
 */


/**
 * *****************************************************************************
 * Instance třídy {@code CommandNastraz} představují ...
 *
 * @author jméno autora
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class CommandNastraz extends ACommand
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

     /*************************************************************************
     *Vytvoří příkaz nastražující pastičku.
     */
    public CommandNastraz()
    {
        super("nastraž",
              "Pokud je v místnosti myš a vy máte co nastražit," +
                " chytí ji a přidá ji do vašich rukou");
    }


    //== ABSTRAKTNÍ METODY =====================================================
    //== PŘÍSTUPOVÉ METODY VLASTNOSTÍ INSTANCÍ =================================
    //== OSTATNÍ NESOUKROMÉ METODY INSTANCÍ ====================================

    /*************************************************************************
     * Instance třídy CommandNastraz představují příkazy realizující
     * nastražení pastičky. Pokud je v místnosti myš a v rukou pastička,
     * vyndá z rukou pastičku a vloží do nich myš a to samé i v místnosti.
     */

    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return "Nezadali jste objekt, který chcete nastražit" + status();
        }

        String somethingName = arguments[1];
        Hands HANDS = Hands.getInstance();
        Place currentPlace = Place.getCurrentPlace();

        boolean jeMyš      = false;
        boolean jePastička = false;

        if (!somethingName.toLowerCase().equals("pastička"))
                {
                    return  "Nemůžete přece nastražit "
                            + somethingName + " jako" +
                            " pastičku..." +  status();
                }

        Something pastička = HANDS.chooseSomething("pastička");
        if (somethingName != null) {
            jePastička = true;
        }

        Something myš = currentPlace.chooseSomething("Myš");
        if (myš != null) {
            jeMyš = true;
        }

        if (jeMyš && jePastička)
         {
            currentPlace.add(pastička);
            currentPlace.remove(myš);
            HANDS.remove(pastička);
            HANDS.add(myš);
            return "Nastražil(a) jste pastičku a chytil(a) myš"  + status();
        }

        if (jeMyš && !jePastička)
         {
            return "Nemáte pastičku, kterou byste nastražil" + status();
        }

        if (!jeMyš && jePastička)
         {
            return "V místnosti není myš, kterou byste mohl(a) chytit"
                   + status();
        }

        if (!jeMyš && !jePastička)
         {
            return "V místnosti není myš a nemáte ani pastičku," +
                " kterou byste nastražil(a)"  + status();
        }

        return "";
    }



//    == SOUKROMÉ A POMOCNÉ METODY TŘÍDY =======================================
//    == SOUKROMÉ A POMOCNÉ METODY INSTANCÍ ====================================
//    == INTERNÍ DATOVÉ TYPY ===================================================
//    == TESTOVACÍ METODY A TŘÍDY ==============================================
//
//         /********************************************************************
//          * Testovací metoda.
//          */
//         public static void test()
//         {
//             CommandNastraz instance = new CommandNastraz();
//         }
//         /** @param args Parametry příkazového řádku - nepoužívané. */
//         public static void main(String[] args)  {  test();  }
}


