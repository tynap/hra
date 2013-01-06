package cz.vse._101.po0000.xpavj012b_doplneny;



/**
 * Instance třídy {@code PrikazPoloz} definuje příkaz,
 * při němž hráč přesune předmět z aktuálního prostoru do batohu.
 *
 * @author Rudolf PECINOVSKÝ
 */
class PrikazVezmi implements IPrikaz
{
    private static final String NAZEV = "vezmi";

    private HerniPlan plan;
    private Uloziste  uloziste;


    /**
    *  Konstruktor třídy
    *
    *  @param plan herní plán, ve kterém se bude ve hře "chodit"
    *  @param uloziste Objekt, představující batoh
    */
    PrikazVezmi(HerniPlan plan, Uloziste uloziste) {
        this.plan = plan;
        this.uloziste = uloziste;
    }


    @Override
    public String proved(String... parametry)
    {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (pokladany objekt), tak ....
            return "Co mám zvednout? Musíš zadat jméno objektu";
        }

        String nazev = parametry[0];

        // pozkouším se odebrat objekt z aktuálního prostoru
        Vec objekt = plan.getAktualniProstor().odeberVec(nazev);

        if (objekt == null) {
            return "Takový objekt v prostoru není nebo nejde zvednout,"
                    + "anebo je batoh plný!";
        }
        else {
            uloziste.pridej(objekt);
            return "Přidal(a) jste do batohu objekt " + nazev;
        }
    }


    @Override
    public String getNazev()
    {
        return NAZEV;
    }
}
