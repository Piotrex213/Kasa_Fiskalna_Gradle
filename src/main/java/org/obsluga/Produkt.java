package org.obsluga;

import java.io.Serializable;

public class Produkt implements Serializable {
    private final int id;
    private final String nazwa;
    private final double cena;

    public Produkt(int id, String nazwa, double cena){
        this.id=id;
        this.nazwa=nazwa;
        this.cena=cena;
    }

    public int getId(){
        return id;
    }
    public String getNazwa(){
        return nazwa;
    }
    public double getCena(){
        return cena;
    }

}
