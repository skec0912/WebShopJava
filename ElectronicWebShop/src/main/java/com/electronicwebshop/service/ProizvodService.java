package com.electronicwebshop.service;

import com.electronicwebshop.model.Proizvod;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProizvodService {
    List<Proizvod> getProizvodList();
    Proizvod getProizvodById(int id);
    void addProizvod(Proizvod proizvod);
    void editProizvod(Proizvod proizvod);
    void deleteProizvod(Proizvod proizvod);
}
