package com.ecosoft.customer.customers.controller;

import com.ecosoft.customer.customers.configurations.AppConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HolaMundoController {
   // private Logger log = LoggerFactory.getLogger(HolaMundoController.class);

    @Autowired
    private AppConfiguration appConfiguration;

    @GetMapping("/hola/{name}")
    public String saludo(@PathVariable String name){
        //Esto es para el manejo de appender  SIFT
        MDC.put("userid", name);

        for (int i = 0; i < 1000; i++) {
            log.trace("Ejeutando en modo TRACE");
            log.debug("Ejeutando en modo DEBUG");
            log.info("Ejeutando en modo INFO");
            log.warn("Ejeutando en modo WARN");
            log.error("Ejeutando en modo ERROR");
        }

        System.out.println(appConfiguration.toString());
        return "Hola mundo";
    }
}
