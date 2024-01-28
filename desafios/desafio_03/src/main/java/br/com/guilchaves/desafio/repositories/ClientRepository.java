package br.com.guilchaves.desafio.repositories;

import br.com.guilchaves.desafio.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
