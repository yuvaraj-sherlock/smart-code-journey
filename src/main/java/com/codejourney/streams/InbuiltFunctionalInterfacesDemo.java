package com.codejourney.streams;

import java.util.*;
import java.util.function.*;

/**
 * Problem: Demonstrate all four core Java 8 built-in Functional Interfaces
 *          (Predicate, Function, Consumer, Supplier) and the Comparator
 *          functional interface with both anonymous class and lambda forms.
 *
 * Interfaces covered:
 *   Predicate<T>   — boolean test(T t)           → use for filtering/condition checks
 *   Function<T,R>  — R apply(T t)                → use for transformation/mapping
 *   Consumer<T>    — void accept(T t)             → use for side-effect actions (e.g. print)
 *   Supplier<T>    — T get()                      → use for lazy value generation
 *   Comparator<T>  — int compare(T o1, T o2)      → use for ordering
 *
 * Important Methods:
 *   predicate.test(value)
 *   function.apply(value)
 *   consumer.accept(value)
 *   supplier.get()
 *   comparator.compare(o1, o2)
 *   list.sort(comparator)
 *   new Random().nextInt()
 */
public class InbuiltFunctionalInterfacesDemo {

    public static void main(String[] args) {

        // Predicate: test a condition
        System.out.println("=== Predicate ===");
        Predicate<String> startsWithY = str -> str.startsWith("Y");
        System.out.println("'Yuvaraj' starts with Y: " + startsWithY.test("Yuvaraj"));
        System.out.println("'Govind' starts with Y:  " + startsWithY.test("Govind"));

        // Predicate composition
        Predicate<Integer> isEven      = n -> n % 2 == 0;
        Predicate<Integer> isPositive  = n -> n > 0;
        System.out.println("4 is even AND positive: " + isEven.and(isPositive).test(4));
        System.out.println("-2 is even AND positive: " + isEven.and(isPositive).test(-2));

        // Function: transform a value
        System.out.println("\n=== Function ===");
        Function<String, String> toUpperCase = String::toUpperCase;
        System.out.println("Uppercase: " + toUpperCase.apply("govind"));

        // Function composition with andThen
        Function<String, Integer> strLength      = String::length;
        Function<String, String>  lengthAsString = strLength.andThen(len -> "Length is " + len);
        System.out.println(lengthAsString.apply("hello"));

        // Consumer: perform an action, returns void
        System.out.println("\n=== Consumer ===");
        Consumer<String> printer = str -> System.out.println("Consuming: " + str);
        printer.accept("Yuvaraj");

        // Chained consumers with andThen
        Consumer<String> upper   = str -> System.out.print("Upper: " + str.toUpperCase());
        Consumer<String> length  = str -> System.out.println(" | Length: " + str.length());
        upper.andThen(length).accept("java");

        // Supplier: lazily provide a value
        System.out.println("\n=== Supplier ===");
        Supplier<Integer> randomInt = () -> new Random().nextInt(100);
        System.out.println("Random value: " + randomInt.get());

        Supplier<List<String>> listFactory = ArrayList::new;
        List<String> newList = listFactory.get();
        newList.add("Created from Supplier");
        System.out.println(newList);

        // Comparator: sort a list
        System.out.println("\n=== Comparator ===");
        Comparator<String> descOrder = (s1, s2) -> s2.compareTo(s1);
        List<String> names = new ArrayList<>(Arrays.asList("zaveed", "gopal", "ram", "arun"));
        names.sort(descOrder);
        System.out.println("Sorted descending: " + names);

        // Comparator.comparing with method reference
        names.sort(Comparator.comparing(String::length));
        System.out.println("Sorted by length:  " + names);
    }
}
