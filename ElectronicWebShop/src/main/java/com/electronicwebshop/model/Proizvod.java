package com.electronicwebshop.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class Proizvod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String proizvodId;

    @NotEmpty (message = "Naziv proizvoda je obavezno polje!")
    private String nazivProizvoda;

    private String kategorijaProizvoda;
    private String opisProizvoda;

    @Min(value=0, message = "Cijena mora biti veća od 0!")
    private double cijena;
    private String stanjeProizvoda;
    private String statusProizvoda;

    @Min(value=0, message = "Kolicina mora biti veća od 0!")
    private int proizvodaNaSkladistu;
    private String proizvodac;

    @Transient
    private MultipartFile slika;

    public MultipartFile getSlika() {
        return slika;
    }

    public void setSlika(MultipartFile slika) {
        this.slika = slika;
    }

    public String getProizvodId() {
        return proizvodId;
    }

    public void setProizvodId(String productId) {
        this.proizvodId = productId;
    }

    public String getNazivProizvoda() {
        return nazivProizvoda;
    }

    public void setNazivProizvoda(String nazivProizvoda) {
        this.nazivProizvoda = nazivProizvoda;
    }

    public String getKategorijaProizvoda() {
        return kategorijaProizvoda;
    }

    public void setKategorijaProizvoda(String kategorijaProizvoda) {
        this.kategorijaProizvoda = kategorijaProizvoda;
    }

    public String getOpisProizvoda() {
        return opisProizvoda;
    }

    public void setOpisProizvoda(String opisProizvoda) {
        this.opisProizvoda = opisProizvoda;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public String getStanjeProizvoda() {
        return stanjeProizvoda;
    }

    public void setStanjeProizvoda(String stanjeProizvoda) {
        this.stanjeProizvoda = stanjeProizvoda;
    }

    public String getStatusProizvoda() {
        return statusProizvoda;
    }

    public void setStatusProizvoda(String statusProizvoda) {
        this.statusProizvoda = statusProizvoda;
    }

    public int getProizvodaNaSkladistu() {
        return proizvodaNaSkladistu;
    }

    public void setProizvodaNaSkladistu(int proizvodaNaSkladistu) {
        this.proizvodaNaSkladistu = proizvodaNaSkladistu;
    }

    public String getProizvodac() {
        return proizvodac;
    }

    public void setProizvodac(String proizvodac) {
        this.proizvodac = proizvodac;
    }
}
