package com.interlink.salary;

import com.interlink.employee.Employee;

public class Salary {
    private final Employee employee;
    private double salary;

    public Salary(Employee employee, double salary) {
        this.employee = employee;
        if(salary < 0) {
            salary = 0;
        }
        this.salary = salary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public double getSalary() {
        return salary;
    }

    public void addBonus(double bonus) {
        salary += bonus;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "employee=" + employee.getFullName() +
                ", salary=" + salary +
                '}';
    }
}
