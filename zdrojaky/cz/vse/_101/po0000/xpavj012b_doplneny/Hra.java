package cz.vse._101.po0000.xpavj012b_doplneny;

/**
 *  Třída Hra - třída představující logiku adventury.
 *
 *  Toto je hlavní třída  logiky aplikace.
 *  Tato třída vytváří instanci třídy HerniPlan, která inicializuje mistnosti hry
 *  a vytváří seznam platných příkazů a instance tříd provádějící jednotlivé příkazy.
 *  Vypisuje uvítací a ukončovací text hry.
 *  Také vyhodnocuje jednotlivé příkazy zadané uživatelem.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2012/2013
 */

public class Hra
{
    private SeznamPrikazu platnePrikazy;    // obsahuje seznam přípustných příkazů
    private HerniPlan     herniPlan;
    private boolean       konecHry = false;
    private Uloziste      uloziste;

    /**
     *  Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan)
     *  a seznam platných příkazů.
     */
    public Hra() {
        herniPlan = new HerniPlan();
        uloziste  = new Uloziste();
        platnePrikazy = new SeznamPrikazu();
        platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
        platnePrikazy.vlozPrikaz(new PrikazJdi(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazKonec(this));

        platnePrikazy.vlozPrikaz(new PrikazPoloz(herniPlan, uloziste));
        platnePrikazy.vlozPrikaz(new PrikazVezmi(herniPlan, uloziste));
    }

    /**
     *  Vrátí úvodní zprávu pro hráče.
     *
     * @return Přivítání
     */
    public String vratUvitani() {
        return "Vítejte!\n" +
               "Toto je příběh o Červené Karkulce, babičce a vlkovi.\n" +
               "Napište 'napoveda', pokud si nevíte rady, jak hrát dál.\n" +
               "\n" +
               herniPlan.getAktualniProstor().dlouhyPopis();
    }

    /**
     *  Vrátí závěrečnou zprávu pro hráče.
     *
     * @return Závěrečná zpráva
     */
    public String vratEpilog() {
        return "Dík, že jste si zahráli.  Ahoj.";
    }

    /**
     * Vrací true, pokud hra skončila.
     *
     * @return Informace o stavu hry (false=běží, true = skončila)
     */
     public boolean konecHry() {
        return konecHry;
    }

    /**
     *  Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
     *  Pak otestuje zda příkaz je klíčovým slovem  např. jdi.
     *  Pokud ano spustí samotné provádění příkazu.
     *
     *@param  radek  text, který zadal uživatel jako příkaz do hry.
     *@return          vrací se řetězec, který se má vypsat na obrazovku
     */
     public String zpracujPrikaz(String radek) {
        String [] slova = radek.split("[ \t]+");
        String slovoPrikazu = slova[0];
        String []parametry = new String[slova.length-1];
        for (int i=0 ;i<parametry.length;i++){
           	parametry[i]= slova[i+1];
        }
        String textKVypsani;
        if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) {
            IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu);
            textKVypsani = prikaz.proved(parametry);
            textKVypsani += "\nv prostoru se nachází: " +
                            getHerniPlan().getAktualniProstor().popisVeci();
        }
        else {
            textKVypsani="Nevím co tím myslíš, tento příkaz neznám? ";
        }
        return textKVypsani;
    }


     /**
     *  Nastaví, že je konec hry, metodu využívá třída PrikazKonec,
     *  mohou ji použít i další implementace rozhraní Prikaz.
     *
     *  @param  konecHry  hodnota false= konec hry, true = hra pokračuje
     */
    void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }

     /**
     *  Metoda vrátí odkaz na herní plán, je využita hlavně v testech,
     *  kde se jejím prostřednictvím získává aktualní místnost hry.
     *
     *  @return     odkaz na herní plán
     */
     public HerniPlan getHerniPlan(){
        return herniPlan;
     }

}

