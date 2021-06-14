package org.gui;

import javafx.stage.FileChooser;
import org.obsluga.Koszyk;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MetodyGui {
    static String  d ="";
    static double k = 0;
    static String b ="";

    public static String druk(String a, int b , double k) {
        d = d + "Nazwa produktu : "+a+" ilosc : " + b+" laczna cena : " + k +"\n";
        return d;
    }

    public static boolean czyInt(String a) {
        boolean k = true;
        try{Integer.parseInt(a);}
        catch(Exception e){
            k = false;
        }
        return k;
    }

    public static boolean czyDouble(String a){
        boolean k = true;
        try{Double.parseDouble(a);}
        catch(Exception e){
            k = false;
        }
        return k;
    }

    public static boolean sprWartDoKoszyka(String a, String b){
        return a.isEmpty() || b.isEmpty() || !czyInt(a) ||!czyInt(b);
    }

    public static boolean sprWartDoBazy(String a, String b, String c){
        return a.isEmpty() || b.isEmpty() || c.isEmpty() ||
                !czyInt(a) || !czyDouble(c);
    }

    public static boolean czyKoszykMaToId(int a, Koszyk b){
        return b.czyIstniejeProduktODanymId(a);
    }

    public static String jezeliKoszykZawieraId(boolean t){
        if (t)
            return "Istnieje przedmiot o takim Id";
        else
            return "Przedmiot jest dodawany do bazy !";
    }

    public static double wyliczKoszyk(Koszyk koszyk, int id, int iloscSztuk){
        k = k+koszyk.getWartoscPrzedmiotu(id,iloscSztuk);
        return k;
    }

    public static double doDwochMiejscPoPrzecinku(double a){
        return Math.round(a*100.0)/100.0;
    }

    private static void zapiszPlik(String tresc, File file) {
        try {
            FileWriter fileWriter;

            fileWriter = new FileWriter(file);
            fileWriter.write(tresc);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public static void FileChooserZapisz(String a) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filtr = new FileChooser.ExtensionFilter("Lista zakupów w formacie .txt",
                "*.txt");
        fileChooser.getExtensionFilters().add(filtr);

        File wybranyPlik = fileChooser.showSaveDialog(null);
        if (wybranyPlik != null) {
            zapiszPlik(a, wybranyPlik);
        }
    }
    public static String konwertujBazeDanychNaString(Koszyk k){
        for(int i =0;i<k.getDlugoscKoszyka();i++){
            b = b+k.wyswietlBaze(i);
        }
        return b;
    }
}
