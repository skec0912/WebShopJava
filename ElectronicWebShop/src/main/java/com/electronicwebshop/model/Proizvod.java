package com.electronicwebshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proizvod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String proizvodId;
    private String nazivProizvoda;
    private String kategorijaProizvoda;
    private String opisProizvoda;
    private double cijena;
    private String stanjeProizvoda;
    private String statusProizvoda;
    private int proizvodaNaSkladistu;
    private String proizvodac;


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
