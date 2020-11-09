package org.imerljak.ten_pin_bowling.game;

import java.util.ArrayList;
import java.util.List;

import static org.imerljak.ten_pin_bowling.game.Constants.STRIKE_VALUE;

abstract class AbstractFrame implements Frame {

    protected final List<Throw> throwList = new ArrayList<>();

    private final int maxThrowScore;
    private final int maxThrowCount;

    protected AbstractFrame(int maxThrowScore, int maxThrowCount) {
        this.maxThrowScore = maxThrowScore;
        this.maxThrowCount = maxThrowCount;
    }


    @Override
    public void addThrow(String atThrow) {
        if (throwList.size() == maxThrowCount) {
            throw new IllegalStateException("Cannot make more throws on this frame");
        }

        final ThrowImpl nextThrow = new ThrowImpl(atThrow);

        if (throwScore() + nextThrow.getValue() > maxThrowScore) {
            throw new IllegalStateException("Cannot score more than " + maxThrowScore + " in this frame");
        }

        if (throwList.isEmpty()) {
            throwList.add(nextThrow);
            return;
        }

        if ((throwScore() + nextThrow.getValue()) > maxThrowScore) {
            throw new IllegalStateException("Cannot keep playing in this frame");
        }

        throwList.add(nextThrow);
    }

    @Override
    public boolean isComplete() {
        if (throwList.isEmpty()) {
            return false;
        }

        if (throwList.get(0).isStrike()) {
            return true;
        }

        return throwList.size() == maxThrowCount || throwScore() == maxThrowScore;
    }

    @Override
    public List<Throw> getThrows() {
        return throwList;
    }

    @Override
    public int bonusThrows() {
        if (hasStrike()) {
            return 2;
        }

        if (hasSpare()) {
            return 1;
        }

        return 0;
    }

    protected int throwScore() {
        return throwList.stream()
                .mapToInt(Throw::getValue)
                .sum();
    }

    @Override
    public boolean hasStrike() {
        return throwList.stream().anyMatch(Throw::isStrike);
    }

    @Override
    public boolean hasSpare() {
        return throwList.size() > 1 && throwScore() == STRIKE_VALUE;
    }
}
