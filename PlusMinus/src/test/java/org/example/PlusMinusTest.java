package org.example;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlusMinusTest {

    @Test
    void plusMinus() {
        List<Integer> arrange = Arrays.asList(1,1,0,-1,-1);
        List<String> results = PlusMinus.plusMinus(arrange);
        assertNotNull(results);
        assertEquals("0.4000", results.get(0));
        assertEquals("0.4000", results.get(1));
        assertEquals("0.2000", results.get(2));
    }

    @Test
    void plusMinus2() {
        List<Integer> arrange = Arrays.asList(-4, 3, -9, 0, 4, 1);
        List<String> results = PlusMinus.plusMinus(arrange);
        assertNotNull(results);
        assertEquals("0.5000", results.get(0));
        assertEquals("0.3333", results.get(1));
        assertEquals("0.1667", results.get(2));
    }
}