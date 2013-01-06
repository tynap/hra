/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.vse;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import java.nio.charset.Charset;

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



/*******************************************************************************
 * Třída poskytuje možnost zazipovat zadanou složku do stejnojmenného souboru.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 0.00.0000 — 20yy-mm-dd
 */
public class Zipper2
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Název class-souboru této třídy. */
    private static final String THIS_CLASS = "Zipper2.class";

    /** Filtr eliminující z kopírování soubory, o které nestojíme. */
    private static final FileFilter NO_CLASS_CTXT = new FileFilterImpl();

    /** Společný rodičovský balíček odevzdávaných prací. */
    private static final String START = "cz.vse";

    /** Kořenová složka projektu. */
    private static final String ROOT = ".SRC";

    /** Fiktivní identifikační soubor. */
    private static final File ID_FILE = new File("ID");



//== VARIABLE CLASS ATTRIBUTES =================================================

    /** Složka, kterou dialogové okno pro zadání složek  nabídne jako výchozí.*/
    private static File   startFolder;

    /** Zdrojová složka odkud budeme kopírovat. */
    private static File   sourceFolder;

    /** Název zdrojové složky a současně i název cílového souboru. */
    private static String folderName;

    /** Složka, do níž bude umístěn cílový soubor. */
    private static File   destFolder;

    /** Cílový soubor. */
    private static File   destFile;

    /** Výstupní proud směřující do cílového souboru. */
    private static FileOutputStream fos;

    /** Dekorující výstupní proud zajišťující vytváření obsahu
     *  odpovídajícímu formátu pro ZIP. */
    private static ZipOutputStream  zipStream;
//
//    /** Cesta zadaná relativně ke zdrojové složce a definující tak
//     *  i virtuální cílovou složku. */
//    private static String relFolder;



