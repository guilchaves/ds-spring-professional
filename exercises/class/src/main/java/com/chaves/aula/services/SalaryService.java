package com.chaves.aula.services;

import com.chaves.aula.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    @Autowired
    private TaxService taxService;
    @Autowired
    private PensionService pensionService;

    public double netSalary(Employee employee) {
        double taxDiscount = taxService.tax(employee.getGrossSalary());
        double pensionDiscount = pensionService.discount(employee.getGrossSalary());
        double grossSalary = employee.getGrossSalary();

        return grossSalary - taxDiscount - pensionDiscount;
    }


}
