package com.example.demo.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "produse")
public class produse implements Serializable {
    @Id
    private Long id;
    public String nume;
    public Long pretinceput;
    public Long pretfinal;
    public String imagine;
    public String descriere;
    public String licitator;
    public String timp;
    public String timpexpirare;

public produse()
{

}
public produse(Long id, String nume, Long pretinceput, Long pretfinal, String imagine, String descriere,
               String licitator, String timp, String timpexpirare)
{
    this.id=id;
    this.nume=nume;
    this.pretinceput=pretinceput;
    this.pretfinal = pretfinal;
    this.imagine = imagine;
    this.descriere = descriere;
    this.licitator = licitator;
    this.timp = timp;
    this.timpexpirare = timpexpirare;
}
    public void SetId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Long getPretinceput() {
        return pretinceput;
    }

    public void setPretinceput(Long pretinceput) {
        this.pretinceput = pretinceput;
    }

    public Long getPretfinal() {
        return pretfinal;
    }

    public void setPretfinal(Long pretfinal) {
        this.pretfinal = pretfinal;
    }

    public String getImagine() {
        return imagine;
    }

    public void setImagine(String imagine) {
        this.imagine = imagine;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getLicitator() {
        return licitator;
    }

    public void setLicitator(String licitator) {
        this.licitator = licitator;
    }

    public String getTimp() {
        return timp;
    }

    public void setTimp(String timp) {
        this.timp = timp;
    }

    public String getTimpexpirare() {
        return timpexpirare;
    }

    public void setTimpexpirare(String timpexpirare) {
        this.timpexpirare = timpexpirare;
    }
}
