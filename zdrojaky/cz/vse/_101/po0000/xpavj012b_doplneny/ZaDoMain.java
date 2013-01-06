package cz.vse._101.po0000.xpavj012b_doplneny;



/*******************************************************************************
 * Třída {@code ZaDoMain} (Základ Doplněný) je hlavní třídou aplikace,
 * která spouští celý projekt.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class ZaDoMain
{
    public static void main(String[] args)
    {
        TextoveRozhrani textoveRozhrani = new TextoveRozhrani();
        textoveRozhrani.hraj();
    }


    /** Soukromý konstruktor zabraňující vytvoření instance.*/
    private ZaDoMain() {}
}
