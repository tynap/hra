/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.ut0915.xpelk04;





/*******************************************************************************
 * Instance třídy {@code CommandStart} realizuje reakci aplikace
 * na startovací příkaz, který spouští hru.
 * Tento příkaz je možné zadat pouze tehdy, není-li hra již spuštěna.
 * Po ukončení hry jej lze ale zadat znovu a tak hru znovu odstartovat.
 *
 * @author  Kristýna PELEŠKOVÁ
 * @version 12.01
 */
public class CommandStart extends ACommand
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
    public CommandStart()
    {
        super("", "Příkaz startující aplikaci");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

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
    public String execute(String... arguments)
    {
        Game game = Game.getInstance();
        if (game.isAlive()) {
            return "Zadal(a) jste prázdný příkaz." +
                    "\nPro nápovědu zadejte příkaz ?" + status();
        }
        //Inicializuje příkazy, prostory i batoh
        ACommand.initializeCommands();
        Place    .initializePlaces();
        Hands.getInstance().initialize();
        Game.getInstance().setAlive(true);
        return "Upozorňujeme návštěvníky naší zoologické zahrady, " +
                "že skupinka ochránců přírody" +
            "\nnarušila náš systém na správu klecí a otevřela všechny dveře, " +
                "čímž došlo k úniku" +
            "\nvšech zvířat do areálu ZOO. " +
                "Žádáme vás o co nejrychlejší opuštění zahrady. Děkujeme." +
               "\n\n" +
                  status();

    }
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTING CLASSES AND METHODS ===============================================
//
//    /*************************************************************************
//     * Testovací metoda.
//     */
//    public static void test()
//    {
//        ACommand inst = new ACommand();
//    }
//    /** @param args Parametry příkazového řádku - nepoužívané. */
//    public static void main(String[] args)  {  test();  }
}
