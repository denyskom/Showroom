package com.interlink.service;

import com.interlink.employee.Employee;
import com.interlink.employee.fixed.FixedSalary;
import com.interlink.employee.manager.Salesman;
import com.interlink.repositiry.salary.SalaryRange;
import com.interlink.repositiry.sales.DealList;
import com.interlink.repositiry.sales.deal.Deal;
import com.interlink.repositiry.staff.Staff;
import com.interlink.salary.Bookkeeping;

import java.time.Month;
import java.util.List;
import java.util.Map;

public class ShowroomService {
    private DealList deals;
    private Staff staff;
    private SalaryRange salaryRange;
    private Bookkeeping bookkeeping;

    public ShowroomService(DealList deals, Staff staff, SalaryRange salaryRange) {
        this.deals = deals;
        this.staff = staff;
        this.salaryRange = salaryRange;
        this.bookkeeping = new Bookkeeping(deals, staff, salaryRange);
    }

    public void hire(FixedSalary fixedSalary) {
        staff.hire(fixedSalary.employeeValue());
        salaryRange.hire(fixedSalary);
    }

    public void hire(Salesman manager) {
        staff.hire(manager.employeeValue());
    }

    public Map<Employee, Double> getSalaryReport(Month month, int year) {
        return bookkeeping.getSalaryReport(month, year);
    }

    public void setManagerPercent(int managerPercent) {
        bookkeeping.setManagerPercent(managerPercent);
    }

    public void setReward(double reward) {
        bookkeeping.setReward(reward);
    }

    public void setRewordCount(int rewordCount) {
        bookkeeping.setRewordCount(rewordCount);
    }

    public List<Deal> getAllDeals() {
        return deals.getAllDeals();
    }

    public List<Employee> getStaff() {
        return staff.getStuff();
    }

    public List<FixedSalary> getFixedSalaryes() {
        return salaryRange.getFixedSalaryEmployees();
    }

    public void addDeal(Deal deal) {
        deals.addDeal(deal);
    }
}
