package com.company;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {


//        Supplier<String> suppliedValue = () -> "one";
        Supplier<List<String>> suppliedStringArrayList = ArrayList::new;
//        List<String> resultOfSupply = MyStreamAPI.generate(suppliedValue, suppliedStringArrayList, 2);
//
//        List<String> listOfElement = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
//        BinaryOperator<String> binaryOperator = (sb1, sb2) -> sb1 + "_________" + (sb2);
//        Optional<String> finalViewOfLit = MyStreamAPI.reduce(listOfElement, binaryOperator);
//
//        String seed = "startOfArray";
//        String listWithSeed = MyStreamAPI.reduce(seed, listOfElement, binaryOperator);
//
//        Consumer<String> consumer = s -> System.out.println("I am consumer, I can`t return anything");
//
//        List<String> notDistinctList = new ArrayList<String>(Arrays.asList("1", "1", "1", "1", "1", "2", "3"));
//        List<String> distinctList = MyStreamAPI.distinct(notDistinctList, suppliedStringArrayList);
//
//        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
//        Optional<Integer> minimumValueOfList = MyStreamAPI.min(integerList, Integer::compareTo);
//
//        Optional<Integer> maximumValueOfList = MyStreamAPI.max(integerList, Integer::compareTo);
//
//        List<Integer> unFilteredList = new ArrayList<>(Arrays.asList(5, 3, 2, 1, 6, 7, 8, 9, 4));
//        List<Integer> filteredList = MyStreamAPI.filter(unFilteredList, element -> element < 7);
//
//        boolean isAnyMatch = MyStreamAPI.anyMatch(unFilteredList, element -> element > 622);
//
//        boolean isAllMatch = MyStreamAPI.allMatch(unFilteredList, element -> element < 9);
//
//        boolean isNoneMatch = MyStreamAPI.noneMatch(unFilteredList, element -> element <= 9);
//
//        List<String> primaryList = new ArrayList<>(Arrays.asList("1", "2", "3"));
//        Function<String, Integer> mappingFunction = s -> new Integer(Integer.valueOf(s));
//        Supplier<List<Integer>> suppliedIntegerArrayList = ArrayList::new;
//        List<Integer> listAfterMapping = MyStreamAPI.map(primaryList, mappingFunction, suppliedIntegerArrayList);

//        String predicateValue = "Sasha";
//        Supplier<Map<Boolean, List<String>>> suppliedMap = HashMap::new;
//        List<String> listOfStrings = new ArrayList<>(Arrays.asList("Vova", "Sasha"));
//        Map<Boolean,List<String>> partitionedMap = MyStreamAPI.partitionBy(listOfStrings, element -> element.equals(predicateValue), suppliedMap, suppliedStringArrayList);

    }

}

