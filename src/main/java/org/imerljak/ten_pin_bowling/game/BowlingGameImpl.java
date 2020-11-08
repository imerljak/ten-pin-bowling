package org.imerljak.ten_pin_bowling.game;

import java.util.*;

class BowlingGameImpl implements BowlingGame {

    final Set<String> players = new HashSet<>();
    final Map<String, List<Throw>> playerThrows = new HashMap<>();

    @Override
    public void registerPlayer(String name) {
        players.add(name);
    }

    @Override
    public boolean hasPlayer(String name) {
        return players.contains(name);
    }

    @Override
    public void registerThrow(String player, String pins) {
        assertPlayerIsInGame(player);

        this.playerThrows.compute(player, (key, value) -> {
            if (value == null) {
                value = new ArrayList<>();
            }

            if (value.size() == 10) {
                throw new IllegalStateException("Should not have more than 10 throws");
            }

            value.add(new ThrowImpl(pins));
            return value;
        });
    }

    @Override
    public int throwCount(String player) {
        assertPlayerIsInGame(player);

        final List<Throw> aThrows = playerThrows.get(player);
        return aThrows == null ? 0 : aThrows.size();
    }

    @Override
    public List<Throw> getThrows(String player) {
        assertPlayerIsInGame(player);

        return playerThrows.get(player);
    }

    private void assertPlayerIsInGame(String player) {
        if (!this.players.contains(player)) {
            throw new IllegalArgumentException("Player " + player + " is not participating in this game yet.");
        }
    }
}
