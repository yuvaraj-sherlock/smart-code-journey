package com.codejourney.core;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Problem: Given a list of employees, find the second-highest salaried employee under each manager.
Approach: Group employees by manager and identify the top 2 salaries within each group.

Pattern: Map + Grouping + Top-K
Trigger: "for each manager" + "second highest"
Core Tweak: Maintain top 2 salaries
*/

/*
Important methods:
      Collectors.groupingBy(Function);
      Map.forEach((key,value)->Consumer);
      .sorted(Comparator.comparingDouble(Function).reversed())
      .skip(1)
      .findFirst()
      .ifPresent()
*/

public class SecondHighestSalaryByManager {
  public static void main(String[] args) {
    List<MyEmployee> employeeSampleData = MyEmployee.getEmployeeSampleData();

    Map<String, List<MyEmployee>> managerMap = employeeSampleData.stream()
            .collect(Collectors.groupingBy(MyEmployee::manager));

    managerMap.forEach((manager, employeeList)->{
          System.out.println("Manager: "+manager);

          if(employeeList.size()<2){
            System.out.println("Not enough employees");
            return;
          }

          employeeList.stream()
                  .sorted(Comparator.comparingDouble(MyEmployee :: salary).reversed())
                  .skip(1)
                  .findFirst()
                  .ifPresent(System.out::println);
    });
  }
}

 record MyEmployee(int id,
                       String name,
                       double salary,
                       String manager,
                       String city,
                       String dept) {

  public static List<MyEmployee> getEmployeeSampleData() {
    return List.of(
            new MyEmployee(1, "Alice", 90000, "M1", "Bangalore", "IT"),
            new MyEmployee(2, "Bob", 75000, "M1", "Hyderabad", "IT"),
            new MyEmployee(3, "Charlie", 80000, "M1", "Chennai", "IT"),

            new MyEmployee(4, "David", 95000, "M2", "Pune", "HR"),
            new MyEmployee(5, "Eve", 70000, "M2", "Mumbai", "HR"),
            new MyEmployee(6, "Frank", 85000, "M2", "Delhi", "HR")
    );
  }
}
