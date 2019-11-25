package com.jmain.primegen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberGeneratorImplTest {

    @Test
    void generate() {
    }

    @Test
    void isPrime_trivialCases() {
        PrimeNumberGenerator primeGen= new PrimeNumberGeneratorImpl();
        assertFalse(primeGen.isPrime(-5));
        assertFalse(primeGen.isPrime(0));
        assertFalse(primeGen.isPrime(1));

        assertTrue(primeGen.isPrime(2));

        assertFalse(primeGen.isPrime(1000));
    }
}