package com.codejourney.dto;

/*
Important methods:
      record class
      List.of(list of employee object);
*/

import java.util.List;

public record Employee(int id,
                       String name,
                       double salary,
                       String manager,
                       String city,
                       String dept) {

  public static List<Employee> getEmployeeSampleData() {
    return List.of(
            new Employee(1, "Alice", 90000, "M1", "Bangalore", "IT"),
            new Employee(2, "Bob", 75000, "M1", "Hyderabad", "IT"),
            new Employee(3, "Charlie", 80000, "M1", "Chennai", "IT"),

            new Employee(4, "David", 95000, "M2", "Pune", "HR"),
            new Employee(5, "Eve", 70000, "M2", "Mumbai", "HR"),
            new Employee(6, "Frank", 85000, "M2", "Delhi", "HR")
    );
  }
}
