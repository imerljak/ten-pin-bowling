package org.imerljak.ten_pin_bowling.game.entities;


import static org.imerljak.ten_pin_bowling.game.entities.Constants.STRIKE_VALUE;

class ThrowImpl implements Throw {

    private final String stringValue;
    private final int intValue;

    public ThrowImpl(final String value) {
        this.stringValue = value;
        this.intValue = parseValueToInt(value);
    }

    @Override
    public int getValue() {
        return this.intValue;
    }

    private int parseValueToInt(String value) {
        try {
            final int parsedValue = value.equalsIgnoreCase("F") ? 0 : Integer.parseInt(value);

            if (parsedValue < 0 || parsedValue > 10) {
                throw new IllegalArgumentException("Throw value out of bounds [0 >= N <= 10]: " + value);
            }

            return parsedValue;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid throw value: " + value);
        }
    }

    @Override
    public boolean isStrike() {
        return intValue == STRIKE_VALUE;
    }

    @Override
    public String toString() {
        if (intValue == STRIKE_VALUE) {
            return  "X";
        }

        return stringValue;
    }
}
