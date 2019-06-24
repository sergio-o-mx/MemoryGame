package com.ioconnectservices.memorygame;

import com.ioconnectservices.memorygame.utils.StringUtils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StringUtilsTest {

    @Test
    public void testStringFromNumbers_success() {
        assertEquals(StringUtils.stringFromNumbers(0, 1), "01");
    }

    @Test
    public void testStringFromNumbers_fail() {
        assertNotEquals(StringUtils.stringFromNumbers(0, 2), "00");
    }

    @Test
    public void testNumbersFromString_success() {
        assertEquals(StringUtils.numbersFromString("01")[0], 0);
        assertEquals(StringUtils.numbersFromString("01")[1], 1);
    }

    @Test
    public void testNumbersFromString_fail() {
        assertNotEquals(StringUtils.numbersFromString("01")[0], 2);
        assertNotEquals(StringUtils.numbersFromString("01")[1], 3);
    }
}
