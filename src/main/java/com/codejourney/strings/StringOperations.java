package com.codejourney.strings;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A consolidated class for common String and character-level coding problems.
 *
 * Problems covered:
 *   1. Group integers into Even and Odd buckets
 *   2. Find the first non-repeating character in a String
 *   3. Remove duplicate characters from a String (preserve order)
 *   4. Find duplicate characters in a String
 *   5. Find the digit-sum of a numeric String
 *
 * NOTE: FirstUniqueChar.java has been removed — it contained a logic bug
 *       (used > 1 which finds the first *repeated* char, not the first *unique* one).
 *       The correct stream-based solution is implemented here in Problem 2.
 *
 * Important Methods:
 *   Arrays.stream(array).boxed()
 *   Collectors.groupingBy(key, Collectors.counting())
 *   str.chars().mapToObj(c -> (char) c)
 *   str.toCharArray()
 *   Function.identity()
 *   .distinct()
 *   String::valueOf
 *   Collectors.joining()
 *   Character::getNumericValue
 *   .mapToInt(...).sum()
 */
public class StringOperations {

    public static void main(String[] args) {

        // Problem 1: Group integers into Even / Odd
        System.out.println("=== Problem 1: Group Even & Odd ===");
        int[] numbers = {1, 2, 3, 4, 5, 6};
        groupEvenAndOdd(numbers);

        // Problem 2: First non-repeating character
        System.out.println("\n=== Problem 2: First Non-Repeating Character ===");
        findFirstNonRepeatingChar("swiss");
        findFirstNonRepeatingChar("aabbcc");

        // Problem 3: Remove duplicate characters
        System.out.println("\n=== Problem 3: Remove Duplicate Characters ===");
        removeDuplicateChars("helloworld");

        // Problem 4: Find duplicate characters
        System.out.println("\n=== Problem 4: Find Duplicate Characters ===");
        findDuplicateChars("helloworld");

        // Problem 5: Sum of digits in a number string
        System.out.println("\n=== Problem 5: Sum of Digits ===");
        findSumOfDigits("123456789");
    }

    /**
     * Problem 1 — Group Even & Odd:
     * Stream the int array, box to Integer, then groupingBy with a ternary
     * key function to partition into "Even" and "Odd" lists.
     */
    private static void groupEvenAndOdd(int[] input) {
        Map<String, List<Integer>> grouped = Arrays.stream(input)
                .boxed()
                .collect(Collectors.groupingBy(num -> num % 2 == 0 ? "Even" : "Odd"));
        System.out.println(grouped);
    }

    /**
     * Problem 2 — First Non-Repeating Character:
     * Build a frequency map (character → count) using streams.
     * Then iterate the original string in order and return the first
     * character whose count is exactly 1.
     * This preserves the original order of characters.
     */
    private static void findFirstNonRepeatingChar(String input) {
        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        char firstNonRepeating = ' ';
        for (char c : input.toCharArray()) {
            if (frequencyMap.get(c) == 1) {
                firstNonRepeating = c;
                break;
            }
        }
        System.out.println("Input: \"" + input + "\" → First non-repeating char: '"
                + (firstNonRepeating == ' ' ? "none" : firstNonRepeating) + "'");
    }

    /**
     * Problem 3 — Remove Duplicate Characters:
     * Stream characters, apply .distinct() to keep only first occurrences,
     * map each char to a String, then join into a single result String.
     */
    private static void removeDuplicateChars(String input) {
        String result = input.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println("Input: \"" + input + "\" → Without duplicates: \"" + result + "\"");
    }

    /**
     * Problem 4 — Find Duplicate Characters:
     * Build a frequency map, then filter for characters whose count > 1.
     */
    private static void findDuplicateChars(String input) {
        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Character> duplicates = frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Input: \"" + input + "\" → Duplicate chars: " + duplicates);
    }

    /**
     * Problem 5 — Sum of Digits:
     * Stream the characters of the numeric string, convert each char
     * to its numeric value using Character::getNumericValue, then sum.
     */
    private static void findSumOfDigits(String number) {
        int sum = number.chars()
                .mapToObj(c -> (char) c)
                .mapToInt(Character::getNumericValue)
                .sum();
        System.out.println("Input: \"" + number + "\" → Digit sum: " + sum);
    }
}
