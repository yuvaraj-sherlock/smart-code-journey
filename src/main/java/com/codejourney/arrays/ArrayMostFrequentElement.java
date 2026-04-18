package com.codejourney.arrays;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Problem: Find the most frequently occurring element in an integer array.
 *
 * Approach (Stream - Primary):
 *   Use Collectors.groupingBy with Collectors.counting() to build a frequency map.
 *   Then stream the entry set and find the entry with the maximum count value
 *   using Map.Entry.comparingByValue().
 *
 * Approach (HashMap - Traditional):
 *   Manually build a frequency map using HashMap.
 *   Iterate the entry set to find the entry with the highest frequency.
 *
 * Important Methods:
 *   Arrays.stream(input).boxed()
 *   Collectors.groupingBy(Function.identity(), Collectors.counting())
 *   collect.entrySet().stream().max(Map.Entry.comparingByValue())
 *   Optional.get()
 *   map.containsKey(key)
 *   map.getOrDefault(key, defaultValue)
 */
public class ArrayMostFrequentElement {

    public static void main(String[] args) {
        int[] input = {4, 5, 8, 7, 4, 7, 6, 7};
        System.out.println("Input: " + Arrays.toString(input));

        System.out.println("\n--- Stream Approach ---");
        findMostFrequentUsingStream(input);

        System.out.println("\n--- HashMap Approach ---");
        findMostFrequentUsingHashMap(input);
    }

    /** Stream approach: build frequency map, then pick max by value */
    private static void findMostFrequentUsingStream(int[] input) {
        Map<Integer, Long> frequencyMap = Arrays.stream(input)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map.Entry<Integer, Long> mostFrequent = frequencyMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get();

        System.out.println("Most frequent element: " + mostFrequent.getKey()
                + " | Frequency: " + mostFrequent.getValue());
    }

    /** HashMap approach: manually track counts and find the maximum */
    private static void findMostFrequentUsingHashMap(int[] input) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : input) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int element = 0;
        int maxFrequency = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                element = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }
        System.out.println("Most frequent element: " + element
                + " | Frequency: " + maxFrequency);
    }
}
