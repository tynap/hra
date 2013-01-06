/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.vse._101.po0000.xpavj012c_v_ramci;

import cz.vse.adv_framework.empty_classes.*;
import cz.vse.adv_framework.game_txt.IGame;

import cz.vse.adv_framework.scenario.TypeOfScenario;
import cz.vse.adv_framework.scenario.ScenarioStep;
import cz.vse.adv_framework.scenario.AScenarioManager;

import cz.vse.adv_framework.test_util._Test_101;


import static  cz.vse.adv_framework.scenario.TypeOfStep.*;



/*******************************************************************************
 * Instance třídy {@code EmptyScenarioManager} slouží jako správce scénářů,
 * které mají prověřit a/nebo demonstrovat správnou funkci plánované hry.
 * Jednotlivé scénáře jsou iterovatelné posloupností kroků specifikovaných
 * instancemi třídy <code>ScenarioStep</code> z rámce, do nějž se hra začleňuje.
 * <p>
 * Správce scénářů je jedináček, který má na starosti všechny scénáře
 * týkající se s ním sdružené hry.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 12.01
 */
public class SpravceScenaru extends AScenarioManager
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Třída, jejíž instance jsou zde spravovány. */
    private final static Class<? extends IGame> CLASS = Hra.class;

    /** Jméno autora dané třídy. */
    private static final String AUTHOR = "PECINOVSKÝ Rudolf";

    /** Xname autora/autorky dané třídy. */
    private static final String XNAME = "XPECR999";


    /*==========================================================================
     * Konstruktor plnohodnotné instance třídy {@link ScenarioStep}
     * vyžaduje následující parametry:
     *   String   command;   //Příkaz realizující tento krok scénáře
     *   String   message;   //Zpráva vypsaná po zadání příkazu
     *   String   place;     //Prostor, v němž skončí hráč po zadání příkazu
     *   String[] neighbors; //Sousedé aktuálního prostoru (= východy)
     *   String[] objects;   //Objekty vyskytující se v daném prostoru
     *   String[] bag;       //Aktuální obsah batohu
     *   TypeOfStep typeOfStep; //Typ daného kroku scénáře
     =========================================================================*/


    /***************************************************************************
     * Počáteční krok hry, který je pro všechny scénáře shodný.
     */
     private static final ScenarioStep START_STEP =
        new ScenarioStep("", //Název prvního příkazu musí být prázdný řetězec
            "Vítejte!\n" +
            "Toto je příběh o Červené Karkulce, babičce a vlkovi.\n" +
            "Napište 'napoveda', pokud si nevíte rady, jak hrát dál.\n",

            "domeček",
            new String[] { "les" },
            new String[] { "bábovka", "víno", "kamna" },
            new String[] { },
            tsSTART);


    /***************************************************************************
     * Kroky základního úspěšného scénáře
     * popisující očekávatelný úspěšný průběh hry.
     * Z těchto kroků sestavený scénář nemusí být nutně nejkratším možným
     * (takže to vlastně ani nemusí být základní úspěšný scénář),
     * ale musí vyhovovat všem okrajovým podmínkám zadání,
     * tj. musí obsahovat minimální počet kroků,
     * projít požadovaný.minimální počet prostorů
     * a demonstrovat použití všech požadovaných příkazů.
     */
    private static final ScenarioStep[] HAPPY_SCENARIO_STEPS =
    {
        START_STEP,

        new ScenarioStep("vezmi bábovka",
            "Přidal(a) jste do batohu objekt bábovka\n" +
            "v prostoru se nachází: [bábovka, víno, kamna###]",

            "domeček",
            new String[] { "les" },
            new String[] { "víno", "kamna" },
            new String[] { "bábovka", },
            tsPICK_UP),

        new ScenarioStep("vezmi víno",
            "Přidal(a) jste do batohu objekt víno\n" +
            "v prostoru se nachází: [víno, kamna###]",

            "domeček",
            new String[] { "les" },
            new String[] { "kamna" },
            new String[] { "víno", "bábovka" },
            tsPICK_UP),

        new ScenarioStep("jdi les",
            "Jsi v mistnosti/prostoru les s jahodami, malinami a pramenem vody.\n" +
            "vychody: domeček hluboký_les\n" +
            "v prostoru se nachází: [vlk###]",

            "les",
            new String[] { "hluboký_les", "domeček" },
            new String[] { "vlk" },
            new String[] { "víno", "bábovka" },
            tsMOVE),

        new ScenarioStep("jdi hluboký_les",
            "Jsi v mistnosti/prostoru temný les, ve kterém lze potkat vlka.\n" +
            "vychody: les jeskyně chaloupka\n" +
            "v prostoru se nachází: [vlk###]",

            "hluboký_les",
            new String[] { "les", "chaloupka", "jeskyně" },
            new String[] { "vlk" },
            new String[] { "víno", "bábovka" },
            tsMOVE),

        new ScenarioStep("jdi chaloupka",
            "Jsi v mistnosti/prostoru chaloupka, ve které bydlí babička Karkulky.\n" +
            "vychody: hluboký_les\n" +
            "v prostoru se nachází: [sklenice, postel###, babička###]",

            "chaloupka",
            new String[] { "hluboký_les" },
            new String[] { "babička###", "postel###", "sklenice" },
            new String[] { "víno", "bábovka" },
            tsMOVE),

        new ScenarioStep("polož bábovka",
            "Jsi v mistnosti/prostoru chaloupka, ve které bydlí babička Karkulky.\n" +
            "vychody: hluboký_les\n" +
            "v prostoru se nachází: [sklenice, postel###, babička###]",

            "chaloupka",
            new String[] { "hluboký_les" },
            new String[] { "babička###", "postel###", "sklenice", "bábovka" },
            new String[] { "víno" },
            tsPUT_DOWN),

        new ScenarioStep("polož víno",
            "Jsi v mistnosti/prostoru chaloupka, ve které bydlí babička Karkulky.\n" +
            "vychody: hluboký_les\n" +
            "v prostoru se nachází: [sklenice, postel###, babička###]",

            "chaloupka",
            new String[] { "hluboký_les" },
            new String[] { "babička###", "postel###", "sklenice", "bábovka", "víno" },
            new String[] { },
            tsPUT_DOWN),


        new ScenarioStep("konec",
            "Konec hry. Děkuji, že jste si zahrál(a).",

            "chaloupka",
            new String[] { "hluboký_les" },
            new String[] { "babička###", "postel###", "sklenice", "bábovka", "víno" },
            new String[] { },
            tsEND),
    };


    static { ScenarioStep.setIndex(2); }


    /***************************************************************************
     * Základní chybový scénář definující reakce
     * na povinnou sadu chybových stavů.
     */
    private static final ScenarioStep[] MISTAKE_SCENARIO_STEPS =
    {
        START_STEP,

        new ScenarioStep("příkaz",
            "Neznám příkaz",
            "domeček",
            new String[] { "les" },
            new String[] { "bábovka", "víno", "kamna" },
            new String[] { },
            tsUNKNOWN),


        new ScenarioStep("konec",
            "Hra byla ukončena.",
            "domeček",
            new String[] { "les" },
            new String[] { "bábovka", "víno", "kamna" },
            new String[] { },
            tsEND)

//        UKONČENÍ
    };


    /** Jediná instance této třídy. Spravuje všechny scénáře sdružené hry. */
    private static final SpravceScenaru MANAGER = new SpravceScenaru();



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
    public static SpravceScenaru getInstance()
    {
        return MANAGER;
    }


    /***************************************************************************
     * Vytvoří instanci představující správce scénářů hry.
     */
    private SpravceScenaru()
    {
        super(AUTHOR, XNAME, CLASS);

        addScenario("Úspěšný",
                    TypeOfScenario.scHAPPY,    HAPPY_SCENARIO_STEPS);
        addScenario("Chybový",
                    TypeOfScenario.scMISTAKES, MISTAKE_SCENARIO_STEPS);
        seal();
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTOVACÍ METODY A TŘÍDY ==================================================

    /***************************************************************************
     * Základní test ověřující,
     * jestli správce scénářů vyhovuje zadaným okrajovým podmínkám, tj. jestli:
     * <ul>
     *   <li>Umí vrátit správně naformátované jméno autora/autorky hry
     *       a jeho/její xname.</li>
     *   <li>Definuje základní úspěšný a základní chybový scénář.</li>
     *   <li>Základní chybový scénář má následující vlastnosti:
     *     <ul>
     *       <li>Startovní příkaz, jehož název je prázdný řetězec</li>
     *       <li>Minimální požadovaný počet kroků</li>
     *       <li>Minimální počet navštívených místností</li>
     *       <li>Minimální počet "zahlédnutých" místností</li>
     *       <li>Použití příkazů pro přechod z prostoru do prostoru
     *         zvednutí nějakého objektu a položení nějakého objektu</li>
     *     </ul>
     *   </li>
     *   <li>Základní chybový scénář má následující vlastnosti:
     *     <ul>
     *       <li>Startovní příkaz, jehož název je prázdný řetězec</li>
     *       <li>Použití všech povinných chybových typů kroku
     *         definovaných ve třídě
     *         {@link cz.vse.adv_framework.scenario.TypeOfStep}</li>
     *       <li>Vyvolání nápovědy</li>
     *       <li>Ukončení příkazem pro nestandardní ukončení hry</li>
     *     </ul>
     *   </li>
     * </ul>
     */
    public static void testMyScenarioManager()
    {
        _Test_101 test = _Test_101.getInstance(MANAGER);
        test.testScenarioManager();
    }


    /***************************************************************************
     * Simuluje hraní hry podle základního úspěšného
     * a základního chybového scénáře.
     */
    public static void simulateBasicScenarios()
    {
        _Test_101 test = _Test_101.getInstance(MANAGER);
        test.simulateScenario(MANAGER.getScenario(0), false);
        test.simulateScenario(MANAGER.getScenario(1), false);
    }


    /***************************************************************************
     * Testování funkce hry prováděné postupně
     * prostřednictvím všech scénářů daného správce
     */
    public static void testMyGame()
    {
        IGame     hra  = MANAGER.getGame();
        _Test_101 test = _Test_101.getInstance(hra);
        test.testGame();
    }


    /** @param args Parametry příkazového řádku - nepoužívané. */
    public static void main(String[] args)
    {
        testMyScenarioManager();
        simulateBasicScenarios();
        testMyGame();
    }
}
