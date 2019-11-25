package com.jmain.primegen;

import java.util.List;

public class PrimeNumberGeneratorImpl implements PrimeNumberGenerator {
    @Override
    public List<Integer> generate(int startingValue, int endingValue) {
        return null;
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
