package com.codejourney.customObjects;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: Perform various transformations on a list of Employee records using
 *          Java Streams — filtering, mapping, grouping, sorting, and Map conversions.
 *
 * Operations covered:
 *   1. Filter employees with salary > 50K, uppercase names, sort in reverse order
 *   2. Group employees by city
 *   3. Group by city, show only employee names (not full object)
 *   4. Find the employee with the maximum salary
 *   5. Find the 3rd highest salaried employee
 *   6. Convert List<Employee> to Map<name, salary>
 *   7. Sort map by key (ascending & descending)
 *   8. Sort map by value (ascending & descending)
 *
 * Important Methods:
 *   record Employee(...)
 *   Collectors.groupingBy(emp -> emp.city())
 *   Collectors.mapping(emp -> emp.name(), Collectors.toList())
 *   Collectors.toMap(key, value, mergeFunction, mapFactory)
 *   Map.Entry.comparingByKey() / comparingByValue()
 *   Map.Entry.<K,V>comparingByKey().reversed()
 *   .max(Comparator.comparing(...)).get()
 *   .sorted(...).skip(2).findFirst().ifPresent(...)
 *   LinkedHashMap::new                 // preserves insertion order
 */
public class EmployeeStreamOperations {

    record Employee(String name, double salary, String city) {
        public static List<Employee> getSampleData() {
            return Arrays.asList(
                    new Employee("Alice",   45000, "Mumbai"),
                    new Employee("Charlie", 30000, "Delhi"),
                    new Employee("Diana",   85000, "Mumbai"),
                    new Employee("Eve",     55000, "Chennai"),
                    new Employee("Yuvi",    60000, "Delhi"),
                    new Employee("Bob",     75000, "Hyderabad"),
                    new Employee("Frank",   40000, "Goa")
            );
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Employee.getSampleData();

        System.out.println("=== 1. High Salary Names (>50K), Uppercase, Reverse Sorted ===");
        getHighSalaryNamesReverseUppercase(employees);

        System.out.println("\n=== 2. Group Employees by City ===");
        groupByCity(employees);

        System.out.println("\n=== 3. Group by City → Employee Names Only ===");
        groupByCityNamesOnly(employees);

        System.out.println("\n=== 4. Max Salaried Employee ===");
        findMaxSalaryEmployee(employees);

        System.out.println("\n=== 5. 3rd Highest Salary ===");
        findNthHighestSalary(employees, 3);

        System.out.println("\n=== 6. Convert to Map<Name, Salary> ===");
        Map<String, Double> salaryMap = convertToSalaryMap(employees);

        System.out.println("\n=== 7a. Sort Map by Key (Ascending) ===");
        sortMapByKey(salaryMap);

        System.out.println("\n=== 7b. Sort Map by Key (Descending) ===");
        sortMapByKeyDesc(salaryMap);

        System.out.println("\n=== 8a. Sort Map by Value (Ascending) ===");
        sortMapByValue(salaryMap);

        System.out.println("\n=== 8b. Sort Map by Value (Descending) ===");
        sortMapByValueDesc(salaryMap);
    }

    private static void getHighSalaryNamesReverseUppercase(List<Employee> employees) {
        List<String> result = employees.stream()
                .filter(emp -> emp.salary() > 50000)
                .map(emp -> emp.name().toUpperCase())
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(result);
    }

    private static void groupByCity(List<Employee> employees) {
        Map<String, List<Employee>> grouped = employees.stream()
                .collect(Collectors.groupingBy(Employee::city));
        grouped.forEach((city, empList) -> System.out.println(city + " → " + empList));
    }

    private static void groupByCityNamesOnly(List<Employee> employees) {
        Map<String, List<String>> grouped = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::city,
                        Collectors.mapping(Employee::name, Collectors.toList())));
        grouped.forEach((city, names) -> System.out.println(city + " → " + names));
    }

    private static void findMaxSalaryEmployee(List<Employee> employees) {
        employees.stream()
                .max(Comparator.comparing(Employee::salary))
                .ifPresent(System.out::println);
    }

    private static void findNthHighestSalary(List<Employee> employees, int n) {
        employees.stream()
                .sorted(Comparator.comparing(Employee::salary).reversed())
                .skip(n - 1)
                .findFirst()
                .ifPresent(emp -> System.out.println("Rank #" + n + ": " + emp));
    }

    private static Map<String, Double> convertToSalaryMap(List<Employee> employees) {
        Map<String, Double> map = employees.stream()
                .collect(Collectors.toMap(Employee::name, Employee::salary));
        System.out.println(map);
        return map;
    }

    private static void sortMapByKey(Map<String, Double> map) {
        Map<String, Double> sorted = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sorted);
    }

    private static void sortMapByKeyDesc(Map<String, Double> map) {
        Map<String, Double> sorted = map.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByKey().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sorted);
    }

    private static void sortMapByValue(Map<String, Double> map) {
        Map<String, Double> sorted = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sorted);
    }

    private static void sortMapByValueDesc(Map<String, Double> map) {
        Map<String, Double> sorted = map.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sorted);
    }
}