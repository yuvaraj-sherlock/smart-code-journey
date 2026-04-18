package com.codejourney.arrays;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: Find the intersection (common elements) of two String arrays.
 *          The result should not contain duplicates even if elements repeat
 *          across both arrays.
 *
 * Approach (Stream - Primary):
 *   Load the first array into a HashSet for O(1) lookups.
 *   Stream over the second array and filter elements present in the set.
 *   Collect into a Set to automatically deduplicate.
 *
 * Approach (List.contains - Readable):
 *   Convert both arrays to Lists. For each element in list1,
 *   check if list2 contains it and add to a result Set.
 *
 * Approach (Nested Loop - Brute Force):
 *   Compare every pair (s1[i], s2[j]); add to Set on match.
 *
 * Important Methods:
 *   new HashSet<>(Arrays.asList(array))
 *   Arrays.stream(array).filter(str -> set.contains(str))
 *   Collectors.toSet()
 *   list.contains(element)
 */
public class ArrayIntersectionFinder {

    public static void main(String[] args) {
        String[] s1 = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "FOUR"};
        String[] s2 = {"THREE", "FOUR", "FIVE", "SIX", "SEVEN", "FOUR"};

        System.out.println("Array 1: " + Arrays.toString(s1));
        System.out.println("Array 2: " + Arrays.toString(s2));

        System.out.println("\n--- Stream Approach ---");
        findIntersectionUsingStream(s1, s2);

        System.out.println("\n--- List.contains Approach ---");
        findIntersectionUsingList(s1, s2);

        System.out.println("\n--- Nested Loop Approach ---");
        findIntersectionUsingNestedLoop(s1, s2);
    }

    /** Stream approach: O(n+m) — uses HashSet for O(1) lookup */
    private static void findIntersectionUsingStream(String[] s1, String[] s2) {
        Set<String> setFromS1 = new HashSet<>(Arrays.asList(s1));
        Set<String> intersection = Arrays.stream(s2)
                .filter(setFromS1::contains)
                .collect(Collectors.toSet());
        System.out.println("Intersection: " + intersection);
    }

    /** List.contains approach: readable but O(n*m) */
    private static void findIntersectionUsingList(String[] s1, String[] s2) {
        List<String> list1 = Arrays.asList(s1);
        List<String> list2 = Arrays.asList(s2);
        Set<String> intersection = new HashSet<>();
        for (String str : list1) {
            if (list2.contains(str)) {
                intersection.add(str);
            }
        }
        System.out.println("Intersection: " + intersection);
    }

    /** Nested loop approach: O(n*m) brute force */
    private static void findIntersectionUsingNestedLoop(String[] s1, String[] s2) {
        Set<String> intersection = new HashSet<>();
        for (String a : s1) {
            for (String b : s2) {
                if (a.equals(b)) {
                    intersection.add(a);
                }
            }
        }
        System.out.println("Intersection: " + intersection);
    }
}
