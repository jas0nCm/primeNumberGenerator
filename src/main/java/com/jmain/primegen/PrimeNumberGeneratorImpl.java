package com.jmain.primegen;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberGeneratorImpl implements PrimeNumberGenerator {
    int iterations;

    public PrimeNumberGeneratorImpl(int iterations) {
        this.iterations = iterations;
    }
    @Override
    public List<Integer> generate(int startingValue, int endingValue) {
        List<Integer> primesList = new ArrayList<>();

        if (endingValue < startingValue) {
            int temp = endingValue;
            endingValue = startingValue;
            startingValue = temp;
        }

        for (int i = startingValue; i <= endingValue; i++) {
            if (isPrime(i)) {
                primesList.add(i);
            }
        }

        return  primesList;
    }

    @Override
    public boolean isPrime(int value) {
        if (value <= 1)
            return false;
        if (value == 2 || value == 3)

            return true;
        if (value % 2 == 0)
            return false;

        int[] decomposedValue = MathHelpers.decomposeValue(value);
        int exponent = decomposedValue[0];
        int limit = decomposedValue[1];
        for (int i = 0; i < iterations; i++) {
            if (MathHelpers.testValueCompositeness(exponent, limit, value) == true)
                return false;
        }

        return true;
    }
}
