package org.imerljak.ten_pin_bowling.game;

class FrameBonusResolver {

    int resolveBonus(int bonusThrows, Frame frame) {
        if (bonusThrows == 0) {
            return 0;
        }

        int bonusScore = 0;

        for (Throw aThrow : frame.getThrows()) {
            if (bonusThrows == 0) {
                break;
            }

            bonusScore += aThrow.getValue();
            bonusThrows--;
        }

        return bonusScore + resolveBonus(bonusThrows, frame.nextFrame());
    }

}
