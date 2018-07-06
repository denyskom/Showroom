package com.interlink.repositiry.salary;

import com.interlink.employee.fixed.FixedSalary;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ShowroomSalaryRange implements SalaryRange {
    private List<FixedSalary> employees;

    public ShowroomSalaryRange(List<FixedSalary> employees) {
        this.employees = employees;
    }

    @Override
    public List<FixedSalary> getFixedSalaryEmployees() {
        return new ArrayList<>(employees);
    }

    @Override
    public Optional<FixedSalary> getEmployeeById(int id) {
        return employees.stream()
                .filter(employee -> employee.getEmployeeId() == id).findAny();
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
        getEmployeeById(employee.getEmployeeId())
                .ifPresent(old -> {
                    old.setSalary(employee.getSalary());
                    old.setPost(employee.getPost());
                });

    }

    @Override
    public List<FixedSalary> getFixedSalaryByMonth(Month month, int year) {
        LocalDate startOfPeriod = LocalDate.of(year, month, 1);
        return employees.stream().filter(employee -> {
            if(employee.getEndDate().isPresent()) {
                if(startOfPeriod.isAfter(employee.getEndDate().get())) {
                    return false;
                }
            }

            LocalDate salaryStart = employee.getStartDate();
            return startOfPeriod.isAfter(salaryStart) || startOfPeriod.equals(salaryStart);

        }).collect(Collectors.toList());
    }
}
