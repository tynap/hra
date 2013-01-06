/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.vse._101.po0000.xpecr999_literals;

import cz.vse.adv_framework.game_txt.IGame;

import cz.vse.adv_framework.scenario.TypeOfScenario;
import cz.vse.adv_framework.scenario.ScenarioStep;
import cz.vse.adv_framework.scenario.AScenarioManager;

import cz.vse.adv_framework.test_util._Test_101;

import java.util.Calendar;
import java.util.GregorianCalendar;


import static  cz.vse.adv_framework.scenario.TypeOfStep.*;



/*******************************************************************************
 * Instance třídy {@code ManagerWithLiterals} slouží jako správce scénářů,
 * které mají prověřit a/nebo demonstrovat správnou funkci plánované hry.
 * Jednotlivé scénáře jsou iterovatelné posloupností kroků specifikovaných
 * instancemi třídy <code>ScenarioStep</code> z rámce, do nějž se hra začleňuje.
 * <p>
 * Tato třída poskytuje definice používající přímé zadávání textů.
 * Slouží pouze k demonstraci rozdílu oproti třídě (správci scénářů)
 * používající konstanty a nejsou u ní proto průběžně upravovány detaily tak,
 * aby s její pomocí byla hra doopravdy testovatelná.
 * <p>
 * Správce scénářů je jedináček, který má na starosti všechny scénáře
 * týkající se s ním sdružené hry.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 12.01
 */
