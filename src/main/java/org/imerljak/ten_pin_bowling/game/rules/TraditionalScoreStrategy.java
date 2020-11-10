package org.imerljak.ten_pin_bowling.game.rules;

import org.imerljak.ten_pin_bowling.game.FrameSearcher;
import org.imerljak.ten_pin_bowling.game.entities.Frame;
import org.imerljak.ten_pin_bowling.game.entities.Throw;

class TraditionalScoreStrategy implements ScoreStrategy {

    @Override
    public int calculate(Frame frame, FrameSearcher searcher, int number) {
        if (number < 10) {
            return normalFrameScore(frame, searcher, number);
        }

        return lastFrameScore(frame, searcher, number);
    }

    private int normalFrameScore(Frame frame, FrameSearcher searcher, int number) {
        int previousScore = 0;

        if (number > 1) {
            previousScore = searcher.frame(number - 1).frameScore();
        }

        final int throwScore = frame.throwScore();
        final int previousFrameBonus = resolveBonus(frame.bonusThrows(), searcher, searcher.frame(number + 1));

        return previousScore + throwScore + previousFrameBonus;
    }

    private int lastFrameScore(Frame frame, FrameSearcher searcher, int number) {
        int previousScore = 0;

        if (number > 1) {
            previousScore = searcher.frame(number - 1).frameScore();
        }

        return previousScore + frame.throwScore();
    }

    private int resolveBonus(int bonusThrows, FrameSearcher searcher, Frame frame) {
        if (bonusThrows == 0) {
            return 0;
        }

        int bonusScore = 0;

        for (Throw aThrow : frame.getThrows()) {
            if (bonusThrows == 0) {
                break;
            }

            bonusScore += aThrow.getValue();
            bonusThrows--;
        }

        return bonusScore + resolveBonus(bonusThrows, searcher, searcher.frame(frame.frameNumber() + 1));
    }
}
