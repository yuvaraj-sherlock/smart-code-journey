package com.codejourney.core;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class ArrayIntersectionFinder {
    public static void main(String[] args) {
        String[] s1 = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "FOUR"};
        String[] s2 = {"THREE", "FOUR", "FIVE", "SIX", "SEVEN", "FOUR"};

        //Stream approach:
      Set<String> set = new HashSet<>(Arrays.asList(s1));
      Set<String> collect = Arrays.stream(s2)
              .filter(str -> set.contains(str))
              .collect(Collectors.toSet());
      System.out.println(collect);


      // 1st approach
       /* List<String> list1 = Arrays.asList(s1);
        List<String> list2 = Arrays.asList(s2);
        Set<String> set = new HashSet<>();
        for(String str:list1){
            if(list2.contains(str)){
                set.add(str);
            }
        }
        System.out.println(set);*/

        // 2nd approach
       /* Set<String> set = new HashSet<>();
        for(int i=0;i<s1.length;i++){
            for(int j=0;j<s2.length;j++){
                if(s1[i].equals(s2[j])){
                    set.add(s1[i]);
                }
            }
        }
        System.out.println(set);*/


    }
}