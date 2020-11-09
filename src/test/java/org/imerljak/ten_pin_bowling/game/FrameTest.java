package org.imerljak.ten_pin_bowling.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrameTest {

    @Test
    void shouldScoreZeroOnAllFouls() {
        final Frames frames = new FramesImpl();

        frames.addThrow("F");
        frames.addThrow("F");

        frames.addThrow("F");
        frames.addThrow("F");

        frames.addThrow("F");
        frames.addThrow("F");

        frames.addThrow("F");
        frames.addThrow("F");

        frames.addThrow("F");
        frames.addThrow("F");

        frames.addThrow("F");
        frames.addThrow("F");

        frames.addThrow("F");
        frames.addThrow("F");

        frames.addThrow("F");
        frames.addThrow("F");

        frames.addThrow("F");
        frames.addThrow("F");

        frames.addThrow("F");
        frames.addThrow("F");

        int totalScore = frames.frame(10).frameScore();

        assertEquals(0, totalScore);
    }

    @Test
    void shouldScore300OnPerfectGame() {
        final Frames frames = new FramesImpl();

        frames.addThrow("10");
        frames.addThrow("10");
        frames.addThrow("10");
        frames.addThrow("10");
        frames.addThrow("10");
        frames.addThrow("10");
        frames.addThrow("10");
        frames.addThrow("10");
        frames.addThrow("10");
        frames.addThrow("10");
        frames.addThrow("10");
        frames.addThrow("10");

        int totalScore = frames.frame(10).frameScore();
        assertEquals(300, totalScore);

    }

    @Test
    void shouldScore167OnJeffGame() {
        final Frames frames = new FramesImpl();

        frames.addThrow("10");
        frames.addThrow("7");
        frames.addThrow("3");
        frames.addThrow("9");
        frames.addThrow("0");
        frames.addThrow("10");
        frames.addThrow("0");
        frames.addThrow("8");
        frames.addThrow("8");
        frames.addThrow("2");
        frames.addThrow("F");
        frames.addThrow("6");
        frames.addThrow("10");
        frames.addThrow("10");
        frames.addThrow("10");
        frames.addThrow("8");
        frames.addThrow("1");

        int totalScore = frames.frame(10).frameScore();

        assertEquals(167, totalScore);
    }

    @Test
    void shouldScore151OnJohnGame() {
        final Frames frames = new FramesImpl();

        frames.addThrow("3");
        frames.addThrow("7");
        frames.addThrow("6");
        frames.addThrow("3");
        frames.addThrow("10");
        frames.addThrow("8");
        frames.addThrow("1");
        frames.addThrow("10");
        frames.addThrow("10");
        frames.addThrow("9");
        frames.addThrow("0");
        frames.addThrow("7");
        frames.addThrow("3");
        frames.addThrow("4");
        frames.addThrow("4");
        frames.addThrow("10");
        frames.addThrow("9");
        frames.addThrow("0");

        for (int i = 0; i < 10; i++) {
            final Frame frame = frames.frame(i + 1);
            final int frameScore = frame.frameScore();
            System.out.println("Frame " + (i+1) + ": " + frameScore);
        }

        int totalScore = frames.frame(10).frameScore();

        assertEquals(151, totalScore);
    }
}
