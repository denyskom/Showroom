package com.interlink.salary;

import com.interlink.employee.Employee;
import com.interlink.repositiry.salary.SalaryRange;
import com.interlink.repositiry.sales.DealList;
import com.interlink.repositiry.sales.deal.Deal;
import com.interlink.repositiry.staff.Staff;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class Bookkeeping {
    private DealList dealList;
    private Staff staff;
    private SalaryRange salaryRange;
    private int managerPercent = 5;
    private int rewordCount = 3;
    private double reward = 1000;


    public Bookkeeping(DealList dealList, Staff staff, SalaryRange salaryRange) {
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

    public List<Salary> getSalaryReport(Month month, int year) {
        List<Salary> salaryReport = getEmployeesWithPositiveSalary(month, year);
        addZeroSalaryEmployees(salaryReport);
        return salaryReport;
    }

    private List<Salary> getEmployeesWithPositiveSalary(Month month, int year) {
        List<Salary> paidByEmployee = countFixedEmployeeSalary(month, year);
        paidByEmployee.addAll(countManagerSalary(month, year));
        return paidByEmployee;
    }

    private void addZeroSalaryEmployees(List<Salary> salaryReport) {
        List<Employee> stuff = staff.getStuff();
        stuff.removeAll(
                salaryReport.stream()
                        .map(Salary::getEmployee)
                        .collect(Collectors.toList()));

        stuff.forEach(employee -> salaryReport.add(new Salary(employee,0)));
    }

    private List<Salary> countFixedEmployeeSalary(Month month, int year) {
        List<Salary> salaries = new ArrayList<>();
        salaryRange.getFixedSalaryByMonth(month,year)
                .forEach(salaryRecord ->
                        salaries.add(new Salary(salaryRecord.employeeValue(), salaryRecord.getSalary())));

        return salaries;
    }

    private List<Salary> countManagerSalary(Month month, int year) {
        Map<Integer, Double> profit = getManagersProfitMappedById(month, year);
        List<Salary> managersSalary = mapSalaryByEmployee(getManagersSalaryWithoutBonuses(profit));
        giveBonusesToTopManagers(managersSalary);

        return managersSalary;
    }

    private void giveBonusesToTopManagers(List<Salary> managersSalary) {
        List<Salary> sortedManagersSalary = managersSalary.stream()
                .sorted(Comparator.comparingDouble(Salary::getSalary))
                .collect(Collectors.toList());

        List<Salary>topManagersSalary = getTopManagersSalary(sortedManagersSalary);
        topManagersSalary.forEach(salary -> salary.addBonus(reward));
    }

    private List<Salary> getTopManagersSalary(List<Salary> sortedManagersSalary) {
        if(sortedManagersSalary.size() > rewordCount) {
            return sortedManagersSalary.stream()
                    .skip(sortedManagersSalary.size() - rewordCount)
                    .collect(Collectors.toList());
        }
        return sortedManagersSalary;
    }

    private Map<Integer, Double> getManagersProfitMappedById(Month month, int year) {
        return dealList.getDealsByMonth(month, year)
                .stream().filter(Deal::isValid)
                .collect(Collectors.groupingBy(
                        deal -> deal.getSeller().getEmployeeId(),
                        Collectors.summingDouble(Deal::getTotalPrice)));
    }


    private List<Salary> mapSalaryByEmployee(Map<Integer, Double> salaryMappedById) {
        return salaryMappedById.entrySet().stream()
                .filter(salaryById -> staff.findEmployeeById(salaryById.getKey()).isPresent())
                .map(salaryById ->
                        new Salary(staff.findEmployeeById(salaryById.getKey()).get(),
                                salaryById.getValue())).collect(Collectors.toList());
    }


    private Map<Integer, Double> getManagersSalaryWithoutBonuses(Map<Integer, Double> profit) {
        Map<Integer, Double> profitCopy = new HashMap<>(profit);
        profit.forEach((managerId, managerProfit) ->
                profitCopy.put(managerId, (managerProfit / 100) * managerPercent));
        return profitCopy;
    }

}
