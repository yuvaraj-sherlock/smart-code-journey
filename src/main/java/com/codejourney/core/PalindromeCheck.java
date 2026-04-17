package com.codejourney.core;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*Can palindrome be formed? Given a string, check if palindrome can be formed by rearranging its characters.
Ex1. string: bangalore ans : false
Ex2. string: abdybayd ans : true because string can be rearranged as abdyydba*/

/*
Important methods:
      string.chars().mapToObj(c->(char)c)
      Function.identity()
      Collectors.counting()
      map.entrySet()
*/

public class PalindromeCheck {
  public static void main(String[] args) {
    String str = "abdybayd";
    Map<Character, Long> map = str.chars().mapToObj(c -> (char) c)
            .collect(
                    Collectors.groupingBy(
                            Function.identity(),
                            Collectors.counting()));
    long count = map.entrySet()
            .stream()
            .filter(entry -> entry.getValue() == 1)
            .count();
    if (count > 1) {
      System.out.println("The given string: " + str + " is not formed a palindrome");
    } else {
      System.out.println("The given string: " + str + " is formed a palindrome");
    }
  }
}
