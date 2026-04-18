package com.codejourney.arrays;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Problem: Find duplicate elements in an integer array.
 *
 * Approach (Stream - Primary):
 *   Group elements by identity and count occurrences using Collectors.groupingBy.
 *   Filter entries where count > 1 to isolate duplicates.
 *
 * Approach (HashSet):
 *   Use a HashSet; if Set.add() returns false, the element is a duplicate.
 *
 * Approach (Nested Loop - Brute Force):
 *   Compare every pair of elements using two nested loops.
 *
 * Approach (Sorting):
 *   Sort the array; adjacent equal elements are duplicates.
 *
 * Important Methods:
 *   Arrays.stream(array).boxed()
 *   Collectors.groupingBy(Function.identity(), Collectors.counting())
 *   map.entrySet().stream().filter(entry -> entry.getValue() > 1)
 *   Map.Entry::getKey
 *   set.add(element) // returns false if already present
 */
public class ArrayDuplicateFinder {

    public static void main(String[] args) {
        int[] inputArray = {111, 333, 555, 777, 333, 444, 555};
        System.out.println("Input: " + Arrays.toString(inputArray));

        System.out.println("\n--- Stream Approach ---");
        findDuplicatesUsingStream(inputArray);

        System.out.println("\n--- HashSet Approach ---");
        findDuplicatesUsingHashSet(inputArray);

        System.out.println("\n--- Sorting Approach ---");
        findDuplicatesUsingSorting(inputArray.clone());
    }

    /** Stream approach: group by identity, filter count > 1 */
    private static void findDuplicatesUsingStream(int[] input) {
        Map<Integer, Long> frequencyMap = Arrays.stream(input)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Integer> duplicates = frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Duplicate elements: " + duplicates);
    }

    /** HashSet approach: add() returns false for already-seen elements */
    private static void findDuplicatesUsingHashSet(int[] input) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();
        for (int num : input) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        System.out.println("Duplicate elements: " + duplicates);
    }

    /** Sorting approach: sort first, then compare adjacent elements */
    private static void findDuplicatesUsingSorting(int[] input) {
        Arrays.sort(input);
        Set<Integer> duplicates = new LinkedHashSet<>();
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] == input[i + 1]) {
                duplicates.add(input[i]);
            }
        }
        System.out.println("Duplicate elements: " + duplicates);
    }
}
