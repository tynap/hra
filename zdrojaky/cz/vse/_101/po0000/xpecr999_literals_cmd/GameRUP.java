/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.po0000.xpecr999_literals_cmd;

import cz.vse.adv_framework.game_txt.Commands;
import cz.vse.adv_framework.game_txt.IBag;
import cz.vse.adv_framework.game_txt.IGame;

import cz.vse.adv_framework.scenario.AScenarioManager;

import java.util.Collection;



/*******************************************************************************
 * Instance třídy {@code GameRUP} mají na starosti logiku hry.
 * Jsou schopny akceptovat jednotlivé příkazy a poskytovat informace
 * o průběžném stavu hry a jejích součástí.
 * <p>
 * Třída hry musí být navíc definována jako jedináček (singleton)
 * a kromě metod deklarovaných v tomto rozhraní musí definovat
 * statickou tovární metodu {@code getInstance()}.
 * Splnění této podmínky nemůže prověřit překladač,
 * ale prověří ji až následné testy hry.
 *
 * @author    Rudolf PECINOVSKÝ
 * @version   0.00.000
 */
public class GameRUP implements IGame
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    private static final GameRUP GAME = new GameRUP();


//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    private boolean alive = false;



//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Vrátí odkaz na jedináčka - jedinou existující instanci třídy.
     *
     * @return Odkaz na jedináčka
     */
    public static GameRUP getInstance()
    {
        return GAME;
    }


    /***************************************************************************
     * Vytvoří instanci jedináčka.
     */
    private GameRUP()
    {
//        ManagerWithLiterals.getInstance().setGame(this);
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí informaci o tom, je-li hra aktuálně spuštěná.
     * Spuštěnou hru není možno pustit znovu.
     * Chceme-li hru spustit znovu, musíme ji nejprve ukončit.
     *
     * @return Je-li hra spuštěná, vrátí {@code true},
     *         jinak vrátí {@code false}
     */
    @Override
    public boolean isAlive()
    {
        return alive;
    }


    /***************************************************************************
     * Nastaví příznak aktivity, resp. ukončenosti hry
     *
     * @param state Je-li hra ukončena, zadává se {@code false},
     *              je-li hra rozehrána, zadává se {@code true}
     */
    void setAlive(boolean state)
    {
        alive = state;
    }


    /***************************************************************************
     * Vrátí jméno autora/autorky programu
     * ve formátu zadaném v rozhraní {@link IAuthor}
     *
     * @return Jméno autora/autorky programu v požadovaném formátu
     */
    @Override
    public String getAuthorName()
    {
        return ManagerWithLiterals.getInstance().getAuthorName();
    }


    /***************************************************************************
     * Vrátí xname autora/autorky programu
     * ve formátu zadaném v rozhraní {@link IAuthor}
     *
     * @return Xname autora/autorky programu v požadovaném formátu
     */
    @Override
    public String getAuthorID()
    {
        return ManagerWithLiterals.getInstance().getAuthorID();
    }


    /***************************************************************************
     * Vrátí odkaz na batoh, do nějž bude hráč ukládat sebrané objekty.
     *
     * @return Batoh, do nějž hráč ukládá sebrané objekty
     */
    @Override
    public IBag getBag()
    {
        return Hands.getInstance();
    }


    /***************************************************************************
     * Vrátí kolekci všech příkazů použitelných ve hře.
     *
     * @return Kolekce všech příkazů použitelných ve hře
     */
    @Override
    public Collection<ACommand> getAllCommands()
    {
        return ACommand.getAllCommands();
    }


    /***************************************************************************
     * Vrátí odkaz na přepravku s názvy povinných příkazů, tj. příkazů pro
     * <ul>
     *   <li>přesun hráče do jiného prostoru,</li>
     *   <li>zvednutí objektu (odebrání z prostoru a vložení do batohu),</li>
     *   <li>položení objektu (odebrání z batohu a vložení do prostoru),</li>
     *   <li>ukončení hry.</li>
     * </ul>
     *
     * @return Přepravka s názvy povinných příkazů
     */
    @Override
    public Commands getBasicCommands() {
        return new Commands("jdi", "polož", "vezmi", "?", "konec");
    }


    /***************************************************************************
     * Vrátí kolekci odkazů na všechny prostory vystupující ve hře.
     *
     * @return Kolekce odkazů na všechny prostory vystupující ve hře
     */
    @Override
    public Collection<Room> getAllPlaces()
    {
        return Room.getAllRooms();
    }


    /***************************************************************************
     * Vrátí odkaz na aktuální prostor,
     * tj. na prostor, v němž se hráč pravé nachází.
     *
     * @return Prostor, v němž se hráč pravé nachází
     */
    @Override
    public Room getCurrentPlace()
    {
        return Room.getCurrentRoom();
    }


    /***************************************************************************
     * Vrátí správce scénářů specifikujících požadované chování hry
     * v různých situacích.
     * Scénáře slouží k automatizovanému ověření funkčnosti hry
     * a/nebo demonstraci jejího možného průběhu.
     *
     * @return Správce scénářů dané hry
     */
    @Override
    public AScenarioManager getScenarioManager()
    {
        return ManagerWithLiterals.getInstance();
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Zpracuje zadaný příkaz a vrátí text zprávy pro uživatele.
     *
     * @param command Zadávaný příkaz
     * @return Textová odpověď hry na zadaný příkaz
     */
    @Override
    public String executeCommand(String command)
    {
        return ACommand.executeCommand(command);
    }


    /***************************************************************************
     * Ukončí celou hru a vrátí alokované prostředky.
     */
    @Override
    public void stop()
    {
        alive = false;
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
//        GameRUP inst = new GameRUP();
//    }
//    /** @param args Parametry příkazového řádku - nepoužívané. */
//    public static void main(String[] args)  {  test();  }
}
