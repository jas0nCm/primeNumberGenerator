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

        return false;
    }
}
