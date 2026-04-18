package com.codejourney.customObjects;

import java.util.Map;

public class TeamSize {

  static Map<String, String> teamMap = Map.of("A", "B",
          "C", "D",
          "E", "F",
          "G", "H",
          "I", "J",
          "K", "L",
          "B", "M",
          "D", "O",
          "M", "P");
  static int count = 0;

  private static int findTeamSize(String manager) {
    if (teamMap.containsKey(manager)) {
      count++;
      System.out.print(teamMap.get(manager) + " ");
      findTeamSize(teamMap.get(manager));
    }
    return count;
  }

  public static void main(String[] args) {
    //Program to find the total number of subordinates (both direct and indirect) for any given manager
    String manager = "B";
    System.out.println("Manager: " + manager);
    System.out.println("Subordinates: ");
    int count = TeamSize.findTeamSize(manager);
    System.out.println();
    System.out.println("Total Subordinates: " + count);
  }
}