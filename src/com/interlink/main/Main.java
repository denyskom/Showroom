package com.interlink.main;


import com.interlink.employee.manager.Manager;
import com.interlink.product.Car;
import com.interlink.product.Product;
import com.interlink.repositiry.sales.SalesList;
import com.interlink.repositiry.sales.ShowroomSalesList;
import com.interlink.repositiry.sales.deal.Deal;
import com.interlink.salary.PayrollSheet;

import java.time.LocalDate;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        SalesList salesList = new ShowroomSalesList();
        Manager managerJon = new Manager(1,"Jon");
        Manager managerIgor = new Manager(2,"Igor");

        Product product = new Car("BMW", 1, 15000,"BMV", "Sedan");

        salesList.addDeal(new Deal(1,
                Collections.singletonList(product),
                LocalDate.now(),
                managerIgor));

        salesList.addDeal(new Deal(2,
                Collections.singletonList(product),
                LocalDate.now(),
                managerIgor));

        salesList.addDeal(new Deal(3,
                Collections.singletonList(product),
                LocalDate.now(),
                managerJon));

        PayrollSheet sheet = new PayrollSheet(salesList,null, null);

        System.out.println(sheet.countManagerSalary(LocalDate.now().getMonth()));


    }
}
