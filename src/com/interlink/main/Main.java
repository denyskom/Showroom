package com.interlink.main;


import com.interlink.employee.fixed.FixedSalaryEmployee;
import com.interlink.employee.manager.Manager;
import com.interlink.product.Car;
import com.interlink.product.Product;
import com.interlink.repositiry.goods.position.AssortmentPosition;
import com.interlink.repositiry.sales.deal.Deal;
import com.interlink.salary.Salary;
import com.interlink.service.ShowroomService;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ShowroomService service = generateDemoService();
        List<Salary> julyReport = service.getSalaryReport(Month.JULY, 2018);
        julyReport.forEach(salary -> System.out.println(salary.getEmployee() + "  Salary: " + salary.getSalary()));
    }

    private static ShowroomService generateDemoService() {
        Manager managerJon = new Manager(1,"Jon");
        Manager managerIgor = new Manager(2,"Igor");
        Manager managerAndrey = new Manager(3,"Andrey");
        Manager managerDima = new Manager(4,"Dima");
        Manager managerVasia= new Manager(5,"Vasia");

        FixedSalaryEmployee fixedDart = new FixedSalaryEmployee(7, "Dart", 3000,
                LocalDate.now().minusMonths(2));
        FixedSalaryEmployee fixedVayder = new FixedSalaryEmployee(8, "Vayder", 1000,
                LocalDate.now().minusMonths(2));


        Product product = new Car("BMW", 1, 15000,"BMV", "Sedan");

        ShowroomService service = new ShowroomService();
        service.addPosition(new AssortmentPosition(1, product, 9));

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
                Arrays.asList(product, product),
                LocalDate.now(),
                managerJon));

        service.addDeal(new Deal(7,
                Collections.singletonList(product),
                LocalDate.now(),
                managerVasia));

        service.addDeal(new Deal(8,
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

        return service;
    }
}
