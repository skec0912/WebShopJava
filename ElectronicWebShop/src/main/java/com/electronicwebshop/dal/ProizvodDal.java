package com.electronicwebshop.dal;

import com.electronicwebshop.model.Proizvod;

import java.util.ArrayList;
import java.util.List;

public class ProizvodDal {

    private List<Proizvod> listaProizvoda;

    public List<Proizvod> dohvatiListuProizvoda() {
        Proizvod proizvod1 = new Proizvod();

        proizvod1.setNazivProizvoda("Samsung Galaxy S6");
        proizvod1.setKategorijaProizvoda("Mobiteli");
        proizvod1.setOpisProizvoda("Popularni proizvođač mobitela napravio je još jedan odličan primjerak pametnog telefona Samsung Galaxy S6");
        proizvod1.setCijena(2700);
        proizvod1.setStanjeProizvoda("New");
        proizvod1.setStatusProizvoda("Active");
        proizvod1.setProizvodaNaSkladistu(11);
        proizvod1.setProizvodac("Samsung");

        listaProizvoda = new ArrayList<Proizvod>();
        listaProizvoda.add(proizvod1);

        return listaProizvoda;
    }
}