//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

    /*************************************************************************
     * Zjistí od uživatele, odkud a kam chce kopírovat,
     * a požadavek realizuje.
     */
    public static void createZIP()
    {
        try {
            prepareFiles();
            try {
                copyFiles();
            }
            finally {
                try {
                    zipStream.close();
                }
                catch (IOException ex) {
                    throw new RuntimeException(
                            "\nNepodařilo se zavřít vytvořený ZIP-soubor " +
                        zipStream, ex);
                }
            }
        } catch (RuntimeException runtimeException){
            StringWriter stringWriter = new StringWriter();
            PrintWriter  printWriter  = new PrintWriter(stringWriter);
            runtimeException.printStackTrace(printWriter);
            String message = stringWriter.toString();
            System.out.println(message);
            JOptionPane.showMessageDialog(null, message);
            System.exit(1);
        }
        JOptionPane.showMessageDialog(null, "HOTOVO");
    }



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /** Soukromý konstruktor zabraňující vytvoření instance.*/
    private Zipper2() {}



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================

    /***************************************************************************
     * Zjistí od uživatele zdrojovou složku a složku pro vytvářený ZIP.
     */
    private static void askUser()
    {
        sourceFolder   = selectFolder("Nastav zdroj");
//        sourceFolder = new File(
//"d:/Tvorba_PGM_SVN/@A_Aplikace/@A_Jarchive/src/cz/pecinovsky/utility/jarchive/");
        folderName   = sourceFolder.getName();

        for(;;) {
            destFolder     = selectFolder("Nastav cíl");
//            destFolder   = new File(
//            "d:/Tvorba_PGM_SVN/@A_Aplikace/@A_Jarchive/TMP/");
            destFile     = new File(destFolder, '/' + folderName + ".zip");
            if (destFile.exists()) {
                int answer = JOptionPane.showConfirmDialog(null,
                                "Soubor\n\n" + destFile +
                                "\n\njiž existuje.\n\nChcete jej nahradit?");
                if (answer == 0) {
                    destFile.delete();
                    break;
                }
//                if (answer == 1) {
//                    throw new RuntimeException(
//                            "\nVyhazuji výjimku");
//                }
                if (answer != 1) {
                    System.exit(1);
                }
            }
            else {
                break;
            }
        }

        try {
            destFile.createNewFile();
        }
        catch (IOException ex) {
            throw new RuntimeException(
                "\nNepodařilo se vytvořit soubor: " + destFile, ex);
        }
        try {
            fos       = new FileOutputStream(destFile);
        }
        catch (FileNotFoundException ex) {
            throw new RuntimeException(
                    "\nNebyl nalezýen soubor " + destFile, ex);
        }
    }


    /***************************************************************************
     * Metoda zkopíruje všechny soubory ze složky {@link #sourceFolder}
     * a jejích podsložek do připraveného ZIP-souboru.
     */
    private static void copyFiles()
    {
        String relFolder = folderName + '/';
        createID  (sourceFolder, relFolder);
        copyFolder(sourceFolder, relFolder);
    }


    /***************************************************************************
     * Metoda zkopíruje všechny soubory ze zadané složky a jejích podsložek
     * do zadané virtuální složky ve vytvářeném ZIP-souboru.
     *
     * @param sourceFolder Zdrojové složka
     * @param relFolder    Virtuální složka v ZIP-souboru
     */
    private static void copyFolder(File sourceFolder, String relFolder)
    {
        File[] files = sourceFolder.listFiles(NO_CLASS_CTXT);
        for (File file : files) {
            String fileName = file.getName();
            if (file.isDirectory()) {
                String embeddedRelFolder = relFolder + fileName + '/';
                copyFolder(file, embeddedRelFolder);
            }
            else {
                String entryName = relFolder + fileName;
                ZipEntry zipEntry = new ZipEntry(entryName);
                openEntry(zipEntry, file);
                copyFile(file, zipEntry);
                closeEntry(zipEntry);
            }
        }
    }


    /***************************************************************************
     * Metoda zkopíruje zadaný soubor do zadané položky
     * v zadaném zipovém výstupním proudu.
     *
     * @param file      Kopírovaný soubor
     * @param zipEntry  Cílová položka ve vytvářeném ZIP-souboru
     */
    private static void copyFile(File file, ZipEntry zipEntry)
    {
        FileInputStream     fis;
        BufferedInputStream bis;
        try {
            fis = new FileInputStream    (file);
            bis = new BufferedInputStream(fis);
        }
        catch (FileNotFoundException ex) {
            throw new RuntimeException(
                    "\nNenalezen kopírovaný soubor: ", ex);
        }
        int c;
        for(;;) {
            try {
                c = bis.read();
            }
            catch (IOException e) {
                throw new RuntimeException(
                    "\nNepodařilo se přečíst další znak ze souboru " + file, e);
            }
            if (c < 0) {
                break;
            }
            try {
                zipStream.write(c);
            }
            catch (IOException ex) {
                throw new RuntimeException(
                    "\nNepodařilo se přečíst další znak do položky" +
                    zipEntry, ex);
            }

        }
    }


    /***************************************************************************
     * Vytvoří identifikační záznam naznačující použitou cestu.
     *
     * @param sourceFolder Zdrojové složka
     * @param relFolder    Virtuální složka v ZIP-souboru
     */
    private static void createID(File sourceFolder, String relFolder)
    {
        String entryName;
        String pkg   = sourceFolder.getPath().replaceAll("[/\\u005c]", ".");
        int    start = pkg.lastIndexOf(START);
        if (start >= 0) {
            entryName = pkg.substring(start);
        }
        else {
            int end = pkg.lastIndexOf(ROOT);
            start   = pkg.lastIndexOf('.', end-1);
            entryName = pkg.substring(start+1);
        }
        entryName += ".ID";
        ZipEntry zipEntry  = new ZipEntry(entryName);
        openEntry (zipEntry, ID_FILE);
        closeEntry(zipEntry);
    }


    /***************************************************************************
     * Otevře položku v cílovém archivu a připraví se pro její naplnění.
     *
     * @param zipEntry  Otevíraná položka
     * @param file      Soubor, jehož obsahem ji budeme plnit
     */
    private static void openEntry(ZipEntry zipEntry, File file)
    {
        try {
            zipStream.putNextEntry(zipEntry);
        }
        catch (IOException ex) {
            throw new RuntimeException(
                    "\nNepodařilo se přidat soubor " + file, ex);
        }
    }


    /***************************************************************************
     * Zavře zadanou položku v cílovém archivu.
     *
     * @param zipEntry Zavíraná položka
     */
    private static void closeEntry(ZipEntry zipEntry)
    {
        try {
            zipStream.closeEntry();
        }
        catch (IOException ex) {
            throw new RuntimeException(
                "\nNepodařilo se zavřít ZIP-Entry " + zipEntry, ex);
        }
    }


    /***************************************************************************
     * Zjistí od uživatele složku, jejíž obsah chce kopírovat,
     * a složku, v níž bude umístěn výstupní ZIP-soubor pojmenovaný stejně
     * jako kopírovaná složka.
     */
    private static void prepareFiles()
    {
        setStartFolder();
    FOR:
        for(;;) {
            askUser();
            String question = String.format(
                              "Obsah složky\n\n%s\n\nse bude ukládat " +
                              "do souboru\n\n%s\n\nSouhlasí?",
                              sourceFolder, destFile);
            int answer = JOptionPane.showConfirmDialog(null, question);
            switch (answer) {
                case 0:  break FOR;
                case 1:  continue;
                default: System.exit(1);
            }
        }
        zipStream = new ZipOutputStream(fos, Charset.forName("UTF-8"));
        zipStream.setLevel(9);
    }


    /***************************************************************************
     * Metoda požádá uživatele o zadání zdrojové složky.
     *
     * @param buttonText Text na potvrzovacím tlačítku
     * @return Vybraná složka
     */
    private static File selectFolder(String buttonText)
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(startFolder);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setApproveButtonText(buttonText);
        int state = fileChooser.showOpenDialog(null);
        if (state == JFileChooser.CANCEL_OPTION) {
            System.exit(1);
        }
        File folder = fileChooser.getSelectedFile();
        startFolder = folder;
        return folder;
    }


    /***************************************************************************
     * Prohlásí za výchozí složku tu, v níž se nachází daná třída,
     * resp. JAR-soubor s danou třídou.
     */
    private static void setStartFolder()
    {
        URL myURL = Zipper2.class.getResource(THIS_CLASS);
        String urlString = myURL.toString();
        int    start;
        if (urlString.startsWith("jar:")) {
            //Vyhazuji počáteční jar:
            urlString = urlString.substring(4);
        }
        else if (urlString.startsWith("file:")) {
            URL folderURL = Zipper2.class.getResource("Zipper.class");
        }
        else {
            throw new RuntimeException("\nNeznámá URL: " + urlString);
        }
        //Vyhazuji konec směřující do vnitřku složky
        int end = urlString.lastIndexOf('/');
        urlString = urlString.substring(0, end);
        URL folderURL;
        try {
            folderURL = new URL(urlString);
        }
        catch (MalformedURLException ex) {
            throw new RuntimeException(
                    "\nŠpatně vytvořená URL složky: " + urlString, ex);
        }
        URI uri;
        try {
            uri = folderURL.toURI();
        }
        catch (URISyntaxException ex) {
            throw new RuntimeException(
                    "\nNepodařilo se udělat URI z URL: " + folderURL, ex);
        }
        startFolder = new File(uri);
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================

    /***************************************************************************
     * Filtr propouštějící soubory, které nemají příponu {@code .class}
     * ani {@code .ctxt} a složky, které se nejmenují {@code doc}.
     */
    private static class FileFilterImpl implements FileFilter
    {
        @Override
        public boolean accept(File file)
        {
            if (file.isDirectory()) {
                if ("doc".equals(file.getName())) {
                    return false;
                }
                else {
                    return true;
                }
            }
            String fileName = file.getName();
            if (fileName.endsWith  (".class")  ||
                fileName.endsWith  (".ctxt")  ||
                fileName.startsWith("__SHELL"))
            {
                return false;
            }
            else {
                return true;
            }
        }
    }



//== TESTING CLASSES AND METHODS ===============================================

    /** @param args Command line arguments - not used. */
    public static void main(String[] args)  {  createZIP();  }
}
