package br.com.guilchaves.aula.repositories;

import br.com.guilchaves.aula.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
