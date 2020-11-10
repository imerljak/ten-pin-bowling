package org.imerljak.ten_pin_bowling.game;

import org.imerljak.ten_pin_bowling.game.entities.Frame;
import org.imerljak.ten_pin_bowling.game.entities.FrameFactory;
import org.imerljak.ten_pin_bowling.game.rules.ScoreStrategy;
import org.imerljak.ten_pin_bowling.game.rules.ScoreStrategyFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.imerljak.ten_pin_bowling.game.rules.ScoreStrategyType.TRADITIONAL;
import static org.junit.jupiter.api.Assertions.*;

class FrameManagerImplTest {

    private final ScoreStrategyFactory scoreStrategyFactory = new ScoreStrategyFactory();
    private FrameManager frameManager;

    @BeforeEach
    void prepare() {
        final ScoreStrategy scoreStrategy = scoreStrategyFactory.make(TRADITIONAL);
        frameManager = new FrameManagerImpl(new FrameFactory(scoreStrategy));
    }

    @Test
    void shouldChangeFrameOnStrike() {
        final Frame firstFrame = frameManager.getCurrentFrame();

        frameManager.addThrow("10");

        final Frame nextFrame = frameManager.getCurrentFrame();

        assertNotEquals(firstFrame, nextFrame);
    }

    @Test
    void shouldChangeFrameOnSpare() {
        final Frame firstFrame = frameManager.getCurrentFrame();

        frameManager.addThrow("7");
        frameManager.addThrow("3");

        final Frame nextFrame = frameManager.getCurrentFrame();

        assertNotEquals(firstFrame, nextFrame);
    }

    @Test
    void shouldChangeFrameOnThrowCount() {
        final Frame firstFrame = frameManager.getCurrentFrame();

        frameManager.addThrow("4");
        frameManager.addThrow("3");

        final Frame nextFrame = frameManager.getCurrentFrame();

        assertNotEquals(firstFrame, nextFrame);
    }

}
