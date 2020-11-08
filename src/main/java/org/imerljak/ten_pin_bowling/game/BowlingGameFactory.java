package org.imerljak.ten_pin_bowling.game;

public class BowlingGameFactory {

    static BowlingGame makeGame() {
        return new BowlingGameImpl();
    }

}
