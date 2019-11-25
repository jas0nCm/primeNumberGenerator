package com.jmain.primegen;

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
}
