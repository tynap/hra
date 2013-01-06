package cz.vse._101.po0000.xpavj012c_v_ramci;



/*******************************************************************************
 * Třída {@code ZaRaMain} (Základ v Rámci) je hlavní třídou aplikace,
 * která spouští celý projekt.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class ZaRaMain
{
    public static void main(String[] args)
    {
        TextoveRozhrani textoveRozhrani = new TextoveRozhrani();
        textoveRozhrani.startGame();
    }


    /** Soukromý konstruktor zabraňující vytvoření instance.*/
    private ZaRaMain() {}
}
