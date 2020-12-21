package com.md.demo.controller;


import com.md.demo.crud.iUserCrud;
import com.md.demo.crud.iZipcodeCrud;
import com.md.demo.model.User;
import com.md.demo.model.Zipcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {


    @Autowired
    RestTemplate restTemplate;
    @Autowired
    iUserCrud iuserCrud;
    @Autowired
    iZipcodeCrud IzipcodeCrud;

    @PostMapping("/registerUser")
    public ResponseEntity<Zipcode> gettest(@RequestParam(name = "fullName") String fullName,
                                           @RequestParam(name = "adress") String adress,
                                           @RequestParam(name = "postcode") int zipcode,
                                           @RequestParam(name = "email") String email,
                                           @RequestParam(name = "driversLicens") String driversLicens) {

        Zipcode postcode = restTemplate.getForObject("Http://zipcode/getCity?zipcode=" + zipcode, Zipcode.class);

        if (postcode != null) {
            saveZipcode(postcode);
            saveUser(new User(fullName, adress, email, driversLicens, postcode));
        }
        return new ResponseEntity<Zipcode>(postcode, HttpStatus.OK);
    }
    public void saveUser(User user) {
        iuserCrud.save(user);
    }


    public void saveZipcode(Zipcode zipcode) {
        IzipcodeCrud.save(zipcode);
    }


}
