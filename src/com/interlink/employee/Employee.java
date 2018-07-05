package com.interlink.employee;

import com.interlink.salary.SalaryRange;

public class Employee {
    private String fullName;
    private SalaryRange salaryRange;

    protected Employee(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public SalaryRange getSalaryRange() {
        return salaryRange;
    }

}
