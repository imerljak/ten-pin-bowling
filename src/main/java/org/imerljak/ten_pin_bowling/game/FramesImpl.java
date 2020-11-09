package org.imerljak.ten_pin_bowling.game;

import java.util.List;

import static java.util.Arrays.asList;

public class FramesImpl implements Frames, FrameSearcher {

    private final List<Frame> frameList;

    private Frame currentFrame;

    public FramesImpl() {

        final Frame firstFrame = new DefaultFrame(this, 1);
        final Frame secondFrame = new DefaultFrame(this, 2);
        final Frame thirdFrame = new DefaultFrame(this, 3);
        final Frame fourthFrame = new DefaultFrame(this, 4);
        final Frame fifthFrame = new DefaultFrame(this, 5);
        final Frame sixthFrame = new DefaultFrame(this, 6);
        final Frame seventhFrame = new DefaultFrame(this, 7);
        final Frame eighthFrame = new DefaultFrame(this, 8);
        final Frame ninthFrame = new DefaultFrame(this, 9);
        final Frame tenthFrame = new LastFrame(this, 10);

        this.frameList = asList(
                firstFrame,
                secondFrame,
                thirdFrame,
                fourthFrame,
                fifthFrame,
                sixthFrame,
                seventhFrame,
                eighthFrame,
                ninthFrame,
                tenthFrame
        );

        this.currentFrame = firstFrame;
    }

    @Override
    public Frame frame(int position) {
        if (frameList.size() < (position)) {
            return null;
        }

        return frameList.get(position - 1);
    }

    @Override
    public void addThrow(String atThrow) {

        if (currentFrame == null) {
            throw new IllegalStateException("Cannot play more than 10 frames");
        }

        currentFrame.addThrow(atThrow);

        if (currentFrame.isComplete()) {
            currentFrame = currentFrame.nextFrame();
        }
    }

    @Override
    public Frame getCurrentFrame() {
        return currentFrame;
    }

}
