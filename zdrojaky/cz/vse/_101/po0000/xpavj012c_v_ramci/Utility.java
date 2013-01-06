package cz.vse._101.po0000.xpavj012c_v_ramci;

import cz.vse.adv_framework.game_txt.INamed;

import java.util.Collection;


/*******************************************************************************
 * Třídy {@code Utility} slouží jako knihovna užitečných metod.
 *
 * @author    Rudolf PECINOVSKÝ
 * @version   0.00.000
 */
public class Utility
{
//== KONSTANTNÍ ATRIBUTY TŘÍDY =================================================
//== PROMĚNNÉ ATRIBUTY TŘÍDY ===================================================
//== KONSTANTNÍ ATRIBUTY INSTANCÍ ==============================================
//== PROMĚNNÉ ATRIBUTY INSTANCÍ ================================================
//== PŘÍSTUPOVÉ METODY VLASTNOSTÍ TŘÍDY ========================================
//== OSTATNÍ NESOUKROMÉ METODY TŘÍDY ===========================================

    /***************************************************************************
     * Zjistí, zda v je zadané kolekci pojmenovaný objekt se zadany nazvem
     * a vrátí jej.
     *
     * @param <T>      Typ objektů uložených v kolekci
     * @param  nazev   Nazev hledaného pojemnovaného objektu
     * @param  kolekce Kolekce, ve které pojmenovaný objekt hledám
     * @return Byl-li v kolekci objekt se zadanýžm názvem, vrati jej,
     *         jinak vrati prazdny odkaz {@code null}
     */
    public static <T extends INamed>
                   T najdi(String nazev, Collection<T> kolekce)
    {
        nazev = nazev.toLowerCase();
        for (T ip : kolekce) {
            if (ip.getName().toLowerCase().equals(nazev)) {
                return ip;
            }
        }
        return null;
    }



//##############################################################################
//== KONSTRUKTORY A TOVÁRNÍ METODY =============================================

    /***************************************************************************
     * Soukromý konstruktor zabraňující vytvoření instancí
     */
    private Utility(){/**/}



//== ABSTRAKTNÍ METODY =========================================================
//== PŘÍSTUPOVÉ METODY VLASTNOSTÍ INSTANCÍ =====================================
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
//        Utility inst = new Utility();
//    }
//    /** @param args Parametry příkazového řádku - nepoužívané. */
//    public static void main(String[] args)  {  test();  }
}
