package br.com.daviAlves22.Aprendendo_spring_boot_e_java.services;

import br.com.daviAlves22.Aprendendo_spring_boot_e_java.exception.ResourceNotFoundException;
import br.com.daviAlves22.Aprendendo_spring_boot_e_java.model.Person;
import br.com.daviAlves22.Aprendendo_spring_boot_e_java.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonRepository repository;

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    //listando todos os clientes
    public List<Person> findAll() {
        logger.info("Usuários Encontrados com Sucesso! :");
        return repository.findAll();
    }


    //listando o cliente pelo id
    public Person findById(Long id) {
        logger.info("Finding one Person!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id Não Localizado!"));
    }

    //criando um novo cliente
    public Person create(Person person) {
        logger.info("Cliente criado com Sucesso!");
        return repository.save(person);//salva e volta para o controller
    }

    //Deletando um cliente
    public void delete(Long id) {
        logger.info("Cliente deletado com Sucesso!");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id Não Localizado!"));
        repository.delete(entity);
    }

    //atualizando os dados do cliente
    public Person update(Person person) {
        logger.info("Dados do cliente atualizados com Sucesso!");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Id Não Localizado!"));

        //pegando a entidade para atualizar os dados do cliente
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }


}