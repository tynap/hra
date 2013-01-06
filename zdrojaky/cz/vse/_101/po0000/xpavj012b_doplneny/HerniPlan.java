package cz.vse._101.po0000.xpavj012b_doplneny;



/**
 *  Class HerniPlan - třída představující mapu adventury.
 *
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2012/2013
 */
public class HerniPlan {

    private Prostor aktualniProstor;

     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();

    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor domecek = new Prostor("domeček",
                                      "domeček, ve kterém bydlí Karkulka",
                                      "bábovka", "víno", "¤kamna");
        Prostor chaloupka = new Prostor("chaloupka",
                                "chaloupka, ve které bydlí babička Karkulky",
                                "¤babička", "¤postel", "sklenice");
        Prostor jeskyne = new Prostor("jeskyně",
                                      "stará plesnivá jeskyně");
        Prostor les = new Prostor("les",
                                  "les s jahodami, malinami a pramenem vody");
        Prostor hlubokyLes = new Prostor("hluboký_les",
                                 "temný les, ve kterém lze potkat vlka",
                                 "¤vlk");

        // přiřazují se průchody mezi prostory (sousedící prostory)
        domecek.setVychod(les);
        les.setVychod(domecek);
        les.setVychod(hlubokyLes);
        hlubokyLes.setVychod(les);
        hlubokyLes.setVychod(jeskyne);
        hlubokyLes.setVychod(chaloupka);
        jeskyne.setVychod(hlubokyLes);
        chaloupka.setVychod(hlubokyLes);

        aktualniProstor = domecek;  // hra začíná v domečku
    }

    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */

    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }

    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }

}
