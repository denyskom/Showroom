package com.interlink.salary;

import com.interlink.employee.Employee;
import com.interlink.repositiry.salary.SalaryRange;
import com.interlink.repositiry.sales.SalesList;
import com.interlink.repositiry.sales.deal.Deal;
import com.interlink.repositiry.staff.Staff;

import java.time.Month;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PayrollSheet {
    private SalesList salesList;
    private Staff staff;
    private SalaryRange salaryRange;
    private int managerPercent = 20;
    private double reward = 1000;


    public PayrollSheet(SalesList salesList, Staff staff, SalaryRange salaryRange) {
        this.salesList = salesList;
        this.staff = staff;
        this.salaryRange = salaryRange;
    }

    public void setManagerPercent(int managerPercent) {
        this.managerPercent = managerPercent;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    private Map<Employee, Double> countSalary(Month month) {
        Map<Employee, Double> salaries = new HashMap<>();
//        staff.getStuff().stream().map()
        return null;
    }

    public Map<Integer, Double> countManagerSalary(Month month) {
        Map<Integer, Double> percents = new HashMap<>();
        salesList.getDealsByMonth(month).stream()
                .collect(Collectors.groupingBy(
                        Deal::getId, Collectors.summingDouble(Deal::getTotalPrice)))
                .forEach((key, value) -> percents.put(key, value * (20 / 100)));
        return percents;
    }
}
