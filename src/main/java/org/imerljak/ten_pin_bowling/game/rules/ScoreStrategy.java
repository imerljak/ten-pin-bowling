package org.imerljak.ten_pin_bowling.game.rules;

import org.imerljak.ten_pin_bowling.game.FrameSearcher;
import org.imerljak.ten_pin_bowling.game.entities.Frame;

public interface ScoreStrategy {

    int calculate(Frame frame, FrameSearcher searcher, int number);

}
