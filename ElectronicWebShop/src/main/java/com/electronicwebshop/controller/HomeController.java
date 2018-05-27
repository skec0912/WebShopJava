package com.electronicwebshop.controller;

import com.electronicwebshop.dal.ProizvodDal;
import com.electronicwebshop.model.Proizvod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    private ProizvodDal proizvodDal = new ProizvodDal();

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/listaProizvoda")
    public String dohvatiProizvode(Model model){
        List<Proizvod> listaProizvoda = proizvodDal.dohvatiListuProizvoda();
        Proizvod proizvod = listaProizvoda.get(0);
        model.addAttribute(proizvod);

        return "listaProizvoda";
    }
}
