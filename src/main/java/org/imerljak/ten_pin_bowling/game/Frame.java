package org.imerljak.ten_pin_bowling.game;

import java.util.List;

public interface Frame {

    int bonusThrows();

    boolean isComplete();

    void addThrow(String atThrow);

    List<Throw> getThrows();

    int frameScore();

    Frame nextFrame();

    boolean hasStrike();

    boolean hasSpare();
}
