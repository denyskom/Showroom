package com.interlink.repositiry.salary;

import com.interlink.employee.fixed.FixedSalary;

import java.util.List;
import java.util.Optional;

public interface SalaryRange {
    List<FixedSalary> getFixedSalaryEmployees();

    Optional<FixedSalary> getEmployeeById(int id);

    void hire(FixedSalary employee);

    void fire(int employeeId);

    void updateEmployee(FixedSalary employee);
}
