package com.ecosoft.customer.customers.controller;

import com.ecosoft.customer.customers.configurations.AppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

    @Autowired
    private AppConfiguration appConfiguration;

    @GetMapping("/hola")
    public String saludo(){

        System.out.println(appConfiguration.toString());
        return "Hola mundo";
    }
}
