package com.codejourney.core;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;


record Person(String name,int age){

}

public class FIDemo {
    public static void main(String[] args) {

        /*List<String> list = new ArrayList<>();
        list.add("Arun");
        list.add("Zaveed");
        list.add("Charan");
        list.add("Bharath");

        Predicate<String> predicate = (names -> (names.startsWith("A")|| names.startsWith("Z")));
       // Function<String,String> function = (name -> (name.toUpperCase()));
        Function<String,String> function = (String::toUpperCase);

        List<String> collect = list.stream().filter(predicate).collect(Collectors.toList());
        System.out.println(collect);
        List<String> collect1 = collect.stream().map(function).collect(Collectors.toList());
        System.out.println(collect1);*/

        //Scenario: Filter a list of integers to find even numbers and numbers greater than 10.
       /* List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 10, 11, 12, 15, 20);
        System.out.println("Given numbers: "+numbers);*/

        //1st approach
        /*List<Integer> collect = numbers.stream().filter(num -> (num > 10 && num % 2 == 0)).collect(Collectors.toList());
        System.out.println("The result is: "+collect);*/

        //2nd approach
        /*Predicate<Integer> p1 = num -> num %2 ==0;
        Predicate<Integer> p2 = num -> num>10;
        Predicate<Integer> p3 = p1.and(p2);
        List<Integer> collect = numbers.stream().filter(p3).collect(Collectors.toList());
        System.out.println(collect);*/

        //Scenario: Transform a list of strings to their lengths
        /*List<String> words = Arrays.asList("hello", "world", "java", "programming", "lambda");
        Function<String,Integer> function = (str)-> str.length();
        Function<String, Integer> stringIntegerFunction = function.andThen(length -> length + 5);
        List<Integer> collect = words.stream().map(stringIntegerFunction).collect(Collectors.toList());
        System.out.println(collect);*/

        //Scenario: Convert a list of Person objects to a list of their names.
       /* List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        );
        Function<Person, String> function = (person)-> person.getName();
        List<String> collect = people.stream().map(function).collect(Collectors.toList());
        System.out.println(collect);*/

       // Scenario : From a list of integers, keep only even numbers, remove duplicates, square them, and print.
       /* List<Integer> numbers = Arrays.asList(2, 4, 4, 6, 8, 8, 10);
        numbers.stream().filter(num -> num%2==0).distinct().map(num->num*num).forEach(System.out::println);
*/
        //Scenario: From a list of names, collect only unique names as a Set.
       /* List<String> names = Arrays.asList("Ram", "Shyam", "Ram", "Mohan", "Shyam");
        Set<String> collect = names.stream().collect(Collectors.toSet());
        System.out.println(collect);

        //Same Scenario but order should be preserved.
        List<String> collect1 = names.stream().distinct().collect(Collectors.toList());
        System.out.println(collect1);

        LinkedHashSet<String> collect2 = names.stream().collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(collect2);*/

        //Scenario: Count how many unique numbers are present in the list.
       /* List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6, 6);
        long count = numbers.stream().distinct().count();
        System.out.println(count);*/

        //Scenario: From a list of words ["Java", "Streams", "Streams", "Fun", "Java", "Practice"]
        //Print unique words with their length.Preserve the order.
        /*List<String> words = Arrays.asList("Java", "Streams", "Streams", "Fun", "Java", "Practice");
        words.stream().distinct().collect(Collectors.toList()).forEach(word -> System.out.println( word +" length: "+word.length()));*/

        //Scenario: From numbers 1, 2, 2, 3, 4, 4, 5, 6
        //Keep only unique numbers.
        //Filter numbers greater than 3.
        //Sum them.

        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6);
        int sum = numbers.stream().distinct().filter(num -> num > 3).mapToInt(Integer::intValue).sum();
        System.out.println(sum);

    }
}