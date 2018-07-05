package com.interlink.salary;

import com.interlink.employee.Employee;
import com.interlink.repositiry.sales.Sales;
import com.interlink.repositiry.staff.Staff;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class PayrollShit {
    private Sales sales;
    private Staff staff;


    public PayrollShit(Sales sales, Staff staff) {
        this.sales = sales;
        this.staff = staff;
    }

    private Map<Employee, Double> countSalary(Month month) {
        Map<Employee, Double> salaries = new HashMap<>();
        return null;

    }


}
