package com.electronicwebshop.controller;

import com.electronicwebshop.dal.ProizvodDal;
import com.electronicwebshop.model.Proizvod;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class HomeController {

    private Path path;

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
    public String dohvatiProizvod(@PathVariable String proizvodId, Model model) throws IOException {
        Proizvod proizvod = proizvodDal.getProizvodById(proizvodId);
        model.addAttribute(proizvod);

        return "detaljiProizvoda";
    }

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/admin/popisProizvoda")
    public String popisProizvoda(Model model) {
        List<Proizvod> proizvodi = proizvodDal.getAllProizvod();
        model.addAttribute("proizvodi", proizvodi);
        return "popisProizvoda";
    }

    @RequestMapping("/admin/popisProizvoda/dodajProizvod")
    public String dodajProizvod(Model model) {
        Proizvod proizvod = new Proizvod();
        proizvod.setKategorijaProizvoda("Mobiteli");
        proizvod.setStanjeProizvoda("Novo");
        proizvod.setStatusProizvoda("Active");

        model.addAttribute("proizvod", proizvod);
        return "dodajProizvod";
    }

    @RequestMapping(value = "/admin/popisProizvoda/dodajProizvod", method = RequestMethod.POST)
    public String dodajProizvodPost(@ModelAttribute("proizvod") Proizvod proizvod, HttpServletRequest request) {
        proizvodDal.addProizvod(proizvod);

        MultipartFile slikaProizvoda = proizvod.getSlika();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\slike\\" + proizvod.getProizvodId() + ".png");

        if (slikaProizvoda != null && !slikaProizvoda.isEmpty()) {
            try {
                slikaProizvoda.transferTo(new File(path.toString()));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Neuspješan unos slike, pokušajte ponovo.", e);
            }

        }
        return "redirect:/admin/popisProizvoda";
    }

    @RequestMapping("/admin/popisProizvoda/deleteProizvod/{id}")
    public String deleteProizvod(@PathVariable String id, Model model, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\slike\\" + id + ".png");

        if(Files.exists(path)){
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        proizvodDal.deleteProizvod(id);

        return "redirect:/admin/popisProizvoda";
    }

    @RequestMapping("/admin/popisProizvoda/editProizvod/{id}")
    public String editProizvod(@PathVariable String id, Model model) {
        Proizvod proizvod = proizvodDal.getProizvodById(id);

        model.addAttribute(proizvod);

        return "editProizvod";
    }


    @RequestMapping(value = "/admin/popisProizvoda/editProizvod", method = RequestMethod.POST)
    public String editProizvod(@PathVariable ("proizvod") Proizvod proizvod, Model model, HttpServletRequest request) {

        MultipartFile slikaProizvoda = proizvod.getSlika();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\slike\\" + proizvod.getProizvodId() + ".png");

        if(slikaProizvoda != null && !slikaProizvoda.isEmpty()){
            try {
                slikaProizvoda.transferTo(new File(path.toString()));
            }catch (Exception e){
                throw new RuntimeException("Neuspješan unos slike, pokušajte ponovo.", e);
            }
        }

        proizvodDal.editProizvod(proizvod);
        return "redirect:/admin/popisProizvoda";
    }
}
