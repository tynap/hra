package cz.vse._101.po0000.xpavj012c_v_ramci;

import cz.vse.adv_framework.game_txt.ICommand;



/*******************************************************************************
 * Instance třídy {@code PrikazAdapter} adaptují
 * objekty příkazů původní aplikace na požadavky rámce.
 *
 * @author    Rudolf PECINOVSKÝ
 * @version   0.00.000
 */
public class PrikazAdapter implements ICommand
{
//== KONSTANTNÍ ATRIBUTY TŘÍDY =================================================
//== PROMĚNNÉ ATRIBUTY TŘÍDY ===================================================
//== STATICKÝ INICIALIZAČNÍ BLOK - STATICKÝ KONSTRUKTOR ========================
//== KONSTANTNÍ ATRIBUTY INSTANCÍ ==============================================

    private final IPrikaz adaptovany;



//== PROMĚNNÉ ATRIBUTY INSTANCÍ ================================================
//== PŘÍSTUPOVÉ METODY VLASTNOSTÍ TŘÍDY ========================================
//== OSTATNÍ NESOUKROMÉ METODY TŘÍDY ===========================================

//##############################################################################
//== KONSTRUKTORY A TOVÁRNÍ METODY =============================================

    /***************************************************************************
     *
     * @param adaptovany Příkaz adaptovaný na rámec
     */
    public PrikazAdapter(IPrikaz adaptovany)
    {
        this.adaptovany = adaptovany;
    }



//== ABSTRAKTNÍ METODY =========================================================
//== PŘÍSTUPOVÉ METODY VLASTNOSTÍ INSTANCÍ =====================================

    /***************************************************************************
     * Vrací název příkazu, tj. text, který musí hráč zadat
     * pro vyvolaní daného příkazu.
     *
     * @return Název příkazu
     */
    @Override
    public String getName()
    {
        return adaptovany.getNazev();
    }


    /***************************************************************************
     * Vrací popis příkazu s vysvětlením jeho funkce
     * a významu jednotlivých parametru.
     *
     * @return Popis příkazu
     */
    @Override
    public String getDescription()
    {
        return "Příkazy v původním demu nemají popis";
    }


    /***************************************************************************
     * Metoda realizující reakci hry na zadaní daného příkazu.
     * Počet parametrů je závislý na konkrétním příkazu, např. příkazy konec
     * a nápověda nemají parametry, příkazy jdi a seber maji jeden parametr
     * příkaz použij muže mít dva parametry atd.
     *
     * @param parametry Parametry příkazu;
     *                  jejich počet muže byt pro každý příkaz jiný
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... parametry)
    {
        return adaptovany.proved(parametry);
    }



//== OSTATNÍ NESOUKROMÉ METODY INSTANCÍ ========================================
//== SOUKROMÉ A POMOCNÉ METODY TŘÍDY ===========================================
//== SOUKROMÉ A POMOCNÉ METODY INSTANCÍ ========================================
//== INTERNÍ DATOVÉ TYPY =======================================================
//== TESTY A METODA MAIN =======================================================
//
//    /***************************************************************************
//     * Testovací metoda.
//     */
//    public static void test()
//    {
//        PrikazAdapter inst = new PrikazAdapter();
//    }
//    /** @param args Parametry příkazového řádku - nepoužívané. */
//    public static void main(String[] args)  {  test();  }
}
