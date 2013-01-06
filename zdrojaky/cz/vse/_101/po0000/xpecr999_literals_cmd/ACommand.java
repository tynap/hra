/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.po0000.xpecr999_literals_cmd;

import cz.vse.adv_framework.game_txt.ICommand;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



/*******************************************************************************
 * Třída {@code ACommand} je společným rodičem všech tříd, jejichž instance
 * mají na starosti interpretaci příkazů zadávaných uživatelem hrajícím hru.
 * Název spouštěného příkazu bývá většinou první slovo řádku zadávaného
 * z klávesnice a další slova pak bývají interpretována jako parametry.
 * <p>
 * Můžete ale definovat příkaz, který odstartuje konverzaci
 * (např. s osobou přítomnou v místnosti) a tím přepne systém do režimu,
 * v němž se zadávané texty neinterpretují jako příkazy,
 * ale předávají se definovanému objektu až do chvíle,
 * kdy uživatel rozhovor ukončí a objekt rozhovoru přepne hru zpět
 * do režimu klasických příkazů.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 12.01
 */
public abstract class ACommand implements ICommand
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    private static final Map<String, ACommand> NAME_2_COMMAND = new HashMap<>();



//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================

    /** Statický konstruktor (konstruktor třídy) -
     *  vytvoří po jedné instanci od každé ze svých dceřiných tříd. */
    static {
        new CommandStart();
    }



//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /** Název daného příkazu. */
    private final String name;

    /** Stručný popis daného příkazu. */
    private final String description;



//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================

    /***************************************************************************
     * Vrátí kolekci všech příkazů použitelných ve hře.
     *
     * @return Kolekce všech příkazů použitelných ve hře
     */
    static Collection<ACommand> getAllCommands()
    {
        return NAME_2_COMMAND.values();
    }



//== OTHER NON-PRIVATE CLASS METHODS ===========================================

    /***************************************************************************
     * Zpracuje zadaný příkaz a vrátí text zprávy pro uživatele.
     *
     * @param line Zadávaný příkaz
     * @return Textová odpověď hry na zadaný příkaz
     */
    static String executeCommand(String line)
    {
        line = line.trim().toLowerCase();
        if (line.isEmpty()) {
            return NAME_2_COMMAND.get("").execute((String[]) null);
        }
        String[] words = line.split("\\s+");
        ACommand command = NAME_2_COMMAND.get(words[0]);
        if (command == null) {
            return "Tento příkaz neznám." +
                 "\nChcete-li poradit, zadejte příkaz ?";
        }
        String answer = command.execute(words);
        return answer;
    }


    /***************************************************************************
     * Inicializuje všechny příkazy,
     * tj. požádá všechny příkazy, aby se inicializovaly a nastavily si tak
     * případné potřebné příznaky do správného výchozího stavu.
     */
    static void initializeCommands()
    {
        for (ACommand command : NAME_2_COMMAND.values()) {
            command.initialize();
        }
    }



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Vytvoří rodičovský podobjekt vytvářeného příkazu hry.
     *
     * @param name        Název vytvářeného příkazu
     * @param description Stručný popis vytvářeného příkazu
     */
    ACommand(String name, String description)
    {
        this.name        = name;
        this.description = description;
        NAME_2_COMMAND.put(name.toLowerCase(), this);
    }



//== ABSTRACT METHODS ==========================================================

    /***************************************************************************
     * Metoda realizující reakci hry na zadání daného příkazu.
     * Počet parametrů je závislý na konkrétním příkazu,
     * např. příkazy <i>konec</i> a <i>nápověda</i> nemají parametry,
     * příkazy <i>jdi</i> a <i>seber</i> mají jeden parametr
     * příkaz <i>použij</i> muže mít dva parametry atd.
     *
     * @param arguments Parametry příkazu;
     *                  jejich počet muže byt pro každý příkaz jiný
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    abstract
    public String execute(String... arguments)
    ;



//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí název příkazu, tj. text, který musí hráč zadat
     * pro vyvolaní daného příkazu.
     *
     * @return Název příkazu
     */
    @Override
    public String getName()
    {
        return name;
    }


    /***************************************************************************
     * Vrátí popis příkazu s vysvětlením jeho funkce
     * a významu jednotlivých parametru.
     *
     * @return Popis příkazu
     */
    @Override
    public String getDescription()
    {
        return description;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Inicializuje daný příkaz.
     * Implicitní, zděděná verze této metody je prázdná.
     * Většině příkazů stačí a ty, které opravdu potřebují něco inicializovat,
     * tak ji překryjí vlastní verzí.
     */
    void initialize()
    {
        return;
    }



//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTING CLASSES AND METHODS ===============================================
//
//    /***************************************************************************
//     * Testovací metoda.
//     */
//    public static void test()
//    {
//        ACommand inst = new ACommand();
//    }
//    /** @param args Parametry příkazového řádku - nepoužívané. */
//    public static void main(String[] args)  {  test();  }
}
