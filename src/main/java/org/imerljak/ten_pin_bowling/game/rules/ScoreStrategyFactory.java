package org.imerljak.ten_pin_bowling.game.rules;

public class ScoreStrategyFactory {
    public ScoreStrategy make(ScoreStrategyType scoreType) {
        switch (scoreType) {
            case TRADITIONAL:
                return new TraditionalScoreStrategy();
            case WORLD_BOWLING:
                return new WorldBowlingScoreStrategy();
            default:
                throw new IllegalArgumentException("Unknown score type: " + scoreType);
        }
    }
}
