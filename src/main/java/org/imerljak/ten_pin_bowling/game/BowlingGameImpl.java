package org.imerljak.ten_pin_bowling.game;

import org.imerljak.ten_pin_bowling.game.rules.ScoreStrategy;

import java.util.*;

class BowlingGameImpl implements BowlingGame {

    private final Set<String> players = new HashSet<>();
    private final SortedMap<String, FrameManager> playerFrames = new TreeMap<>();

    private final FrameManagerFactory frameManagerFactory;

    BowlingGameImpl(ScoreStrategy rule) {
        frameManagerFactory = new FrameManagerFactory(rule);
    }

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
                value = frameManagerFactory.make();
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
    public Map<String, FrameManager> getGameScores() {
        return playerFrames;
    }
}
