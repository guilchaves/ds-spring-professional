package br.com.guilchaves.aula.repositories;

import br.com.guilchaves.aula.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
