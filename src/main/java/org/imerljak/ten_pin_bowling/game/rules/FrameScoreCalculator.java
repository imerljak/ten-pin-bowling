package org.imerljak.ten_pin_bowling.game.rules;

import org.imerljak.ten_pin_bowling.game.entities.Frame;

@FunctionalInterface
public interface FrameScoreCalculator {

    int calculate(Frame frame);

}
