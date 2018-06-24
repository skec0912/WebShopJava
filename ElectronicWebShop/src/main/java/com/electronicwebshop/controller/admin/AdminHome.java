package com.electronicwebshop.controller.admin;

import com.electronicwebshop.model.Proizvod;
import com.electronicwebshop.service.ProizvodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminHome {
    @Autowired
    private ProizvodService proizvodService;

    @RequestMapping
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/popisProizvoda")
    public String popisProizvoda(Model model) {
        List<Proizvod> proizvodi = proizvodService.getProizvodList();
        model.addAttribute("proizvodi", proizvodi);
        return "popisProizvoda";
    }

    @RequestMapping("/customer")
    public String customerManagement(Model model){
        return "customerManagement";
    }
}

