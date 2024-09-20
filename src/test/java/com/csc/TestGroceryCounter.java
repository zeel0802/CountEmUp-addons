package com.csc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGroceryCounter {

    GroceryCounter counter;

    @BeforeEach
    void setUp() {
        counter = new GroceryCounter();
    }

    @Test
    void testIncrement() {
        counter.increment(5);
        assertEquals("$00.05", counter.total());
        assertEquals(0, counter.number_of_overflows());

        counter.increment(95);
        assertEquals("$01.00", counter.total());
        assertEquals(0, counter.number_of_overflows());

        counter.increment(10000);
        assertEquals("$01.00", counter.total());
        assertEquals(1, counter.number_of_overflows());

        counter.increment(9999);
        assertEquals("$00.99", counter.total());

        counter.increment(1);
        assertEquals("$01.00", counter.total());
        assertEquals(2, counter.number_of_overflows());
    }
}