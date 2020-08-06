package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example {


    public static void main(String[] args) {
       List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        int sum = Stream.of(1,2,3,4).reduce(1, (acc, x) -> acc + x);
        System.out.println(sum);








//        String[] array = {"Java", "Ruuuuussshhh"};
//        Arrays.stream(array).map(s -> s.split(""))
//                            .flatMap(Arrays::stream)
//                            .distinct()
//                            .collect(Collectors.toList())
//                            .forEach(System.out::print);


    }


}
