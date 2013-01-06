/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.po0000.xpecr999_constants;

import cz.vse.adv_framework.game_txt.IPlace;

import java.util.ArrayList;
import java.util.Collection;

import java.util.EnumMap;
import java.util.List;


import static cz.vse._101.po0000.xpecr999_constants.Thing.ALCOHOLIC;
import static cz.vse._101.po0000.xpecr999_constants.Thing.HEAVY;

import static cz.vse.adv_framework.test_util.default_game.game.Texts.*;



/*******************************************************************************
 * Instance výčtového typu {@code Room} představují prostory hry -
 * v našem případě místnosti ve služebním bytě.
 * <p>
 * Tato třída demonstruje možné použití konstruktoru třídy,
 * v němž se připraví kontejnery obsahující počáteční sousedy každé místnosti
 * a předměty, nacházející se v jednotlivých místnostech na počátku hry,
 * aby se před každým začátkem hry nemusely rušit dříve vytvořené objekty
 * a znovu vytvářet nové objekty na základě jejich názvů.
 * <p>
 * <b>Třída má připravena dvě řešení,
 * z nichž jedno je aktivní a druhé je zakomentováno:</b>
 * <ul>
 *   <li>V prvním případě je použito klasické řešení využívající
 *       dvojrozměrná pole - každé místnosti náleží jeden řádek,
 *       v němž jsou vyjmenováni počáteční sousedé, resp, výchozí objekty.
 *       Kód náležející tomuto řešení je označen komentářem<br>
 *       <b>{@code //2D Arrays}</b>
 *       <br>&nbsp;</li>
 *   <li>V druhém případě je použito řešení využívající mapy,
 *       v níž jsou místnosti jako klíče, jimž je přiřazena hodnota
 *       představovaná seznamem počátečních sousedů, resp. objektů.
 *       Kód náležející tomuto řešení je označen komentářem<br>
 *       <b>{@code //Maps}</b>
 *       <br>&nbsp;</li>
 * </ul>
 * <p>
 * Takto jednorázově připravené kontejnery s počátečními sousedy a objekty
 * sice poněkud zrychlí inicializace,
 * jenže toto zrychlení je lidskými smysly nepostřehnutelné
 * a sami se můžete přesvědčit, nakolik zkomplikuje kód.
 * Klasické řešení využívající dvourozměrná pole jej přitom zkomplikuje více,
 * než řešení využívající mapy.
 * Navíc řešení s mapami nebude (oproti názoru zastánců klasiky) pomalejší,
 * protože mapy založené na výčtových typech jsou stejně rychlé jako pole.
 * <p>
 * V této třídě se navíc  předpokládá,
 * že si podrobné informace o vytvářeném objektu
 * odvodí jeho konstruktor z obdrženého názvu,
 * a místnosti se proto nesnaží tomuto konstruktoru napovídat
 * a předávat mu doplňující informace v parametrech.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public enum Room implements IPlace
{
//== VALUES OF THE ENUMERATION TYPE ============================================
//
    Předsíň ("Vstupní prostor bytu odkud se dá přesunout do většiny místností.",
            new String[] { LOŽNICE, OBÝVÁK, KOUPELNA },
            HEAVY+BOTNÍK, DEŠTNÍK)
    ,
    Koupelna("Pomocný prostor, kde můžete získat potřebné předměty",
            new String[] { PŘEDSÍŇ },
            BRÝLE, HEAVY+UMYVADLO, ČASOPIS)
    ,
    Obývák  ("Průchozí prostor, kudy se dá dojít od kuchyně",
            new String[] { KUCHYŇ, PŘEDSÍŇ },
            HEAVY+TELEVIZE)
    ,
    Kuchyň  ("Prostor, v němž je hledaný předmět - lednička." +
           "\nJinak moje nejoblívenější místnost",
            new String[] { LOŽNICE, OBÝVÁK },
            HEAVY+LEDNIČKA, PAPÍR)
    ,
    Ložnice ("Pomocný, ve hře nepoužívaný prostor, " +
           "\njinak Druhá nejmilejší místnost v bytě, " +
           "\nv níž osazenstvo tráví mnohé příjemné chvilky.",
            new String[] { KUCHYŇ, PŘEDSÍŇ },
            HEAVY+POSTEL, HEAVY+ZRCADLO, ŽUPAN)
    ,
    Lednička("Cílový prostor, odkud si můžete vzít něco k jídlu;" +
           "\nnejčastější cíl mých výletů",
            new String[] {},
            ALCOHOLIC+PIVO, ALCOHOLIC+PIVO, ALCOHOLIC+PIVO,
            ALCOHOLIC+VÍNO, ALCOHOLIC+RUM,
            SALÁM, HOUSKA)
    ;



//== CONSTANT CLASS ATTRIBUTES =================================================

    //Maps
    /** Počáteční sousedé jednotlivých místností. */
    private static final EnumMap<Room, List<Room>> initialNeighbors =
                                                  new EnumMap<>(Room.class);

    /** Počáteční objekty umístěné v místnostech. */
    private static final EnumMap<Room, List<Thing>> initialObjects =
                                                    new EnumMap<>(Room.class);

