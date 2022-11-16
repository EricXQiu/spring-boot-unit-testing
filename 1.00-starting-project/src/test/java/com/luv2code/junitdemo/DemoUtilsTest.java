package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
class DemoUtilsTest {
    DemoUtils demoUtils;

    @BeforeAll
    static void setupBeforeAll() {
        System.out.println("Before All Setup!");
    }

    @BeforeEach
    void setupTestBeforeEach() {

        System.out.println("Before Each Setup!");
        this.demoUtils = new DemoUtils();
    }

    @AfterEach
    void cleanAfterEach() {
        System.out.println("After Each Clean Up!");
    }

    @Test
    void testEqualsAndNotEquals() {

        System.out.println("Run Test: Test Equals And Not Equals.");

        int expectedValue = 6;
        int testValue = demoUtils.add(2, 4);

        assertEquals(expectedValue, testValue, "2 + 4 should be 6");

        assertNotEquals(7, testValue, "2 + 4 should not be 7");

    }

    @Test
    void testNullAndNotNull() {

        System.out.println("Run Test: Test Null And Not Null.");

        assertNotNull(demoUtils.checkNull(new String("This is good")), "This should not be null!");
        assertNull(demoUtils.checkNull(null), "This should be null!");
    }

    @Test
    void testSameAndNotSame() {
        System.out.println("Run Test: Test Same or Not Same.");

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "This should be the same");
        assertNotSame(demoUtils.getAcademy(), "luv2code", "This should not be the same.");
    }

    @Test
    void testTrueOrFalse() {
        System.out.println("Run Test: True or False.");
        int num1 = 10;
        int num2 = 2;
        assertTrue(demoUtils.isGreater(num1, num2));
        assertFalse(demoUtils.isGreater(num2, num1));
    }

    @Test
    void testArrayAndIterables() {
        System.out.println("Run Test: Test Arrays and Iterables.");

        String[] strArray = new String[] {"A", "B", "C"};

        assertArrayEquals(demoUtils.getFirstThreeLettersOfAlphabet(), strArray,
                "These two arrays should be the same");

        List<String> strList = new ArrayList<>(){{
            add("luv");
            add("2");
            add("code");
        }};

        assertIterableEquals(strList, demoUtils.getAcademyInList(), "These two lists should be the same.");
    }

    @Test
    void testLineMatch() {
        List<String> strList = new ArrayList<>(){{
            add("luv");
            add("2");
            add("code");
        }};

        assertLinesMatch(strList, demoUtils.getAcademyInList(), "These lines should match.");
    }

    @Test
    void testThrowsAndDoesNotThrow() {
        System.out.println("Run Test: Test throw and does not throw.");
        assertThrows(Exception.class, () -> demoUtils.throwException(-1), "This should throw an exception.");
        assertDoesNotThrow(() -> demoUtils.throwException(1), "This should throw an exception.");
    }

    @Test
    void testTimeOut() {
        System.out.println("Run Test: Test timeout");
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> demoUtils.checkTimeout(),
                "Method should be finished within 3 seconds");
    }

    @Test
    void testMultiply() {
        int expected = 12;
        assertEquals(expected, demoUtils.multiply(3, 4), "This multiplication is 12.");
    }

}
