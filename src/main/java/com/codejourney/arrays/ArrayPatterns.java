package com.codejourney.arrays;

import java.util.*;

/**
 * Problem 1 — Sort & Swap Pattern:
 *   Given {36,11,6,9,45,4}, sort the array and then rearrange it so that
 *   elements alternate as: smaller, larger, smaller, larger...
 *   (i.e., swap each adjacent pair at even indices).
 *   Input: {36,11,6,9,45,4}  →  Sorted: {4,6,9,11,36,45}  →  Output: {6,4,11,9,45,36}
 *
 * Problem 2 — Move Zeros to End:
 *   Move all zero elements to the end of the array while preserving
 *   the relative order of non-zero elements.
 *   Input: {0,1,0,3,12}  →  Output: {1,3,12,0,0}
 *
 * Approach (Sort & Swap):
 *   Sort the array first, then iterate with step 2; swap arr[i] and arr[i+1]
 *   at every even index.
 *
 * Approach (Move Zeros — List):
 *   Collect non-zero elements in a list, count zeros, append zeros at the end.
 *
 * Approach (Move Zeros — Two-Pointer):
 *   Use a write pointer (currentPos). Overwrite with non-zero elements,
 *   then fill remaining positions with zeros in-place.
 *
 * Important Methods:
 *   Arrays.sort(array)
 *   Arrays.toString(array)
 *   Arrays.stream(array).forEach(...)
 *   Two-pointer in-place technique
 */
public class ArrayPatterns {

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Sort & Swap Pattern ===");
        int[] input1 = {36, 11, 6, 9, 45, 4};
        System.out.println("Input: " + Arrays.toString(input1));
        arraySortAndSwapPattern(input1);

        System.out.println("\n=== Problem 2: Move Zeros to End ===");
        int[] input2 = {0, 1, 0, 3, 12};
        System.out.println("Input: " + Arrays.toString(input2));

        System.out.println("\n-- List Approach --");
        moveZerosUsingList(input2.clone());

        System.out.println("\n-- Two-Pointer In-Place Approach --");
        moveZerosTwoPointer(input2.clone());
    }

    /**
     * Sort & Swap Pattern:
     * After sorting, swap adjacent pairs at even indices (0-1, 2-3, 4-5...)
     * to produce the alternating smaller-larger pattern.
     */
    private static void arraySortAndSwapPattern(int[] input) {
        Arrays.sort(input);
        System.out.println("After sort: " + Arrays.toString(input));

        for (int i = 0; i < input.length - 1; i += 2) {
            int temp = input[i];
            input[i] = input[i + 1];
            input[i + 1] = temp;
        }
        System.out.println("After swap pattern: " + Arrays.toString(input));
    }

    /**
     * Move Zeros — List approach:
     * Separate non-zeros and zero count, then reconstruct the array.
     */
    private static void moveZerosUsingList(int[] input) {
        List<Integer> result = new ArrayList<>();
        int zeroCount = 0;
        for (int num : input) {
            if (num == 0) zeroCount++;
            else result.add(num);
        }
        for (int i = 0; i < zeroCount; i++) result.add(0);
        System.out.println("Result: " + result);
    }

    /**
     * Move Zeros — Two-pointer in-place:
     * Write pointer tracks the next position for a non-zero value.
     * After placing all non-zeros, fill remaining slots with 0.
     */
    private static void moveZerosTwoPointer(int[] input) {
        int writePos = 0;
        for (int num : input) {
            if (num != 0) {
                input[writePos++] = num;
            }
        }
        while (writePos < input.length) {
            input[writePos++] = 0;
        }
        System.out.println("Result: " + Arrays.toString(input));
    }
}
