package com.codejourney.core;

import java.util.*;
import java.util.stream.IntStream;

// Merge two arrays in Java and sort the merged array.
// This example also demonstrates how to remove duplicates from the merged array.
// The merged array is sorted in ascending order.
// The example uses ArrayList and TreeSet to achieve this.
// The merged array is printed in the end.
// The example uses Integer type for the arrays, but it can be modified to use other types as well.
// The example is a simple demonstration of merging and sorting arrays in Java.
public class ArrayMerge {
    public static void main(String[] args) {

      //Stream approach:
      int[] arr1 = {12, -7, 18, 9, 37, -1, 21};
      int[] arr2 = {27, 8, 71, -9, 18};

      int[] array = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
              .sorted()
              .toArray();
      System.out.println(Arrays.toString(array));

       /* Integer[] arrayA = new Integer[] {12, -7, 18, 9, 37, -1, 21};
        Integer[] arrayB = new Integer[] {27, 8, 71, -9, 18};

        List<Integer> list = new ArrayList<>(arrayA.length+arrayB.length);
        list.addAll(Arrays.asList(arrayA));
        list.addAll(Arrays.asList(arrayB));
        Collections.sort(list);

        Integer[] mergedArray = new Integer[arrayA.length+arrayB.length];
        for(int i =0;i<mergedArray.length;i++){
            mergedArray[i] = list.get(i);
        }
        System.out.println(Arrays.toString(mergedArray));

        //without duplicates
        Set<Integer> set = new TreeSet<Integer>(List.of(mergedArray));
        System.out.println(set);*/
    }

}