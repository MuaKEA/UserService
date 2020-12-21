package com.md.demo.model;


import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String fullName;
    private String adress;
    private String email;
    private String driversLicens;
    @OneToOne
    private Zipcode zipcode;


    public User() {
    }


    public User(String fullName, String adress, String email, String driversLicens, Zipcode zipcode) {
        this.fullName = fullName;
        this.adress = adress;
        this.email = email;
        this.driversLicens = driversLicens;
        this.zipcode = zipcode;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Zipcode getZipcode() {
        return zipcode;
    }

    public void setZipcode(Zipcode zipcode) {
        this.zipcode = zipcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDriversLicens() {
        return driversLicens;
    }

    public void setDriversLicens(String driversLicens) {
        this.driversLicens = driversLicens;
    }
}
