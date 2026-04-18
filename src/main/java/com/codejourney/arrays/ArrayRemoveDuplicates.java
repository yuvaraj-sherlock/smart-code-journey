package com.codejourney.arrays;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: Remove duplicate elements from an integer array while preserving
 *          insertion order.
 *
 * Approach (Stream + distinct - Primary):
 *   Use Arrays.stream(input).distinct() to eliminate duplicates.
 *   Box to Integer and collect to a List.
 *
 * Approach (Stream + LinkedHashSet):
 *   Collect to a LinkedHashSet via Collectors.toCollection(),
 *   which both deduplicates and preserves insertion order.
 *
 * Approach (Manual HashSet):
 *   Iterate the array; use a HashSet to track seen elements.
 *   Add unseen elements to the result list.
 *
 * Important Methods:
 *   Arrays.stream(input).distinct()
 *   .boxed()
 *   Collectors.toList()
 *   Collectors.toCollection(LinkedHashSet::new)
 *   set.add(element)           // returns false if already present
 */
public class ArrayRemoveDuplicates {

    public static void main(String[] args) {
        int[] input = {1, 2, 2, 3, 4, 5, 5, 3, 6, 6, 1};
        System.out.println("Input: " + Arrays.toString(input));

        System.out.println("\n--- Stream + distinct() Approach ---");
        removeDuplicatesUsingStream(input);

        System.out.println("\n--- Stream + LinkedHashSet Approach ---");
        removeDuplicatesUsingLinkedHashSet(input);

        System.out.println("\n--- Manual HashSet Approach ---");
        removeDuplicatesManually(input);
    }

    /** Stream distinct(): simplest one-liner for deduplication */
    private static void removeDuplicatesUsingStream(int[] input) {
        List<Integer> result = Arrays.stream(input)
                .distinct()
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Without duplicates: " + result);
    }

    /** LinkedHashSet: deduplicates and guarantees insertion-order */
    private static void removeDuplicatesUsingLinkedHashSet(int[] input) {
        LinkedHashSet<Integer> result = Arrays.stream(input)
                .boxed()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println("Without duplicates (order preserved): " + result);
    }

    /** Manual approach: classic HashSet seen-check loop */
    private static void removeDuplicatesManually(int[] input) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int num : input) {
            if (seen.add(num)) {
                result.add(num);
            }
        }
        System.out.println("Without duplicates: " + result);
    }
}
