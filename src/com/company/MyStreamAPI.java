package com.company;

import java.util.*;
import java.util.function.*;

public class MyStreamAPI {

    public static <E> List<E> generate(Supplier<E> generator,
                                       Supplier<List<E>> listFactory,
                                       int count) {

        List<E> result = listFactory.get();

        for (int i = 0; i < count; i++) {
            result.add((E) generator.get());
        }
        return result;
    }

    public static <E> Optional<E> reduce(List<E> elements, BinaryOperator<E> accumulator) {

        E result = accumulator.apply(elements.get(0), elements.get(1));
        for (int i = 2; i < elements.size(); i++)
            result = accumulator.apply(result, elements.get(i));
        return Optional.of(result);
    }

    public static <E> E reduce(E seed, List<E> elements, BinaryOperator<E> accumulator) {
        E result = seed;
        for (E element : elements)
            result = accumulator.apply(result, element);

        return result;
    }

    public static <E> void forEach(List<E> elements, Consumer<E> consumer) {
        for (E element : elements)
            consumer.accept(element);
    }

    public static <E> List<E> distinct(List<E> elements, Supplier<List<E>> listFactory) {
        List<E> result = listFactory.get();
        Set<E> set = new HashSet<>(elements);
        result.addAll(set);
        return result;
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
        List<E> result = new ArrayList<>();
        for (E element : elements)
            if (filter.test(element))
                result.add(element);

        return result;
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
        List<E> listOfTrueValue = listFactory.get();
        List<E> valueOfFalseValue = listFactory.get();
        Map<Boolean, List<E>> result = mapFactory.get();
        for (E element : elements)
            if (predicate.test(element))
                listOfTrueValue.add(element);
            else valueOfFalseValue.add(element);

        result.put(true, listOfTrueValue);
        result.put(false, valueOfFalseValue);

        return result;
    }

    public static <T, K> Map<K, List<T>> groupBy(List<T> elements,
                                                 Function<T, K> classifier,
                                                 Supplier<Map<K, List<T>>> mapFactory,
                                                 Supplier<List<T>> listFactory) {
        Map<K, List<T>> result = mapFactory.get();
        for (T element : elements) {
            K key = classifier.apply(element);
            if (!result.containsKey(key))
                result.put(key, listFactory.get());
            result.get(key).add(element);
        }
        return result;
    }

    public static <T, K, U> Map<K, U> toMap(List<T> elements,
                                            Function<T, K> keyFunction,
                                            Function<T, U> valueFunction,
                                            BinaryOperator<U> mergeFunction,
                                            Supplier<Map<K, U>> mapFactory) {
        List<U> listOfValue = new ArrayList<>();
        List<K> listOfKey = new ArrayList<>();
        Map<K, U> result = mapFactory.get();

        for (T element : elements)
            listOfValue.add(valueFunction.apply(element));

        for (T element : elements)
            listOfKey.add(keyFunction.apply(element));

        int idCounter = 0;
        for (K key : listOfKey) {
            U value = listOfValue.get(idCounter);
            if (!result.containsKey(key)){
                result.put(key, value);
            } else{
                U nextValue = listOfValue.get(idCounter +1);
                U mergedValue = mergeFunction.apply(value, nextValue);
                result.put(key, mergedValue);
            }
            idCounter++;
        }
        return result;
    }


    public static <E, T> Map<Boolean, List<T>> partitionByAndMapElement(List<E> elements,
                                                                        Predicate<E> predicate,
                                                                        Supplier<Map<Boolean, List<T>>> mapFactory,
                                                                        Supplier<List<T>> listFactory,
                                                                        Function<E, T> elementMapper) {
        Map<Boolean, List<T>> result = mapFactory.get();
        List<T> listOfTrueKey = listFactory.get();
        List<T> listOfFalseKey = listFactory.get();

        for (E element : elements)
            if (predicate.test(element))
                listOfTrueKey.add(elementMapper.apply(element));
            else listOfFalseKey.add(elementMapper.apply(element));

        result.put(true, listOfTrueKey);
        result.put(false, listOfFalseKey);

        return result;
    }

    public static <T, U, K> Map<K, List<U>> groupByAndMapElement(List<T> elements,
                                                                 Function<T, K> classifier,
                                                                 Supplier<Map<K, List<U>>> mapFactory,
                                                                 Supplier<List<U>> listFactory,
                                                                 Function<T, U> elementMapper) {
        Map<K, List<U>> result = mapFactory.get();
        for (T element : elements) {
            K key = classifier.apply(element);
            if (!result.containsKey(key))
                result.put(key, listFactory.get());
            result.get(key).add(elementMapper.apply(element));
        }
        return result;
    }


}





