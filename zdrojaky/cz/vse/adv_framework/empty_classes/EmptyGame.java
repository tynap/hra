/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse.adv_framework.empty_classes;

import cz.vse.adv_framework.game_txt.Commands;
import cz.vse.adv_framework.game_txt.IBag;
import cz.vse.adv_framework.game_txt.IGame;
import cz.vse.adv_framework.game_txt.IPlace;
import cz.vse.adv_framework.game_txt.ICommand;

import cz.vse.adv_framework.scenario.AScenarioManager;

import java.util.Collection;



/*******************************************************************************
 * Instance třídy {@code EmptyGame} mají na starosti logiku hry.
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
public class EmptyGame implements IGame
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
    public EmptyGame()
    {
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
        //TODO Nedodělané
        throw new UnsupportedOperationException(
                                        "Metoda ještě není implementována");
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
        //TODO Nedodělané
        throw new UnsupportedOperationException(
                                        "Metoda ještě není implementována");
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
        //TODO Nedodělané
        throw new UnsupportedOperationException(
                                        "Metoda ještě není implementována");
    }


    /***************************************************************************
     * Vrátí odkaz na batoh, do nějž bude hráč ukládat sebrané objekty.
     *
     * @return Batoh, do nějž hráč ukládá sebrané objekty
     */
    @Override
    public IBag getBag()
    {
        //TODO Nedodělané
        throw new UnsupportedOperationException(
                                        "Metoda ještě není implementována");
    }


    /***************************************************************************
     * Vrátí kolekci všech příkazů použitelných ve hře.
     *
     * @return Kolekce všech příkazů použitelných ve hře
     */
    @Override
    public Collection<? extends ICommand> getAllCommands()
    {
        //TODO Nedodělané
        throw new UnsupportedOperationException(
                                        "Metoda ještě není implementována");
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
     * @return Přepravka se základními příkazy
     */
    @Override
    public Commands getBasicCommands() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    /***************************************************************************
     * Vrátí kolekci odkazů na všechny prostory vystupující ve hře.
     *
     * @return Kolekce odkazů na všechny prostory vystupující ve hře
     */
    @Override
    public Collection<? extends IPlace> getAllPlaces()
    {
        //TODO Nedodělané
        throw new UnsupportedOperationException(
                                        "Metoda ještě není implementována");
    }


    /***************************************************************************
     * Vrátí odkaz na aktuální prostor,
     * tj. na prostor, v němž se hráč pravé nachází.
     *
     * @return Prostor, v němž se hráč pravé nachází
     */
    @Override
    public IPlace getCurrentPlace()
    {
        //TODO Nedodělané
        throw new UnsupportedOperationException(
                                        "Metoda ještě není implementována");
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
        //TODO Nedodělané
        throw new UnsupportedOperationException(
                                        "Metoda ještě není implementována");
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
        //TODO Nedodělané
        throw new UnsupportedOperationException(
                                        "Metoda ještě není implementována");
    }


    /***************************************************************************
     * Ukončí celou hru a vrátí alokované prostředky.
     */
    @Override
    public void stop()
    {
        //TODO Nedodělané
        throw new UnsupportedOperationException(
                                        "Metoda ještě není implementována");
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
//        EmptyGame inst = new EmptyGame();
//    }
//    /** @param args Parametry příkazového řádku - nepoužívané. */
//    public static void main(String[] args)  {  test();  }
}
