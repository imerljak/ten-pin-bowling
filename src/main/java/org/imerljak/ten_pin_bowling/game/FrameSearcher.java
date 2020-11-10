package org.imerljak.ten_pin_bowling.game;

import org.imerljak.ten_pin_bowling.game.entities.Frame;

public interface FrameSearcher {
    Frame frame(int number);
}
