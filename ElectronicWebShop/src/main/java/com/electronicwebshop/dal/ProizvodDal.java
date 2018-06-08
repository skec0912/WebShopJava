package com.electronicwebshop.dal;

import com.electronicwebshop.model.Proizvod;

import java.util.List;

public interface ProizvodDal {
    void addProizvod(Proizvod proizvod);
    void editProizvod(Proizvod proizvod);
    Proizvod getProizvodById(String proizvodId);
    List<Proizvod> getAllProizvod();
    void deleteProizvod(String id);
}
