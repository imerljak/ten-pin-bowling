package org.imerljak.ten_pin_bowling.game;

class DefaultFrame extends AbstractFrame implements Frame {

    private static final int MAX_THROW_COUNT = 2;
    private static final int MAX_THROW_SCORE = 10;

    private final FrameSearcher searcher;
    private final int frameNumber;

    protected DefaultFrame(FrameSearcher searcher, int frameNumber) {
        super(MAX_THROW_SCORE, MAX_THROW_COUNT);
        this.searcher = searcher;
        this.frameNumber = frameNumber;
    }

    @Override
    public Frame nextFrame() {
        return searcher.frame(frameNumber + 1);
    }

    @Override
    public int frameScore() {
        int previousScore = 0;

        if (frameNumber > 1) {
            previousScore = searcher.frame(frameNumber - 1).frameScore();
        }

        final int throwScore = throwScore();
        final int previousFrameBonus = new FrameBonusResolver().resolveBonus(bonusThrows(), searcher.frame(frameNumber + 1));

        return previousScore + throwScore + previousFrameBonus;
    }
}
