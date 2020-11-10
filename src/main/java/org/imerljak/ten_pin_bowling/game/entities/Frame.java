package org.imerljak.ten_pin_bowling.game.entities;

import java.util.List;

public interface Frame {

    int bonusThrows();

    int throwScore();

    boolean isComplete();

    int frameNumber();

    void addThrow(String atThrow);

    List<Throw> getThrows();

    int frameScore();

    boolean hasStrike();

    boolean hasSpare();
}
