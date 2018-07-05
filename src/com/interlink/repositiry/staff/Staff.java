package com.interlink.repositiry.staff;

import com.interlink.employee.Employee;

import java.util.List;

public interface Staff {

    List<Employee> getStuff();

    void hire(int EmployeeId);

    void fire(int EmployeeId);
}
