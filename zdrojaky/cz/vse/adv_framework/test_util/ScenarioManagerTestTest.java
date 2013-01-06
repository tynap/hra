/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy.
 */
package cz.vse.adv_framework.test_util;

import cz.vse.adv_framework.game_txt.IGame;

import cz.vse.adv_framework.scenario.TypeOfScenario;
import cz.vse.adv_framework.scenario.ScenarioStep;
import cz.vse.adv_framework.scenario.AScenarioManager;


import static  cz.vse.adv_framework.scenario.TypeOfStep.*;



/*******************************************************************************
 * Instance třída {@code ScenarioManagerTestTest} slouží jako
 * testovací správce scénářů, který má prověřit správnou funkci testu.
 *
 * @author Rudolf PECINOVSKÝ
 * @version 3.00,  22.11.2006
 */
class ScenarioManagerTestTest extends AScenarioManager
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Třída, jejíž instance jsou zde spravovány. */
    private final static Class<? extends IGame> TŘÍDA = null;

    /** Jmeno autora dane tridy. */
    private static final String autor = "PECINOVSKÝ Rudolf";

    /** Xname autora/autorky třídy. */
    private static final String xname = "XPECR999";

    private static final ScenarioStep KROK_0 =
            new ScenarioStep("",//Název prvního příkazu musí být prázdný řetězec
            "Uvítání",
            "P1",
            new String[] { "P2", "P3", "P4", "P5", "P6" },
            new String[] {},
            new String[] { "O1" },
            tsSTART);


/*******************************************************************************
 * Interní výčtový typ {@code Scénáře} slouží k usnadnění automatického
 * přidávání definovaných scénářů do vytvářeného správce.
 * Jeho instance představují zárodky budoucích scénářů.
 * Pamatují si typ odpovídajícího scénáře a jeho budoucí kroky.
 *
 * Konstruktor plnohodnotné instance třídy {@link ScenarioStep}
 * vyžaduje následující parametry:
 *      String   příkaz;    //Příkaz realizující tetno krok scénáře
 *      String   zpráva;    //Zpráva vypsaná po zadání příkazu
 *      String   prostor;   //Prostor, v něž skončí hráč po zadání příkazu
 *      String[] východy;   //Aktuální východy z aktuálního prostoru
 *      String[] objekty;   //Objekty vyskytující se v daném prostoru
 *      String[] batoh;     //Aktuální obsah batohu
 *      TypeOfStep typTestu;  //Typ daného kroku testu
 */
private static enum Scénáře
{

    /***************************************************************************
     * Základní scénář popisující možný úspěšný průběh hry.
     */
    ZÁKLADNÍ (TypeOfScenario.scHAPPY,

        KROK_0,

        new ScenarioStep("Polož O1",
            "Položení objektu",
            "P1",
            new String[] { "P2", "P3", "P4", "P5", "P6" },
            new String[] { "O1" },
            new String[] {},
            tsPUT_DOWN),

        new ScenarioStep("Zvedni O1",
            "Zvednutí objektu",
            "P1",
            new String[] { "P2", "P3", "P4", "P5", "P6" },
            new String[] {},
            new String[] { "O1" },
            tsPICK_UP),

        new ScenarioStep("Jdi P2",
            "PŘECHOD",
            "P2",
            new String[] { "P1", "P3", "P4", "P5", "P6" },
            new String[] {},
            new String[] { "O1" },
            tsMOVE),

        new ScenarioStep("Nes3",
            "Nestandardní příkaz - přesun do 3",
            "P3",
            new String[] { "P1", "P2", "P4", "P5", "P6" },
            new String[] {},
            new String[] { "O1" },
            tsNON_STANDARD),

        new ScenarioStep("Nes4",
            "Nestandardní příkaz - přesun do 4",
            "P4",
            new String[] { "P1", "P2", "P3", "P5", "P6" },
            new String[] {},
            new String[] { "O1" },
            tsNON_STANDARD),

        new ScenarioStep("Nes+5",
            "Nestandardní příkaz - je jen do počtu",
            "P4",
            new String[] { "P1", "P2", "P3", "P5", "P6" },
            new String[] {},
            new String[] { "O1" },
            tsNON_STANDARD),

        new ScenarioStep("Nes+6",
            "Nestandardní příkaz - je jen do počtu",
            "P4",
            new String[] { "P1", "P2", "P3", "P5", "P6" },
            new String[] {},
            new String[] { "O1" },
            tsNON_STANDARD),

        new ScenarioStep("Nes+7",
            "Nestandardní příkaz - je jen do počtu",
            "P4",
            new String[] { "P1", "P2", "P3", "P5", "P6" },
            new String[] {},
            new String[] { "O1" },
            tsNON_STANDARD),

        new ScenarioStep("Nes1",
            "Nestandardní příkaz - přesun do 1",
            "P1",
            new String[] { "P2", "P3", "P4", "P5", "P6" },
            new String[] {},
            new String[] { "O1" },
            tsNON_STANDARD)

        //V úspěsném scénáři nemusí být typ posledního příkazu tsEND
        //Hra může končit i prostým dosažením požadovaného cíle
   ),//ZÁKLADNÍ


