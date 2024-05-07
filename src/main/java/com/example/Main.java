package com.example;

import java.util.*;

import java.util.function.*;

import com.model.User;
import com.util.TriFunction;
import com.util.Adder;

public class Main {
    public static void printRandomDoubles(Supplier<Double> randomSupplier, int count)
    {
        System.out.println("supplier random num 5 : ");
        for(int i = 0; i <count; i++)
        {
            System.out.println(randomSupplier.get());
        }
    }
    public static <T> void process(List<T> inputs, Consumer<T> processor)
    {
        for(T input: inputs){
            processor.accept(input);
        }
    }
    public static <T> void secondProcess(List<T> inputs, BiConsumer<Integer, T> processor)
    {
        for(int i = 0; i < inputs.size(); i++)
        {
            processor.accept(i, inputs.get(i));
        }
    }
    public static <T> List<T> filter(List<T> inputs, Predicate<T> condition)
    {
        List<T> output = new ArrayList<>();
        for(T input: inputs)
        {
            if (condition.test(input))
            {
                output.add(input);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        //Function<Integer, Integer> myAdder = new Adder();
        Function<Integer, Integer> myAdder = x -> x+10;
        int result = myAdder.apply(5);
        System.out.println("result 1 : " + result);

        BiFunction<Integer, Integer, Integer> add = (Integer x, Integer y) -> (x+y);
        int result2 = add.apply(3,5);
        System.out.println("result 2 : " + result2);

        TriFunction<Integer, Integer, Integer, Integer> addThreeNumbers = (x, y, z) -> x+y+z;

        int result3 = addThreeNumbers.apply(3, 2, 5);
        System.out.println("result 3 : " + result3);

        Supplier<String> myStringSupplier = () -> "hello world";
        Supplier<Double> myRandomDoubleSupplier = () -> Math.random();

        System.out.println("supplier 4 : " + myStringSupplier.get());
        printRandomDoubles(myRandomDoubleSupplier, 5);

        Consumer<String> myStringConsumer = (String str) -> {
            System.out.println(str);
        };

        System.out.println("consumer 5 :");
        myStringConsumer.accept("\thello");
        myStringConsumer.accept("\tworld");

        List<Integer> integerInputs = Arrays.asList(4,2,3);
        Consumer<Integer> myIntegerProcessor = x ->
                System.out.println("Processing integer : " + x);
        process(integerInputs, myIntegerProcessor);

        Consumer<Integer> myDifferentIntegerProcessor = x ->
                System.out.println("Processing integer in different way : " + x);
        process(integerInputs, myDifferentIntegerProcessor);

        Consumer<Double> myDoubleProcessor = x ->
                System.out.println("Processing double : " + x);
        List<Double> doubleInputs =  Arrays.asList(1.1, 2.2, 3.3);
        process(doubleInputs, myDoubleProcessor);

        System.out.println("Processing double, index : ");
        BiConsumer<Integer, Double> myDoubleProcessorWithInputIndex = (index, input) ->
                System.out.println("\tProcessing " + input + " at index " + index);
        List<Double> inputs = Arrays.asList(1.1, 2.2, 3.3);
        secondProcess(inputs, myDoubleProcessorWithInputIndex);

        Predicate<Integer> isPositive = x -> x > 0;
        List<Integer> inputsForFilter = Arrays.asList(10, 5, 4, 2, -4);
        System.out.println("Positive number : " + filter(inputsForFilter, isPositive));
        System.out.println("Non Positive number : " + filter(inputsForFilter, isPositive.negate()));
        System.out.println("Non negative number : " + filter(inputsForFilter, isPositive.or(x -> x == 0)));
        System.out.println("Positive even number : " + filter(inputsForFilter, isPositive.and(x -> x % 2 == 0)));

        List<User> users = new ArrayList<>();
        users.add(new User(3, "Alice"));
        users.add(new User(1, "Charlie"));
        users.add(new User(5, "Bob"));
        users.add(new User(7, "Gob"));
        System.out.println("users with model : \n" + users);

        Comparator<User> idComparator = (u1, u2) -> u1.getId() - u2.getId();
        Collections.sort(users, idComparator);
        System.out.println("compared id of users with model : \n" +users);

        Collections.sort(users, (u1, u2) -> u1.getName().compareTo(u2.getName()));
        System.out.println("compared name of users  with model : \n" +users);
    }

}
