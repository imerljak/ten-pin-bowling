package org.imerljak.ten_pin_bowling.game;

import org.imerljak.ten_pin_bowling.game.entities.FrameFactory;
import org.imerljak.ten_pin_bowling.game.rules.ScoreStrategy;

public class FrameManagerFactory {

    private final FrameFactory frameFactory;

    public FrameManagerFactory(ScoreStrategy scoreStrategy) {
        frameFactory = new FrameFactory(scoreStrategy);
    }

    public FrameManager make() {
        return new FrameManagerImpl(frameFactory);
    }
}
