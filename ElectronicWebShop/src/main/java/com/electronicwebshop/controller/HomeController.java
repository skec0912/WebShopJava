package com.electronicwebshop.controller;

import com.electronicwebshop.dal.ProizvodDal;
import com.electronicwebshop.model.Proizvod;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
    public String dohvatiProizvod(@PathVariable String proizvodId, Model model) {
        Proizvod proizvod = proizvodDal.getProizvodById(proizvodId);
        model.addAttribute(proizvod);

        return "detaljiProizvoda";
    }


}
