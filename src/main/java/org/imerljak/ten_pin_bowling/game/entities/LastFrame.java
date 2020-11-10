package org.imerljak.ten_pin_bowling.game.entities;

import org.imerljak.ten_pin_bowling.game.FrameSearcher;
import org.imerljak.ten_pin_bowling.game.rules.ScoreStrategy;

import static org.imerljak.ten_pin_bowling.game.entities.Constants.STRIKE_VALUE;

class LastFrame extends AbstractFrame implements Frame {

    private static final int MAX_THROW_COUNT = 3;
    private static final int MAX_THROW_SCORE = 30;

    protected LastFrame(FrameSearcher searcher, ScoreStrategy scoreStrategy, int frameNumber) {
        super(
                MAX_THROW_SCORE,
                MAX_THROW_COUNT,
                frameNumber,
                frame -> scoreStrategy.calculate(frame, searcher, frameNumber)
        );
    }

    @Override
    public boolean isComplete() {
        if (throwList.isEmpty()) {
            return false;
        }

        if (throwList.size() == MAX_THROW_COUNT) {
            return true;
        }

        final int throwScore = throwScore();

        if (throwScore == MAX_THROW_SCORE) {
            return true;
        }

        return throwList.size() == 2 && throwScore < STRIKE_VALUE;
    }

}
