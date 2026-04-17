package com.codejourney.core;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Important methods:
      string.chars().mapToObj(c->(char)c)
      Function.identity()
      Collectors.counting()
      map.entrySet()
*/

public class PalindromeCheck {
  public static void main(String[] args) {
    String str = "abdybaydgh";
    Map<Character, Long> map = str.chars().mapToObj(c -> (char) c)
            .collect(
                    Collectors.groupingBy(
                            Function.identity(),
                            Collectors.counting()));
    int counter = 0;
    for (Map.Entry<Character, Long> entries : map.entrySet()) {
      if (entries.getValue() == 1) {
        counter++;
      }
    }
    if (counter > 1) {
      System.out.println("The given string: " + str + " is not formed a palindrome");
    } else {
      System.out.println("The given string: " + str + " is formed a palindrome");
    }
  }
}
