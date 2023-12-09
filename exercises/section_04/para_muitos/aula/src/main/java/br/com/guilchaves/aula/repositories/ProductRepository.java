package br.com.guilchaves.aula.repositories;

import br.com.guilchaves.aula.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
