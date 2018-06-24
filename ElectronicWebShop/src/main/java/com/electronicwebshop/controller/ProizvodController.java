package com.electronicwebshop.controller;

import com.electronicwebshop.model.Proizvod;
import com.electronicwebshop.service.ProizvodService;
import org.apache.commons.io.IOExceptionWithCause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
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

    @RequestMapping("/detaljiProizvoda/{proizvodId}")
    public String detaljiProizvoda(@PathVariable int proizvodId, Model model) throws IOException {

        Proizvod proizvod = proizvodService.getProizvodById(proizvodId);
        model.addAttribute("proizvod",proizvod);

        return "detaljiProizvoda";
    }
}
