package com.interlink.employee;

import com.interlink.salary.SalaryType;

public abstract class Employee {
    protected String fullName;
    protected SalaryType salaryType;

    protected Employee(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public SalaryType getSalaryType() {
        return salaryType;
    }

}
