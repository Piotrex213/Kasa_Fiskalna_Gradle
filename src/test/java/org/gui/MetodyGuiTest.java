package org.gui;

import org.junit.jupiter.api.Test;
import org.obsluga.Koszyk;

import static org.junit.jupiter.api.Assertions.*;

public class MetodyGuiTest {
    @Test
    public void druk_powinno_zwracac_odpowiedni_string(){
        assertEquals("Nazwa produktu : "+1337+" ilosc : " +1337+" laczna cena : " + 12.0 +"\n",MetodyGui.druk("1337",1337,12));
    }
    @Test
    public void sprWart_prawidlowe_dane_powinno_zwracac_false(){
        assertFalse(MetodyGui.sprWartDoKoszyka("123", "12332"));
    }
    @Test
    public void sprWart_nieprawidlowe_dane_powinno_zwracac_true(){
        assertTrue(MetodyGui.sprWartDoKoszyka("abc","abc"));
    }
    @Test
    public void sprWartDoBazy_prawidlowe_dane_powinno_zwracac_false(){
        assertFalse(MetodyGui.sprWartDoBazy("123","Abrakadabra","123.21"));
    }
    @Test
    public void sprWartDoBazy_nieprawidlowe_dane_powinno_zwracac_true(){
        assertTrue(MetodyGui.sprWartDoBazy("123","Abrakadabra","123..21"));
    }
    @Test
    public void doDwochMiejscPoPrzecinku_czy_dobrze_zaokragla(){
        assertEquals(32,MetodyGui.doDwochMiejscPoPrzecinku(32));
    }
    @Test
    public void czyInt_powinno_zwracac_true(){
        assertTrue(MetodyGui.czyInt("12332"));
    }
    @Test
    public void czyKoszykMaToId_ma_zwracac_false(){
        Koszyk k = new Koszyk();
        k.dodajPrzedmiotDoKoszyka(13,"Abradab",32.1);
        assertFalse(MetodyGui.czyKoszykMaToId(14,k));
    }
    @Test
    public void jezeliKoszykZawieraId_ma_wydrukowac_odpowiedni_komunikat_ZAWIERA(){
        Koszyk k = new Koszyk();
        k.dodajPrzedmiotDoKoszyka(13,"Abradab",12.1);
        assertEquals("Istnieje przedmiot o takim Id",
                MetodyGui.jezeliKoszykZawieraId(MetodyGui.czyKoszykMaToId(13,k)));
    }
    @Test
    public void jezeliKoszykZawieraId_ma_wydrukowac_odpowiedni_komunikat_NIEZAWIERA(){
        Koszyk k = new Koszyk();
        k.dodajPrzedmiotDoKoszyka(13,"Abradab",12.1);
        assertEquals("Przedmiot jest dodawany do bazy !",
                MetodyGui.jezeliKoszykZawieraId(MetodyGui.czyKoszykMaToId(12,k)));
    }
    @Test
    public void wyliczKoszyk_ma_zsumowac_wszystkie_wartosci_przedmiotow_w_koszyku(){
    }
}
