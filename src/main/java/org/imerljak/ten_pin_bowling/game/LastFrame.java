package org.imerljak.ten_pin_bowling.game;

import static org.imerljak.ten_pin_bowling.game.Constants.STRIKE_VALUE;

class LastFrame extends AbstractFrame implements Frame {

    private static final int MAX_THROW_COUNT = 3;
    private static final int MAX_THROW_SCORE = 30;

    private final FrameSearcher searcher;
    private final int frameNumber;

    protected LastFrame(FrameSearcher searcher, int frameNumber) {
        super(MAX_THROW_SCORE, MAX_THROW_COUNT);
        this.searcher = searcher;
        this.frameNumber = frameNumber;
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

    @Override
    public int frameScore() {
        int previousScore = 0;

        if (frameNumber > 1) {
            previousScore = searcher.frame(frameNumber - 1).frameScore();
        }

        return previousScore + throwScore();
    }

    @Override
    public Frame nextFrame() {
        return null;
    }
}
