package com.interlink.repositiry.staff;

import com.interlink.employee.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShowroomStaff implements Staff{
    private List<Employee> employees;

    public ShowroomStaff() {
        this.employees = new ArrayList<>();
    }

    @Override
    public List<Employee> getStuff() {
        return employees;
    }

    @Override
    public Optional<Employee> findEmployeeById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id).findAny();
    }

    @Override
    public void hire(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void fire(int EmployeeId) {
        findEmployeeById(EmployeeId)
                .ifPresent(employee -> employees.remove(employee));
    }
}
