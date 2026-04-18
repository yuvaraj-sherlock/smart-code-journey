package com.codejourney.core;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOperations {
    public static void main(String[] args) {

        //Intermediate operations
        //filter(); map(); flatMap(); distinct(); sorted(); limit();skip();

        //Terminal operations
        //forEach(); collect(); count(); min(); max(); findFirst();

        //Comparator operations
        //Comparator.naturalOrder(); Comparator.reverseOrder(); Comparator.comparing();

       // List<String> list = Arrays.asList("Ram", "Shyam", "Ram", "Mohana", "Shyam");
        //list.stream().forEach(System.out::println);
        //List<String> collect = list.stream().collect(Collectors.toList());
        //System.out.println(collect);
        //collect.forEach(System.out::println);
       // list = new ArrayList<>();
       // Optional<String> first = list.stream().findFirst().;
       // String s = first.get();
       // String s = first.orElseGet(() -> "default value");
       // String defaultValue = first.orElse("default value");
       // System.out.println(defaultValue);

       /* long count = list.stream().count();
        System.out.println(count);*/

        /*Optional<String> max = list.stream().max((s1,s2)->s1.length()-s2.length());
        String s = max.get();
        System.out.println(s);*/

       /* String s = list.stream().min((s1, s2) -> s1.length() - s2.length()).get();
        System.out.println(s);*/

        //list.stream().sorted().forEach(System.out::print);

        //list.stream().limit(2).forEach(System.out::println);

       // list.stream().skip(2).forEach(System.out::println);

        /*List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collect = numbers.stream().filter(n -> n % 2 == 0).map(n -> n * n).collect(Collectors.toList());
        System.out.println(collect);*/

        /*List<String> names = Arrays.asList("Amit", "Zara", "John", "Kiran", "Bob");

        // Find name with minimum length
        String s = names.stream().min(Comparator.comparing(str-> str.length())).get();
        System.out.println(s);*/

        /*List<Product> products = Arrays.asList(
                new Product("Laptop", 55000),
                new Product("Phone", 35000),
                new Product("Tablet", 25000),
                new Product("Monitor", 15000)
        );

       // Find the product with the lowest price.
        Product product = products.stream().min(Comparator.comparing(prod -> prod.price)).get();
        System.out.println(product);*/

        List<Product> products = Arrays.asList(
                new Product("Laptop", 55000),
                new Product("Phone", 35000),
                new Product("Tablet", 25000),
                new Product("Monitor", 15000)
        );
        /*Product product = products.stream().min(Comparator.comparing(prod -> prod.price)).get();
        System.out.println(product);*/
        List<Product> collect = products.stream().sorted(Comparator.comparing(prod->prod.name)).collect(Collectors.toList());
        System.out.println(collect);


    }
}

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return name + " - ₹" + price;
    }
}