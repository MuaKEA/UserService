package com.md.demo.controller;


import com.md.demo.crud.iUserCrud;
import com.md.demo.model.User;
import com.md.demo.model.Zipcode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {


    @Autowired
    RestTemplate restTemplate;
    @Autowired
    iUserCrud iuserCrud;

    @GetMapping("/registerUser")
    public ResponseEntity<Zipcode> gettest(@RequestParam(name = "fullName") String fullName,
                                           @RequestParam(name = "adress") String adress,
                                           @RequestParam(name = "postcode") String postcode){

        Zipcode zipcode = restTemplate.getForObject("http://zipcode/getCity?zipcode="+ postcode ,Zipcode.class);


        User user =  new User(fullName,adress,zipcode);
            iuserCrud.save(user);


        return  new ResponseEntity<Zipcode>(zipcode,HttpStatus.OK);
    }


}
