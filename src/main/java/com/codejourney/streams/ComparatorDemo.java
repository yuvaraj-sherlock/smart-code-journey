package com.codejourney.streams;

import java.util.*;

/**
 * Problem: Sort a list of Student objects by their marks using the Java 8
 *          Comparator API — both ascending and descending.
 *
 * Approach (Stream - Primary):
 *   Use list.stream().sorted(Comparator.comparing(Student::marks)) to sort
 *   in ascending order and .reversed() for descending.
 *
 * Approach (Lambda Comparator - Classic):
 *   Define an explicit Comparator lambda: (s1, s2) -> s1.marks() - s2.marks()
 *   and pass it to list.sort().
 *
 * Note: Java 16+ records are used here for Student — they auto-generate
 *       constructor, getters (as accessor methods), equals, hashCode, toString.
 *
 * Important Methods:
 *   record Student(int id, String name, int marks) {}
 *   Comparator.comparing(Student::marks)
 *   .reversed()
 *   list.stream().sorted(comparator).toList()
 *   list.sort(comparator)
 */
public class ComparatorDemo {

    record Student(int id, String name, int marks) {}

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student(1, "Raju",   66),
                new Student(2, "Govind", 75),
                new Student(3, "Gopal",  49),
                new Student(4, "Mohan",  89)
        );

        // Sort ascending by marks (Stream approach)
        System.out.println("=== Sorted Ascending by Marks (Stream) ===");
        List<Student> ascending = students.stream()
                .sorted(Comparator.comparing(Student::marks))
                .toList();
        ascending.forEach(System.out::println);

        // Sort descending by marks (Stream + reversed)
        System.out.println("\n=== Sorted Descending by Marks (reversed) ===");
        List<Student> descending = students.stream()
                .sorted(Comparator.comparing(Student::marks).reversed())
                .toList();
        descending.forEach(System.out::println);

        // Sort by name alphabetically
        System.out.println("\n=== Sorted by Name (Alphabetical) ===");
        List<Student> byName = students.stream()
                .sorted(Comparator.comparing(Student::name))
                .toList();
        byName.forEach(System.out::println);

        // Lambda Comparator (classic pre-Java-8-stream style)
        System.out.println("\n=== Lambda Comparator (classic list.sort) ===");
        List<Student> mutable = new ArrayList<>(students);
        mutable.sort((s1, s2) -> s1.marks() - s2.marks());
        mutable.forEach(System.out::println);

        // Sort String list descending
        System.out.println("\n=== String List Sorted Descending ===");
        List<String> names = new ArrayList<>(Arrays.asList("Arun", "Zaveed", "Charan", "Bharath"));
        names.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println("Ascending:  " + names);
        names.sort(Comparator.reverseOrder());
        System.out.println("Descending: " + names);
    }
}
