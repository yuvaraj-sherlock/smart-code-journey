package com.codejourney.core;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstUniqueChar {

    public static Character findFirstUniqueChar(String str){
        char[] charInput = str.toCharArray();
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int index = 0; index < charInput.length; index++){
            if(map.containsKey(charInput[index])){
                map.put(charInput[index],map.get(charInput[index]).intValue()+1);
            }else{
                map.put(charInput[index],1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue()>1){
                return entry.getKey();
            }
        }
        return null;
    }
}