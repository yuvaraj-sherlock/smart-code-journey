package com.codejourney.arrays;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Problem: Merge two integer arrays and sort the result in ascending order.
 *          Optionally remove duplicates from the merged array.
 *
 * Approach (Stream - Primary):
 *   Use IntStream.concat() to combine both primitive int streams,
 *   then call .sorted() and .toArray() in one pipeline.
 *
 * Approach (ArrayList + Collections.sort):
 *   Add both arrays to an ArrayList and sort using Collections.sort().
 *   For deduplication, wrap in a TreeSet (maintains sorted order).
 *
 * Important Methods:
 *   IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
 *   .sorted()
 *   .toArray()
 *   Arrays.toString(array)
 *   new TreeSet<>(list)        // sorted + deduplicated
 *   Collections.sort(list)
 */
public class ArrayMergeAndSort {

    public static void main(String[] args) {
        int[] arr1 = {12, -7, 18, 9, 37, -1, 21};
        int[] arr2 = {27, 8, 71, -9, 18};

        System.out.println("Array 1: " + Arrays.toString(arr1));
        System.out.println("Array 2: " + Arrays.toString(arr2));

        System.out.println("\n--- Stream Approach (with duplicates) ---");
        mergeAndSortUsingStream(arr1, arr2);

        System.out.println("\n--- ArrayList Approach (with duplicates) ---");
        mergeAndSortUsingList(arr1, arr2);

        System.out.println("\n--- Merge Without Duplicates (TreeSet) ---");
        mergeAndSortWithoutDuplicates(arr1, arr2);
    }

    /** Stream approach: concise single-pipeline merge and sort */
    private static void mergeAndSortUsingStream(int[] arr1, int[] arr2) {
        int[] merged = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                .sorted()
                .toArray();
        System.out.println("Merged & Sorted: " + Arrays.toString(merged));
    }

    /** ArrayList approach: explicit merge then Collections.sort */
    private static void mergeAndSortUsingList(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        for (int n : arr1) list.add(n);
        for (int n : arr2) list.add(n);
        Collections.sort(list);
        System.out.println("Merged & Sorted: " + list);
    }

    /** TreeSet approach: merge, deduplicate, and auto-sort */
    private static void mergeAndSortWithoutDuplicates(int[] arr1, int[] arr2) {
        Set<Integer> treeSet = new TreeSet<>();
        for (int n : arr1) treeSet.add(n);
        for (int n : arr2) treeSet.add(n);
        System.out.println("Merged, Sorted & Deduplicated: " + treeSet);
    }
}
