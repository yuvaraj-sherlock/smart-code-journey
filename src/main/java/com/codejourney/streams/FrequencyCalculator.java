package com.codejourney.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: Find the frequency (occurrence count) of each element in a list.
 *
 * NOTE: This is distinct from ArrayMostFrequentElement (which finds only the
 *       single highest-frequency element in an int[]). This class produces a
 *       complete frequency map for a List<String> or any List<T>.
 *
 * Approach (Stream - Primary):
 *   Use Collectors.groupingBy(item -> item, Collectors.counting()) to build
 *   a Map<T, Long> where each key maps to its total count.
 *
 * Approach (Traditional HashMap):
 *   Iterate the list and use map.getOrDefault(key, 0) + 1 to increment counts.
 *
 * Important Methods:
 *   Collectors.groupingBy(Function.identity(), Collectors.counting())
 *   map.getOrDefault(key, defaultValue)
 *   Map<String, Long>   // stream result type
 *   Map<String, Integer> // traditional result type
 */
public class FrequencyCalculator {

    public static void main(String[] args) {
        List<String> stationery = Arrays.asList(
                "Pen", "Eraser", "Note Book", "Pen",
                "Pencil", "Paper clip", "Stapler",
                "Note Book", "Pencil", "Paper clip");

        System.out.println("Input: " + stationery);

        System.out.println("\n--- Stream Approach (Map<String, Long>) ---");
        frequencyUsingStream(stationery);

        System.out.println("\n--- Traditional HashMap Approach ---");
        frequencyUsingHashMap(stationery);

        // Integer list scenario
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5, 5);
        System.out.println("\nInput: " + numbers);
        System.out.println("\n--- Integer Frequency (Stream) ---");
        Map<Integer, Long> intFreq = numbers.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        System.out.println(intFreq);
    }

    /** Stream: Collectors.groupingBy + counting — one-liner */
    private static void frequencyUsingStream(List<String> list) {
        Map<String, Long> frequencyMap = list.stream()
                .collect(Collectors.groupingBy(item -> item, Collectors.counting()));
        frequencyMap.forEach((item, count) ->
                System.out.println("  " + item + " → " + count));
    }

    /** Traditional: getOrDefault increments count for each element */
    private static void frequencyUsingHashMap(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        frequencyMap.forEach((item, count) ->
                System.out.println("  " + item + " → " + count));
    }
}
