package br.com.daviAlves22.Aprendendo_spring_boot_e_java.controllers;

import br.com.daviAlves22.Aprendendo_spring_boot_e_java.PersonServices;
import br.com.daviAlves22.Aprendendo_spring_boot_e_java.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;
    // private PersonServices service = new PersonServices();

    //com isso podemos chamar o endPoint através do brownser
    @RequestMapping(value = "/{id}",
    method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person findById(@PathVariable ("id") String id){
        return service.findById(id);
    }
}