/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy.
 */
package cz.vse.adv_framework.test_util;

import cz.vse.adv_framework.scenario.Scenario;
import cz.vse.adv_framework.scenario.AScenarioManager;
import cz.vse.adv_framework.scenario.ScenarioStep;

import cz.vse.adv_framework.utilities.DBG_Logger;

import java.util.Date;
import java.util.Iterator;



/*******************************************************************************
 * Instance třídy {@code ScenarioManagerTest} umějí otestovat správce scénářů.
 * Testují však pouze korektnost vlastních správců scénářů
 * a korektnost jimi spravovaných scénářů.
 * Nepokouší se pomocí scénářů zadaného správce testovat příslušnou hru.
 * To mají na starosti instance třídy {@link ScenarioSimulator}.
 * <p>
 * Třída není definována jako knihovní,
 * aby mohla implementovat rozhraní {@code ITest}
 * a bylo ji tak možno použít v hromadných testech odevzdaných scénářů.
 *
 * @author    Rudolf PECINOVSKÝ
 * @version   0.00.000
 */
class ScenarioManagerTest implements ITest<AScenarioManager>
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Logger, prostřednictvím nějž zaznamenáváme veškeré informace. */
    private final static DBG_Logger DBG = DBG_Logger.getInstance();

    private static final ScenarioManagerTest singleton =
                                             new ScenarioManagerTest();



//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

    /***************************************************************************
     * Vypíše úvodní zprávu hry, ze které by se mělo dát odhadnout,
     * o čem hra bude.
     *
     * @param manager Správce scénářů hry, jejíž uvítání se vypisuje
     */
    public static void writeInvitation(AScenarioManager manager)
    {
        Scenario     scenario    = manager.getHappyScenario();
        ScenarioStep initialStep = scenario.iterator().next();
        DBG.info(initialStep.toString());
    }



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Vytvoří objekt schopný testovat správce scénářů.
     */
    private ScenarioManagerTest()
    {
    }


    /***************************************************************************
     * Vrátí objekt pro testování správce scénářů.
     *
     * @return Objekt pro testování správce scénářů
     */
    public static ScenarioManagerTest getInstance()
    {
        return singleton;
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Otestuje, že zadaný správce scénářů vyhovuje na něj kladeným požadavkům
     * a otestuje všechny jeho scénáře.
     *
     * @param manager Testovaná instance
     */
    @Override
    public void test(AScenarioManager manager)
    {
        Date startTime =  new Date();
        DBG.info("Testuji správce scénářů autora: {0} – {1}" +
               "\n########## START: {2, date} – {2, time}\n",
               manager.getAuthorID(), manager.getAuthorName(), startTime);

        writeInvitation(manager);

        verifyHappyScenario  (manager);    //Ověří, že nultým scénářem je ZÚspě
        verifyMistakeScenario(manager);    //Ověří, že prvním scénářem je ZChyb

        ScenarioTest.Summary summary = ScenarioTest.testAllScenarios(manager);
        boolean ok = summary.ok;

        Date   stopTime =  new Date();
        double duration = (stopTime.getTime() - startTime.getTime()) / 1000.0;
        DBG.info("########## STOP: {0, date} – {0, time}  -  " +
                 "Trvání testu {1, number,#.#} s – Test byl {2}ÚSPĚŠNÝ\n" +
                 "Konec testu scénářů autora: {3} – {4}\n\n" ,
                 stopTime, duration, (ok ? "" : "NE"),
                 manager.getAuthorID(), manager.getAuthorName());
    }



//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

    /***************************************************************************
     * Prověří, že základní úspěšný scénář dodaný testovaným správcem
     * je prvním scénářem nabízeným jeho iterátorem.
     *
     * @param manager Testovaný správce scénářů
     */
    private void verifyHappyScenario(AScenarioManager manager)
    {
        Scenario happyScenario  = manager.getHappyScenario();
        Scenario zerothScenario = manager.getScenario(0);

        Iterator<Scenario> iterator = manager.iterator();
        if ((happyScenario == null)          ||
            (! happyScenario.equals(zerothScenario))  ||
            (! iterator.hasNext())     ||
            (! iterator.next().equals(happyScenario)))
        {
            throw new TestException("\nIterátor správce scénářů musí vždy "  +
                             "nabídnout jako první základní úspěšný scénář," +
              "\nkterý musí být současně získatelný jako scénář s indexem 0");
        }
    }


    /***************************************************************************
     * Prověří, že základní chybový scénář dodaný testovaným správcem
     * je druhým scénářem nabízeným jeho iterátorem.
     *
     * @param manager Testovaný správce scénářů
     */
    private void verifyMistakeScenario(AScenarioManager manager)
    {
        Scenario mistakeScenario = manager.getMistakeScenario();
        Scenario firstScenario   = manager.getScenario(1);

        Iterator<Scenario> iterator = manager.iterator();
        if ((mistakeScenario != null)        &&
            (mistakeScenario.equals(firstScenario))  &&
            (iterator.hasNext()))
        {
            iterator.next();
            if (iterator.hasNext())  {
                Scenario druhý = iterator.next();
                if (druhý.equals(mistakeScenario)) {
                    return;                     //==========>
                }
            }
        }
        throw new TestException("\nIterátor správce scénářů musí vždy " +
                             "nabídnout jako druhý základní chybový scénář," +
              "\nkterý musí být současně získatelný jako scénář s indexem 1");
    }



//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTOVACÍ METODY A TŘÍDY ==================================================
//
//    /***************************************************************************
//     * Testovací metoda.
//     */
//    public static void test()
//    {
//        ScenarioManagerTest inst = new ScenarioManagerTest();
//    }
//    /** @param args Parametry příkazového řádku - nepoužívané. */
//    public static void main(String[] args)  {  test();  }
}
