package com.md.demo.model;

import javax.persistence.*;

@Entity
public class Zipcode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private int nr;
    private String navn;


    public Zipcode() {
    }

    public Zipcode(Long id, int nr, String navn) {
        this.Id = id;
        this.nr = nr;
        this.navn = navn;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

}