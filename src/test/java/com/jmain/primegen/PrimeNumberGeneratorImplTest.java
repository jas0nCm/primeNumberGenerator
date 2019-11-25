package com.jmain.primegen;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberGeneratorImplTest {

    @Test
    void generate() {
        PrimeNumberGenerator primeGen = new PrimeNumberGeneratorImpl(5);
        List<Integer> primesList = primeGen.generate(7900, 7920);

        List<Integer> expectedPrimesList = new ArrayList<>();
        expectedPrimesList.add(Integer.valueOf(7901));
        expectedPrimesList.add(Integer.valueOf(7907));
        expectedPrimesList.add(Integer.valueOf(7919));

        assertEquals(expectedPrimesList, primesList);

        expectedPrimesList.add(Integer.valueOf(7917));

        assertNotEquals(expectedPrimesList, primesList);
    }

    @Test
    void generateReversRange() {
        PrimeNumberGenerator primeGen = new PrimeNumberGeneratorImpl(5);
        List<Integer> primesList = primeGen.generate(7920, 7900);

        List<Integer> expectedPrimesList = new ArrayList<>();
        expectedPrimesList.add(Integer.valueOf(7901));
        expectedPrimesList.add(Integer.valueOf(7907));
        expectedPrimesList.add(Integer.valueOf(7919));

        assertEquals(expectedPrimesList, primesList);

        expectedPrimesList.add(Integer.valueOf(7917));

        assertNotEquals(expectedPrimesList, primesList);
    }

    @Test
    void isPrime_trivialCases() {
        PrimeNumberGenerator primeGen = new PrimeNumberGeneratorImpl(5);
        assertFalse(primeGen.isPrime(-5));
        assertFalse(primeGen.isPrime(0));
        assertFalse(primeGen.isPrime(1));

        assertTrue(primeGen.isPrime(2));
        assertTrue(primeGen.isPrime(3));

        assertFalse(primeGen.isPrime(1000));
    }
}