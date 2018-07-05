package com.interlink.employee.fixed;

import com.interlink.employee.Employee;
import com.interlink.salary.SalaryType;

public class FixedSalaryEmployee extends Employee implements FixedSalary {
    private double salary;
    public FixedSalaryEmployee(int id, String fullName, double salary) {
        super(id, fullName, SalaryType.FIXED);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void setPost(String post) {
        super.setPost(post);
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
