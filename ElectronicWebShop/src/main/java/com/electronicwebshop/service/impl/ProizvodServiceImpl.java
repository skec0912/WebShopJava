package com.electronicwebshop.service.impl;

import com.electronicwebshop.dal.ProizvodDal;
import com.electronicwebshop.model.Proizvod;
import com.electronicwebshop.service.ProizvodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProizvodServiceImpl implements ProizvodService {

    @Autowired
    private ProizvodDal proizvodDal;

    public Proizvod getProizvodById(int proizvodId) {
        return proizvodDal.getProizvodById(proizvodId);
    }

    @Override
    public void addProizvod(Proizvod proizvod) {
        proizvodDal.addProizvod(proizvod);
    }

    @Override
    public void editProizvod(Proizvod proizvod) {
        proizvodDal.editProizvod(proizvod);
    }

    @Override
    public void deleteProizvod(Proizvod proizvod) {
        proizvodDal.deleteProizvod(proizvod);
    }

    public List<Proizvod> getProizvodList() {
        return proizvodDal.getProizvodList();
    }


}
