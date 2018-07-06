package com.interlink.service;

import com.interlink.employee.Employee;
import com.interlink.employee.fixed.FixedSalary;
import com.interlink.employee.manager.Salesman;
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

import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        List<Product> products = deal.getProducts();
        if(products.isEmpty()) {
            return;
        }
        Map<Integer, Integer> productsCountById = new HashMap<>();
        products.forEach(product -> {
            int productId = product.getId();

            if(productsCountById.containsKey(productId)) {
               productsCountById.put(productId,
                       productsCountById.get(productId));
           }
           productsCountById.put(productId, 1);
        });

        productsCountById.forEach((productId, quantityNeeded) -> {
            Optional<AssortmentPosition> position = assortment.getPositionById(productId);
            if(!position.isPresent() || position.get().getQuantity() <= quantityNeeded) {
                deal.setValid(false);
                deals.addDeal(deal);
                return;
            }

            position.get().salePosition(quantityNeeded);
        });

        deals.addDeal(deal);

        assortment.getAssortment().forEach(position ->
                System.out.println("Name " + position.getProduct().getName() + " Quantity: " + position.getQuantity()));
    }

    public void addPosition(AssortmentPosition position) {
        assortment.addPosition(position);
    }
}
