package com.interlink.salary;

public enum SalaryRange {
    ACCOUNTANT(6000),
    HANDYMAN(5000),
    ADMINISTRATOR(8000),
    PERCENTAGE;

    private int salary;
    SalaryRange() {}

    SalaryRange(int salary) {
        this.salary = salary;
    }
}
