package com.electronicwebshop.dal;

import com.electronicwebshop.model.Proizvod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProizvodDal {

    private List<Proizvod> listaProizvoda;

    public List<Proizvod> getListuProizvoda() {
        Proizvod proizvod1 = new Proizvod();

        proizvod1.setProizvodId("1");
        proizvod1.setNazivProizvoda("Samsung Galaxy S6");
        proizvod1.setKategorijaProizvoda("Mobiteli");
        proizvod1.setOpisProizvoda("Popularni proizvođač mobitela napravio je još jedan odličan primjerak pametnog telefona Samsung Galaxy S6");
        proizvod1.setCijena(2700);
        proizvod1.setStanjeProizvoda("New");
        proizvod1.setStatusProizvoda("Active");
        proizvod1.setProizvodaNaSkladistu(11);
        proizvod1.setProizvodac("Samsung");

        Proizvod proizvod2 = new Proizvod();

        proizvod2.setProizvodId("2");
        proizvod2.setNazivProizvoda("Televizor LG");
        proizvod2.setKategorijaProizvoda("Televizori");
        proizvod2.setOpisProizvoda("Najnoviji televizor marke LG");
        proizvod2.setCijena(4600);
        proizvod2.setStanjeProizvoda("New");
        proizvod2.setStatusProizvoda("Active");
        proizvod2.setProizvodaNaSkladistu(17);
        proizvod2.setProizvodac("LG");

        Proizvod proizvod3 = new Proizvod();

        proizvod3.setProizvodId("3");
        proizvod3.setNazivProizvoda("DELL monitor 24");
        proizvod3.setKategorijaProizvoda("Monitori");
        proizvod3.setOpisProizvoda("Najbolji monitor tvrtke DELL");
        proizvod3.setCijena(2000);
        proizvod3.setStanjeProizvoda("New");
        proizvod3.setStatusProizvoda("Active");
        proizvod3.setProizvodaNaSkladistu(31);
        proizvod3.setProizvodac("DELL");

        listaProizvoda = new ArrayList<Proizvod>();
        listaProizvoda.add(proizvod1);
        listaProizvoda.add(proizvod2);
        listaProizvoda.add(proizvod3);

        return listaProizvoda;
    }

    public Proizvod getProizvodById(String proizvodId) throws IOException {
        for (Proizvod proizvod : getListuProizvoda()) {
            if (proizvod.getProizvodId().equals(proizvodId)) {
                return proizvod;
            }
        }
        throw new IOException("Ne postoji proizvod sa zadanim ID-em");

    }
}
