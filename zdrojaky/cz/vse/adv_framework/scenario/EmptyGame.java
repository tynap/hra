/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse.adv_framework.scenario;

import cz.vse.adv_framework.game_txt.Commands;
import cz.vse.adv_framework.game_txt.IBag;
import cz.vse.adv_framework.game_txt.ICommand;
import cz.vse.adv_framework.game_txt.IGame;
import cz.vse.adv_framework.game_txt.IPlace;

import java.util.Collection;



/*******************************************************************************
 * Instance třídy {@code EmptyGame} představují prototypy instancí hry,
 * které ještě nejsou schopny plnohodnotného spuštění a slouží pouze
 * ke kompletaci těch vlastností správce scénářů, které bude v budoucnu
 * plnit ve spolupráci s plnohodnotnou hrou.
 *
 * @author    Rudolf PECINOVSKÝ
 * @version   0.00.000
 */
public class EmptyGame implements IGame
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Odkaz na instanci jedináčka. */
    private static EmptyGame SINGLETON;



//== VARIABLE CLASS ATTRIBUTES =================================================
//== CONSTUCTORS AND FACTORY METHODS ===========================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /** Správce scénářů fiktivní prázdné hry. */
    private final AScenarioManager scenarioManager;



//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Vrátí odkaz na jedináčka.
     *
     * @return Odkaz na jedináčka
     */
    public static EmptyGame getInstance()
    {
        return SINGLETON;
    }


    /***************************************************************************
     * Definuje zástupnou instancí budoucí hry
     * určenou pouze pro testování scénářů plánované hry.
     * Tuto instanci může používat správce scénářů do doby,
     * než uživatel vytvoří hru schopnou řádného testování.
     *
     * @param scenarioManager Správce scénářů vytvářené hry
     */
    private EmptyGame(AScenarioManager scenarioManager)
    {
        if (SINGLETON != null) {
            throw new IllegalStateException(
                      "Druhá žádost o vytvoření instance prázdné hry");
        }
        this.scenarioManager = scenarioManager;
        SINGLETON = this;
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /** {@inheritDoc} */
    @Override
    public String getAuthorName()
    {
        return scenarioManager.getAuthorName();
    }


    /** {@inheritDoc} */
    @Override
    public String getAuthorID()
    {
        return scenarioManager.getAuthorID();
    }


    /** {@inheritDoc} */
    @Override
    public AScenarioManager getScenarioManager()
    {
        return scenarioManager;
    }


    //-- Formally defined methods ------------------------------------------
    /** {@inheritDoc} */
    @Override
    public Collection<? extends IPlace> getAllPlaces()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    /** {@inheritDoc} */
    @Override
    public IPlace getCurrentPlace()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    /** {@inheritDoc} */
    @Override
    public IBag getBag()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    /** {@inheritDoc} */
    @Override
    public Collection<? extends ICommand> getAllCommands()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    /** {@inheritDoc} */
    @Override
    public Commands getBasicCommands()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    /** {@inheritDoc} */
    @Override
    public boolean isAlive()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /** {@inheritDoc} */
    @Override
    public void stop()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    /** {@inheritDoc} */
    @Override
    public String executeCommand(String command)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }



//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTING CLASSES AND METHODS ===============================================
}
