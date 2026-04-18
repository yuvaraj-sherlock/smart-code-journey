package com.codejourney.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: Demonstrate the core Java Stream API — intermediate and terminal
 *          operations — with practical mini-scenarios on lists of Strings,
 *          Integers, and custom objects.
 *
 * Intermediate operations covered: filter, map, distinct, sorted, limit, skip
 * Terminal operations covered:     forEach, collect, count, min, max, findFirst
 * Comparator operations covered:   naturalOrder, reverseOrder, comparing
 *
 * Important Methods:
 *   list.stream()
 *   .filter(predicate)
 *   .map(function)
 *   .distinct()
 *   .sorted() / .sorted(Comparator)
 *   .limit(n) / .skip(n)
 *   .count()
 *   .min(comparator).get()
 *   .max(comparator).get()
 *   .findFirst().orElse(default)
 *   Collectors.toList()
 *   Comparator.comparing(keyExtractor)
 */
public class StreamBasicDemo {

    public static void main(String[] args) {

        // Scenario 1: Filter even numbers and square them
        System.out.println("=== Scenario 1: Filter Even & Square ===");
        filterEvenAndSquare();

        // Scenario 2: Find name with minimum length
        System.out.println("\n=== Scenario 2: Name with Minimum Length ===");
        findShortestName();

        // Scenario 3: Sort products by name
        System.out.println("\n=== Scenario 3: Sort Products by Name ===");
        sortProductsByName();

        // Scenario 4: Find lowest-priced product
        System.out.println("\n=== Scenario 4: Find Lowest Priced Product ===");
        findCheapestProduct();

        // Scenario 5: limit and skip
        System.out.println("\n=== Scenario 5: Limit & Skip ===");
        limitAndSkipDemo();

        // Scenario 6: count distinct elements
        System.out.println("\n=== Scenario 6: Count Distinct Elements ===");
        countDistinct();
    }

    private static void filterEvenAndSquare() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Even squares: " + result);
    }

    private static void findShortestName() {
        List<String> names = Arrays.asList("Amit", "Zara", "John", "Kiran", "Bob");
        String shortest = names.stream()
                .min(Comparator.comparing(String::length))
                .orElse("none");
        System.out.println("Shortest name: " + shortest);
    }

    private static void sortProductsByName() {
        List<Product> products = getSampleProducts();
        List<Product> sorted = products.stream()
                .sorted(Comparator.comparing(p -> p.name))
                .collect(Collectors.toList());
        System.out.println("Sorted by name: " + sorted);
    }

    private static void findCheapestProduct() {
        List<Product> products = getSampleProducts();
        Product cheapest = products.stream()
                .min(Comparator.comparing(p -> p.price))
                .orElseThrow();
        System.out.println("Cheapest product: " + cheapest);
    }

    private static void limitAndSkipDemo() {
        List<String> names = Arrays.asList("Ram", "Shyam", "Mohan", "Sohan", "Ravi");
        System.out.print("First 2 (limit): ");
        names.stream().limit(2).forEach(n -> System.out.print(n + " "));
        System.out.print("\nAfter skipping 2 (skip): ");
        names.stream().skip(2).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    private static void countDistinct() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6, 6);
        long count = numbers.stream().distinct().count();
        System.out.println("Distinct count: " + count);
    }

    private static List<Product> getSampleProducts() {
        return Arrays.asList(
                new Product("Laptop", 55000),
                new Product("Phone", 35000),
                new Product("Tablet", 25000),
                new Product("Monitor", 15000)
        );
    }
}

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - ₹" + price;
    }
}
