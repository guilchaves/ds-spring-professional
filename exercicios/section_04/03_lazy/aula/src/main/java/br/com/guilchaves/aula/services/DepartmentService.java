package br.com.guilchaves.aula.services;

import br.com.guilchaves.aula.dto.DepartmentDTO;
import br.com.guilchaves.aula.dto.EmployeeMinDTO;
import br.com.guilchaves.aula.entities.Department;
import br.com.guilchaves.aula.entities.Employee;
import br.com.guilchaves.aula.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Transactional(readOnly = true)
    public DepartmentDTO findById(Long id) {
        Optional<Department> result = repository.findById(id);
        return new DepartmentDTO(result.get());
    }

    @Transactional(readOnly = true)
    public List<EmployeeMinDTO> findEmployeesByDepartment(Long id) {
        Optional<Department> result = repository.findById(id);
        List<Employee> list = result.get().getEmployees();
        return list.stream().map(x -> new EmployeeMinDTO(x)).toList();
    }
}