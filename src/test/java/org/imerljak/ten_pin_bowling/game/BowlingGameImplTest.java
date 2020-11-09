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
    void shouldNotPlayMoreThanTenFrames() {
        manager.registerPlayer("Jack");

        // first frame
        manager.addThrow("Jack", "F");
        manager.addThrow("Jack", "F");

        // second frame
        manager.addThrow("Jack", "F");
        manager.addThrow("Jack", "F");

        // third frame
        manager.addThrow("Jack", "F");
        manager.addThrow("Jack", "F");

        // fourth frame
        manager.addThrow("Jack", "F");
        manager.addThrow("Jack", "F");

        // fifth frame
        manager.addThrow("Jack", "F");
        manager.addThrow("Jack", "F");

        // sixth frame
        manager.addThrow("Jack", "F");
        manager.addThrow("Jack", "F");

        // seventh frame
        manager.addThrow("Jack", "F");
        manager.addThrow("Jack", "F");

        // eight frame
        manager.addThrow("Jack", "F");
        manager.addThrow("Jack", "F");

        // ninth frame
        manager.addThrow("Jack", "F");
        manager.addThrow("Jack", "F");

        // tenth frame
        manager.addThrow("Jack", "F");
        manager.addThrow("Jack", "F");

        // nope frame
        assertThrows(IllegalStateException.class, () -> manager.addThrow("Jack", "F"));
    }
}
