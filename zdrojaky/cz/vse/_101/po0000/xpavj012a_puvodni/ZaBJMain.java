package cz.vse._101.po0000.xpavj012a_puvodni;



/*******************************************************************************
 * Třída {@code ZaBJMain} (Základ místo BlueJ) je hlavní třídou aplikace,
 * která spouští celý projekt.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class ZaBJMain
{
    public static void main(String[] args)
    {
        TextoveRozhrani textoveRozhrani = new TextoveRozhrani();
        textoveRozhrani.hraj();
    }


    /** Soukromý konstruktor zabraňující vytvoření instance.*/
    private ZaBJMain() {}
}
