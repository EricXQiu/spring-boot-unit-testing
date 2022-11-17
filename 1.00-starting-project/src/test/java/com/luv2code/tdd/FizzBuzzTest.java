package com.luv2code.tdd;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class FizzBuzzTest {


    @Test
    @Order(1)
    void testForDivisibleByThree() {
        String expected = "Fizz";

        assertEquals(expected, FizzBuzz.compute(3), "This should be Fizz.");

    }

    @Test
    @Order(2)
    void testForDivisibleByFive() {
        String expected = "Buzz";

        assertEquals(expected, FizzBuzz.compute(5), "This should be Buzz.");

    }

    @Test
    @Order(3)
    void testForDivisibleByThreeAndFive() {
        String expected = "FizzBuzz";

        assertEquals(expected, FizzBuzz.compute(15), "This should be FizzBuzz.");

    }

    @Test
    @Order(4)
    void testForNotDivisibleByThreeAndFive() {
        String expected = "7";

        assertEquals(expected, FizzBuzz.compute(7), "This should be 7.");

    }

    @ParameterizedTest(name="value={0}, expected={1}")
    @CsvFileSource(resources = "/small-test-data.csv")
    void automatedTestWithCsvFile(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));
    }
}
