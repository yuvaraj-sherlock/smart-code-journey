package com.codejourney.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Custom pattern finding and fix the problem*/

/*
Important methods:
      Arrays.toString(array); //To print array

*/

public class CustomPattern {
  public static void main(String[] args) {

    int[] input = {36,11,6,9,45,4};
    arraySortAndSwapPattern(input);

    int[] input2 = {0,1,0,3,12};
    moveZerosToEndOfArray(input2);
  }

  /*Input: 36,11,6,9,45,4
  Output: 6,4,11,9,45,36
  Pattern: a1>a2<a3>a4<a5*/
  private static void arraySortAndSwapPattern(int[] input) {
    Arrays.sort(input);
    System.out.println(Arrays.toString(input));
    for(int i=0;i<input.length;i++){
      if((i%2==0) && (i+1<input.length)){
        int temp=input[i];
        input[i]=input[i+1];
        input[i+1]=temp;
      }
    }
    System.out.println(Arrays.toString(input));
  }

  //  Input: [0,1,0,3,12] → Output: [1,3,12,0,0]
  private static void moveZerosToEndOfArray(int[] input2) {
    //1st approach:
    List<Integer> list = new ArrayList<>();
    int zeroCount = 0;
    for (int i : input2) {
      if (i == 0) {
        zeroCount++;
      } else {
        list.add(i);
      }
    }
    for (int i = 0; i < zeroCount; i++) {
      list.add(0);
    }
    System.out.println(list);

    //2nd approach:
    int currentPos = 0;
    for (int i : input2) {
      if (i != 0) {
        input2[currentPos++] = i;
      }
    }
    for (int i = currentPos; i < input2.length; i++) {
      input2[currentPos++] = 0;
    }
    Arrays.stream(input2).forEach(num -> System.out.print(num + ","));
  }
}
