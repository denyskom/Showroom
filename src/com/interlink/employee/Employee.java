package com.interlink.employee;

import com.interlink.salary.SalaryType;

import java.time.LocalDate;
import java.util.Optional;

public abstract class Employee {
    protected final int id;
    protected String fullName;
    protected SalaryType salaryType;
    protected String post;
    protected LocalDate startDate;
    protected LocalDate endDate;

    public Employee(int id, String fullName, SalaryType salaryType) {
        this.id = id;
        this.fullName = fullName;
        this.salaryType = salaryType;
    }

    public String getFullName() {
        return fullName;
    }

    public SalaryType getSalaryType() {
        return salaryType;
    }

    public int getEmployeeId() {
        return id;
    }

    public String getPost() {
        return post;
    }

    protected void setPost(String post) {
        this.post = post;
    }


    protected LocalDate getStartDate() {
        return startDate;
    }

    protected Optional<LocalDate> getEndDate() {
        return Optional.ofNullable(endDate);
    }

    protected Employee employeeValue() {
        return this;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", salaryType=" + salaryType +
                '}';
    }
}
