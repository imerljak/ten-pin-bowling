package org.imerljak.ten_pin_bowling.game.entities;

import org.imerljak.ten_pin_bowling.game.FrameManager;
import org.imerljak.ten_pin_bowling.game.FrameManagerImpl;
import org.imerljak.ten_pin_bowling.game.rules.ScoreStrategy;
import org.imerljak.ten_pin_bowling.game.rules.ScoreStrategyFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.imerljak.ten_pin_bowling.game.rules.ScoreStrategyType.TRADITIONAL;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FrameTest {

    private final ScoreStrategyFactory scoreStrategyFactory = new ScoreStrategyFactory();
    private FrameManager frameManager;

    @BeforeEach
    void prepare() {
        final ScoreStrategy scoreStrategy = scoreStrategyFactory.make(TRADITIONAL);
        frameManager = new FrameManagerImpl(new FrameFactory(scoreStrategy));
    }

    @Test
    void shouldScoreZeroOnAllFouls() {
        frameManager.addThrow("F");
        frameManager.addThrow("F");

        frameManager.addThrow("F");
        frameManager.addThrow("F");

        frameManager.addThrow("F");
        frameManager.addThrow("F");

        frameManager.addThrow("F");
        frameManager.addThrow("F");

        frameManager.addThrow("F");
        frameManager.addThrow("F");

        frameManager.addThrow("F");
        frameManager.addThrow("F");

        frameManager.addThrow("F");
        frameManager.addThrow("F");

        frameManager.addThrow("F");
        frameManager.addThrow("F");

        frameManager.addThrow("F");
        frameManager.addThrow("F");

        frameManager.addThrow("F");
        frameManager.addThrow("F");

        int totalScore = frameManager.frame(10).frameScore();

        assertEquals(0, totalScore);
    }

    @Test
    void shouldScore300OnPerfectGame() {
        frameManager.addThrow("10");
        frameManager.addThrow("10");
        frameManager.addThrow("10");
        frameManager.addThrow("10");
        frameManager.addThrow("10");
        frameManager.addThrow("10");
        frameManager.addThrow("10");
        frameManager.addThrow("10");
        frameManager.addThrow("10");
        frameManager.addThrow("10");
        frameManager.addThrow("10");
        frameManager.addThrow("10");

        int totalScore = frameManager.frame(10).frameScore();
        assertEquals(300, totalScore);

    }

    @Test
    void shouldScore167OnJeffGame() {
        frameManager.addThrow("10");
        frameManager.addThrow("7");
        frameManager.addThrow("3");
        frameManager.addThrow("9");
        frameManager.addThrow("0");
        frameManager.addThrow("10");
        frameManager.addThrow("0");
        frameManager.addThrow("8");
        frameManager.addThrow("8");
        frameManager.addThrow("2");
        frameManager.addThrow("F");
        frameManager.addThrow("6");
        frameManager.addThrow("10");
        frameManager.addThrow("10");
        frameManager.addThrow("10");
        frameManager.addThrow("8");
        frameManager.addThrow("1");

        int totalScore = frameManager.frame(10).frameScore();

        assertEquals(167, totalScore);
    }

    @Test
    void shouldScore151OnJohnGame() {
        frameManager.addThrow("3");
        frameManager.addThrow("7");
        frameManager.addThrow("6");
        frameManager.addThrow("3");
        frameManager.addThrow("10");
        frameManager.addThrow("8");
        frameManager.addThrow("1");
        frameManager.addThrow("10");
        frameManager.addThrow("10");
        frameManager.addThrow("9");
        frameManager.addThrow("0");
        frameManager.addThrow("7");
        frameManager.addThrow("3");
        frameManager.addThrow("4");
        frameManager.addThrow("4");
        frameManager.addThrow("10");
        frameManager.addThrow("9");
        frameManager.addThrow("0");

        int totalScore = frameManager.frame(10).frameScore();

        assertEquals(151, totalScore);
    }
}
