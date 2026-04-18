package com.codejourney.arrays;

import java.util.*;

/**
 * Problem 1: Find the smallest and second-smallest numbers in an integer array.
 * Problem 2: Find the second-largest number in an integer array.
 *
 * NOTE: Both problems are grouped here because they share the same core technique —
 *       sort, deduplicate, and pick by index/skip — making them natural interview pairs.
 *
 * Approach (Stream - Primary):
 *   For smallest: stream → sorted() → limit(2) → forEach to print.
 *   For second-largest: stream → distinct() → boxed() → sorted descending → skip(1) → findFirst().
 *
 * Approach (TreeSet - Traditional):
 *   Add elements to a TreeSet (auto-deduplicates and sorts ascending).
 *   Access by index after converting to a List.
 *
 * Important Methods:
 *   Arrays.stream(input).sorted()
 *   .distinct()
 *   .limit(n)
 *   .skip(n)
 *   .findFirst()
 *   .orElseThrow(...)
 *   new TreeSet<>(Arrays.asList(array))   // sorted + deduplicated
 *   Comparator: (a, b) -> b - a          // descending sort
 */
public class ArraySmallestAndLargest {

    public static void main(String[] args) {
        int[] input = {-9, 3, 36, -25, -9, 71, 0};
        System.out.println("Input: " + Arrays.toString(input));

        System.out.println("\n--- Smallest & Second-Smallest (Stream) ---");
        findSmallestUsingStream(input);

        System.out.println("\n--- Smallest & Second-Smallest (TreeSet) ---");
        findSmallestUsingTreeSet(input);

        System.out.println("\n--- Second-Largest (Stream) ---");
        findSecondLargestUsingStream(input);
    }

    /** Stream: sort and limit to first 2 unique elements */
    private static void findSmallestUsingStream(int[] input) {
        System.out.print("Smallest numbers: ");
        Arrays.stream(input)
                .distinct()
                .sorted()
                .limit(2)
                .forEach(num -> System.out.print(num + " "));
        System.out.println();
    }

    /** TreeSet: naturally sorted and deduplicated; pick by index */
    private static void findSmallestUsingTreeSet(int[] input) {
        Integer[] boxed = Arrays.stream(input).boxed().toArray(Integer[]::new);
        List<Integer> sorted = new ArrayList<>(new TreeSet<>(Arrays.asList(boxed)));
        System.out.println("Smallest: " + sorted.get(0));
        System.out.println("Second Smallest: " + sorted.get(1));
    }

    /** Stream: sort descending, skip the largest, take the next */
    private static void findSecondLargestUsingStream(int[] input) {
        int secondLargest = Arrays.stream(input)
                .distinct()
                .boxed()
                .sorted((a, b) -> b - a)
                .skip(1)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Array must contain at least two distinct elements"));
        System.out.println("Second Largest: " + secondLargest);
    }
}
