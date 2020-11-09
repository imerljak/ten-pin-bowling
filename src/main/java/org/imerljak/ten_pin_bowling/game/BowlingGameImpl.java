package org.imerljak.ten_pin_bowling.game;

import java.util.*;

class BowlingGameImpl implements BowlingGame {

    final Set<String> players = new HashSet<>();
    final SortedMap<String, Frames> playerFrames = new TreeMap<>();

    @Override
    public void registerPlayer(String name) {
        players.add(name);
    }

    @Override
    public boolean hasPlayer(String name) {
        return players.contains(name);
    }

    @Override
    public void addThrow(String player, String pins) {
        assertPlayerIsInGame(player);

        this.playerFrames.compute(player, (key, value) -> {
            if (value == null) {
                value = new FramesImpl();
            }
            value.addThrow(pins);
            return value;
        });
    }

    private void assertPlayerIsInGame(String player) {
        if (!this.players.contains(player)) {
            throw new IllegalArgumentException("Player " + player + " is not participating in this game yet.");
        }
    }

    @Override
    public Map<String, Frames> getGameScores() {
        return playerFrames;
    }
}
