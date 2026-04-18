package com.codejourney.core;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.random.RandomGenerator;

public class InbuiltFIsDemo {
    public static void main(String[] args) {
        /*Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("Y");
            }
        };
        System.out.println(predicate.test("Yuvaraj"));*/

        /*Predicate<String> predicate = string -> string.startsWith("Y");
        System.out.println(predicate.test("Y"));*/

        /*Function<String,String> function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };
        System.out.println(function.apply("yuvaraj"));*/

       /* Function<String, String> function = string -> string.toUpperCase();
        System.out.println(function.apply("govind"));*/

       /* Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Given String is: "+s);
            }
        };
       consumer.accept("Input Yuvaraj");*/
       /*Consumer<String> consumer = System.out::println;
       consumer.accept("Yuvaraj");*/

        /*Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt();
            }
        };
        System.out.println(supplier.get());*/

        /*Supplier<Integer> supplier = ()-> new Random().nextInt();
        System.out.println(supplier.get());*/

       /* Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };*/
        /*Comparator<String> comparator = (s1,s2) -> s2.compareTo(s1);
        List<String> list = Arrays.asList("zaveed", "gopal", "ram");
        list.sort(comparator);
        System.out.println(list);*/



    }
}