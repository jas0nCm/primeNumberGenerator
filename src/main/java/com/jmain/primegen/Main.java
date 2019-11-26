package com.jmain.primegen;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new Exception("invalid argument count");
            }
            int range1 = Integer.parseInt(args[0]);
            int range2 = Integer.parseInt(args[1]);
            int testIterations = 1;

            if (range2 >= range1)
                testIterations = range2 / 4;
            else
                testIterations = range1 / 4;

            if (testIterations <= 0)
                testIterations = 1;

            PrimeNumberGenerator primeGen = new PrimeNumberGeneratorImpl(testIterations);
            List<Integer> primes = primeGen.generate(range1, range2);
            if (primes.size() == 0)
                System.out.println("There are no prime numbers in the specified range.");
            else {
                System.out.println("There are " + primes.size() + " prime numbers in the specified range.");
                System.out.print("The prime numbers in the specified range are: ");
                for (int i = 0; i < primes.size(); i++) {
                    if (i < primes.size() - 1) {
                        System.out.print(primes.get(i) + ", ");
                    } else {
                        System.out.print(primes.get(i));
                    }
                }
                System.out.println();
            }
        }
        catch (NumberFormatException e) {
            System.out.println("usage: please only provide integer values as arguments");
        }
        catch (Exception e) {
            System.out.println("usage: please provide two range arguments, Main <range1> <range2>");
        }
    }
}
