package br.com.guilchaves.aula.services;

import br.com.guilchaves.aula.dto.PersonDTO;
import br.com.guilchaves.aula.dto.PersonDepartmentDTO;
import br.com.guilchaves.aula.entities.Department;
import br.com.guilchaves.aula.entities.Person;
import br.com.guilchaves.aula.repositories.DepartmentRepository;
import br.com.guilchaves.aula.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {
        Person entity = new Person();
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        Department department = departmentRepository.getReferenceById(dto.getDepartment().getId());

        //Department dept = new Department();
        //dept.setId(dto.getDepartment().getId());

        entity.setDepartment(department);
        entity = personRepository.save(entity);
        return new PersonDepartmentDTO(entity);
    }

    public PersonDTO insert(PersonDTO dto) {
        Person entity = new Person();
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        Department department = departmentRepository.getReferenceById(dto.getDepartmentId());

        entity.setDepartment(department);
        entity = personRepository.save(entity);

        return new PersonDTO(entity);
    }


}
