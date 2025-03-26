package br.com.daviAlves22.Aprendendo_spring_boot_e_java;

import br.com.daviAlves22.Aprendendo_spring_boot_e_java.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {
        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Davi");
        person.setLastName("Alves");
        person.setAddress("Cavaleiro - Jaboatão");
        person.setGender("Masculino");

        return person;
    }
}