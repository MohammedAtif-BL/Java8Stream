package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //TO Count the occurrence of each character in a string
        String input = "i love java";
        Map<String, Long> collect = Arrays.stream(input.split(""))
                .filter(s->!s.equals(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);


        //        TO Find all duplicate element from a given string
        List<String> collect1 = Arrays.stream(input.split(""))
                .filter(s -> !s.equals(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(v-> v.getValue()==1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(collect1);

        // First non-repeating character
        String key = Arrays.stream(input.split(""))
                .filter(s -> !s.equals(" "))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(v -> v.getValue() == 1)
                .findFirst().get().getKey();

        System.out.println(key);

        //To find the second largest from an array
        int[] arr = {15,9,12,13,2,8,22,1}; //1,2,5,9,11,13,21
        Integer secondLargest = Arrays.stream(arr).boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();

        System.out.println(secondLargest);

        //To find the longest string in an list/array
        String[] array = {"java","react","Programming","BackEnd language"};
        String longestString = Arrays.stream(array)
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .get();

        System.out.println(longestString);

        //to find max number in array
        Optional<Integer> maxValue = Arrays.stream(arr).boxed()
                .reduce(Integer::max);

        System.out.println(maxValue);

        // to find the element start with 1
        List<String> list = Arrays.stream(arr).boxed()
                .map(x -> x + " ")
                .filter(x -> x.endsWith("22"))
                .collect(Collectors.toList());

        System.out.println(list);


        //String.join example

        List<String> list1 = Arrays.asList("1", "2", "3", "4", "5");//1-2-3-4-5
        String result = String.join("->", list1);
        System.out.println(result);


        //skip and limit methods

//        IntStream.rangeClosed(1,10)
//                .skip(2)
//                .limit(6)
//                .forEach(System.out::print);

        String stringList = IntStream.rangeClosed(1, 10)
                .skip(2)
                .limit(6)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));

        System.out.println(stringList);

    }
}