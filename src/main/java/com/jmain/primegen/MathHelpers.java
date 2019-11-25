package com.jmain.primegen;

import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

public class MathHelpers {
    public static int[] decomposeValue(int value) {
        int mult = value - 1;
        int twoExp = 0;

        while (mult % 2 == 0) {
            twoExp++;
            mult = mult / 2;
        }

        return new int[]{mult, twoExp};
    }

    public static int modPow(int value, int exponent, int mod) {
        BigInteger bigIntValue = BigInteger.valueOf(value);
        BigInteger bigIntExponent = BigInteger.valueOf(exponent);
        BigInteger bigIntMod = BigInteger.valueOf(mod);
        BigInteger x = bigIntValue.modPow(bigIntExponent, bigIntMod);

        return x.intValue();
    }

    public static boolean testValueCompositeness(int exponent, int limit, int value) {
        int witness = ThreadLocalRandom.current().nextInt(2 , value - 1);
        int testValue = MathHelpers.modPow(witness, exponent, value);

        if (testValue == 1 || testValue == value - 1) {
            return false;
        }
        for (int i = 0; i < limit; i++) {
            testValue = MathHelpers.modPow(testValue, 2, value);
            if (testValue == 1)
                return true;
            if (testValue == value - 1)
                return false;
        }

        return true;
    }
}
