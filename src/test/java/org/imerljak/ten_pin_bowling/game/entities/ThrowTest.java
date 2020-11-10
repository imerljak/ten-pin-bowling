package org.imerljak.ten_pin_bowling.game.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ThrowTest {

    @Test
    void shouldConsiderFaultAsZero() {
        final ThrowImpl fault = new ThrowImpl("F");
        assertEquals(0, fault.getValue());
    }

    @Test
    void shouldRegisterValueCorrectly() {
        final ThrowImpl aFive = new ThrowImpl("5");
        final ThrowImpl aZero = new ThrowImpl("0");
        final ThrowImpl aStrike = new ThrowImpl("10");

        assertEquals(5, aFive.getValue());
        assertEquals(0, aZero.getValue());
        assertEquals(10, aStrike.getValue());
    }

    @Test
    void shouldThrowOnValueOverStrike() {
        assertThrows(IllegalArgumentException.class, () -> new ThrowImpl("11"));
    }

    @Test
    void shouldThrowOnValueBelowZero() {
        assertThrows(IllegalArgumentException.class, () -> new ThrowImpl("-1"));
    }

    @Test
    void shouldThrowOnGibberish() {
        assertThrows(IllegalArgumentException.class, () -> new ThrowImpl("Banana"));
    }

}
