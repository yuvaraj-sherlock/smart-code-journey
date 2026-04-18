package com.codejourney.core;

import java.util.*;

/**
 * Utility class to find the smallest and second smallest numbers in an array.
 */
public class ArraySmallestNumberFind {
    /**
     * The main method demonstrates how to find the smallest and second smallest numbers
     * in an array of integers. It removes duplicates, sorts the numbers, and prints the results.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
      //Stream approach:
      int[] input =  {-9, 3, 36, -25, -9, 71, 0};
      Arrays.stream(input)
              .sorted()
              .limit(2)
              .forEach(System.out::println);

       /* Integer[] integers = {-9, 3, 36, -25, -9, 71, 0};
        List<Integer> list = new ArrayList<>(new TreeSet<>(Arrays.asList(integers)));

        System.out.println("Smallest number: "+list.get(0));
        System.out.println("Second Smallest number: "+list.get(1));

        int[] arr = {-9, 3, 36, -25, -9, 71, 0};
        Arrays.stream(arr).distinct().sorted().limit(2).forEach(num -> System.out.println(num));*/

    }
}