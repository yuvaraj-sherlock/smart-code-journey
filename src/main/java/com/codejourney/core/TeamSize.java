package com.codejourney.core;

import java.util.Map;

public class TeamSize {

    static Map<String,String> teamMap = Map.of("A", "B",
            "C", "D",
            "E", "F",
            "G", "H",
            "I", "J",
            "K", "L",
            "B", "M",
            "D", "O",
            "M", "P");
    static int count =0;

    public static int findTeamSize(String manager){
        if(teamMap.containsKey(manager)){
            count++;
            System.out.print(teamMap.get(manager)+" ");
            findTeamSize(teamMap.get(manager));
        }
        return count;
    }
}