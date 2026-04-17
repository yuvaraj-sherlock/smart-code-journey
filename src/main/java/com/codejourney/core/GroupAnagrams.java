package com.codejourney.core;
import java.util.*;
import java.util.stream.Collectors;

/*Problem:
Group a list of strings such that each group contains words that are anagrams of each other
(i.e., same characters arranged differently).
      //Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
     //Output: [["bat"], ["tan", "nat"], ["eat", "tea", "ate"]]
*/
/*
Important methods:
      Arrays.asList("List of Strings");
      String.toCharArray();
      Arrays.sort(array);
      map.containsKey(key);
*/
public class GroupAnagrams {
  public static void main(String[] args) {
    List<String> list = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
    beforeJava8Solution(list);
    afterJava8Solution(list);
  }

  private static void beforeJava8Solution(List<String> list) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : list) {
      char[] charArray = str.toCharArray();
      Arrays.sort(charArray);
      String sortedKey = new String(charArray);
      if (!map.containsKey(sortedKey)) {
        map.put(sortedKey, new ArrayList<>());
      }
      map.get(sortedKey).add(str);
    }
    System.out.println("Before Java8: " + map.values());
  }

  private static void afterJava8Solution(List<String> list) {
    Map<String, List<String>> collect = list.stream().collect(Collectors.groupingBy(word -> {
                                        char[] chArray = word.toCharArray();
                                        Arrays.sort(chArray);
                                        return new String(chArray);
                                      }));
    System.out.println("After Java8: " + collect.values());
  }
}
