package org.imerljak.ten_pin_bowling.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameImplTest {

    BowlingGame manager;

    @BeforeEach
    void beforeEach() {
        manager = new BowlingGameImpl();
    }

    @Test
    void shouldRegisterPlayer() {
        manager.registerPlayer("John");
        manager.registerPlayer("Jeff");

        assertTrue(manager.hasPlayer("John"));
        assertTrue(manager.hasPlayer("Jeff"));
    }

    @Test
    void shouldRegisterPlayerThrow() {
        manager.registerPlayer("John");
        manager.registerThrow("John", "10");

        assertEquals(1, manager.throwCount("John"));
    }

    @Test
    void shouldReturnPlayerThrows() {
        manager.registerPlayer("Jeff");
        manager.registerThrow("Jeff", "5");

        final List<Throw> jeffThrows = manager.getThrows("Jeff");

        assertEquals(1, jeffThrows.size());
    }

    @Test
    void shouldThrowOnMoreThanTenThrows() {
        manager.registerPlayer("Jack");
        manager.registerThrow("Jack", "F");
        manager.registerThrow("Jack", "F");
        manager.registerThrow("Jack", "F");
        manager.registerThrow("Jack", "F");
        manager.registerThrow("Jack", "F");
        manager.registerThrow("Jack", "F");
        manager.registerThrow("Jack", "F");
        manager.registerThrow("Jack", "F");
        manager.registerThrow("Jack", "F");
        manager.registerThrow("Jack", "F");

        assertThrows(IllegalStateException.class, () -> manager.registerThrow("Jack", "F"));
    }
}
