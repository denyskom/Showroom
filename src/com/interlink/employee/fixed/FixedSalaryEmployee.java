package com.interlink.employee.fixed;

import com.interlink.employee.Employee;
import com.interlink.salary.SalaryType;

import java.time.LocalDate;
import java.util.Optional;

public class FixedSalaryEmployee extends Employee implements FixedSalary {
    private double salary;
    private LocalDate startDate;
    private Optional<LocalDate> endDate;
    public FixedSalaryEmployee(int id, String fullName, double salary) {
        super(id, fullName, SalaryType.FIXED);
        this.salary = salary;
        this.startDate = LocalDate.now().plusMonths(1).withDayOfMonth(1);
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

    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public Optional<LocalDate> getEndDate() {
        return endDate;
    }
}
