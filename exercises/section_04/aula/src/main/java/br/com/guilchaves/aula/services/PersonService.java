package br.com.guilchaves.aula.services;

import br.com.guilchaves.aula.dto.PersonDepartmentDTO;
import br.com.guilchaves.aula.entities.Department;
import br.com.guilchaves.aula.entities.Person;
import br.com.guilchaves.aula.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public PersonDepartmentDTO insert(PersonDepartmentDTO dto){
        Person entity = new Person();
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        Department department = new Department();
        department.setId(dto.getDepartment().getId());

        entity.setDepartment(department);

        entity = repository.save(entity);
        return new PersonDepartmentDTO(entity);
    }


}
