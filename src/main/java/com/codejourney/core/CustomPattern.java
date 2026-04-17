package com.codejourney.core;

import java.util.Arrays;

/*Custom pattern finding and fix the problem*/

/*
Important methods:
      Arrays.toString(array); //To print array
*/

public class CustomPattern {
  public static void main(String[] args) {

    int[] input = {36,11,6,9,45,4};
    arraySortAndSwapPattern(input);
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
}
