package com.codejourney.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyCalc {
    public static void main(String[] args) {
        /*Write a java program to find frequency of each element in an array or a list with/without using stream API?
       List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil","Paper clip", "Stapler", "Note Book", "Pencil","Paper clip");
*/
        //Traditional approach
        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen",
                "Pencil","Paper clip", "Stapler", "Note Book", "Pencil","Paper clip");
       /* Map<String,Integer> map = new HashMap<>();
        for(String input: stationeryList){
           map.put(input,map.getOrDefault(input,0)+1);
        }
        System.out.println(map);*/

        //Java8
        Map<String, Long> collect = stationeryList.stream().collect(Collectors.groupingBy(item -> item, Collectors.counting()));
        System.out.println(collect);


    }
}