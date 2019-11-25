package com.jmain.primegen;

import java.math.BigInteger;

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
}
