package cz.vse._101.po0000.xpavj012b_doplneny;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

/**
 * Trida Prostor - popisuje jednotlivé prostory (místnosti) hry
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry.
 * Prostor může mít sousední prostory připojené přes východy. Pro každý východ
 * si prostor ukládá odkaz na sousedící prostor.
 * V prostoru jsou uloženy věci, některé lze "odnést" jiné ne.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 * @version pro školní rok 2012/2013 rozšířená o věci
 */
public class Prostor {

    private String nazev;
    private String popis;
    private Set<Prostor> vychody;   // obsahuje sousední místnosti

    private Set<Vec> objekty = new HashSet<Vec>();

    /**
     * Vytvoření  prostoru se zadaným popisem,
     * (např. "kuchyň", "hala", "trávník") před domem"
     *
     *@param  nazev        Nazev prostoru, jednoznačný identifikátor,
     *                     jedno slovo nebo víceslovný název bez mezer.
     *@param  popis        Popis prostoru.
     *@param  nazvyObjektu Nazvy objektu vyskytujicich se v prostoru
     *                     na pocatku hry
     */
    public Prostor(String nazev, String popis, String... nazvyObjektu) {
        this.nazev = nazev;
        this.popis = popis;
        vychody = new HashSet<>();
        for (String nazevObjektu : nazvyObjektu) {
            boolean zvednutelny = true;
            if (nazevObjektu.charAt(0) == '¤') {
                zvednutelny = false;
                nazevObjektu = nazevObjektu.substring(1);
            }
            objekty.add(new Vec(nazevObjektu, zvednutelny));
        }
    }

    /**
     * Definuje východ z prostoru (sousední/vedlejsi prostor). Vzhledem k tomu, že je použit
     * Set pro uložení východů, může být sousední prostor uveden pouze jednou
     * (tj. nelze mít dvoje dveře do stejné sousední místnosti). Druhé zadání
     * stejného prostoru tiše přepíše předchozí zadání (neobjeví se žádné chybové hlášení).
     * Lze zadat též cestu ze do sebe sama.
     *
     * @param vedlejsi prostor, který sousedi s aktualnim prostorem.
     *
     */
    public void setVychod(Prostor vedlejsi) {
        vychody.add(vedlejsi);
    }

    /**
     * Metoda equals pro porovnání dvou prostorů. Překrývá se metoda equals ze třídy Object.
     * Dva prostory jsou shodné, pokud mají stejný název.
     * Tato metoda je důležitá z hlediska správného fungování seznamu východů (Set).
     *
     * Bližší popis metody equals je u třídy Object.
     *
     *@param   o  object, který se má porovnávat s aktuálním
     *@return     hodnotu true, pokud má zadaný prostor stejný název, jinak false
     */
    @Override
    public boolean equals (Object o) {
        if (o instanceof Prostor) {
            Prostor druhy = (Prostor)o;
            return nazev.equals(druhy.nazev);
        }
        else {
            return false;
        }
    }

    /**
     * metoda hashCode vraci ciselny identifikator instance, ktery se pouziva
     * pro optimalizaci ukladani v dynamickych datovych strukturach. Pri
     * prekryti metody equals je potreba prekryt i metodu hashCode. Podrobny
     * popis pravidel pro vytvareni metody hashCode je u metody hashCode ve
     * tride Object
     */
    @Override
    public int hashCode() {
        return nazev.hashCode();
    }


    /**
     * Vrací název prostoru (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return název prostoru
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Vrací "dlouhý" popis prostoru, který může vypadat následovně:
     * Jsi v mistnosti/prostoru vstupni hala budovy VSE na Jiznim meste.
     * vychody: chodba bufet ucebna
     *
     * @return Dlouhý popis prostoru
     */
    public String dlouhyPopis() {
        return "Jsi v mistnosti/prostoru " + popis + ".\n"
                + popisVychodu();
    }

    /**
     * Vrací textový řetězec, který popisuje sousední východy, například:
     * "vychody: hala ".
     *
     * @return Popis východů - názvů sousedních prostorů
     */
    private String popisVychodu() {
        String vracenyText = "vychody:";
        for (Prostor sousedni : vychody) {
            vracenyText += " " + sousedni.getNazev();
        }
        return vracenyText;
    }

    /**
     * Vrací prostor, který sousedí s aktuálním prostorem a jehož název je zadán
     * jako parametr. Pokud prostor s udaným jménem nesousedí s aktuálním
     * prostorem, vrací se hodnota null.
     *
     * @param nazevSouseda Jméno sousedního prostoru (východu)
     * @return Prostor, který se nachází za příslušným východem, nebo hodnota
     * null, pokud prostor zadaného jména není sousedem.
     */
    public Prostor vratSousedniProstor(String nazevSouseda) {
        if (nazevSouseda == null) {
            return null;
        }
        for (Prostor sousedni : vychody) {
            if (sousedni.getNazev().equals(nazevSouseda)) {
                return sousedni;
            }
        }
        return null;  // prostor nenalezen
    }

    /**
     * Vrací kolekci obsahující prostory, se kterými tento prostor sousedí.
     * Takto získaný seznam sousedních prostor nelze upravovat (přidávat,
     * odebírat východy) protože z hlediska správného návrhu je to plně
     * záležitostí třídy Prostor.
     *
     * @return Nemodifikovatelná kolekce prostorů (východů), se kterými tento
     * prostor sousedí.
     */
    public Collection<Prostor> getVychody() {
        return Collections.unmodifiableCollection(vychody);
    }


    /**
     * Metoda pro vložení veci do prostoru
     *
     * @param neco vec vkládaná do prostoru
     *
     */
    public void vlozVec(Vec neco){
        objekty.add(neco);
    }

    /**
     * Vrací věc, pokud je v aktuálním prostoru a jejíž název je zadán
     * jako parametr. Pokud věc s udaným jménem v aktuálním
     * prostoru není nebo je nepřenositelná, vrací se hodnota null.
     *
     * @param nazev Název odebírané veci
     * @return Věc odpovídajícího názvu nebo null pokud věc v prostoru není
     * nebo je nepřenositelná
     */
    public Vec odeberVec(String nazev){
        nazev = nazev.toLowerCase();
        for (Vec objekt : objekty) {
            if (objekt.getNazev().toLowerCase().equals(nazev)) {
                return objekt;
            }
        }
        return null;
    }

    /**
     * Metoda, která slouží k zjišťování, zda se tomto prostoru hry nachází věc zadaného názvu.
     *
     * @param nazev Název hledané veci
     * @return Vrací true  pokud věc jejíž název je zadánjako parametr je v aktuálním prostoru.
     * Pokud věc s udaným názvem v aktuálním prostoru není, vrací se false.
     */
    public boolean jeVecVProstoru(String nazev){
        return false;
    }

    /**
     * Vrací textový řetězec, který popisuje věci, které se nacházejí v prostoru, například:
     * "věci: jablko ".
     *
     * @return Popis věcí - názvy věcí v prostoru oddělené mezerou
     */
    public String popisVeci(){
        return objekty.toString();
    }
}
