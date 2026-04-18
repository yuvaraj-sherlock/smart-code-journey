package com.codejourney.core;

import java.util.List;

public class FindMissingNumber {

    public static Integer findMissingNumber(List<Integer> list){
        int n = list.size();
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int i : list) {
            actualSum += i;
        }
        return expectedSum - actualSum;
    }
}