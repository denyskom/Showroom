package com.interlink.main;


import com.interlink.employee.manager.Manager;
import com.interlink.product.Car;
import com.interlink.product.Product;
import com.interlink.repositiry.sales.DealList;
import com.interlink.repositiry.sales.ShowroomDealList;
import com.interlink.repositiry.sales.deal.Deal;
import com.interlink.salary.PayrollSheet;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        DealList dealList = new ShowroomDealList();
        Manager managerJon = new Manager(1,"Jon");
        Manager managerIgor = new Manager(2,"Igor");

        Product product = new Car("BMW", 1, 15000,"BMV", "Sedan");

        dealList.addDeal(new Deal(1,
                Collections.singletonList(product),
                LocalDate.now(),
                managerIgor));

        dealList.addDeal(new Deal(2,
                Collections.singletonList(product),
                LocalDate.now(),
                managerIgor));

        dealList.addDeal(new Deal(3,
                Collections.singletonList(product),
                LocalDate.now(),
                managerJon));

        PayrollSheet sheet = new PayrollSheet(dealList,null, null);

        System.out.println(sheet.countManagerSalary(LocalDate.now().getMonth(), LocalDate.now().getYear()));

        Map<Integer, Double> salaries = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            salaries.put(i, (double) i * 100);
        }

        System.out.println(salaries);

        List<Map.Entry<Integer, Double>> topManagers = salaries.entrySet().stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .skip(salaries.size() - 3).collect(Collectors.toList());

        topManagers.forEach(entry -> salaries.put(entry.getKey(), entry.getValue() + 1000));

        System.out.println(salaries);
    }
}
