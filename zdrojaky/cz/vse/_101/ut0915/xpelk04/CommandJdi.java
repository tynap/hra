/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.ut0915.xpelk04;

import java.util.jar.Attributes.Name;







/*******************************************************************************
 * Instance třídy {@code CommandJdi} představují příkazy
 * realizující standardní přesun.
 * Instance by mohla být definována jako jedináček,
 * ale v dané aplikaci svěřuje tuto starost do ruhou správce příkazů.
 *
 * @author  Kristýna PELEŠKOVÁ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class CommandJdi extends ACommand
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Vytvoří příkaz přesouvající hráče z aktuálního prostoru
     * do prostoru zadaného, přičemž zadaný prostor musí být
     * v danou chvíli sousedem prostoru aktuálního.
     */
    public CommandJdi()
    {
        super("Jdi", "Přesune vás z aktuálního prostoru do zadaného " +
                "sousedního.");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Metoda realizující standardní přesun do sousedního prostoru.
     * V parametru by měly být dvě položky: název příkazu
     * a název cílového prostoru.
     *
     * @param arguments Parametry příkazu - název příkazu a cílového prostoru
     * @return Text zprávy vypsané po provedeni příkazu
     */
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length < 2) {
            return "Nezadali jste prostor, do kterého se chcete přesunout"
                    + status();
        }
        String destName = arguments[1];
        Place currentPlace = Place.getCurrentPlace();



        for (Place neighbor : currentPlace.getNeighbors()) {


            if (destName.equalsIgnoreCase(neighbor.getName()))
            {

                if (destName.equals("voliéra"))
                     {
                           Place.setCurrentPlace(neighbor);

                             return "Vstoupil(a) jste do voliéry, " +
                                     "ve které " +
                                    "se vznášejí hladový kondoři, orli, " +
                                    " havrani a spoustu dalších " +
                                     "ptáků. \nV momentě," +
                                    " kdy vás zaregistrují," +
                                     " se za vámi zavřou " +
                                    "dveře. \n" +
                                     "Ptáci vám však dají ještě jednu šanci " +
                                     "a položí vám otázku. \n Pokud " +
                                     "odpovíte " +
                                     "špatně, uklovou vás. \n\n" +
                                     "Orel se ptá: \"Je pravda, že my, ptáci," +
                                    "nemáme bránici?\"";
                         }

                if (destName.equals("terária_s_hady"))
                          {Place.setCurrentPlace(neighbor);
                          return  "Vkročil(a) jste do" +
                            " Terária s hady, kteří po vás mlsně koukají." +
                            "\nNa výměnu za jídlo pro vás mají" +
                            " vědro s vodou." +
                             " Nakrmte je nebo raději zmizte."+ status();
                         }

                 if (destName.equals("sloni"))
                        {Place.setCurrentPlace(neighbor);
                         return  "Vkročil(a) jste do výběhu pro slony, " +
                         "kteří rozzuřeně" +
                         " pobíhají dokola. Nepotřebují" +
                           "\ntrochu schladit studenou sprchou? " +
                         "Být vámi, tak pospíším," +
                         " ať nedopadnete jako ušlapaný" +
                        "\nošetřovatel ležící v rohu, ke " +
                         "kterému vás výměnou za vodu pustí." + status();
                        }

                 if (destName.equals("exit"))
                       {Place.setCurrentPlace(neighbor);
                            return  "Úspěšně jste došli až k východu." +
                             " Ten je ale bohužel již " +
                             "zamčený, protože jste se na začátku" +
                            "\nzdržel na toaletách po " +
                             "požití prošlé klobásy ze stánku " +
                             "vedle, a zbytek zoo je již dávno"+
                            "\nevakuovaný.Jedinou " +
                             "možností otevření dveří je " +
                            "ošetřovatelova karta, " +
                             "kterou vložíte do čtečky." + status();

                          }

                  if (destName.equals("pavilon_krokodýlů"))
                      {Place.setCurrentPlace(neighbor);
                      return "Na krokodýly je moc velká zima," +
                             " proto celý pavilon spí a" +
                             " vy můžete bezpečně projít."+ status();
                       }

                  if (destName.equals("pavilon_hlodavců"))
                      {Place.setCurrentPlace(neighbor);
                      return  "Vkročil(a) jste do Pavilonu " +
                              "hlodavců kde se prohánějí skupinky " +
                               "od hrabošů přes veverky po bobry." +
                              " V dalších " +
                              "pavilonech by se vám mohlo některé zvíře" +
                              "odtud hodit jako krmivo."
                                + status();

                       }

                  if (destName.equals("občerstvení"))
                        {Place.setCurrentPlace(neighbor);

                             return "Vstoupil(a) jste do občerstvení." +
                                    "Jednu z věcí \n budete potřebovat, pro" +
                                     " získání jídla \n pro hladová " +
                                     "zvířata v ZOO, aby vám" +
                                     " umožnila dostat \n se odtud." +
                                     " Proto pečlivě" +
                                     " vybírejte, co si odtud vezmete."
                                     + status();

                         }

                  else{Place.setCurrentPlace(neighbor);

              return "Vkročil(a) jste do: "  +
                   neighbor.getName() + status(); }
            }
        }
        return  "Do zadaného prostoru odtud nemůžete přejít. " + destName
                + status();
    }


   



//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTING CLASSES AND METHODS ===============================================
//
//    /*************************************************************************
//     * Testing method.
//     */
//    public static void test()
//    {
//        CommandJdi inst = new CommandJdi();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