//    //2D arrays
//    /** Počáteční sousedé jednotlivých místností. */
//    private static final Room[][] initialNeighbors =
//                                  new Room[values().length][];
//
//    /** Počáteční objekty umístěné v místnostech. */
//    private static final Thing[][] initialObjects =
//                                   new Thing[values().length][];



//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================

    /** Statický konstruktor připraví statické atributy,
     *  které nemohly být naplněny při konstrukci instancí,
     *  protože v době vytváření instancí tyto atributy ještě neexistovaly. */
    static {
//        initializeInto2DArrays();
        initializeIntoMaps();
    }



//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /** Popis prostoru. */
    private final String description;

    /** Aktuální objekty v prostoru. */
    private final Collection<Thing> objects = new ArrayList<>();

    /** Aktuální sousedé prostoru. */
    private final Collection<Room> neighbors = new ArrayList<>();



//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    /** Názvy objektů v prostoru na počátku hry. */
    private String[] objectNames;

    /** Názvy sousedů prostoru na počátku hry. */
    private String[] neighborNames;



//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

    /***************************************************************************
     * Inicializuje stav všech prostorů,
     * tj. uvede všechny prostoru do stavu požadovaného na počátku hry.
     */
    public static void initializeRooms()
    {
        for (Room room : values()) {
            room.initialize();
        }
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
    private Room(String description, String[] neighborNames,
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
    public Collection<Room> getNeighbors()
    {
        return neighbors;
    }


    /***************************************************************************
     * Vrátí kolekci objektů nacházejících se v daném prostoru.
     *
     * @return Kolekce objektů nacházejících se v daném prostoru
     */
    @Override
    public Collection<Thing> getObjects()
    {
        return objects;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//
//    //2D arrays
//    /***************************************************************************
//     * Inicializuje dvojrozměrná pole,
//     * v nichž jsou uloženy počáteční sousedé jednotlivých místností
//     * a objekty, které se v místnostech nacházejí na počátku hry.
//     */
//    private static void initializeInto2DArrays()
//    {
//        int count = values().length;
//
//        //Pomocné lokální proměnné
//        Room[]   values  = values();    //Pole všech prostorů (zde místností)
//        Room[]   rooms;    //Pole sousedů daného pole
//        Thing[]  things;   //Pole objektů v daném poli
//        String[] names;    //Pole názvů vkládaných entit
//
//        //Pro každou místnost přípravíme jejíé pole sousedů a objektů
//        for (int i=0;   i < count;   i++) {
//            Room room = values[i];  //Inicializovaná místnosti
//
//            names = room.neighborNames;     //Názvy sousedů
//            rooms = new Room[names.length]; //Připravím pro ně pole
//
//            for (int j=0;   j < names.length;   j++) {
//                Room r   = valueOf(names[j]); //Zjistím souseda s daným jménem
//                rooms[j] = r;                 //a zapamatuji si jej v poli
//            }
//            initialNeighbors[i] = rooms;//Zapamatuji si pole sousedů i-tého pole
//            room.neighborNames  = null; //Pole jejich jmen už nebudu potřebovat
//
//            names  = room.objectNames;        //Názvy objektů
//            things = new Thing[names.length]; //Připravím pro ně pole
//            for (int j=0;   j < names.length;   j++) {
//                //Nechám vyrobit objekt se zadaným názvem
//                Thing t = new Thing(names[j]);//Vytvořím objekt s daným jménem
//                things[j] = t;                //a zapamatuji si jej v poli
//            }
//            initialObjects[i] = things; //Zapamatuji si objekty v i-tém poli
//            room.objectNames  = null;   //Pole jejich názvů už nebudu potřebovat
//        }
//    }
//

    //Maps
    /***************************************************************************
     * Inicializuje mapy,
     * v nichž jsou uloženy počáteční sousedé jednotlivých místností
     * a objekty, které se v místnostech nacházejí na počátku hry.
     */
    private static void initializeIntoMaps()
    {
        for (Room room : values()) {
            List<Room> rooms = new ArrayList<>(room.neighborNames.length);
            for (String name : room.neighborNames) {
                rooms.add(valueOf(name));
            }
            initialNeighbors.put(room, rooms);
            room.neighborNames = null;

            List<Thing> things = new ArrayList<>(room.objectNames.length);
            for (String name : room.objectNames) {
                things.add(new Thing(name));
            }
            initialObjects.put(room, things);
            room.objectNames = null;
        }
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

    /***************************************************************************
     * Inicializuje místnost do počátečního stavu,
     * tj. přiřadí jí počáteční sousedy a vloží do ní počáteční objekty.
     */
    private void initialize()
    {
        neighbors.clear();
        objects.clear();

//        //2D arrays
//        neighbors.addAll(Arrays.asList(initialNeighbors[ordinal()]));
//        objects.addAll(Arrays.asList(initialObjects[ordinal()]));

        //Maps
        neighbors.addAll(initialNeighbors.get(this));
        objects  .addAll(initialObjects  .get(this));
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