public class ManagerWithLiterals extends AScenarioManager
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Třída, jejíž instance jsou zde spravovány. */
    private final static Class<? extends IGame> CLASS = null;

    /** Jméno autora dané třídy. */
    private static final String AUTHOR = "PECINOVSKÝ Rudolf";

    /** Xname autora/autorky dané třídy. */
    private static final String XNAME = "XPECR999";

    /** Pomocné konstanty pro rozhovor s ledničkou. */
    private static final int ROKŮ = 20;
    private static final int LETOS;
    private static final int ROK_NAR;
    static {
        Calendar cal = new GregorianCalendar();
        LETOS   = cal.get(Calendar.YEAR);
        ROK_NAR = LETOS - ROKŮ;
    }



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
            "Vítáme vás ve služebním bytě. Jistě máte hlad." +
          "\nNajděte v bytě ledničku - tam vás čeká svačina." +
        "\n\nNacházíte se v místnosti: Předsíň" +
          "\nMůžete se přesunout do místností: Ložnice, Obývák, Koupelna" +
          "\nV místnosti se nachází: Botník, Deštník" +
          "\nMáte v držení předměty:",

            "Předsíň",
            new String[] { "Ložnice", "Obývák", "Koupelna" },
            new String[] { "Botník", "Deštník" },
            new String[] {},
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

        new ScenarioStep("jdi koupelna",
            "Přesunul(a) jste se do místnosti: Koupelna" +
        "\n\nNacházíte se v místnosti: Koupelna" +
          "\nMůžete se přesunout do místností: Předsíň" +
          "\nV místnosti se nachází: Brýle, Umyvadlo, Časopis" +
          "\nMáte v držení předměty:",

            "Koupelna",
            new String[] { "Předsíň" },
            new String[] { "Brýle", "Umyvadlo", "Časopis" },
            new String[] {},
            tsMOVE),

        new ScenarioStep("vezmi brýle",
            "Vzal(a) jste předmět: Brýle" +
        "\n\nNacházíte se v místnosti: Koupelna" +
          "\nMůžete se přesunout do místností: Předsíň" +
          "\nV místnosti se nachází: Umyvadlo, Časopis" +
          "\nMáte v držení předměty: Brýle",

            "Koupelna",
            new String[] { "Předsíň" },
            new String[] { "Umyvadlo", "Časopis" },
            new String[] { "Brýle" },
            tsPICK_UP),

        new ScenarioStep("vezmi časopis",
            "Vzal(a) jste předmět: Časopis" +
        "\n\nNacházíte se v místnosti: Koupelna" +
          "\nMůžete se přesunout do místností: Předsíň" +
          "\nV místnosti se nachází: Umyvadlo" +
          "\nMáte v držení předměty: Brýle, Časopis",

            "Koupelna",
            new String[] { "Předsíň" },
            new String[] { "Umyvadlo" },
            new String[] { "Brýle", "Časopis" },
            tsPICK_UP),

        new ScenarioStep("jdi předsíň",
            "Přesunul(a) jste se do místnosti: Předsíň" +
        "\n\nNacházíte se v místnosti: Předsíň" +
          "\nMůžete se přesunout do místností: Ložnice, Obývák, Koupelna" +
          "\nV místnosti se nachází: Botník, Deštník" +
          "\nMáte v držení předměty: Brýle, Časopis",

            "Předsíň",
            new String[] { "Ložnice", "Obývák", "Koupelna" },
            new String[] { "Botník", "Deštník" },
            new String[] { "Brýle", "Časopis" },
            tsMOVE),

        new ScenarioStep("jdi obývák",
            "Přesunul(a) jste se do místnosti: Obývák" +
        "\n\nNacházíte se v místnosti: Obývák" +
          "\nMůžete se přesunout do místností: Kuchyň, Předsíň" +
          "\nV místnosti se nachází: Televize" +
          "\nMáte v držení předměty: Brýle, Časopis",

            "Obývák",
            new String[] { "Kuchyň", "Předsíň" },
            new String[] { "Televize" },
            new String[] { "Brýle", "Časopis" },
            tsMOVE),

        new ScenarioStep("jdi kuchyň",
            "Přesunul(a) jste se do místnosti: Kuchyň" +
        "\n\nNacházíte se v místnosti: Kuchyň" +
          "\nMůžete se přesunout do místností: Obývák, Ložnice" +
          "\nV místnosti se nachází: Lednička, Papír" +
          "\nMáte v držení předměty: Brýle, Časopis",

            "Kuchyň",
            new String[] { "Obývák", "Ložnice" },
            new String[] { "Lednička", "Papír" },
            new String[] { "Brýle", "Časopis" },
            tsMOVE),

        new ScenarioStep("otevři lednička",
            "Lednička nejde otevřít. Na ledničce leží nějaký popsaný papír." +
        "\n\nNacházíte se v místnosti: Kuchyň" +
          "\nMůžete se přesunout do místností: Obývák, Ložnice" +
          "\nV místnosti se nachází: Lednička, Papír" +
          "\nMáte v držení předměty: Brýle, Časopis",

            "Kuchyň",
            new String[] { "Obývák", "Ložnice" },
            new String[] { "Lednička", "Papír" },
            new String[] { "Brýle", "Časopis" },
            tsNON_STANDARD),

        new ScenarioStep("vezmi papír",
            "Zadaný předmět nemůžete vzít, máte už obě ruce plné." +
        "\n\nNacházíte se v místnosti: Kuchyň" +
          "\nMůžete se přesunout do místností: Obývák, Ložnice" +
          "\nV místnosti se nachází: Lednička, Papír" +
          "\nMáte v držení předměty: Brýle, Časopis",

            "Kuchyň",
            new String[] { "Obývák", "Ložnice" },
            new String[] { "Lednička", "Papír" },
            new String[] { "Brýle", "Časopis" },
            tsBAG_FULL),

        new ScenarioStep("polož časopis",
            "Položil(a) jste předmět: Časopis" +
        "\n\nNacházíte se v místnosti: Kuchyň" +
          "\nMůžete se přesunout do místností: Obývák, Ložnice" +
          "\nV místnosti se nachází: Lednička, Papír, Časopis" +
          "\nMáte v držení předměty: Brýle",

            "Kuchyň",
            new String[] { "Obývák", "Ložnice" },
            new String[] { "Lednička", "Papír", "Časopis" },
            new String[] { "Brýle" },
            tsPUT_DOWN),

        new ScenarioStep("vezmi papír",
            "Vzal(a) jste předmět: Papír" +
        "\n\nNacházíte se v místnosti: Kuchyň" +
          "\nMůžete se přesunout do místností: Obývák, Ložnice" +
          "\nV místnosti se nachází: Lednička, Časopis" +
          "\nMáte v držení předměty: Brýle, Papír",

            "Kuchyň",
            new String[] { "Obývák", "Ložnice" },
            new String[] { "Lednička", "Časopis" },
            new String[] { "Brýle", "Papír" },
            tsPICK_UP),

        new ScenarioStep("přečti papír",
            "Rozhodl(a) jste se přečíst vzkaz na papíře." +
          "\nJe ale psán příliš malým písmem, které je rozmazané" +
        "\n\nNacházíte se v místnosti: Kuchyň" +
          "\nMůžete se přesunout do místností: Obývák, Ložnice" +
          "\nV místnosti se nachází: Lednička, Časopis" +
          "\nMáte v držení předměty: Brýle, Papír",

            "Kuchyň",
            new String[] { "Obývák", "Ložnice" },
            new String[] { "Lednička", "Časopis" },
            new String[] { "Brýle", "Papír" },
            tsNON_STANDARD),

        new ScenarioStep("nasaď brýle",
            "Nasadil(a) jste si brýle." +
        "\n\nNacházíte se v místnosti: Kuchyň" +
          "\nMůžete se přesunout do místností: Obývák, Ložnice" +
          "\nV místnosti se nachází: Lednička, Časopis" +
          "\nMáte v držení předměty: Papír",

            "Kuchyň",
            new String[] { "Obývák", "Ložnice" },
            new String[] { "Lednička", "Časopis" },
            new String[] { "Papír" },
            tsNON_STANDARD),

        new ScenarioStep("přečti papír",
            "Na papíru je napsáno:" +
          "\nLednička stojí nakřivo, a proto jde špatně otevírat." +
          "\nBudete-li mít problémy, něčím ji podložte." +
        "\n\nNacházíte se v místnosti: Kuchyň" +
          "\nMůžete se přesunout do místností: Obývák, Ložnice" +
          "\nV místnosti se nachází: Lednička, Časopis" +
          "\nMáte v držení předměty: Papír",

            "Kuchyň",
            new String[] { "Obývák", "Ložnice" },
            new String[] { "Lednička", "Časopis" },
            new String[] { "Papír" },
            tsNON_STANDARD),

        new ScenarioStep("vezmi časopis",
            "Vzal(a) jste předmět: Časopis" +
        "\n\nNacházíte se v místnosti: Kuchyň" +
          "\nMůžete se přesunout do místností: Obývák, Ložnice" +
          "\nV místnosti se nachází: Lednička" +
          "\nMáte v držení předměty: Papír, Časopis",

            "Kuchyň",
            new String[] { "Obývák", "Ložnice" },
            new String[] { "Lednička" },
            new String[] { "Časopis", "Papír" },
            tsPICK_UP),

        new ScenarioStep("podlož lednička časopis",
            "Rozhodl(a) jste se podložit předmět lednička předmětem časopis." +
          "\nBohužel máte obě ruce plné a nemáte ji čím nadzvednout." +
        "\n\nNacházíte se v místnosti: Kuchyň" +
          "\nMůžete se přesunout do místností: Obývák, Ložnice" +
          "\nV místnosti se nachází: Lednička" +
          "\nMáte v držení předměty: Papír, Časopis",

            "Kuchyň",
            new String[] { "Obývák", "Ložnice" },
            new String[] { "Lednička" },
            new String[] { "Časopis", "Papír" },
            tsNON_STANDARD),

        new ScenarioStep("polož papír",
            "Položil(a) jste předmět: Papír" +
        "\n\nNacházíte se v místnosti: Kuchyň" +
          "\nMůžete se přesunout do místností: Obývák, Ložnice" +
          "\nV místnosti se nachází: Lednička, Papír" +
          "\nMáte v držení předměty: Časopis",

            "Kuchyň",
            new String[] { "Obývák", "Ložnice" },
            new String[] { "Lednička", "Papír" },
            new String[] { "Časopis" },
            tsPUT_DOWN),

        new ScenarioStep("podlož lednička časopis",
            "Rozhodl(a) jste se podložit předmět lednička předmětem časopis." +
          "\nLednička je úspěšně podložena - nyní by již měla jít otevřít." +
        "\n\nNacházíte se v místnosti: Kuchyň" +
          "\nMůžete se přesunout do místností: Obývák, Ložnice" +
          "\nV místnosti se nachází: Lednička, Papír" +
          "\nMáte v držení předměty:",

            "Kuchyň",
            new String[] { "Obývák", "Ložnice" },
            new String[] { "Lednička", "Papír" },
            new String[] {},
            tsNON_STANDARD),

        new ScenarioStep("otevři lednička",
            "Úspěšně jste otevřel(a) ledničku." +
        "\n\nNacházíte se v místnosti: Lednička" +
          "\nMůžete se přesunout do místností:" +
          "\nV místnosti se nachází: Pivo, Pivo, Pivo, " +
                                    "Salám, Houska, Víno, Rum" +
          "\nMáte v držení předměty:",

            "Lednička",
            new String[] {},
            new String[] { "Pivo",  "Pivo",   "Pivo",
                           "Salám", "Houska", "Víno", "Rum" },
            new String[] {},
            tsNON_STANDARD),

        new ScenarioStep("vezmi pivo",
            "Pokoušíte si vzít z inteligentní ledničky Pivo." +
          "\nToto je inteligentní lednička, která neumožňuje " +
          "\npodávání alkoholických nápojů mladistvým." +
          "\nKolik je vám let?",

            "Lednička",
            new String[] {},
            new String[] { "Pivo", "Pivo", "Pivo",
                           "Salám", "Houska", "Víno", "Rum" },
            new String[] {},
            tsUNMOVABLE),

        new ScenarioStep(""+ROKŮ,
            "V kterém roce jste se narodil(a)?\n",

            "Lednička",
            new String[] {},
            new String[] { "Pivo", "Pivo", "Pivo",
                           "Salám", "Houska", "Víno", "Rum" },
            new String[] {},
            tsDIALOG),

        new ScenarioStep("" + ROK_NAR,
            "Věřím vám a předávám vám požadovaný nápoj." +
          "\nOdebral(a) jste z ledničky: Pivo" +
          "\nDobrou chuť. Nezapomeňte zavřít ledničku." +
        "\n\nNacházíte se v místnosti: Lednička" +
          "\nMůžete se přesunout do místností:" +
          "\nV místnosti se nachází: Pivo, Pivo," +
                                    "Salám, Houska, Víno, Rum" +
          "\nMáte v držení předměty: Pivo",

            "Lednička",
            new String[] {},
            new String[] { "Pivo", "Pivo",
                           "Salám", "Houska", "Víno", "Rum" },
            new String[] { "Pivo" },
            tsDIALOG),

        new ScenarioStep("zavři lednička",
            "Úspěšně jste zavřel(a) ledničku." +
        "\n\nNacházíte se v místnosti: Kuchyň" +
          "\nMůžete se přesunout do místností: Obývák, Ložnice" +
          "\nV místnosti se nachází: Lednička, Papír" +
          "\nMáte v držení předměty: Pivo",

            "Kuchyň",
            new String[] { "Obývák", "Ložnice" },
            new String[] { "Lednička", "Papír" },
            new String[] { "Pivo" },
            tsNON_STANDARD),

        new ScenarioStep("konec",
            "Konec hry. \nDěkujeme, že jste zkusil(a) naši hru.",

            "Kuchyň",
            new String[] { "Obývák", "Ložnice" },
            new String[] { "Lednička", "Papír" },
            new String[] { "Pivo" },
            tsEND)

