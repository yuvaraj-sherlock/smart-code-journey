package com.codejourney.core;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayRemoveDuplicateSequence {
    public static void main(String[] args) {

      //Stream approach:
      int[] input = {1,2,2,3,4,5,5,3,6,6,1};
      List<Integer> collect = Arrays.stream(input)
              .distinct()
              .boxed()
              .collect(Collectors.toList());
      System.out.println(collect);

      LinkedHashSet<Integer> collect1 = Arrays.stream(input)
              .boxed()
              .collect(Collectors.toCollection(LinkedHashSet::new));
      System.out.println(collect1);

      /*  Integer arr[]={1,2,2,3,4,5,5,3,6,6,1};
        List<Integer> list = new ArrayList<>(List.of(arr));
        System.out.println(list);
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<list.size();i++){
            Integer i1 = list.get(i);
            if(!set.add(i1)){
                list.set(i,null);
                list.remove(i1);
            }
        }
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            if(iterator.next() == null)
                iterator.remove();
        }
        System.out.println(list);
*/
    }
}