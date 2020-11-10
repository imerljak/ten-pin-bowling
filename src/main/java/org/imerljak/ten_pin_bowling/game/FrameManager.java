package org.imerljak.ten_pin_bowling.game;

import org.imerljak.ten_pin_bowling.game.entities.Frame;

public interface FrameManager extends FrameSearcher {

    void addThrow(String atThrow);

    Frame getCurrentFrame();
}
