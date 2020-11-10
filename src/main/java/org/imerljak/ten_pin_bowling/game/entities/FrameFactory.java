package org.imerljak.ten_pin_bowling.game.entities;


import org.imerljak.ten_pin_bowling.game.FrameSearcher;
import org.imerljak.ten_pin_bowling.game.rules.ScoreStrategy;

public class FrameFactory {

    private final ScoreStrategy scoreStrategy;

    public FrameFactory(ScoreStrategy scoreStrategy) {
        this.scoreStrategy = scoreStrategy;
    }

    public Frame make(FrameType type, FrameSearcher searcher, int number) {
        switch (type) {
            case DEFAULT:
                return new DefaultFrame(searcher, scoreStrategy, number);
            case LAST:
                return new LastFrame(searcher, scoreStrategy, number);
            default:
                throw new IllegalArgumentException("Unknown frame type: " + type);
        }
    }

    public enum FrameType {
        DEFAULT,
        LAST,
    }


}
