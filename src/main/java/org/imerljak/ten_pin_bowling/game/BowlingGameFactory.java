package org.imerljak.ten_pin_bowling.game;

import org.imerljak.ten_pin_bowling.game.rules.ScoreStrategyFactory;
import org.imerljak.ten_pin_bowling.game.rules.ScoreStrategyType;

public class BowlingGameFactory {

    private BowlingGameFactory() {
    }

    public static BowlingGame makeGame(ScoreStrategyType scoreType) {
        return new BowlingGameImpl(new ScoreStrategyFactory().make(scoreType));
    }

}
