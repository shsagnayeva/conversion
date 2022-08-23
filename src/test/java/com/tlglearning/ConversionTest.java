package com.tlglearning;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class ConversionTest {

    @Test
    void convertToDecimal() {
        assertEquals(173, Conversion.convertToDecimal("10101101"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "parse-valid.csv", numLinesToSkip = 1)
    void parse_valid(String representation, int radix, int expected) {
        assertEquals(expected, Conversion.parse(representation, radix));
    }

    @Test
    void parseBase2() {
        assertEquals(173, Conversion.parse("10101101", 2));
    }

    @Test
    void parseBase4() {
        assertEquals(81, Conversion.parse("1101", 4));
    }

    @Test
    void parseBase8() {
        assertEquals(15, Conversion.parse("17", 8));
    }

    @Test
    void parseBase10() {
        assertEquals(17, Conversion.parse("17", 10));
    }

    @Test
    void parseBaseException() {
        assertThrows(IllegalArgumentException.class, () -> Conversion.parse("17", 11));
    }
}