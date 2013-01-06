package cz.vse._101.po0000.xpavj012c_v_ramci;

import cz.vse.adv_framework.game_txt.Commands;
import cz.vse.adv_framework.game_txt.IBag;
import cz.vse.adv_framework.game_txt.ICommand;
import cz.vse.adv_framework.game_txt.IGame;
import cz.vse.adv_framework.game_txt.IPlace;
import cz.vse.adv_framework.scenario.AScenarioManager;
import java.util.Collection;



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

public class Hra implements IGame
{
//    private static final SpravceScenaru SPRAVCE_SCENARU =
//                                        SpravceScenaru.getInstance();

    private static final Hra HRA = new Hra();


    private SeznamPrikazu platnePrikazy;    // obsahuje seznam přípustných příkazů
    private HerniPlan     herniPlan;
    private boolean       konecHry = true;
    private Uloziste      uloziste;


    /***************************************************************************
     * Vrátí instanci hry - jedináčka.
     *
     * @return Instance hry
     */
    public static Hra getInstance()
    {
        return HRA;
    }


    /**
     *  Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan)
     *  a seznam platných příkazů.
     */
    private Hra() {
        herniPlan = new HerniPlan();
        uloziste  = new Uloziste();
        platnePrikazy = new SeznamPrikazu();
        platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
        platnePrikazy.vlozPrikaz(new PrikazJdi(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazKonec(this));

        platnePrikazy.vlozPrikaz(new PrikazPoloz(herniPlan, uloziste));
        platnePrikazy.vlozPrikaz(new PrikazVezmi(herniPlan, uloziste));

//        SPRAVCE_SCENARU.setGame(this);
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
         if (radek.isEmpty()) {
             return start();
         }
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


    @Override
    public boolean isAlive()
    {
        return ! konecHry;
    }


    @Override
    public IPlace getCurrentPlace()
    {
        return herniPlan.getAktualniProstor();
    }


    @Override
    public IBag getBag()
    {
        return uloziste;
    }


    @Override
    public Collection<? extends IPlace> getAllPlaces()
    {
        return herniPlan.getVsechnyProstory();
    }


    @Override
    public Collection<? extends ICommand> getAllCommands()
    {
        return platnePrikazy.getAdaptovanePrikazy();
    }


    /***************************************************************************
     * Vrátí odkaz na přepravku s názvy povinných příkazů, tj. příkazů pro
     * <ul>
     *   <li>přesun hráče do jiného prostoru,</li>
     *   <li>zvednutí objektu (odebrání z prostoru a vložení do batohu),</li>
     *   <li>položení objektu (odebrání z batohu a vložení do prostoru),</li>
     *   <li>vyvolání nápovědy,</li>
     *   <li>okamžité ukončení hry.</li>
     * </ul>
     *
     * @return Přepravka názvy povinných příkazů
     */
    @Override
    public Commands getBasicCommands()
    {
        return new Commands("Jdi", "Polož", "Vezmi", "?", "Konec");
    }


    @Override
    public AScenarioManager getScenarioManager()
    {
        return SpravceScenaru.getInstance();
    }


    @Override
    public void stop()
    {
        setKonecHry(true);
    }


    @Override
    public String executeCommand(String string)
    {
        return zpracujPrikaz(string);
    }


    @Override
    public String getAuthorName()
    {
        return SpravceScenaru.getInstance().getAuthorName();
    }


    @Override
    public String getAuthorID()
    {
        return SpravceScenaru.getInstance().getAuthorID();
    }


    private String start()
    {
        if (konecHry) {
            konecHry = false;
            return vratUvitani();
        }
        else {
            return "Zapomněl(a) jste zadat příkaz!";
        }
    }

}
