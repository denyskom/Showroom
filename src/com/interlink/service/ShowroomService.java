package com.interlink.service;

import com.interlink.employee.Employee;
import com.interlink.employee.fixed.FixedSalary;
import com.interlink.employee.manager.Manager;
import com.interlink.product.Product;
import com.interlink.repositiry.goods.Assortment;
import com.interlink.repositiry.goods.ShowroomAssortment;
import com.interlink.repositiry.goods.position.AssortmentPosition;
import com.interlink.repositiry.salary.SalaryRange;
import com.interlink.repositiry.salary.ShowroomSalaryRange;
import com.interlink.repositiry.sales.DealList;
import com.interlink.repositiry.sales.ShowroomDealList;
import com.interlink.repositiry.sales.deal.Deal;
import com.interlink.repositiry.staff.ShowroomStaff;
import com.interlink.repositiry.staff.Staff;
import com.interlink.salary.Bookkeeping;
import com.interlink.salary.Salary;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ShowroomService {
    private DealList deals;
    private Staff staff;
    private SalaryRange salaryRange;
    private Bookkeeping bookkeeping;
    private Assortment assortment;

    public ShowroomService() {
        this.deals = new ShowroomDealList();
        this.staff = new ShowroomStaff();
        this.salaryRange = new ShowroomSalaryRange();
        this.assortment = new ShowroomAssortment();
        this.bookkeeping = new Bookkeeping(deals, staff, salaryRange);
    }

    public void hire(FixedSalary fixedSalary) {
        staff.hire(fixedSalary.employeeValue());
        salaryRange.hire(fixedSalary);
    }

    public void hire(Manager manager) {
        staff.hire(manager);
    }

    public List<Salary> getSalaryReport(Month month, int year) {
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
        List<Product> products = deal.getProducts();
        if(products.isEmpty()) {
            return;
        }
        Map<Integer, Long> productsCountMappedById = getProductCountMappedById(products);

        productsCountMappedById.forEach((productId, quantityNeeded) -> {
            Optional<AssortmentPosition> position = assortment.getPositionById(productId);
            if(!position.isPresent() || position.get().getQuantity() <= quantityNeeded) {
                deal.setValid(false);
                deals.addDeal(deal);
                return;
            }

            position.get().salePosition(Math.toIntExact(quantityNeeded));
        });

        deals.addDeal(deal);
    }

    private Map<Integer, Long> getProductCountMappedById(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getId, Collectors.counting()));
    }

    public void addPosition(AssortmentPosition position) {
        assortment.addPosition(position);
    }
}
