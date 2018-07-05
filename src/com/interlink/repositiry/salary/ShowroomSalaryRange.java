package com.interlink.repositiry.salary;

import com.interlink.employee.fixed.FixedSalary;

import java.util.List;
import java.util.Optional;

public class ShowroomSalaryRange implements SalaryRange {
    private List<FixedSalary> employees;

    public ShowroomSalaryRange(List<FixedSalary> employees) {
        this.employees = employees;
    }

    @Override
    public List<FixedSalary> getFixedSalaryEmployees() {
        return employees;
    }

    @Override
    public Optional<FixedSalary> getEmployeeById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id).findAny();
    }

    @Override
    public void hire(FixedSalary employee) {
        employees.add(employee);
    }

    @Override
    public void fire(int employeeId) {
        getEmployeeById(employeeId)
                .ifPresent(employee -> employees.remove(employee));
    }

    @Override
    public void updateEmployee(FixedSalary employee) {
        getEmployeeById(employee.getId())
                .ifPresent(old -> {
                    old.setSalary(employee.getSalary());
                    old.setPost(employee.getPost());
                });

    }
}
