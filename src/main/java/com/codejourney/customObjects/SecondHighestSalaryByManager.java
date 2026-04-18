package com.codejourney.customObjects;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: Given a list of employees, find the second-highest salaried employee
 *          under each manager.
 *
 * Pattern: Map + Grouping + Top-K
 * Trigger: "for each manager" + "second highest"
 *
 * Approach:
 *   1. Group employees by manager using Collectors.groupingBy.
 *   2. For each manager's group, sort employees by salary descending.
 *   3. Skip the first (highest salary) and take the next one with findFirst().
 *   4. Guard against groups with fewer than 2 employees.
 *
 * Important Methods:
 *   Collectors.groupingBy(MyEmployee::manager)
 *   Map.forEach((key, value) -> ...)
 *   .sorted(Comparator.comparingDouble(MyEmployee::salary).reversed())
 *   .skip(1)
 *   .findFirst()
 *   .ifPresent(System.out::println)
 */
public class SecondHighestSalaryByManager {

    record MyEmployee(int id, String name, double salary, String manager, String city, String dept) {
        public static List<MyEmployee> getSampleData() {
            return List.of(
                    new MyEmployee(1, "Alice",   90000, "M1", "Bangalore", "IT"),
                    new MyEmployee(2, "Bob",     75000, "M1", "Hyderabad", "IT"),
                    new MyEmployee(3, "Charlie", 80000, "M1", "Chennai",   "IT"),

                    new MyEmployee(4, "David",   95000, "M2", "Pune",      "HR"),
                    new MyEmployee(5, "Eve",     70000, "M2", "Mumbai",    "HR"),
                    new MyEmployee(6, "Frank",   85000, "M2", "Delhi",     "HR")
            );
        }
    }

    public static void main(String[] args) {
        List<MyEmployee> employees = MyEmployee.getSampleData();

        // Group all employees by their manager
        Map<String, List<MyEmployee>> byManager = employees.stream()
                .collect(Collectors.groupingBy(MyEmployee::manager));

        // For each manager, find and print the second-highest paid employee
        byManager.forEach((manager, empList) -> {
            System.out.println("Manager: " + manager);

            if (empList.size() < 2) {
                System.out.println("  Not enough employees to determine second-highest salary.");
                return;
            }

            empList.stream()
                    .sorted(Comparator.comparingDouble(MyEmployee::salary).reversed())
                    .skip(1)
                    .findFirst()
                    .ifPresent(emp -> System.out.println("  Second Highest → " + emp));
        });
    }
}