package com.codejourney.core;
import java.util.*;
record Student(int id,String name,int marks){
}
public class Comparator8Demo {
    public static void main(String[] args) {

        /*Comparator<String> comparator = (s1,s2)-> s1.compareTo(s2);
        List<String> list = new ArrayList<>();
        list.add("Arun");
        list.add("Zaveed");
        list.add("Charan");
        list.add("Bharath");
        list.sort(comparator);
        System.out.println(list);*/

        Student std1 = new Student(1,"raju",66);
        Student std2 = new Student(2,"govind",75);
        Student std3 = new Student(3,"gopal",49);
        Student std4 = new Student(4,"mohan",89);
        List<Student> list = new ArrayList<>();
        list.add(std1);
        list.add(std2);
        list.add(std3);
        list.add(std4);

       /* Comparator<Student> comparator = (s1,s2)->s1.getMarks()-s2.getMarks();

        list.sort(comparator);
        System.out.println(list);*/

      //Stream approach:
      List<Student> list1 = list.stream()
              .sorted(Comparator.comparing(std -> std.marks()))
              .toList();
      System.out.println(list1);
    }
}