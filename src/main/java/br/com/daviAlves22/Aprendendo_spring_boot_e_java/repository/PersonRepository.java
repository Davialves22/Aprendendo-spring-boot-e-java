package br.com.daviAlves22.Aprendendo_spring_boot_e_java.repository;

import br.com.daviAlves22.Aprendendo_spring_boot_e_java.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

//para ter acesso ao crud
//passa dois parametos,o tipo e o id
public interface PersonRepository extends JpaRepository<Person, Long> {}