package org.imerljak.ten_pin_bowling.game.entities;

import org.imerljak.ten_pin_bowling.game.FrameSearcher;
import org.imerljak.ten_pin_bowling.game.rules.ScoreStrategy;

class DefaultFrame extends AbstractFrame implements Frame {

    private static final int MAX_THROW_COUNT = 2;
    private static final int MAX_THROW_SCORE = 10;

    protected DefaultFrame(FrameSearcher searcher, ScoreStrategy scoreStrategy, int frameNumber) {
        super(
                MAX_THROW_SCORE,
                MAX_THROW_COUNT,
                frameNumber,
                frame -> scoreStrategy.calculate(frame, searcher, frameNumber)
        );
    }

}
