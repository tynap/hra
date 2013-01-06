package cz.vse._101.po0000.xpavj012b_doplneny;



/**
 * Instance třídy {@code PrikazPoloz} definuje příkaz,
 * při němž hráč přesune předmět z batohu do aktuálního prostoru.
 *
 * @author Rudolf PECINOVSKÝ
 */
class PrikazPoloz implements IPrikaz
{
    private static final String NAZEV = "polož";

    private HerniPlan plan;
    private Uloziste  uloziste;


    /**
    *  Konstruktor třídy
    *
    *  @param plan herní plán, ve kterém se bude ve hře "chodit"
    *  @param uloziste Objekt, představující batoh
    */
    PrikazPoloz(HerniPlan plan, Uloziste uloziste) {
        this.plan = plan;
        this.uloziste = uloziste;
    }


    @Override
    public String proved(String... parametry)
    {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (pokladany objekt), tak ....
            return "Co mám položit? Musíš zadat jméno objektu";
        }

        String nazev = parametry[0];

        // pozkouším se vyjmout objekt z batohu
        Vec objekt = uloziste.vyjmi(nazev);

        if (objekt == null) {
            return "Takový objekt v batohu není!";
        }
        else {
            plan.getAktualniProstor().vlozVec(objekt);
            return "Polozil(a) jste objekt " + nazev;
        }
    }


    @Override
    public String getNazev()
    {
        return NAZEV;
    }
}
