package org.imerljak.ten_pin_bowling.game;

import org.imerljak.ten_pin_bowling.game.entities.Frame;
import org.imerljak.ten_pin_bowling.game.entities.FrameFactory;

import java.util.List;

import static java.util.Arrays.asList;
import static org.imerljak.ten_pin_bowling.game.entities.FrameFactory.FrameType.DEFAULT;
import static org.imerljak.ten_pin_bowling.game.entities.FrameFactory.FrameType.LAST;

public class FrameManagerImpl implements FrameManager, FrameSearcher {

    private final List<Frame> frameList;

    private Frame currentFrame;

    public FrameManagerImpl(FrameFactory factory) {

        final Frame firstFrame = factory.make(DEFAULT,this, 1);
        final Frame secondFrame = factory.make(DEFAULT,this, 2);
        final Frame thirdFrame = factory.make(DEFAULT,this, 3);
        final Frame fourthFrame = factory.make(DEFAULT,this, 4);
        final Frame fifthFrame = factory.make(DEFAULT,this, 5);
        final Frame sixthFrame = factory.make(DEFAULT,this, 6);
        final Frame seventhFrame = factory.make(DEFAULT,this, 7);
        final Frame eighthFrame = factory.make(DEFAULT,this, 8);
        final Frame ninthFrame = factory.make(DEFAULT,this, 9);
        final Frame tenthFrame = factory.make(LAST,this, 10);

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
            currentFrame = this.frame(currentFrame.frameNumber() + 1);
        }
    }

    @Override
    public Frame getCurrentFrame() {
        return currentFrame;
    }

}