    /***************************************************************************
     * Základní chybový scénář definující reakce
     * na povinnou sadu chybových stavů.
     */
    CHYBOVÝ (TypeOfScenario.scMISTAKES,

        KROK_0,

        new ScenarioStep("",
            "NIC",
            "P1",
            new String[] { "P2", "P3", "P4", "P5", "P6" },
            new String[] {},
            new String[] { "O1" },
            tsEMPTY),

        new ScenarioStep("XXX",
            "NEZNÁM_AKCI",
            "P1",
            new String[] { "P2", "P3", "P4", "P5", "P6" },
            new String[] {},
            new String[] { "O1" },
            tsUNKNOWN),

        new ScenarioStep("Jdi P1",
            "NENÍ_SOUSED",
            "P1",
            new String[] { "P2", "P3", "P4", "P5", "P6" },
            new String[] {},
            new String[] { "O1" },
            tsBAD_NEIGHBOR),

        new ScenarioStep("Připrav protor pro zvedání/pokládání",
            "Připrav protor pro zvedání/pokládání",
            "P1",
            new String[] { "P2", "P3", "P4", "P5", "P6" },
            new String[] { "T1", "O2", "O3" },
            new String[] { "O1" },
            tsNON_STANDARD),

        new ScenarioStep("Zvedni O1",
            "NENÍ_PŘEDMĚT",
            "P1",
            new String[] { "P2", "P3", "P4", "P5", "P6" },
            new String[] { "T1", "O2", "O3" },
            new String[] { "O1" },
            tsBAD_OBJECT),

        new ScenarioStep("Zvedni T1",
            "TEŽKÝ_PŘEDMĚT",
            "P1",
            new String[] { "P2", "P3", "P4", "P5", "P6" },
            new String[] { "T1", "O2", "O3" },
            new String[] { "O1" },
            tsUNMOVABLE),

        new ScenarioStep("Zvedni O2",
            "PLNÝ_BATOH",
            "P1",
            new String[] { "P2", "P3", "P4", "P5", "P6" },
            new String[] { "T1", "O2", "O3" },
            new String[] { "O1" },
            tsBAG_FULL),

        new ScenarioStep("Polož O2",
            "NEMÁM_PŘEDMĚT",
            "P1",
            new String[] { "P2", "P3", "P4", "P5", "P6" },
            new String[] { "T1", "O2", "O3" },
            new String[] { "O1" },
            tsNOT_IN_BAG),

        new ScenarioStep("Help",
            "NÁPOVĚDA",
            "P1",
            new String[] { "P2", "P3", "P4", "P5", "P6" },
            new String[] { "T1", "O2", "O3" },
            new String[] { "O1" },
            tsHELP),

        new ScenarioStep("konec",
            "Zpráva_o_předčasném_ukončení_hry.",
            "P1",
            new String[] { "P2", "P3", "P4", "P5", "P6" },
            new String[] { "T1", "O2", "O3" },
            new String[] { "O1" },
            tsEND)
   ),


