package com.util;

import java.util.function.Function;

public class Adder implements Function<Integer, Integer> {
    public Integer apply(Integer x) {
        return x + 10;
    }
}