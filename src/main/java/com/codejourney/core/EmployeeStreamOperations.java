package com.codejourney.core;

import java.util.*;
import java.util.stream.Collectors;

/*Problem:
  Java Stream Operations on Employee Data (Filtering, Mapping, and Map Sorting)
  Perform various transformations on a list of employees using Java Streams, including
  filtering, mapping, and sorting data in both lists and maps.
*/
/*
Important methods:
      record class
      Arrays.asList(List of Employees);
      Collectors.toMap(key,value);
      map.entrySet().stream()
      sorted(Map.Entry.comparingByKey())
      sorted(Map.Entry.<String,Double>comparingByKey().reversed())
      sorted(Map.Entry.comparingByValue())
      sorted(Map.Entry.<String,Double>comparingByValue().reversed())
      Collectors.toMap(KEY,VALUE,(e1,e2)->e1,LinkedHashMap::new);
      Collectors.mapping(Function, Collectors.toList());
*/
record Employee(String name, double salary, String city) {
  public static List<Employee> getDummyEmployees() {
    return Arrays.asList(
            new Employee("Alice", 45000, "Mumbai"),
            new Employee("Charlie", 30000, "Delhi"),
            new Employee("Diana", 85000, "Mumbai"),
            new Employee("Eve", 55000, "Chennai"),
            new Employee("Yuvi", 60000, "Delhi"),
            new Employee("Bob", 75000, "Hyderabad"),
            new Employee("Frank", 40000, "Goa")
    );
  }
}

public class EmployeeStreamOperations {
  public static void main(String[] args) {
    List<Employee> dummyEmployees = Employee.getDummyEmployees();

    getHighSalaryEmployeeNamesInReverseUppercase(dummyEmployees);

    groupEmployeesByCity(dummyEmployees);

    groupEmployeesByCityAndReturnCityEmployeeName(dummyEmployees);

    find3rdHighestSalary(dummyEmployees);

    Map<String, Double> map = convertListOfEmployeeToMap(dummyEmployees);

    sortMapByKey(map);

    sortMapByKeyDesc(map);

    sortMapByValue(map);

    sortMapByValueDesc(map);
  }

  /*From the given list of employees find whose salary is greater than 50K and
   convert their names to UPPERCASE and sort it in reverse order*/
  private static void getHighSalaryEmployeeNamesInReverseUppercase(List<Employee> dummyEmployees) {
    List<String> list = dummyEmployees.stream()
            .filter(emp -> emp.salary() > 50000)
            .map(emp -> emp.name().toUpperCase())
            .sorted(Comparator.reverseOrder())
            .toList();
    System.out.println(list);
  }

  //Group Employees by City
  private static void groupEmployeesByCity(List<Employee> dummyEmployees){
    Map<String, List<Employee>> map = dummyEmployees.stream()
            .collect(Collectors.groupingBy(emp -> emp.city()));
    System.out.println(map);
  }

  //Group Employees by City but show only the employee names instead of complete employee object
  private static void groupEmployeesByCityAndReturnCityEmployeeName(List<Employee> dummyEmployees){
    Map<String, List<String>> map = dummyEmployees.stream()
            .collect(
                    Collectors.groupingBy(
                            emp -> emp.city(),
                            Collectors.mapping(emp -> emp.name(), Collectors.toList())));
    System.out.println(map);
  }

  private static void find3rdHighestSalary(List<Employee> dummyEmployees) {
    dummyEmployees.stream()
            .sorted(Comparator.comparing(Employee::salary).reversed())
            .skip(2)
            .findFirst()
            .ifPresent(System.out::println);
  }


  // convert List<Employee> into Map<empName,salary>
  private static Map<String, Double> convertListOfEmployeeToMap(List<Employee> dummyEmployees) {
    Map<String, Double> collect =
            dummyEmployees.stream()
                    .collect(Collectors.toMap(
                            emp -> emp.name(),
                            emp -> emp.salary()));
    System.out.println(collect);
    return collect;
  }

  //sort map by Key
  private static void sortMapByKey(Map<String, Double> map) {
    Map<String, Double> collect = map.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .collect(
                    Collectors.toMap(
                            entry -> entry.getKey(),
                            entry -> entry.getValue(),
                            (e1,e2)->e1,
                            LinkedHashMap::new));
    System.out.println(collect);
  }

  //sort map by Key Descending order
  private static void sortMapByKeyDesc(Map<String, Double> map) {
    Map<String, Double> collect = map.entrySet().stream()
            .sorted(Map.Entry.<String,Double>comparingByKey().reversed())
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1, e2) -> e1,
                    LinkedHashMap::new));
    System.out.println(collect);
  }

  //sort map by Value
  private static void sortMapByValue(Map<String, Double> map) {
    LinkedHashMap<String, Double> collect = map.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1, e2) -> e1,
                    LinkedHashMap::new));
    System.out.println(collect);
  }

  //sort map by Value descending order
  private static void sortMapByValueDesc(Map<String, Double> map) {
    LinkedHashMap<String, Double> collect = map.entrySet().stream()
            .sorted(Map.Entry.<String,Double>comparingByValue().reversed())
            .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1, e2) -> e1,
                    LinkedHashMap::new));
    System.out.println(collect);
  }
}
