package org.imerljak.ten_pin_bowling.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.imerljak.ten_pin_bowling.game.rules.ScoreStrategyType.TRADITIONAL;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BowlingGameImplTest {

    BowlingGame game;

    @BeforeEach
    void beforeEach() {
        game = BowlingGameFactory.makeGame(TRADITIONAL);
    }

    @Test
    void shouldRegisterPlayer() {
        game.registerPlayer("John");
        game.registerPlayer("Jeff");

        assertTrue(game.hasPlayer("John"));
        assertTrue(game.hasPlayer("Jeff"));
    }

    @Test
    void shouldNotPlayMoreThanTenFrames() {
        game.registerPlayer("Jack");

        // first frame
        game.addThrow("Jack", "F");
        game.addThrow("Jack", "F");

        // second frame
        game.addThrow("Jack", "F");
        game.addThrow("Jack", "F");

        // third frame
        game.addThrow("Jack", "F");
        game.addThrow("Jack", "F");

        // fourth frame
        game.addThrow("Jack", "F");
        game.addThrow("Jack", "F");

        // fifth frame
        game.addThrow("Jack", "F");
        game.addThrow("Jack", "F");

        // sixth frame
        game.addThrow("Jack", "F");
        game.addThrow("Jack", "F");

        // seventh frame
        game.addThrow("Jack", "F");
        game.addThrow("Jack", "F");

        // eight frame
        game.addThrow("Jack", "F");
        game.addThrow("Jack", "F");

        // ninth frame
        game.addThrow("Jack", "F");
        game.addThrow("Jack", "F");

        // tenth frame
        game.addThrow("Jack", "F");
        game.addThrow("Jack", "F");

        // nope frame
        assertThrows(IllegalStateException.class, () -> game.addThrow("Jack", "F"));
    }
}
