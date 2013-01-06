/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy.
 */
package cz.vse.adv_framework.test_util;

import cz.vse.adv_framework.utilities.DBG_Logger;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import static cz.vse.adv_framework.utilities.FormatStrings.*;



/*******************************************************************************
 * Třída {@code ATest} slouží jako rodičovská třída
 * různých testovacích tříd kterým poskytuje společné metody,
 * tj. metody pro zadání reakce na chybu a
 * metodu pro nastavení příznaku práce v grafickém režimu.
 *
 * @author    Rudolf PECINOVSKÝ
 * @version   0.00.000
 */
class ATest
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Logger, prostřednictvím nějž zaznamenáváme veškeré informace. */
    protected final static DBG_Logger DBG = DBG_Logger.getInstance();



//== VARIABLE CLASS ATTRIBUTES =================================================

    /** Příznak provozu v grafickém režimu. */
    private static boolean GUI = false;



//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================

    /***************************************************************************
     * Statický konstruktor nastavuje:
     *  - implicitní ošetření nezachycených přerušení
     */
    static {
        Thread.setDefaultUncaughtExceptionHandler(
            new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e)
                {
//                    e.printStackTrace(System.out);
//                    DBG.severe("\n==================================" +
//                        "\nVe vlákně {0} byla vyhozena výjimka:\n{1}\n{2}",
//                        t, e, DBG.stackTrace(e));
                    DBG.severe(DBG.stackTrace(e));
                }
            }
       );
    }



//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /** Seznam chyb nalezených v průběhu testování danou instancí testu. */
    protected final List<String> foundErrors = new ArrayList<>();



//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================

    /***************************************************************************
     * Nastaví příznak provozu v grafickém režimu.
     *
     * @param GUI Nastavovaná hodnota příznaku
     */
    public static void setGUI(boolean GUI)
    {
        ATest.GUI = GUI;
    }



//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Rodičovský konstruktor nemusí provádět žádné speciální akce.
     */
    protected ATest()
    {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Vytiskne chybové hlášení a v případě, že je program provozován pod
     * grafickým uživatelským rozhraním, vypíše chybovou zprávu v okně.
     *
     * @param format     Formát tisku chybového hlášení. Bude ještě doplněn
     *                   společnou úvodní a závěrečnou sekvencí.
     * @param parameters Případné další parametry k tisku
     */
    protected void ERROR(String format, Object... parameters)
    {
        error(format, parameters);
    }


    /***************************************************************************
     * Vytiskne chybové hlášení a vyhodí výjimku {@code TestException}.
     *
     * @param format     Formát tisku chybového hlášení. Bude ještě doplněn
     *                   společnou úvodní a závěrečnou sekvencí.
     * @param parameters Případné další parametry k tisku
     * @throws TestException
     */
    protected void ERROR_T(String format, Object... parameters)
    {
        String message = error(format, parameters);
        throw new TestException(message);
    }



//== PRIVATE AND AUXILIARY CLASS METHODS =======================================

    /***************************************************************************
     * Vytiskne a vrátí chybové hlášení a v případě, že je program provozován
     * pod grafickým uživatelským rozhraním, vypíše chybovou zprávu v okně.
     *
     * @param format     Formát tisku chybového hlášení. Bude ještě doplněn
     *                   společnou úvodní a závěrečnou sekvencí.
     * @param parameters Případné další parametry k tisku
     * @return Chybové hlášení
     */
    private String error(String format, Object[] parameters)
    {
        String message = String.format(format, parameters);
        foundErrors.add(message);
        String complet = N_BERFORE_N + message + N_AFTER_N;
        DBG.severe(complet);
        if (GUI) {
            JOptionPane.showMessageDialog(null, message);
        }
        return message;
    }


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTOVACÍ METODY A TŘÍDY ==================================================
//
//    /***************************************************************************
//     * Testovací metoda.
//     */
//    public static void test()
//    {
//        ATest inst = new ATest();
//    }
//    /** @param args Parametry příkazového řádku - nepoužívané. */
//    public static void main(String[] args)  {  test();  }
}
