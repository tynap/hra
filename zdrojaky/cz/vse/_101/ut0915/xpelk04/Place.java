/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.ut0915.xpelk04;

import cz.vse._101.po0000.xpecr999_literals_io.*;
import cz.vse.adv_framework.game_txt.IPlace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;



/*******************************************************************************
 * Instance výčtového typu {@code Room} představují prostory hry -
 * v našem případě místnosti ve služebním bytě.
 * <p>
 * Tato verze nepotřebuje konstruktoru třídy (= statický inicializační blok),
 * protože se vždy před začátkem hry připraví počáteční stav sousedů a objektů
 * na základě názvů prostorů a objektů,
 * které konstruktory místnosti uložily do připravených konstant.
 * To sice trochu zdržuje, ale na druhou stranu to vede k jednoduššímu kódu.
 * <p>
 * Rozhodování o typu vytvářené instance třídy {@link Thing},
 * tj o její váze a případné alkoholické podstatě,
 * bere na svá bedra místnost, která o konstrukci této instance žádá
 * a připraví konstruktoru objektu všechny potřebné parametry,
 * aby už nemusel na nic myslet.
 * <p>
 * To sice vypadá na první pohled výhodně,
 * protože místnost jako objednavatel přesně ví, jaké objekty požaduje,
 * ale na druhou stranu se to příčí principu,
 * že má být každý objekt za sebe zodpovědný a starat se o své věci sám.
 *
 *
 * @author  Kristýna PELEŠKOVÁ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public enum Place implements IPlace
{
//== VALUES OF THE ENUMERATION TYPE ============================================
//
    Start("Vstupní prostor, v němž začíná hra",
            new String[] {"Pavilon_krokodýlů", "Občerstvení", "Pavilon_opic" },
            "#Banán", "Sáček", "Šátek")
    ,
    Občerstvení("Pomocný prostor, kde můžete získat potřebné předměty",
            new String[] {  "Pavilon_krokodýlů", "Start", "Pavilon_opic"  },
            "Salám", "Pití", "Cigarety", "Pastička")
    ,
    Pavilon_opic("Průchozí prostor",
            new String[] { "Start", "Občerstvení"}
            )
    ,

    Výběh_s_koňmi("Pomocný neprůchozí prostor",
            new String [] {"Pavilon_hlodavců"}
            )
   ,

    Pavilon_krokodýlů("Pomocný průchozí prostor",
            new String[] {"Občerstvení", "Pavilon_hlodavců", "Start"  }
             )

    ,

    Terária_s_hady("Pomocný prostor, kde můžete získat potřebné předměty",
            new String[] {"Sloni", "Pavilon_hlodavců"},
            "#Had", "Voda")
    ,

     Pavilon_hlodavců("Pomocný prostor, kde můžete získat potřebné předměty",
            new String[] { "Pavilon_krokodýlů", "Výběh_s_koňmi", "Terária_s_hady"},
             "#Klec", "Myš")
     ,


     Sloni("Pomocný prostor, kde můžete získat potřebné předměty",
            new String[] {"Voliéra", "Terária_s_hady", "Obchod_se_suvenýry"},
           "CD", "Seno")
    ,

     Voliéra("Pomocný neprůchozí prostor",
            new String[] {"Sloni"}
            )
     ,

    Obchod_se_suvenýry("Pomocný prostor, kde můžete získat potřebné předměty",
          new String[] {"Sloni", "Exit"},
          "Plyšák", "Pohled")
    ,

     Exit("Prostor, ze kterého se můžete bezpečně dostat ven a ukončit hru",
          new String[] {"Obchod_se_suvenýry"}
          )

;


//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================

    /** Aktuální místnost, tj. místnost, v níž se hráč právě nachází. */
    private static Place currentPlace;



//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//
//    /** Protože se prostory musejí inicializovat na počátku každé hry,
//     *  tak je tu statický konstruktor zbytečný, a slouží pouze k tomu,
//     *  aby se na něm demonstrovalo jeho možné použití.
//     */
//    static {
//        initializeRooms();
//    }
//
//
//
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /** Popis prostoru. */
    private final String description;

    /** Názvy objektů v prostoru na počátku hry. */
    private final String[] objectNames;

    /** Názvy sousedů prostoru na počátku hry. */
    private final String[] neighborNames;

    /** Aktuální objekty v prostoru. */
    private final Collection<Something> objects = new ArrayList<>();

    /** Aktuální sousedé prostoru. */
    private final Collection<Place> neighbors = new ArrayList<>();



