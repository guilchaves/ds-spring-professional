package br.com.guilchaves.aula.repositories;

import br.com.guilchaves.aula.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
