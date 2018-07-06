package com.interlink.main;


import com.interlink.employee.Employee;
import com.interlink.employee.fixed.FixedSalaryEmployee;
import com.interlink.employee.manager.Manager;
import com.interlink.product.Car;
import com.interlink.product.Product;
import com.interlink.repositiry.salary.SalaryRange;
import com.interlink.repositiry.salary.ShowroomSalaryRange;
import com.interlink.repositiry.sales.DealList;
import com.interlink.repositiry.sales.ShowroomDealList;
import com.interlink.repositiry.sales.deal.Deal;
import com.interlink.repositiry.staff.ShowroomStaff;
import com.interlink.repositiry.staff.Staff;
import com.interlink.salary.Bookkeeping;
import com.interlink.service.ShowroomService;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        DealList dealList = new ShowroomDealList();
        Manager managerJon = new Manager(1,"Jon");
        Manager managerIgor = new Manager(2,"Igor");
        Manager managerAndrey = new Manager(3,"Andrey");
        Manager managerDima = new Manager(4,"Dima");
        Manager managerVasia= new Manager(5,"Vasia");

        FixedSalaryEmployee fixedDart = new FixedSalaryEmployee(7, "Dart", 3000,
                LocalDate.now().minusMonths(2));
        FixedSalaryEmployee fixedVayder = new FixedSalaryEmployee(8, "Vayder", 1000,
                LocalDate.now().minusMonths(2));


        Staff staff = new ShowroomStaff();
        SalaryRange fixedSalary = new ShowroomSalaryRange();

        Product product = new Car("BMW", 1, 15000,"BMV", "Sedan");

        ShowroomService service = new ShowroomService(dealList,staff, fixedSalary);

        service.addDeal(new Deal(1,
                Collections.singletonList(product),
                LocalDate.now(),
                managerIgor));

        service.addDeal(new Deal(2,
                Collections.singletonList(product),
                LocalDate.now(),
                managerIgor));

        service.addDeal(new Deal(3,
                Collections.singletonList(product),
                LocalDate.now(),
                managerAndrey));

        service.addDeal(new Deal(4,
                Collections.singletonList(product),
                LocalDate.now(),
                managerAndrey));

        service.addDeal(new Deal(5,
                Collections.singletonList(product),
                LocalDate.now(),
                managerAndrey));

        service.addDeal(new Deal(6,
                Collections.singletonList(product),
                LocalDate.now(),
                managerJon));

        service.addDeal(new Deal(7,
                Collections.singletonList(product),
                LocalDate.now(),
                managerJon));

        service.addDeal(new Deal(8,
                Collections.singletonList(product),
                LocalDate.now(),
                managerVasia));

        service.addDeal(new Deal(9,
                Collections.singletonList(product),
                LocalDate.now().minusMonths(2),
                managerIgor));

        service.hire(managerAndrey);
        service.hire(managerJon);
        service.hire(managerIgor);
        service.hire(managerDima);
        service.hire(managerVasia);
        service.hire(fixedDart);
        service.hire(fixedVayder);

        Map<Employee, Double> julyReport = service.getSalaryReport(Month.JULY, 2018);
        julyReport.forEach((key, value) -> System.out.println(key + "  Salary: " + value));
    }
}
