package com.interlink.employee.fixed;

import com.interlink.employee.Employee;

import java.time.LocalDate;
import java.util.Optional;

public interface FixedSalary{

    int getEmployeeId();

    double getSalary();

    void setPost(String post);

    void setSalary(double salary);

    String getPost();

    LocalDate getStartDate();

    Optional<LocalDate> getEndDate();

    Employee employeeValue();
}
