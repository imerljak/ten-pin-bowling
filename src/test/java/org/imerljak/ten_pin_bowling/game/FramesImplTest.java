package org.imerljak.ten_pin_bowling.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FramesImplTest {

    @Test
    void shouldChangeFrameOnStrike() {
        final Frames frames = new FramesImpl();

        final Frame firstFrame = frames.getCurrentFrame();

        frames.addThrow("10");

        final Frame nextFrame = frames.getCurrentFrame();

        assertNotEquals(firstFrame, nextFrame);
    }

    @Test
    void shouldChangeFrameOnSpare() {
        final Frames frames = new FramesImpl();

        final Frame firstFrame = frames.getCurrentFrame();

        frames.addThrow("7");
        frames.addThrow("3");

        final Frame nextFrame = frames.getCurrentFrame();

        assertNotEquals(firstFrame, nextFrame);
    }

    @Test
    void shouldChangeFrameOnThrowCount() {
        final Frames frames = new FramesImpl();

        final Frame firstFrame = frames.getCurrentFrame();

        frames.addThrow("4");
        frames.addThrow("3");

        final Frame nextFrame = frames.getCurrentFrame();

        assertNotEquals(firstFrame, nextFrame);
    }

}
