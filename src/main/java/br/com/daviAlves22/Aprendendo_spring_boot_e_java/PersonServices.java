package br.com.daviAlves22.Aprendendo_spring_boot_e_java;

import br.com.daviAlves22.Aprendendo_spring_boot_e_java.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    //listando todos os clientes
    public List<Person> findAll() {
        logger.info("Buscando todos os CLientes.");
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }


    //listando o cliente pelo id
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

    //criando um novo cliente
    public Person create(Person person) {
        logger.info("Cliente criado com Sucesso!");
        return person;
    }

    //Deletando um cliente
    public void delete(String id) {
        logger.info("Cliente deletado com Sucesso!");
    }

    //atualizando os dados do cliente
    public Person update(Person person) {
        logger.info("Dados do cliente atualizados com Sucesso!");
        return person;
    }


    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Primeiro Nome:" + i);
        person.setLastName("Último Nome:" + i);
        person.setAddress("Nacionalidade: Brasileiro!");
        person.setGender("Sexo: Masculino");

        return person;
    }
}