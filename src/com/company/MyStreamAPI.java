package com.company;

import java.util.*;
import java.util.function.*;

public class MyStreamAPI {

    public static <E> List<E> generate(Supplier<E> generator,
                                       Supplier<List<E>> listFactory,
                                       int count) {

        List<E> temporaryList = listFactory.get();

        for (int i = 0; i < count; i++) {
            temporaryList.add((E) generator.get());
        }
        return temporaryList;
    }

    public static <E> Optional<E> reduce(List<E> elements, BinaryOperator<E> accumulator) {

        E resultOfReduce = accumulator.apply(elements.get(0), elements.get(1));
        for (int i = 2; i < elements.size(); i++) {
            resultOfReduce = accumulator.apply(resultOfReduce, elements.get(i));
        }
        return Optional.of(resultOfReduce);
    }

    public static <E> E reduce(E seed, List<E> elements, BinaryOperator<E> accumulator) {
        E resultOfReduce = seed;
        for (E element : elements) {
            resultOfReduce = accumulator.apply(resultOfReduce, element);
        }
        return resultOfReduce;
    }

    public static <E> void forEach(List<E> elements, Consumer<E> consumer) {
        for (E element : elements) {
            consumer.accept(element);
        }
    }

    public static <E> List<E> distinct(List<E> elements, Supplier<List<E>> listFactory) {
        List<E> listOfDistinctValue = listFactory.get();
        Set<E> set = new HashSet<>(elements);
        listOfDistinctValue.addAll(set);
        return listOfDistinctValue;
    }

    public static <E> Optional<E> min(List<E> elements, Comparator<E> comparator) {
        elements.sort(comparator);
        return Optional.of(elements.get(0));
    }

    public static <E> Optional<E> max(List<E> elements, Comparator<E> comparator) {
        int maxValue = elements.size() - 1;
        elements.sort(comparator);
        return Optional.of(elements.get(maxValue));
    }

    public static <E> List<E> filter(List<E> elements, Predicate<E> filter) {
        List<E> filteredList = new ArrayList<>();
        for (E element : elements) {
            if (filter.test(element))
                filteredList.add(element);
        }
        return filteredList;
    }

    public static <E> boolean anyMatch(List<E> elements, Predicate<E> predicate) {
        for (E element : elements)
            if (predicate.test(element))
                return true;
        return false;
    }

    public static <E> boolean allMatch(List<E> elements, Predicate<E> predicate) {
        for (E element : elements)
            if (!predicate.test(element))
                return false;
        return true;
    }

    public static <E> boolean noneMatch(List<E> elements, Predicate<E> predicate) {
        for (E element : elements)
            if (!predicate.test(element))
                return true;
        return false;
    }

    public static <T, R> List<R> map(List<T> elements,
                                     Function<T, R> mappingFunction,
                                     Supplier<List<R>> listFactory) {
        List<R> result = listFactory.get();
        for (T element : elements)
            result.add(mappingFunction.apply(element));
        return result;
    }


    public static <E> Map<Boolean, List<E>> partitionBy(List<E> elements,
                                                        Predicate<E> predicate,
                                                        Supplier<Map<Boolean, List<E>>> mapFactory,
                                                        Supplier<List<E>> listFactory) {
        List<E> valueOfTrueKey = listFactory.get();
        List<E> valueOfFalseKey = listFactory.get();

        for (E element : elements)
            if (predicate.test(element))
                valueOfTrueKey.add(element);
            else valueOfFalseKey.add(element);

        Map<Boolean, List<E>> result = mapFactory.get();
            result.put(true, valueOfTrueKey);
            result.put(false, valueOfFalseKey);

        return result;
    }

    public static <T, K> Map<K, List<T>> groupBy(List<T> elements,
                                                 Function<T, K> classifier,
                                                 Supplier<Map<K, List<T>>> mapFactory,
                                                 Supplier<List<T>> listFactory) {
        //TODO Implement me
        return null;
    }

    public static <T, K, U> Map<K, U> toMap(List<T> elements,
                                            Function<T, K> keyFunction,
                                            Function<T, U> valueFunction,
                                            BinaryOperator<U> mergeFunction,
                                            Supplier<Map<K, U>> mapFactory) {
        //TODO Implement me
        return null;
    }


    public static <E, T> Map<Boolean, List<T>> partitionByAndMapElement(List<E> elements,
                                                                        Predicate<E> predicate,
                                                                        Supplier<Map<Boolean, List<T>>> mapFactory,
                                                                        Supplier<List<T>> listFactory,
                                                                        Function<E, T> elementMapper) {
        //TODO Implement me
        return null;
    }

    public static <T, U, K> Map<K, List<U>> groupByAndMapElement(List<T> elements,
                                                                 Function<T, K> classifier,
                                                                 Supplier<Map<K, List<U>>> mapFactory,
                                                                 Supplier<List<U>> listFactory,
                                                                 Function<T, U> elementMapper) {
        //TODO Implement me
        return null;
    }


}





