/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package cz.vse._101.po0000.xpavj012a_puvodni;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída ProstorTest slouží ke komplexnímu otestování
 * třídy Prostor
 *
 * @author    Jarmila Pavlíčková
 * @version   pro skolní rok 2012/2013
 */
public class ProstorTest
{
    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /**
     * Testuje, zda jsou správně nastaveny průchody mezi prostory hry.
     */
    @Test
    public  void testLzeProjit() {
        Prostor prostor1 = new Prostor("hala", "vstupni hala budovy VSE na Jiznim meste");
        Prostor prostor2 = new Prostor("bufet", "bufet, kam si muzete zajit na svacinku");
        prostor1.setVychod(prostor2);
        prostor2.setVychod(prostor1);
        assertEquals(prostor2, prostor1.vratSousedniProstor("bufet"));
        assertEquals(null, prostor2.vratSousedniProstor("pokoj"));
    }


     /**
     * Testuje, zda lze správně vložit věci, zjistit zda se v prostoru nacházejí
     * a odebrat pouze přenositelné.
     */
    @Test
    public void testVeci()
    {
        Prostor prostor1 = new Prostor("pokoj", "");
        Vec vec1 = new Vec("jablko", true);
        Vec vec2 = new Vec("stul", false);
        prostor1.vlozVec(vec1);
        prostor1.vlozVec(vec2);
        assertEquals(true, prostor1.jeVecVProstoru("jablko"));
        assertEquals(false, prostor1.jeVecVProstoru("mec"));
        assertEquals(true, prostor1.jeVecVProstoru("stul"));
        assertNull(prostor1.odeberVec("stul"));
        assertSame(vec1, prostor1.odeberVec("jablko"));
        assertNull(prostor1.odeberVec("mec"));
    }
}
