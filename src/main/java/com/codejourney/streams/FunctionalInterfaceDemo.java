package com.codejourney.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: Demonstrate real-world usage of Java functional interfaces
 *          (Predicate, Function, Consumer, Supplier) in stream pipelines
 *          across multiple practical scenarios.
 *
 * Scenarios covered:
 *   1. Filter names starting with "A" or "Z" and convert to uppercase
 *   2. Combine Predicates with .and() to filter even numbers greater than 10
 *   3. Transform strings to their lengths using Function + andThen()
 *   4. Convert Person list to names using Function
 *   5. Filter distinct even numbers, square them, and print
 *   6. Collect unique names preserving insertion order
 *   7. Count unique numbers
 *   8. Print unique words with their lengths
 *   9. Unique numbers > 3, sum them
 *
 * Important Methods:
 *   Predicate<T>: .test(), .and(), .or(), .negate()
 *   Function<T,R>: .apply(), .andThen()
 *   Collectors.toSet()
 *   Collectors.toCollection(LinkedHashSet::new)
 *   .distinct().count()
 *   .mapToInt(Integer::intValue).sum()
 */
public class FunctionalInterfaceDemo {

    record Person(String name, int age) {}

    public static void main(String[] args) {

        // Scenario 1: Filter names by starting letter + map to uppercase
        System.out.println("=== Scenario 1: Filter & Uppercase Names ===");
        filterAndUppercaseNames();

        // Scenario 2: Predicate.and() — even AND greater than 10
        System.out.println("\n=== Scenario 2: Combined Predicates (and) ===");
        combinePredicates();

        // Scenario 3: Function.andThen() chaining
        System.out.println("\n=== Scenario 3: Function.andThen() Chaining ===");
        chainFunctions();

        // Scenario 4: Convert Person list to name list
        System.out.println("\n=== Scenario 4: Person → Name Mapping ===");
        extractPersonNames();

        // Scenario 5: Distinct evens → squared → print
        System.out.println("\n=== Scenario 5: Distinct Even Squares ===");
        distinctEvenSquares();

        // Scenario 6: Collect unique names preserving order
        System.out.println("\n=== Scenario 6: Unique Names (Order Preserved) ===");
        uniqueNamesPreserveOrder();

        // Scenario 7: Count unique numbers
        System.out.println("\n=== Scenario 7: Count Unique Numbers ===");
        countUniqueNumbers();

        // Scenario 8: Print unique words with lengths
        System.out.println("\n=== Scenario 8: Unique Words with Lengths ===");
        uniqueWordsWithLengths();

        // Scenario 9: Unique numbers > 3, sum them
        System.out.println("\n=== Scenario 9: Sum of Unique Numbers > 3 ===");
        sumOfUniqueNumbersGreaterThan3();
    }

    private static void filterAndUppercaseNames() {
        List<String> names = Arrays.asList("Arun", "Zaveed", "Charan", "Bharath");
        List<String> result = names.stream()
                .filter(name -> name.startsWith("A") || name.startsWith("Z"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    private static void combinePredicates() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 10, 11, 12, 15, 20);
        java.util.function.Predicate<Integer> isEven   = num -> num % 2 == 0;
        java.util.function.Predicate<Integer> greaterThan10 = num -> num > 10;

        List<Integer> result = numbers.stream()
                .filter(isEven.and(greaterThan10))
                .collect(Collectors.toList());
        System.out.println("Even AND > 10: " + result);
    }

    private static void chainFunctions() {
        List<String> words = Arrays.asList("hello", "world", "java", "programming");
        java.util.function.Function<String, Integer> getLength  = String::length;
        java.util.function.Function<String, Integer> lengthPlus5 = getLength.andThen(len -> len + 5);

        List<Integer> result = words.stream()
                .map(lengthPlus5)
                .collect(Collectors.toList());
        System.out.println("Lengths + 5: " + result);
    }

    private static void extractPersonNames() {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35));
        List<String> names = people.stream()
                .map(Person::name)
                .collect(Collectors.toList());
        System.out.println("Names: " + names);
    }

    private static void distinctEvenSquares() {
        List<Integer> numbers = Arrays.asList(2, 4, 4, 6, 8, 8, 10);
        System.out.print("Distinct even squares: ");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .map(n -> n * n)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    private static void uniqueNamesPreserveOrder() {
        List<String> names = Arrays.asList("Ram", "Shyam", "Ram", "Mohan", "Shyam");
        LinkedHashSet<String> unique = names.stream()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println("Unique (ordered): " + unique);
    }

    private static void countUniqueNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6, 6);
        long count = numbers.stream().distinct().count();
        System.out.println("Unique count: " + count);
    }

    private static void uniqueWordsWithLengths() {
        List<String> words = Arrays.asList("Java", "Streams", "Streams", "Fun", "Java", "Practice");
        words.stream()
                .distinct()
                .forEach(word -> System.out.println(word + " → length: " + word.length()));
    }

    private static void sumOfUniqueNumbersGreaterThan3() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6);
        int sum = numbers.stream()
                .distinct()
                .filter(n -> n > 3)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of unique numbers > 3: " + sum);
    }
}
