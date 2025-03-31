package br.com.daviAlves22.Aprendendo_spring_boot_e_java.controllers;

import br.com.daviAlves22.Aprendendo_spring_boot_e_java.services.PersonServices;
import br.com.daviAlves22.Aprendendo_spring_boot_e_java.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    //listar todos os que estão cadastrados no sistema
    //com isso podemos chamar o endPoint através do brownser

    //tipo GET
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)

    public List<Person> findAll() {
        return service.findAll();
    }

    // private PersonServices service = new PersonServices();
    //aqui somente um cliente buscando pelo id dele;
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    //colocado o tipo POST
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    //parametro criado atraves do body do postman e retornado
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    //colocado o tipo UPDATE
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    //parametro criado atraves do body do postman e retornado
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }

    //colocado o tipo DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}