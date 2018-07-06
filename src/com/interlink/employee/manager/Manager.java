package com.interlink.employee.manager;

import com.interlink.employee.Employee;
import com.interlink.salary.SalaryType;

public class Manager extends Employee implements Salesman {
    public Manager(int id, String fullName) {
        super(id, fullName, SalaryType.PERCENTAGE);
        super.post = "Manager";
    }

    @Override
    public int getSalesmanId() {
        return getEmployeeId();
    }

    @Override
    public Employee employeeValue() {
        return super.employeeValue();
    }
}
