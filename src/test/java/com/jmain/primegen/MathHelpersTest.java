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
}