package com.chaves.aula.entities;

public class Employee {
    private String name;
    private double grossSalary;

    public Employee(String name, double grossSalary) {
        this.name = name;
        this.grossSalary = grossSalary;
    }

    public String getName() {
        return name;
    }

    public double getGrossSalary() {
        return grossSalary;
    }
}
