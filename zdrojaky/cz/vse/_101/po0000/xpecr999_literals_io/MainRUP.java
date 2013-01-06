/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse._101.po0000.xpecr999_literals_io;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;



/*******************************************************************************
 * Třída {@code MainRUP} je hlavní třídou projektu
 * zprostředkující komunikaci mezi uživatelem a hrou.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class MainRUP
{
    /***************************************************************************
     * Metoda startující aplikaci je podle parametrů příkazového řádku
     * schopna spustit aplikaci v jednom ze tří režimů:
     *  <ul>
     *    <li>Nejsou-li zadány parametry nebo je-i zadán parametr {@code -win},
     *      spustí se hra v okenním režimu komunikujícím prostřednictvím
     *      jednoduchých dialogových oken.
     *      <br>&nbsp;</li>
     *    <li>Parametr {@code -cmd} spouští hru v režimu komunikujícím
     *      s uživatelem prostřednictvím standardního vstupu a výstupu &ndash;
     *      typicky prostřednictvím konzoly.
     *      <br>&nbsp;</li>
     *    <li>Parametr {@code -file} spouští hru v režimu
     *      zapisujícím zprávy uživateli na standardní výstup a
     *      čtoucím vstupní příkazy za zadaného souboru,
     *      který musí být zadán za tímto parametrem;
     *      přesněji za následující mezerou.
     *      Cesta k souboru může být zadána absolutně i relativně.
     *      <br>&nbsp;</li>
     * </ul>
     *
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args)
    {
        if (args.length == 0) {
            //Nejdou-li zadány žádné parametry, spuští se v okenním režimu
            winIO();
        }
        else {
            switch (args[0])
            {
                case "-win":    //Komunikace prostřednictvím jednoduchých oken
                                winIO();    break;

                case "-std":    //Komunikace prostřednictvím standardního
                                //vstupu a výstupu
                                stdIO();    break;

                case "-file":   //Vstup příkazů ze zadaného souboru,
                                //odpovědi hry posílané na standardní výstup
                                fileInStdOut(args); break;

                default:        //Špatně zadaný parametr
                    throw new RuntimeException(
                            "\nNeznámý argument "  +  args[0]);
            }
        }
        System.exit(0);
    }


    /***************************************************************************
     * Komunikuje s uživatelem prostřednictvím jednoduchých dialogových oken
     * poskytovaných třídou {@link JOptionPane}.
     */
    private static void winIO()
    {
        //Pomocné rodičovské okno umožňujcí zobrazovat dialogová okna
        //na druhé obrazovace
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(-1000, 500);  //Pozice, kde se budou okna zobrazovat
        frame.setVisible(true);

        GameRUP game    = GameRUP.getInstance();
        String  command = "";   //Startovací příkaz
        for (;;) {
            //Zadá hře příkaz a převezme odpověď
            String answer = game.executeCommand(command);
            if (! game.isAlive()) {
                //Hra je ukončena => poděkuje za hru a rozloučí se
                JOptionPane.showMessageDialog(frame, answer);
                break;
            }
            //Zobrazí odpověď hry a převezme od uživatele další příkaz
            command = JOptionPane.showInputDialog(frame, answer);
        }
    }


    /***************************************************************************
     * Komunikuje s uživatelem prostřednictvím standardního vstupu a výstupu.
     */
    private static void stdIO()
    {
        Scanner scanner = new Scanner(System.in);
        useScanner(scanner);
    }


    /***************************************************************************
     * Očekává za svým spouštěcím parametrem cestu k souboru
     * se zadanými vstupními příkazy; své odpovědi posílá na standardní výstup.
     *
     * @param args Parametry příkazového řádku
     */
    private static void fileInStdOut(String[] args)
    {
        Scanner scanner = createScanner(args);
        useScanner(scanner);
    }


    /***************************************************************************
     * Vytvoří scanner čtoucí příkazy ze souboru zadaného v příkazovém řádku.
     *
     * @param args Parametry příkazového řádku
     * @return Požadovaný scanner
     */
    private static Scanner createScanner(String[] args)
    {
        if (args.length < 2) {
            throw new RuntimeException(
                    "\nNebyl zadán název souboru");
        }
        File    file = new File(args[1]);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        }
        catch (FileNotFoundException ex) {
            throw new RuntimeException(
                "\nNepodařilo se otevřít zadaný soubor: " + file, ex );
        }
        return  scanner;
    }


    /***************************************************************************
     * Spustí komunikaci s uživatelem, která bude
     * číst příkazy uživatele prostřednictvím zadaného scanneru
     * a posílat odpovědi hry na standardní výstup.
     *
     * @param scanner Scanner zprostředkující vstup
     */
    private static void useScanner(Scanner scanner)
    {
        GameRUP game    = GameRUP.getInstance();
        String  command = "";   //Startovací příkaz
        for (;;) {
            //Zadá hře příkaz a převezme odpověď
            String answer = game.executeCommand(command);
            System.out.println(answer);     //Zobrazí odpověď hry
            if (! game.isAlive()) {
                return;
            }
            command = scanner.nextLine();   //Přečte další příkaz uživatele
        }
    }


    /** Soukromý konstruktor bránící vytvoření dalších instancí. */
    private MainRUP() {}
}
