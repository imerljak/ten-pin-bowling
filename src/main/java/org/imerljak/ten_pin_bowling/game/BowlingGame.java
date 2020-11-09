package org.imerljak.ten_pin_bowling.game;

import java.util.Map;

public interface BowlingGame {

    void registerPlayer(String name);

    boolean hasPlayer(String name);

    void addThrow(String player, String value);

    Map<String, Frames> getGameScores();

}
