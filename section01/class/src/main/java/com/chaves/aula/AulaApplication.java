package com.chaves.aula;

import com.chaves.aula.entities.Employee;
import com.chaves.aula.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class AulaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AulaApplication.class, args);
    }

    @Autowired
    private SalaryService salaryService;

    @Override
    public void run(String... args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Employee employee = new Employee("Maria", 4000.0);
        System.out.println("\nNet salary: " + String.format("%.2f", salaryService.netSalary(employee)));

        sc.close();
    }
}
