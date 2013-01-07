/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.ut0915.xpelk04;

import java.util.Collection;
import java.util.List;





/*******************************************************************************
 * Instances of class {@code CommandNapoveda} represent ...
 *
 * @author  Kristýna PELEŠKOVÁ
 * @version 0.00.0000 — 2013-01-07
 */
public class CommandNapoveda extends ACommand
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
     *
     */
    public CommandNapoveda()
    {
        super("?","Vrátí nápovědu obsahující popsané příkazy i místnosti");
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
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
//        CommandNapoveda inst = new CommandNapoveda();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }


    @Override
    public String execute(String... arguments)
    {
        String Startjm       = Place.Start.getName();
        String Občerstveníjm = Place.Občerstvení.getName();
        String Opicejm       = Place.Pavilon_opic.getName();
        String konejm        = Place.Výběh_s_koňmi.getName();
        String krokousijm    = Place.Pavilon_krokodýlů.getName();
        String hadijm        = Place.Terária_s_hady.getName();
        String hlodavcijm    = Place.Pavilon_hlodavců.getName();
        String Slonijm       = Place.Sloni.getName();
        String Voliérajm     = Place.Voliéra.getName();
        String obchodjm      = Place.Obchod_se_suvenýry.getName();
        String exitjm        = Place.Exit.getName();



        String Start       = Place.Start.getDescription();
        String Občerstvení = Place.Občerstvení.getDescription();
        String Opice       = Place.Pavilon_opic.getDescription();
        String kone        = Place.Výběh_s_koňmi.getDescription();
        String krokousi    = Place.Pavilon_krokodýlů.getDescription();
        String hadi        = Place.Terária_s_hady.getDescription();
        String hlodavci    = Place.Pavilon_hlodavců.getDescription();
        String Sloni       = Place.Sloni.getDescription();
        String Voliéra     = Place.Voliéra.getDescription();
        String obchod      = Place.Obchod_se_suvenýry.getDescription();
        String exit        = Place.Exit.getDescription();






        return  "Místnosti: \n" + Startjm + ": " + Start +
                "\n" + Občerstveníjm + ": " + Občerstvení + "\n"
                     + Opicejm + ": " + Opice
                + "\n" + konejm + ": " + kone
                + "\n" + krokousijm + ": " + krokousi
                + "\n" + hadijm + ": " + hadi
                + "\n" + hlodavcijm + ": " + hlodavci
                + "\n" + Slonijm + ": " + Sloni +
                "\n" + Voliérajm + ": " + Voliéra
                + "\n" + obchodjm + ": " + obchod +
                "\n" + exitjm + ": " + exit;

    }
}