//        UKONČENÍ
    };


    static { ScenarioStep.setIndex(2); }


    /***************************************************************************
     * Základní chybový scénář definující reakce
     * na povinnou sadu chybových stavů.
     */
    private static final ScenarioStep[] MISTAKE_SCENARIO_STEPS =
    {
        START_STEP,

        new ScenarioStep("maso",
            "Tento příkaz neznám." +
          "\nChcete-li poradit, zadejte příkaz ?" +
        "\n\nNacházíte se v místnosti: Předsíň" +
          "\nMůžete se přesunout do místností: Ložnice, Obývák, Koupelna" +
          "\nV místnosti se nachází: Botník, Deštník" +
          "\nMáte v držení předměty:",

            "Předsíň",
            new String[] { "Ložnice", "Obývák", "Koupelna" },
            new String[] { "Botník", "Deštník" },
            new String[] {},
            tsUNKNOWN),

        new ScenarioStep("",
            "Zadal(a) jste prázdný příkaz." +
        "\n\nNacházíte se v místnosti: Předsíň" +
          "\nMůžete se přesunout do místností: Ložnice, Obývák, Koupelna" +
          "\nV místnosti se nachází: Botník, Deštník" +
          "\nMáte v držení předměty:",

            "Předsíň",
            new String[] { "Ložnice", "Obývák", "Koupelna" },
            new String[] { "Botník",  "Deštník" },
            new String[] {},
            tsEMPTY),

        new ScenarioStep("vezmi deštník",
            "Vzal(a) jste předmět: Deštník" +
        "\n\nNacházíte se v místnosti: Předsíň" +
          "\nMůžete se přesunout do místností: Ložnice, Obývák, Koupelna" +
          "\nV místnosti se nachází: Botník" +
          "\nMáte v držení předměty: Deštník",

            "Předsíň",
            new String[] { "Ložnice", "Obývák", "Koupelna" },
            new String[] { "Botník" },
            new String[] { "Deštník" },
            tsPICK_UP),

        new ScenarioStep("jdi koupelna",
            "Přesunul(a) jste se do místnosti: Koupelna" +
        "\n\nNacházíte se v místnosti: Koupelna" +
          "\nMůžete se přesunout do místností: Předsíň" +
          "\nV místnosti se nachází: Brýle, Umyvadlo, Časopis" +
          "\nMáte v držení předměty: Deštník",

            "Koupelna",
            new String[] { "Předsíň" },
            new String[] { "Brýle", "Umyvadlo", "Časopis" },
            new String[] { "Deštník" },
            tsMOVE),

        new ScenarioStep("jdi záchod",
            "Do zadané místnosti se odsud nedá přejít." +
        "\n\nNacházíte se v místnosti: Koupelna" +
          "\nMůžete se přesunout do místností: Předsíň" +
          "\nV místnosti se nachází: Brýle, Umyvadlo, Časopis" +
          "\nMáte v držení předměty: Deštník",

            "Koupelna",
            new String[] { "Předsíň" },
            new String[] { "Brýle", "Umyvadlo", "Časopis" },
            new String[] { "Deštník" },
            tsBAD_NEIGHBOR),

        new ScenarioStep("vezmi koupelna",
            "Zadaný předmět v místnosti není: Koupelna" +
        "\n\nNacházíte se v místnosti: Koupelna" +
          "\nMůžete se přesunout do místností: Předsíň" +
          "\nV místnosti se nachází: Brýle, Umyvadlo, Časopis" +
          "\nMáte v držení předměty: Deštník",

            "Koupelna",
            new String[] { "Předsíň" },
            new String[] { "Brýle", "Umyvadlo", "Časopis" },
            new String[] { "Deštník" },
            tsBAD_OBJECT),

        new ScenarioStep("vezmi umyvadlo",
            "Zadaný předmět nejde zvednout: Umyvadlo" +
        "\n\nNacházíte se v místnosti: Koupelna" +
          "\nMůžete se přesunout do místností: Předsíň" +
          "\nV místnosti se nachází: Brýle, Umyvadlo, Časopis" +
          "\nMáte v držení předměty: Deštník",

            "Koupelna",
            new String[] { "Předsíň" },
            new String[] { "Brýle", "Umyvadlo", "Časopis" },
            new String[] { "Deštník" },
            tsUNMOVABLE),

        new ScenarioStep("polož papír",
            "Předmět není v batohu: Papír" +
        "\n\nNacházíte se v místnosti: Koupelna" +
          "\nMůžete se přesunout do místností: Předsíň" +
          "\nV místnosti se nachází: Brýle, Umyvadlo, Časopis" +
          "\nMáte v držení předměty: Deštník",

            "Koupelna",
            new String[] { "Předsíň" },
            new String[] { "Brýle", "Umyvadlo", "Časopis" },
            new String[] { "Deštník" },
            tsNOT_IN_BAG),

        new ScenarioStep("vezmi brýle",
            "Vzal(a) jste předmět: Brýle" +
        "\n\nNacházíte se v místnosti: Koupelna" +
          "\nMůžete se přesunout do místností: Předsíň" +
          "\nV místnosti se nachází: Umyvadlo, Časopis" +
          "\nMáte v držení předměty: Deštník, Brýle",

            "Koupelna",
            new String[] { "Předsíň" },
            new String[] { "Umyvadlo", "Časopis" },
            new String[] { "Deštník", "Brýle" },
            tsPICK_UP),

        new ScenarioStep("vezmi Časopis",
            "Zadaný předmět nemůžete vzít, máte už obě ruce plné." +
        "\n\nNacházíte se v místnosti: Koupelna" +
          "\nMůžete se přesunout do místností: Předsíň" +
          "\nV místnosti se nachází: Umyvadlo, Časopis" +
          "\nMáte v držení předměty: Deštník, Brýle",

            "Koupelna",
            new String[] { "Předsíň" },
            new String[] { "Umyvadlo", "Časopis" },
            new String[] { "Deštník", "Brýle" },
            tsBAG_FULL),

        new ScenarioStep("?",
            "\nPříkazy, které je možno v průběhu hry zadat:" +
            "\n============================================",
            //Text pokračuje vyjmenováním příkazů a jejich popisů
            //a končí standardním popisem aktuální situace

            "Koupelna",
            new String[] { "Předsíň" },
            new String[] { "Umyvadlo", "Časopis" },
            new String[] { "Deštník", "Brýle" },
            tsHELP),

        new ScenarioStep("konec",
            "Konec hry. \nDěkujeme, že jste zkusil(a) naši hru.",

            "Koupelna",
            new String[] { "Předsíň" },
            new String[] { "Umyvadlo", "Časopis" },
            new String[] { "Deštník", "Brýle" },
            tsEND),
    };


    /** Jediná instance této třídy. Spravuje všechny scénáře sdružené hry. */
    private static final ManagerWithLiterals MANAGER =
                                         new ManagerWithLiterals();



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
    public static ManagerWithLiterals getInstance()
    {
        return MANAGER;
    }


    /***************************************************************************
     * Vytvoří instanci představující správce scénářů hry.
     */
    public ManagerWithLiterals()
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
    }
}
