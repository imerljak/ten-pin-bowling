package org.imerljak.ten_pin_bowling.game.entities;

import org.imerljak.ten_pin_bowling.game.FrameSearcher;
import org.imerljak.ten_pin_bowling.game.rules.ScoreStrategy;
import org.imerljak.ten_pin_bowling.game.rules.ScoreStrategyFactory;
import org.imerljak.ten_pin_bowling.game.rules.ScoreStrategyType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class DefaultFrameTest {

    FrameSearcher searcher;

    ScoreStrategyFactory scoreStrategyFactory = new ScoreStrategyFactory();

    @BeforeEach
    void prepare() {
        searcher = Mockito.mock(FrameSearcher.class);
    }

    @Test
    void shouldScoreOnlyPinsWhenOpen() {
        final ScoreStrategy scoreStrategy = scoreStrategyFactory.make(ScoreStrategyType.TRADITIONAL);

        Frame first = new DefaultFrame(searcher, scoreStrategy, 1);
        Frame second = new DefaultFrame(searcher, scoreStrategy, 2);

        when(searcher.frame(1)).thenReturn(first);
        when(searcher.frame(2)).thenReturn(second);

        first.addThrow("3");
        first.addThrow("4");

        final int score = first.frameScore();

        assertEquals(7, score);
    }

    @Test
    void shouldScoreNextThrowBonusOnSpare() {
        final ScoreStrategy scoreStrategy = scoreStrategyFactory.make(ScoreStrategyType.TRADITIONAL);
        Frame first = new DefaultFrame(searcher, scoreStrategy, 1);
        Frame second = new DefaultFrame(searcher, scoreStrategy, 2);

        when(searcher.frame(1)).thenReturn(first);
        when(searcher.frame(2)).thenReturn(second);

        first.addThrow("3");
        first.addThrow("7");

        second.addThrow("5");

        final int score = first.frameScore();

        assertEquals(15, score);
    }

    @Test
    void shouldScoreNextTwoThrowsBonusOnStrike() {
        final ScoreStrategy scoreStrategy = scoreStrategyFactory.make(ScoreStrategyType.TRADITIONAL);
        Frame first = new DefaultFrame(searcher, scoreStrategy, 1);
        Frame second = new DefaultFrame(searcher, scoreStrategy, 2);
        Frame third = new DefaultFrame(searcher, scoreStrategy, 3);

        when(searcher.frame(1)).thenReturn(first);
        when(searcher.frame(2)).thenReturn(second);
        when(searcher.frame(3)).thenReturn(third);

        first.addThrow("10");
        second.addThrow("10");
        third.addThrow("10");

        final int score = first.frameScore();

        assertEquals(30, score);
    }

}
