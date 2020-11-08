package org.imerljak.ten_pin_bowling.game;

import java.util.List;

public interface BowlingGame {

    void registerPlayer(String name);

    boolean hasPlayer(String name);

    void registerThrow(String player, String value);

    int throwCount(String player);

    List<Throw> getThrows(String player);

}
