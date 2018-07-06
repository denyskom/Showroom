package com.interlink.salary;

import com.interlink.employee.Employee;
import com.interlink.repositiry.salary.SalaryRange;
import com.interlink.repositiry.sales.DealList;
import com.interlink.repositiry.sales.deal.Deal;
import com.interlink.repositiry.staff.Staff;
import javafx.collections.transformation.SortedList;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class PayrollSheet {
    private DealList dealList;
    private Staff staff;
    private SalaryRange salaryRange;
    private int managerPercent = 5;
    private int rewordCount = 3;
    private double reward = 1000;


    public PayrollSheet(DealList dealList, Staff staff, SalaryRange salaryRange) {
        this.dealList = dealList;
        this.staff = staff;
        this.salaryRange = salaryRange;
    }

    public void setManagerPercent(int managerPercent) {
        this.managerPercent = managerPercent;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public void setRewordCount(int rewordCount) {
        this.rewordCount = rewordCount;
    }

    public Map<Employee, Double> countSalary(Month month) {
        Map<Employee, Double> salaries = new HashMap<>();
        return null;
    }

    private Map<Integer, Double> countManagerSalary(Month month, int year) {
        Map<Integer, Double> profit = dealList.getDealsByMonth(month, year).stream()
                .collect(Collectors.groupingBy(
                        deal -> deal.getSeller().getSalesmanId(), Collectors.summingDouble(Deal::getTotalPrice)));

        HashMap<Integer, Double> profitCopy = new HashMap<>(profit);
        profit.forEach((key, value) -> profitCopy.put(key, (value / 100) * 20));
        return profitCopy;
    }

    private Map<Integer, Double> countFixedSalary(Month month, int year) {
        Map<Integer, Double> salaries = new HashMap<>();
        salaryRange.getFixedSalaryByMonth(month,year)
                .forEach(salary -> salaries.put(salary.getEmployeeId(), salary.getSalary()));


        List<Map.Entry<Integer, Double>> topManagers = salaries.entrySet().stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .skip(salaries.size() - rewordCount).collect(Collectors.toList());

        topManagers.forEach(entry -> salaries.put(entry.getKey(), entry.getValue() + reward));
        return salaries;
    }

    private Map<Employee, Double> willBePaid(Month month, int year) {

        Map<Integer, Double> paidById = countFixedSalary(month, year);
        paidById.putAll(countManagerSalary(month, year));

        Map<Employee, Double> paidByEmployee = new HashMap<>();
        List<Employee> staffList = staff.getStuff();
        
        paidById.forEach((key, value) -> staffList.stream()
                .filter(employee ->
                        employee.getEmployeeId() == key)
                .findFirst()
                .ifPresent(employee -> paidByEmployee.put(employee, value)));

        return paidByEmployee;
    }
}
