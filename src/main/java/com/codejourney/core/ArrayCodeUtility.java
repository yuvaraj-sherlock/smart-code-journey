package com.codejourney.core;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*Basic Java Coding Exercises using Arrays, Streams and String Operations
 * Implement common Java problems like filtering numbers, string manipulation,
 * and basic data transformations using efficient approaches.*/

/*
Important methods:
      Arrays.stream(array)
      boxed()
      String.chars().mapToObj(c->(char)c)
      String.toCharArray()
      Function.identity()
      Collectors.counting()
      mapToInt(Character::getNumericValue)
            .sum();
*/
public class ArrayCodeUtility {
  public static void main(String[] args) {
    //From the given integers find the even number and odd numbers
    int[] input = {1, 2, 3, 4, 5, 6};
    findEvenOdd(input);

    //Find first nonrepeating character
    String strInput = "swiss";
    findFirstNonRepeatingChar(strInput);

    //To remove duplicates from the given String
    String dup = "helloworld";
    removeDuplicates(dup);

    //find the duplicates from the given String
    findDuplicates(dup);

    //find the sum of the given number
    String number = "123456789";
    findSumOfGivenNumber(number);
  }

  private static void findEvenOdd(int[] input) {
    Map<String, List<Integer>> map = Arrays.stream(input)
            .boxed()
            .collect(Collectors.groupingBy(num -> num % 2 == 0 ? "Even" : "Odd"));
    System.out.println(map);
  }

  private static void findFirstNonRepeatingChar(String strInput) {
    Map<Character, Long> map = strInput.chars().mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    char firstNonRepeatingChar = ' ';
    for (char c : strInput.toCharArray()) {
      if (map.get(c) == 1) {
        firstNonRepeatingChar = c;
        break;
      }
    }
    System.out.println(
            "First non repeating character from the given String: " + strInput + " is: " + firstNonRepeatingChar);
  }

  private static void removeDuplicates(String dup) {
    dup.chars().mapToObj(c -> (char) c)
            .distinct()
            .forEach(System.out::print);
  }

  private static void findDuplicates(String dup) {
    Set<Character> set = new HashSet<>();
    dup.chars().mapToObj(c -> (char) c)
            .map(letter -> {
              if (!set.add(letter)) {
                System.out.println(letter);
              }
              return set;
            })
            .toList();
  }

  private static void findSumOfGivenNumber(String number) {
    int sum = number.chars().mapToObj(c -> (char) c)
            .mapToInt(Character::getNumericValue)
            .sum();
    System.out.println(sum);
  }
}
