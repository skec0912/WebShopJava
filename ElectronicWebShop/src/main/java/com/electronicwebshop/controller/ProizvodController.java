package com.electronicwebshop.controller;

import com.electronicwebshop.model.Proizvod;
import com.electronicwebshop.service.ProizvodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/proizvod")
public class ProizvodController {

    @Autowired
    private ProizvodService proizvodService;

    @RequestMapping("/listaProizvoda")
    public String getProducts(Model model) {
        List<Proizvod> proizvodi = proizvodService.getProizvodList();
        model.addAttribute("proizvodi", proizvodi);

        return "listaProizvoda";
    }
}
