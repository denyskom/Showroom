package com.interlink.repositiry.staff;

import com.interlink.employee.Employee;

import java.util.List;

public class ShowroomStaff implements Staff{
    List<Employee> employees;

    @Override
    public List<Employee> getStuff() {
        return null;
    }

    @Override
    public void hire(int EmployeeId) {

    }

    @Override
    public void fire(int EmployeeId) {

    }
}
