package com.electronicwebshop.controller;

import com.electronicwebshop.dal.ProizvodDal;
import com.electronicwebshop.model.Proizvod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProizvodDal proizvodDal;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/listaProizvoda")
    public String dohvatiProizvode(Model model) {

        List<Proizvod> proizvodi = proizvodDal.getAllProizvod();
        model.addAttribute("proizvodi", proizvodi);

        return "listaProizvoda"; //naziv viewa koji se poziva
    }

    @RequestMapping("/listaProizvoda/proizvod/{proizvodId}")
    public String dohvatiProizvod(@PathVariable String proizvodId, Model model) {
        Proizvod proizvod = proizvodDal.getProizvodById(proizvodId);
        model.addAttribute(proizvod);

        return "detaljiProizvoda";
    }
}
