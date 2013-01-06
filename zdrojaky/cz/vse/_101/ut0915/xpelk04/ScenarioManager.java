/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.vse._101.ut0915.xpelk04;

import cz.vse.adv_framework.game_txt.IGame;

import cz.vse.adv_framework.scenario.TypeOfScenario;
import cz.vse.adv_framework.scenario.ScenarioStep;
import cz.vse.adv_framework.scenario.AScenarioManager;

import cz.vse.adv_framework.test_util._Test_101;


import static  cz.vse.adv_framework.scenario.TypeOfStep.*;



/*******************************************************************************
 * Instance třídy {@code ScenarioManager} slouží jako správce scénářů,
 * které mají prověřit a/nebo demonstrovat správnou funkci plánované hry.
 * Jednotlivé scénáře jsou iterovatelné posloupností kroků specifikovaných
 * instancemi třídy <code>ScenarioStep</code> z rámce, do nějž se hra začleňuje.
 * <p>
 * Správce scénářů je jedináček, který má na starosti všechny scénáře
 * týkající se s ním sdružené hry.
 *
 * @author Kristýna PELEŠKOVÁ
 * @version 12.01
 */
public class ScenarioManager extends AScenarioManager
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Třída, jejíž instance jsou zde spravovány. */
    private final static Class<? extends IGame> CLASS = null;

    /** Jméno autora dané třídy. */
    private static final String AUTHOR = "PELEŠKOVÁ Kristýna";

    /** Xname autora/autorky dané třídy. */
    private static final String XNAME = "XPELK04";


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
        new ScenarioStep( "", //Název prvního příkazu musí být prázdný řetězec
            "Upozorňujeme návštěvníky naší zoologické zahrady," +
             " že skupinka ochránců přírody" +
            "\nnarušila náš systém na správu klecí a otevřela všechny dveře," +
             " čímž došlo k úniku" +
            "\nvšech zvířat do areálu ZOO. Žádáme vás o co nejrychlejší " +
             "opuštění zahrady. Děkujeme."+
            "\n\nNacházíte se v prostoru: Start" +
            "\nMůžete přejít do prostoru: Pavilon_krokodýlů, Občerstvení," +
             " Pavilon_opic" +
            "\nV prostoru se nachází: Banán, Sáček, Šátek"+
            "\nV rukách máte:",

            "Start",
            new String[] { "Pavilon_krokodýlů", "Občerstvení", "Pavilon_opic" },
            new String[] { "Banán", "Sáček", "Šátek" },
            new String[] {},
            tsSTART );


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

        new ScenarioStep( "jdi Občerstvení",
            "Vkročil(a) jste do Občerstvení, které je již z části vyrabované." +

            "\nNacházíte se v prostoru: Občerstvení"+
            "\nMůžete přejít do prostoru: Pavilon_krokodýlů, Pavilon_Opic," +
            " Start"+
            "\nV prostoru se nachází: Salám, Pití, Cigarety, Pastička" +
            "\nV rukách máte:",

            "Občerstvení",
            new String[] { "Pavilon_krokodýlů", "Start", "Pavilon_opic" },
            new String[] { "Salám", "Pití", "Cigarety", "Pastička" },
            new String[] {},
            tsMOVE ),


        new ScenarioStep( "zvedni Pastička",

            "Zvedl(a) jste pastička" +
            "\n\nNacházíte se v prostoru: Občerstvení" +
            "\nMůžete přejít do prostoru: Pavilon_krokodýlů, Start," +
            " Pavilon_Opic" +
            "\nV prostoru se nachází: Salám, Pití, Cigarety" +
            "\nV rukách máte: Pastička ",

            "Občerstvení",
            new String[] { "Pavilon_krokodýlů", "Start", "Pavilon_opic" },
            new String[] { "Salám", "Pití", "Cigarety" },
            new String[] {"Pastička"},
            tsPICK_UP ),


        new ScenarioStep( "jdi Pavilon_krokodýlů",
            "Na krokodýly je moc velká zima, proto celý pavilon spí a" +
            " vy můžete bezpečně projít"+
            "\nNacházíte se v prostoru: Pavilon_krokodýlů"+
            "\nMůžete přejít do prostoru: Občerstvení, Pavilon_hlodavců, Start"+
            "\nV prostoru se nachází:" +
            "\nV rukách máte: Pastička",

            "Pavilon_krokodýlů",
            new String[] { "Občerstvení", "Pavilon_hlodavců", "Start" },
            new String[] {},
            new String[] {"Pastička"},
            tsMOVE ),



        new ScenarioStep( "jdi Pavilon_hlodavců",
            "Vkročil(a) jste do Pavilonu hlodavců kde se prohánějí skupinky " +
            "od hrabošů přes veverky" +
            "\n po bobry."+
            "\n\nNacházíte se v prostoru: Pavilon_hlodavců "+
            "\nMůžete přejít do prostoru: Pavilon_krokodýlů, Výběh_s_koňmi," +
            " Terária_s_hady" +
            "\nV prostoru se nachází: Myš, Klec" +
            "\nV rukách máte: ",

            "Pavilon_hlodavců",
            new String[] { "Pavilon_krokodýlů", "Výběh_s_koňmi",
                                                "Terária_s_hady" },
            new String[] { "Myš", "Klec" },
            new String[] {"Pastička"},
            tsMOVE ),

          new ScenarioStep("?",
            "\nPříkazy, které je možno v průběhu hry zadat:" +
            "\n============================================",
            //Text pokračuje vyjmenováním příkazů a jejich popisů
            //a končí standardním popisem aktuální situace

            "Pavilon_hlodavců",
            new String[] { "Pavilon_krokodýlů", "Výběh_s_koňmi",
                                                "Terária_s_hady" },
            new String[] { "Klec", "Myš" },
            new String[] {"Pastička"},
            tsHELP),


        new ScenarioStep("nastraž Pastička",
           "Nastražil(a) jste pastičku a chytil(a) myš",

            "Pavilon_hlodavců",
            new String[] { "Pavilon_krokodýlů", "Výběh_s_koňmi",
                                                "Terária_s_hady" },
            new String[] { "Klec" },
            new String[] {"Myš"},
            tsNON_STANDARD ),



        new ScenarioStep( "jdi Terária_s_hady",
            "Vkročil(a) jste do Terária s hady, kteří po vás mlsně koukají." +
            "\nNa výměnu za jídlo pro vás mají vědro s vodou." +
            " Nakrmte je nebo raději zmizte."+
            "\n\nNacházíte se v prostoru: Terária_s_hady "+
            "\nMůžete přejít do prostoru: Pavilon_hlodavců, Sloni" +
            "\nV prostoru se nachází: Had, Voda" +
            "\nV rukách máte: Myš",

            "Terária_s_hady",
            new String[] { "Pavilon_hlodavců", "Sloni" },
            new String[] { "Had", "Voda" },
            new String[] {"Myš"},
            tsMOVE ),


            new ScenarioStep( "vyměň Myš",
            "Nakrmila jste hady a odměnou je vám vědro s vodou." +

            "\n\nNacházíte se v prostoru: Terária_s_hady "+
            "\nMůžete přejít do prostoru: Pavilon_hlodavců, Sloni" +
            "\nV prostoru se nachází: Had, Voda" +
            "\nV rukách máte: Voda",

            "Terária_s_hady",
            new String[] { "Pavilon_hlodavců", "Sloni" },
            new String[] { "Had"},
            new String[] {"Voda"},
            tsNON_STANDARD ),


            new ScenarioStep( "jdi Sloni",
            "Vkročil(a) jste do výběhu pro slony, kteří rozzuřeně" +
            " pobíhají dokola. Nepotřebují" +
            "\ntrochu schladit studenou sprchou? Být vámi, tak pospíším," +
            " ať nedopadnete jako ušlapaný" +
            "\nošetřovatel ležící v rohu, ke kterému vás výměnou za vodu pustí."+


            "\n\nNacházíte se v prostoru: Sloni "+
            "\nMůžete přejít do prostoru: Voliéra, Terária_s_hady, " +
            "Obchod_se_suvenýry" +
            "\nV prostoru se nachází: Ošetřovatelova_karta, CD, Seno" +
            "\nV rukách máte: Myš",

            "Sloni",
            new String[] { "Voliéra", "Terária_s_hady", "Obchod_se_suvenýry" },
            new String[] { "CD", "Seno" },
            new String[] {"Voda"},
            tsMOVE ),


            new ScenarioStep( "použij Voda",
            "Osvěžil(a) jste slony a ty se v klidu přesunuly pryč. Nyní můžete prohledat kapsy"+
            "\nmrtvému ošetřovateli v rohu."+


            "\n\nNacházíte se v prostoru: Sloni "+
            "\nMůžete přejít do prostoru: Voliéra, Terária_s_Hady, Obchod se suvenýry" +
            "\nV prostoru se nachází: Ošetřovatelova_karta, CD, Seno" +
            "\nV rukách máte:",


            "Sloni",
            new String[] { "Voliéra", "Terária_s_Hady", "Obchod_se_suvenýry" },
            new String[] { "Ošetřovatelova_karta", "CD", "Seno" },
            new String[] {},
            tsNON_STANDARD),


            new ScenarioStep( "zvedni Ošetřovatelova_karta ",
            "Zvedl(a) jste Ošetřovatelovu_kartu" +

            "\n\nNacházíte se v prostoru: Sloni "+
            "\nMůžete přejít do prostoru: Voliéra, Terária_s_hady, Obchod se suvenýry" +
            "\nV prostoru se nachází: Ošetřovatelova_karta, CD, Seno" +
            "\nV rukách máte:",


            "Sloni",
            new String[] { "Voliéra", "Terária_s_Hady", "Obchod_se_suvenýry" },
            new String[] {  "CD", "Seno" },
            new String[] {"Ošetřovatelova_karta"},
            tsPICK_UP ),




            new ScenarioStep( "jdi Obchod_se_suvenýry ",
            "Vkročil(a) jste do Obchod_se_suvenýry, který je již z větší části vyrabovaný." +

            "\n\nNacházíte se v prostoru: Obchod_se_suvenýry "+
            "\nMůžete přejít do prostoru: Exit, Sloni" +
            "\nV prostoru se nachází: Plyšák, Pohled" +
            "\nV rukách máte: Ošetřovatelova_karta",

            "Obchod_se_suvenýry",
            new String[] { "Sloni", "Exit" },
            new String[] { "Plyšák", "Pohled" },
            new String[] {"Ošetřovatelova_karta"},
            tsMOVE ),


            new ScenarioStep( "jdi Exit ",
            "Úspěšně jste došli až k východu. Ten je ale bohužel již zamčený, protože jste se na začátku" +
            "\nzdržel na toaletách po požití prošlé klobásy ze stánku vedle, a zbytek zoo je již dávno"+
            "\nevakuovaný.Jedinou možností otevření dveří je ošetřovatelova karta, kterou položíte na čtečku."+

            "\n\nNacházíte se v prostoru: Exit "+
            "\nMůžete přejít do prostoru: Obchod se suvenýry" +
            "\nV prostoru se nachází: " +
            "\nV rukách máte: Ošetřovatelova_karta",

            "Exit",
            new String[] { "Obchod_se_suvenýry" },
            new String[] {},
            new String[] {"Ošetřovatelova_karta"},
            tsMOVE ),


            new ScenarioStep( "polož Ošetřovatelova_karta",
            "Úspěšně jste otevřeli dveře ze ZOO a vy jste ve zdraví opustil ZOO.",

            "Exit",
            new String[] { "Obchod_se_suvenýry" },
            new String[] {"Ošetřovatelova_karta"},
            new String[] {},
            tsPUT_DOWN ),



            new ScenarioStep( "konec",
            " Děkuji, že jste si zahrál(a)"+
            "\nmoji hru.",

            "Exit",
            new String[] { "Obchod_se_suvenýry" },
            new String[] {"Ošetřovatelova_karta"},
            new String[] {},
            tsEND),





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

        new ScenarioStep( "ahoj",
            "Tento příkaz neznám." +
            "\nPro nápovědu zadejte příkaz ?" +

            "\n\nNacházíte se v prostoru: Start" +
            "\nMůžete přejít do prostoru: Pavilon krokodýlů, Občerstvení, Pavilon opic" +
            "\nV prostoru se nachází: Banán, Sáček, Šátek"+
            "\nV rukách máte:",

            "Start",
            new String[] { "Pavilon_krokodýlů", "Občerstvení", "Pavilon_opic" },
            new String[] { "Banán", "Sáček", "Šátek" },
            new String[] {},
            tsUNKNOWN ),





        new ScenarioStep( "",
            "Zadal(a) jste prázdný příkaz" +
            "\nPro nápovědu zadejte příkaz ?"+

            "\n\nNacházíte se v prostoru: Cesta" +
            "\nMůžete přejít do prostoru: Pavilon krokodýlů, Občerstvení, Pavilon opic" +
            "\nV prostoru se nachází: Banán, Sáček, Šátek"+
            "\nV rukách máte:",

            "Start",
            new String[] { "Pavilon_krokodýlů", "Občerstvení", "Pavilon_opic" },
            new String[] { "Banán", "Sáček", "Šátek" },
            new String[] {},
            tsEMPTY ),


            new ScenarioStep( "zvedni Sáček",

             "Zvedl(a) jste Sáček" +
            "\n\nNacházíte se v prostoru: Cesta" +
            "\nMůžete přejít do prostoru: Pavilon krokodýlů, Občerstvení, Pavilon opic" +
            "\nV prostoru se nachází: Banán, Šátek"+
            "\nV rukách máte: Sáček",

            "Start",
            new String[] { "Pavilon_krokodýlů", "Občerstvení", "Pavilon_opic" },
            new String[] { "Banán", "Šátek" },
            new String[] {"Sáček"},
            tsPICK_UP ),



            new ScenarioStep( "jdi Občerstvení",

            "Vkročil(a) jste do Občerstvení"  +
            "\n\nNacházíte se v prostoru: Občerstvení" +
            "\nMůžete přejít do prostoru: Pavilon krokodýlů, Start, Pavilon opic" +
            "\nV prostoru se nachází: Salám, Pití, Cigarety, Pastička"+
            "\nV rukách máte: Sáček",

            "Občerstvení",
            new String[] { "Pavilon_krokodýlů", "Start", "Pavilon_opic" },
            new String[] { "Salám", "Pití", "Cigarety", "Pastička"},
            new String[] {"Sáček"},
            tsMOVE ),


            new ScenarioStep( "jdi Terária_s_hady",
            "Do zadaného prostoru odtud nemůžete přejít."  +
            "\n\nNacházíte se v prostoru: Občerstvení" +
            "\nMůžete přejít do prostoru: Pavilon krokodýlů, Start, Pavilon opic" +
            "\nV prostoru se nachází: Salám, Pití, Cigarety, Pastička"+
            "\nV rukách máte: Sáček",

            "Občerstvení",
            new String[] { "Pavilon_krokodýlů", "Start", "Pavilon_opic" },
            new String[] { "Salám", "Pití", "Cigarety", "Pastička"},
            new String[] {"Sáček"},
            tsBAD_NEIGHBOR ),


          new ScenarioStep( "zvedni Občerstvení",
            "Zadaný předmět v místnosti není: Občerstvení"  +
            "\n\nNacházíte se v prostoru: Občerstvení" +
            "\nMůžete přejít do prostoru: Pavilon krokodýlů, Start, Pavilon opic" +
            "\nV prostoru se nachází: Salám, Pití, Cigarety, Pastička"+
            "\nV rukách máte: Sáček",

            "Občerstvení",
            new String[] { "Pavilon_krokodýlů", "Start", "Pavilon_opic" },
            new String[] { "Salám", "Pití", "Cigarety", "Pastička" },
            new String[] {"Sáček"},
            tsBAD_OBJECT ),



             new ScenarioStep( "polož Voda",
            "Zadaný předmět nemáte v rukách: Voda"  +
            "\n\nNacházíte se v prostoru: Občerstvení" +
            "\nMůžete přejít do prostoru: Pavilon krokodýlů, Start, Pavilon opic" +
            "\nV prostoru se nachází: Salám, Pití, Cigarety, Pastička"+
            "\nV rukách máte: Sáček",

            "Občerstvení",
            new String[] { "Pavilon_krokodýlů", "Start", "Pavilon_opic" },
            new String[] { "Salám", "Pití", "Cigarety", "Pastička"},
            new String[] {"Sáček"},
            tsNOT_IN_BAG ),


             new ScenarioStep( "zvedni Pití",

             "Zvedl(a) jste Pití"  +
            "\n\nNacházíte se v prostoru: Občerstvení" +
            "\nMůžete přejít do prostoru: Pavilon krokodýlů, Start, Pavilon opic" +
            "\nV prostoru se nachází: Salám, Cigarety, Pastička"+
            "\nV rukách máte: Sáček, Pití",

            "Občerstvení",
            new String[] { "Pavilon_krokodýlů", "Start", "Pavilon_opic" },
            new String[] { "Salám", "Cigarety", "Pastička"},
            new String[] {"Sáček", "Pití"},
            tsPICK_UP),



            new ScenarioStep( "zvedni Cigarety",

             "Máte plné ruce a předmět nemůžete vzít."  +
            "\n\nNacházíte se v prostoru: Občerstvení" +
            "\nMůžete přejít do prostoru: Pavilon krokodýlů, Start, Pavilon opic" +
            "\nV prostoru se nachází: Salám, Cigarety, Pastička"+
            "\nV rukách máte: Sáček, Pití",

            "Občerstvení",
            new String[] { "Pavilon_krokodýlů", "Start", "Pavilon_opic" },
            new String[] { "Salám", "Cigarety", "Pastička"},
            new String[] {"Sáček","Pití"},
            tsBAG_FULL),


            new ScenarioStep("?",
            "\nPříkazy, které je možno v průběhu hry zadat:" +
            "\n============================================",
            //Text pokračuje vyjmenováním příkazů a jejich popisů
            //a končí standardním popisem aktuální situace

            "Občerstvení",
            new String[] { "Pavilon_krokodýlů", "Start", "Pavilon_opic" },
            new String[] { "Salám", "Cigarety", "Pastička"},
            new String[] {"Sáček", "Pití"},
            tsHELP),



            new ScenarioStep( "polož",

             "Nezadali jste objekt, který chcete položit"  +
            "\n\nNacházíte se v prostoru: Občerstvení" +
            "\nMůžete přejít do prostoru: Pavilon krokodýlů, Start, Pavilon opic" +
            "\nV prostoru se nachází: Salám, Cigarety, Pastička"+
            "\nV rukách máte: Sáček, Pití",

            "Občerstvení",
            new String[] { "Pavilon_krokodýlů", "Start", "Pavilon_opic" },
            new String[] { "Salám", "Cigarety", "Pastička"},
            new String[] {"Sáček","Pití"},
            tsPUT_DOWN_WA),




             new ScenarioStep( "zvedni",

             "Nezadali jste objekt, který chcete zvednout"  +
            "\n\nNacházíte se v prostoru: Občerstvení" +
            "\nMůžete přejít do prostoru: Pavilon krokodýlů, Start, Pavilon opic" +
            "\nV prostoru se nachází: Salám, Cigarety, Pastička"+
            "\nV rukách máte: Sáček, Pití",

            "Občerstvení",
            new String[] { "Pavilon_krokodýlů", "Start", "Pavilon_opic" },
            new String[] { "Salám", "Cigarety", "Pastička"},
            new String[] {"Sáček","Pití"},
           tsPICK_UP_WA),




         new ScenarioStep( "jdi Pavilon_krokodýlů",
            "Na krokodýly je moc velká zima, proto celý pavilon spí a vy můžete bezpečně projít"+
            "\nNacházíte se v prostoru: Pavilon_krokodýlů"+
            "\nMůžete přejít do prostoru: Občerstvení, Pavilon_hlodavců, Start"+
            "\nV prostoru se nachází:" +
            "\nV rukách máte: Pastička",

            "Pavilon_krokodýlů",
            new String[] { "Občerstvení", "Pavilon_hlodavců", "Start" },
            new String[] {},
            new String[] {"Sáček", "Pití"},
            tsMOVE ),

      new ScenarioStep( "jdi Terária_s_hady",
            "Přesunul(a) jste se do Terária s hady"+
            "\nNacházíte se v prostoru: Terária_s_hady"+
            "\nMůžete přejít do prostoru: Sloni, Pavilon_hlodavců"+
            "\nV prostoru se nachází: Had, Voda" +
            "\nV rukách máte: Sáček, Pití",

            "Terária_s_hady",
            new String[] { "Sloni", "Pavilon_hlodavců" },
            new String[] {"Had", "Voda"},
            new String[] {"Sáček", "Pití"},
            tsMOVE ),

     new ScenarioStep( "zvedni Had",
            "Tento objekt nelze zvednou"+
            "\nNacházíte se v prostoru: Terária_s_hady"+
            "\nMůžete přejít do prostoru: Sloni, Pavilon_hlodavců"+
            "\nV prostoru se nachází: Had, Voda" +
            "\nV rukách máte: Sáček, Pití",


             "Terária_s_hady",
            new String[] { "Sloni", "Pavilon_hlodavců" },
            new String[] {"Had", "Voda"},
            new String[] {"Sáček", "Pití"},

            tsUNMOVABLE ),




   new ScenarioStep( "jdi",
             "Nezadali jste prostor, do kterého se chcete přesunout"+
            "\nNacházíte se v prostoru: Terária_s_hady"+
            "\nMůžete přejít do prostoru: Sloni, Pavilon_hlodavců"+
            "\nV prostoru se nachází: Had, Voda" +
            "\nV rukách máte: Sáček, Pití",


             "Terária_s_hady",
            new String[] { "Sloni", "Pavilon_hlodavců" },
            new String[] {"Had", "Voda"},
            new String[] {"Sáček", "Pití"},
            tsMOVE_WA)   ,


     new ScenarioStep( "konec",

            " Děkuji, že jste si zahrál(a)"+
            "\nmoji hru.",

            "Terária_s_hady",
            new String[] { "Sloni", "Pavilon_hlodavců" },
            new String[] {"Had", "Voda"},
            new String[] {"Sáček", "Pití"},
            tsEND )

//        UKONČENÍ
    };


    /** Jediná instance této třídy. Spravuje všechny scénáře sdružené hry. */
    private static final ScenarioManager MANAGER =
                                          new ScenarioManager();



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
    public static ScenarioManager getInstance()
    {
        return MANAGER;
    }


    /***************************************************************************
     * Vytvoří instanci představující správce scénářů hry.
     */
    private ScenarioManager()
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
    public static void main( String[] args )
    {
        testMyScenarioManager();
        simulateBasicScenarios();
    }
}
