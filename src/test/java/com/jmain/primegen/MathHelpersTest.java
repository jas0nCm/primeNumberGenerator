package com.jmain.primegen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathHelpersTest {

    @Test
    void decomposeValue() {
        int[] decomposedValue = MathHelpers.decomposeValue(101);
        assertEquals(25, decomposedValue[0]);
        assertEquals(2, decomposedValue[1]);
    }

    @Test
    void modGen() {
        int testValue = MathHelpers.modPow(17, 11, 97);
        assertEquals(38, testValue);
    }

    @Test
    void testValueCompositeness_primes() {
        int[] primes = new int[]{17, 101, 881, 1399, 2861};

        for (int i = 0; i < primes.length; i++) {
            int prime = primes[i];
            int[] decomposedValue = MathHelpers.decomposeValue(prime);
            int exponent = decomposedValue[0];
            int limit = decomposedValue[1];

            assertFalse(MathHelpers.testValueCompositeness(exponent, limit, prime));
        }
    }

    @Test
    void testValueCompositeness_composites() {
        int[] primes = new int[]{51, 849, 1761, 4897, 6063};

        for (int i = 0; i < primes.length; i++) {
            int prime = primes[i];
            int[] decomposedValue = MathHelpers.decomposeValue(prime);
            int exponent = decomposedValue[0];
            int limit = decomposedValue[1];

            assertTrue(MathHelpers.testValueCompositeness(exponent, limit, prime));
        }
    }

}