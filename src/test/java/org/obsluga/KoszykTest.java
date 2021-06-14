package org.obsluga;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class KoszykTest {
    static Koszyk nowyKoszyk = new Koszyk();
    @BeforeAll
    public static void  ustawKoszyk(){
        nowyKoszyk.dodajPrzedmiotDoKoszyka(1337,"Parabola",13.12);
    }
    @Test
    public void dodajPrzedmiotDoKoszyka_powinno_spelniac_swoja_role() {
        assertTrue(nowyKoszyk.czyIstniejeProduktODanymId(1337));
    }
    @Test
    public void getDlugoscKoszyka_zwraca_true_gdy_dlugosc_wieksza_niz_0(){
        assertTrue(nowyKoszyk.getDlugoscKoszyka()>0);
    }
    @Test
    public void getWartoscPrzedmiotu_poprawnie_zwraca_wartosci(){
        assertEquals(26.24,nowyKoszyk.getWartoscPrzedmiotu(1337,2));
    }
    @Test
    public void getWartoscPrzedmiotu_zwraca_falsz_przy_niepoprawnych_danych(){
        boolean t = nowyKoszyk.getWartoscPrzedmiotu(1337, 2) != 26.24;
        assertFalse(t);
    }
    /*@Test
    public void getNazwaPrzedmiotu_poprawnie_zwraca_wartosci(){
        assertEquals("Parabola",nowyKoszyk.getNazwaPrzedmiotu(1337));
    }*/
    @Test
    public void getNazwaPrzedmiotu_zwraca_falsz_przy_niepoprawnych_danych(){
        boolean t = nowyKoszyk.getNazwaPrzedmiotu(1337).equals("P");
        assertFalse(t);
    }
    @Test
    public void zapisProduktowDoPliku_sprawdza_czy_plik_istnieje(){
        nowyKoszyk.zapisProduktowDoPliku();
        File plik = new File("baza.txt");
        assertTrue(plik.exists());
    }
    @Test
    public void otwarcieProduktowZPliku_sprawdza_czy_produkty_zostaly_zapisane_do_arraylist(){
        nowyKoszyk.otwarcieProduktowZPliku();
        assertTrue(nowyKoszyk.getDlugoscKoszyka()>0);
    }
}