//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

    /***************************************************************************
     * Inicializuje stav všech prostorů,
     * tj. uvede všechny prostoru do stavu požadovaného na počátku hry.
     */
    public static void initializePlaces()
    {
        for (Place place : values()) {
            place.initialize();
        }
        currentPlace = Start;
    }


    /***************************************************************************
     * Vrátí kolekci odkazů na všechny prostory vystupující ve hře.
     *
     * @return Kolekce odkazů na všechny prostory vystupující ve hře
     */
    static Collection<Place> getAllPlaces()
    {
//        //Verze rozepsaná do několika příkazů
//        Room[] roomsArr = values();
//        Collection<Room> roomList = Arrays.asList(roomsArr);
//        return roomList;

        //Verze dělající totéž, avšak zapsaná v jediném příkazu
        return Arrays.asList(values());
    }


    /***************************************************************************
     * Vrátí odkaz na aktuální prostor,
     * tj. na místnost, v níž se hráč pravé nachází.
     *
     * @return Místnost, v níž se hráč pravé nachází
     */
    static Place getCurrentPlace()
    {
        return currentPlace;
    }


    /***************************************************************************
     * Nastaví zadaný prostor jako aktuální.
     * Nic nekontroluje, věří žadateli,
     * protože metodu beztak vidí pouze třídy z daného balíčku.
     *
     * @param place Nastavovaná aktuální místnost
     */
    static void setCurrentPlace(Place place)
    {
        currentPlace = place;
    }



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Vytvoří prostor se zadaným názvem, popisem a počátečními
     * sousedy a objekty.
     *
     * @param description   Popis vytvářeného prostoru
     * @param neighborNames Názvy sousedů vytvářeného prostoru při startu hry
     * @param objectNames   Názvy objektů ve vytvářeném prostoru při startu hry
     */
    private Place(String description, String[] neighborNames,
                                     String... objectNames)
    {
        this.description   = description;
        this.neighborNames = neighborNames;
        this.objectNames   = objectNames;
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí popis prostoru, který daný prostor stručné charakterizuje.
     *
     * @return Popis daného prostoru
     */
    @Override
    public String getDescription()
    {
        return description;
    }


    /***************************************************************************
     * Vrátí název prostoru.
     *
     * @return Název prostoru
     */
    @Override
    public String getName()
    {
        return super.name();
    }


    /***************************************************************************
     * Vrátí kolekci sousedů daného prostoru, tj. kolekci prostorů,
     * do nichž je možno se z tohoto prostoru přesunout příkazem typu
     * {@link Commands.Type#MOVE Commands.Type.MOVE}.
     *
     * @return Kolekce sousedů
     */
    @Override
    public Collection<Place> getNeighbors()
    {
        return neighbors;
    }


    /***************************************************************************
     * Vrátí kolekci objektů nacházejících se v daném prostoru.
     *
     * @return Kolekce objektů nacházejících se v daném prostoru
     */
    @Override
    public Collection<Something> getObjects()
    {
        return objects;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Odebere zadaný objekt z daného prostoru.
     *
     * @param something Odebíraný objekt
     */
    void remove(Something something)
    {
        objects.remove(something);
    }



//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

    /***************************************************************************
     * Inicializuje místnost do počátečního stavu,
     * tj. přiřadí jí počáteční sousedy a vloží do ní počáteční objekty.
     */
    private void initialize()
    {
        neighbors.clear();
        for (String neighborName : neighborNames) {
            neighbors.add(Place.valueOf(neighborName));
        }
        objects.clear();
        for (String objectName : objectNames) {
            //V této verzi rozhoduje o podobě vytvářeného objektu žadatel
            //Začíná-li název znakem #, jedná se o nepřenositelný předmět
            //Začíná-li název znakem @, jedná se o alkoholický nápoj
            char prefix = objectName.charAt(0);
            String nameWithoutPrefix = objectName.substring(1);
            Something something;
            switch (prefix)
            {
                case '#': something = Something.newHeavySomething(nameWithoutPrefix);
                          break;

                default:  something = Something.newOrdinarySomething(objectName);
                          break;
            }
            objects.add(something);
        }
    }



//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTING CLASSES AND METHODS ===============================================
//
//    /*************************************************************************
//     * Testing method.
//     */
//    public static void test()
//    {
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
