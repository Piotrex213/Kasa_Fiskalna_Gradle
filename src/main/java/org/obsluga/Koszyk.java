package org.obsluga;

import java.io.*;
import java.util.ArrayList;

public class Koszyk  {
    private ArrayList<Produkt> produkty;

    public Koszyk(){

        produkty = new ArrayList<Produkt>();
        otwarcieProduktowZPliku();
    }

    public void dodajPrzedmiotDoKoszyka(int i, String nazwa, double cena){
        Produkt p = new Produkt(i,nazwa,cena);
        produkty.add(p);
    }

    public int getDlugoscKoszyka(){
        return produkty.size();
    }

    public double getWartoscPrzedmiotu(int id,int iloscSztuk){
        double w = 0;
        for(int i = 0;i<getDlugoscKoszyka();i++){
            if(produkty.get(i).getId()==id){
                w = produkty.get(i).getCena()*iloscSztuk;
                break;
            }
        }
        return w;
    }

    public String getNazwaPrzedmiotu(int id){
        String w = "";
        for(int i = 0;i<getDlugoscKoszyka();i++){
            if(produkty.get(i).getId()==id){
                w = produkty.get(i).getNazwa();
                break;
            }
        }
        return w;

    }

    public boolean czyIstniejeProduktODanymId(int a){
        boolean p=false;
        for (Produkt produkt : produkty) {
            if (produkt.getId() == a) {
                p = true;
                break;
            }
        }
        return p;
    }

    public void zapisProduktowDoPliku(){
        try{
            FileOutputStream f = new FileOutputStream("baza.txt");
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(produkty);
            o.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void otwarcieProduktowZPliku(){
        try {
            FileInputStream f = new FileInputStream("baza.txt");
            ObjectInputStream o = new ObjectInputStream(f);
            produkty = (ArrayList<Produkt>) o.readObject();
            o.close();
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    public String wyswietlBaze(int i){
        return "Id : " + produkty.get(i).getId()+
                " Nazwa : "+ produkty.get(i).getNazwa()+
                " Cena : "+ produkty.get(i).getCena()+"\n";
    }
}
