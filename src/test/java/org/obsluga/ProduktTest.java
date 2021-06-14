package org.obsluga;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProduktTest {
    Produkt k = new Produkt(13,"Abradab",12.3);
    @Test
    public void getId_powinno_zwracac_id(){

        assertEquals(13,k.getId());
    }
    @Test
    public void getNazwa_powinno_zwracac_nazwe(){
        assertEquals("Abradab",k.getNazwa());
    }
    @Test
    public void getCena_powinno_zwraca_cene(){
        assertEquals(12.3,k.getCena());
    }
}
