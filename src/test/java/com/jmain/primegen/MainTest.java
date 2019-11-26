package com.jmain.primegen;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testMain() {
        Main.main(new String[]{"7900", "7920"});

        assertEquals("There are 3 prime numbers in the specified range.\nThe prime numbers in the specified range are: 7901, 7907, 7919\n", outContent.toString());
    }

    @Test
    void testMainInverse() {
        Main.main(new String[]{"7920", "7900"});

        assertEquals("There are 3 prime numbers in the specified range.\nThe prime numbers in the specified range are: 7901, 7907, 7919\n", outContent.toString());
    }

    @Test
    void testMainNumberFormatException() {
        Main.main(new String[]{"one", "thirty"});

        assertEquals("usage: please only provide integer values as arguments\n", outContent.toString());
    }

    @Test
    void testMainNegativeRange() {
        Main.main(new String[]{"-100", "-10"});

        assertEquals("There are no prime numbers in the specified range.\n", outContent.toString());
    }

    @Test
    void testMainOneArg() {
        Main.main(new String[]{"3"});

        assertEquals("usage: please provide two range arguments, Main <range1> <range2>\n", outContent.toString());
    }

    @Test
    void testMainThreeArgs() {
        Main.main(new String[]{"3", "100", "50000"});

        assertEquals("usage: please provide two range arguments, Main <range1> <range2>\n", outContent.toString());
    }
}