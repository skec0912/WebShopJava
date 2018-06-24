package com.electronicwebshop.dal;

import com.electronicwebshop.model.Proizvod;

import java.util.List;

public interface ProizvodDal {
    List<Proizvod> getProizvodList();
    Proizvod getProizvodById(int id);
    void addProizvod(Proizvod proizvod);
    void editProizvod(Proizvod proizvod);
    void deleteProizvod(Proizvod proizvod);
}
