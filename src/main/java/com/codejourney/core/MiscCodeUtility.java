package com.codejourney.core;

import java.util.Arrays;

public class MiscCodeUtility {
  public static void main(String[] args) {

    int[] numbers = {5, 3, 8, 1, 4};
    findSecondLargestNumber(numbers);

    //Program to reverse the given sentence
       /* String givenSentence = "hello welcome to spring world";
        String reverseSentence = SentenceReverse.reverseSentence(givenSentence);
        System.out.println(givenSentence);
        System.out.println(reverseSentence);*/

    //Program to find the first non-repeated char from the given string
        /*String givenInput = "success";
        Character firstUniqueChar = FirstUniqueChar.findFirstUniqueChar(givenInput);
        System.out.println(firstUniqueChar);*/

    //Program to Find the Missing Number from Array (0 to n)
        /*List<Integer> list = Arrays.asList(0,3,2,5,4,1);
        int missingNumber = FindMissingNumber.findMissingNumber(list);
        System.out.println(missingNumber);*/

    //Program to find the total number of subordinates (both direct and indirect) for any given manager
    String manager = "B";
    System.out.println("Manager: "+manager);
    System.out.println("Subordinates: ");
    int count = TeamSize.findTeamSize(manager);
    System.out.println();
    System.out.println("Total Subordinates: "+count);
  }

  // Find the second-largest number in an array using Stream API.
  private static void findSecondLargestNumber(int[] numbers) {
    int secondLargest = Arrays.stream(numbers)
            .distinct()
            .boxed()
            .sorted((a, b) -> b - a)
            .skip(1)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Array must contain at least two distinct elements"));
    System.out.println("Second largest number: " + secondLargest);
  }
}