    /***************************************************************************
     * Testovací scénář testující reakce testu na chybná zadání scénáře.
     */
    TESTOVACÍ (TypeOfScenario.scGENERAL,

        KROK_0,

        new ScenarioStep("Polož O1",
            "Změna sousedů",
            "P1",
            new String[] { "P2", "P3", "P4", "P5" },
            new String[] { "O1" },
            new String[] {},
            tsPUT_DOWN),

        new ScenarioStep("Zvedni O1",
            "Změna místnosti při Zvednutí objektu",
            "P2",
            new String[] { "P2", "P3", "P4", "P5", "P6" },
            new String[] {},
            new String[] { "O1" },
            tsPICK_UP),

        new ScenarioStep("Zvedni O2",
            "Zvednutí neexistujícího objektu",
            "P1",
            new String[] { "P2", "P3", "P4", "P5", "P6" },
            new String[] {},
            new String[] { "O2" },
            tsPICK_UP),

        new ScenarioStep("Jdi P2",
            "PŘECHOD",
            "P2",
            new String[] { "P1", "P3", "P4", "P5", "P6" },
            new String[] {},
            new String[] { "O1" },
            tsMOVE),


        new ScenarioStep("NesK",
            "Korektní univerzální konec nechybového scénáře",
            "KONEC",
            new String[] {},
            new String[] {},
            new String[] {},
            tsNON_STANDARD)
   ),


    /***************************************************************************
     * Testovací scénář testující reakce testu na chybný úvodní krok.
     */
    POST_MORTEM (TypeOfScenario.scGENERAL,

        KROK_0,

        new ScenarioStep("konec",
            "Zpráva_o_předčasném_ukončení_hry.",
            "P1",
            new String[] { "P2", "P3", "P4", "P5", "P6" },
            new String[] {},
            new String[] { "O1" },
            tsEND),

        KROK_0,

        KROK_0
   );


//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    private final TypeOfScenario    typ;
    private final ScenarioStep[] kroky ;

//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Konstruktor zárodků scénářů zadaného typu se zadanými kroky.
     *
     * @param typ   Typ budoucího scénáře
     * @param kroky Kroky budoucího scénáře
     */
    private Scénáře(TypeOfScenario typ, ScenarioStep... kroky)
    {
        this.typ   = typ;
        this.kroky = kroky;
    }
}//===== tsEND POMOCNÉHO VÝČTOVÉHO TYPU Scénáře ================================


    /** Jediná instance této třídy. Spravuje všechny scénáře sdružené hry. */
    private static final ScenarioManagerTestTest SS =
                                             new ScenarioManagerTestTest();



//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Vrátí správce scénářů - jedinou instanci této třídy.
     *
     * @return Správce scénářů
     */
    public static ScenarioManagerTestTest getInstance()
    {
        return SS;
    }


    /***************************************************************************
     * Vytvoří instanci představující správce scénářů hry.
     */
    private ScenarioManagerTestTest()
    {
        super(autor, xname, TŘÍDA);

        for (Scénáře s : Scénáře.values()) {
            addScenario(s.name(),  s.typ,  s.kroky);
        }
        seal();
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTOVACÍ METODY A TŘÍDY ==================================================
//
//    /***************************************************************************
//     * Základní test ověřující, jestli správce scénářů vyhovuje
//     * zadným okrajovým podmínkám.
//     */
//    public static void test()
//    {
//        ScenarioManagerTest test = ScenarioManagerTest.getInstance();
//        test.test(SS);
//    }
//
//
//    /***************************************************************************
//     * Simulace průběhu hry podle základního úspěšného scénáře.
//     */
//    public static void simulujÚspěšný()
//    {
//        ScenarioStart .conciseSimulation (SS.getScenario(0));
//    }
//
//
//    /***************************************************************************
//     * Simulace průběhu hry podle základního chybového scénáře.
//     */
//    public static void simulujChybový()
//    {
//        ScenarioStart .conciseSimulation (SS.getScenario(1));
//    }
//
//
//    /***************************************************************************
//     * Testování funkce hry prováděné postupně
//     * prostřednictvím všech scénářů daného správce
//     */
//    public static void prověrkaHry()
//    {
//        IGame hra = null;   //Hra_BytLednička.getGame();
//        ScenarioStart .runScenarios(hra);
//    }
//
//
//    /** @param args Parametry příkazového řádku - nepoužívané. */
//    public static void main(String[] args)
//    {
//        test();
////        simulujÚspěšný();
////        simulujChybový();
////        prověrkaHry();
//    }
}
