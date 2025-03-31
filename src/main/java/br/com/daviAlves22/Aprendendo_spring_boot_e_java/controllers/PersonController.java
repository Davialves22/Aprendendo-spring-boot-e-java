package br.com.daviAlves22.Aprendendo_spring_boot_e_java.controllers;

import br.com.daviAlves22.Aprendendo_spring_boot_e_java.services.PersonServices;
import br.com.daviAlves22.Aprendendo_spring_boot_e_java.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    //listar todos os que estão cadastrados no sistema
    //com isso podemos chamar o endPoint através do brownser
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> findAll() {
        return service.findAll();
    }

    // private PersonServices service = new PersonServices();
    //aqui somente um cliente buscando pelo id dele
    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    //colocado o tipo POST
    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    //parametro criado atraves do body do postman e retornado
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    //colocado o tipo DELETE
    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE
    )
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    //colocado o tipo UPDATE
    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    //parametro criado atraves do body do postman e retornado
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }
}