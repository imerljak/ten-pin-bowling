package org.imerljak.ten_pin_bowling.game;

public interface Frames extends FrameSearcher {

    void addThrow(String atThrow);

    Frame getCurrentFrame();
}
