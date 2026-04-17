package com.codejourney.core;

import com.codejourney.dto.Employee;

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
    List<Employee> employeeSampleData = Employee.getEmployeeSampleData();

    Map<String, List<Employee>> managerMap = employeeSampleData.stream()
            .collect(Collectors.groupingBy(Employee::manager));

    managerMap.forEach((manager, employeeList)->{
          System.out.println("Manager: "+manager);

          if(employeeList.size()<2){
            System.out.println("Not enough employees");
            return;
          }

          employeeList.stream()
                  .sorted(Comparator.comparingDouble(Employee :: salary).reversed())
                  .skip(1)
                  .findFirst()
                  .ifPresent(System.out::println);
    });
  }
}
