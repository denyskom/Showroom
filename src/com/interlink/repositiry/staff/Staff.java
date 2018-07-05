package com.interlink.repositiry.staff;

import com.interlink.employee.Employee;

import java.util.List;
import java.util.Optional;

public interface Staff {

    List<Employee> getStuff();

    Optional<Employee> findEmployeeById(int id);

    void hire(Employee employee);

    void fire(int EmployeeId);
}
