package com.electronicwebshop.controller.admin;

import com.electronicwebshop.model.Proizvod;
import com.electronicwebshop.service.ProizvodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/admin")
public class AdminProizvod {
    private Path path;

    @Autowired
    private ProizvodService proizvodService;

    @RequestMapping("/proizvod/addProizvod")
    public String addProizvod(Model model) {
        Proizvod proizvod = new Proizvod();

        proizvod.setKategorijaProizvoda("Televizori");
        proizvod.setStatusProizvoda("Active");
        proizvod.setStanjeProizvoda("New");

        model.addAttribute("proizvod", proizvod);

        return "dodajProizvod";
    }

    @RequestMapping(value = "/proizvod/addProizvod",method = RequestMethod.POST)
    public String addProizvodPost(@Valid @ModelAttribute("proizvod")Proizvod proizvod, BindingResult result, HttpServletRequest request){
        if(result.hasErrors()){
            return "dodajProizvod";
        }
        proizvodService.addProizvod(proizvod);

        MultipartFile slika = proizvod.getSlika();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\slike\\" + proizvod.getProizvodId() +".png");
        if(slika != null && !slika.isEmpty()){
            try {
                slika.transferTo(new File(path.toString()));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }
        return "redirect:/admin/popisProizvoda";
    }

    @RequestMapping("/proizvod/editProizvod/{id}")
    public String editProizvod(@PathVariable("id")int id, Model model) {
        Proizvod proizvod = proizvodService.getProizvodById(id);

        model.addAttribute("proizvod", proizvod);

        return "editProizvod";
    }

    @RequestMapping(value = "/proizvod/editProizvod",method = RequestMethod.POST)
    public String editProizvodPost(@Valid @ModelAttribute("proizvod")Proizvod proizvod, BindingResult result, HttpServletRequest request){
        if(result.hasErrors()){
            return "editProizvod";
        }

        MultipartFile slika = proizvod.getSlika();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\slike\\" + proizvod.getProizvodId() +".png");
        if(slika != null && !slika.isEmpty()){
            try {
                slika.transferTo(new File(path.toString()));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }

        proizvodService.editProizvod(proizvod);
        return "redirect:/admin/popisProizvoda";
    }

    @RequestMapping("/proizvod/deleteProizvod/{id}")
    public String deleteProizvod(@PathVariable("id")int id, Model model, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\slike\\" + id +".png");

        if(Files.exists(path)){
            try {
                Files.delete(path);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        Proizvod proizvod = proizvodService.getProizvodById(id);
        proizvodService.deleteProizvod(proizvod);

        return "redirect:/admin/popisProizvoda";
    }
}
