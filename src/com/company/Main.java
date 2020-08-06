package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {


    public static void main(String[] args) {


//        Supplier<String> suppliedValue = () -> "one";
//        Supplier<List<String>> suppliedArrayList = ArrayList::new;

        List<String> listOfElement = new ArrayList<>(Arrays.asList("1","2", "3", "4" ,"5"));
        BinaryOperator<String> binaryOperator = (sb1, sb2) -> sb1 +"_________" + (sb2) ;


////        List<String> neededList =  MyStreamAPI.generate(suppliedValue, suppliedArrayList, 2);
        Optional<String> count = MyStreamAPI.reduce(listOfElement, binaryOperator);
        System.out.println(count);




    }

}

