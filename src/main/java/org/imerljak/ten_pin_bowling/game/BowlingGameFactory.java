package org.imerljak.ten_pin_bowling.game;

public class BowlingGameFactory {

    private BowlingGameFactory() {
    }

    public static BowlingGame makeGame() {
        return new BowlingGameImpl();
    }

}
