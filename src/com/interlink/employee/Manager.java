package com.interlink.employee;

import com.interlink.salary.SalaryType;

public class Manager extends Employee {

    public Manager(String fullName) {
        super(fullName);
        salaryType = SalaryType.PERCENTAGE;
    }
}
