package org.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.stage.FileChooser;
import org.obsluga.Koszyk;

import static java.lang.Integer.parseInt;

public class Gui {
    Koszyk koszyk = new Koszyk();
    String s = MetodyGui.konwertujBazeDanychNaString(koszyk);

    @FXML
    private TextField idProduktu,iloscProduktow,idProduktuDoBazy,nazwaProduktuDoBazy,cenaProduktuDoBazy;
    public TextArea stanKoszyka;
    public Button dodajDoKoszyka,dodajDoBazy;
    public Alert a = new Alert(Alert.AlertType.NONE);
    public Label lacznaWartoscKoszyka;

    public void initialize() {
        stanKoszyka.setDisable(true);
        stanKoszyka.setWrapText(true);
        dodajDoKoszyka.setDisable(true);
        dodajDoBazy.setDisable(true);
    }

    public void sprawdzenieWartosci(){
        dodajDoKoszyka.setDisable(MetodyGui.sprWartDoKoszyka(idProduktu.getText(),iloscProduktow.getText()));
        dodajDoBazy.setDisable(MetodyGui.sprWartDoBazy(idProduktuDoBazy.getText(),nazwaProduktuDoBazy.getText(),
                cenaProduktuDoBazy.getText()));
    }

    public void dodajDoBazy() {

        if(MetodyGui.czyKoszykMaToId(parseInt(idProduktuDoBazy.getText()),koszyk))
        {
            a = new Alert(Alert.AlertType.ERROR);
            a.show();
            a.setContentText("Takie ID istenieje w bazie.  Wybierz inne.");
        }
        else {
            koszyk.dodajPrzedmiotDoKoszyka(parseInt(idProduktuDoBazy.getText()),nazwaProduktuDoBazy.getText()
                    ,MetodyGui.doDwochMiejscPoPrzecinku(Double.parseDouble(cenaProduktuDoBazy.getText())));
            a = new Alert(Alert.AlertType.INFORMATION);
            a.show();
            a.setContentText("Dodano nowy produkt do bazy");
            koszyk.zapisProduktowDoPliku();
        }
    }

    public void dodajDoKoszyka() {

        int parseIdProduktu = parseInt(idProduktu.getText());
        int parseIloscProduktow = parseInt(iloscProduktow.getText());
        if(MetodyGui.czyKoszykMaToId(parseIdProduktu,koszyk)){
            String druk = MetodyGui.druk(koszyk.getNazwaPrzedmiotu(parseIdProduktu),
                    parseIloscProduktow,koszyk.getWartoscPrzedmiotu(parseIdProduktu,
                            parseIloscProduktow ));
            stanKoszyka.setText(druk);
            lacznaWartoscKoszyka.setText("Laczna wartosc koszyka wynosi : "+
                    Double.toString(MetodyGui.wyliczKoszyk(koszyk,parseIdProduktu,parseIloscProduktow))+" zl");
            a = new Alert(Alert.AlertType.INFORMATION);
            a.show();
            a.setContentText("Przedmioty zostały dodane do koszyka !");
        }
        else
        {
            a = new Alert(Alert.AlertType.ERROR);
            a.show();
            a.setContentText("Brak ID w bazie");
        }
    }

    public void wystawParagon() {
        MetodyGui.FileChooserZapisz(stanKoszyka.getText()+"\n\n"+lacznaWartoscKoszyka.getText());
    }

    public void wyswietlZawartoscBazy() {
        TextArea area = new TextArea(s);
        area.setWrapText(true);
        area.setEditable(false);
        a = new Alert(Alert.AlertType.INFORMATION);
        a.getDialogPane().setContent(area);
        a.setHeaderText("Lista Produktow :");
        a.showAndWait();
    }
}