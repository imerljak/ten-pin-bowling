package org.imerljak.ten_pin_bowling.io;

import org.imerljak.ten_pin_bowling.game.BowlingGame;
import org.imerljak.ten_pin_bowling.game.Frame;
import org.imerljak.ten_pin_bowling.game.Frames;

import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.join;

public class TerminalBowlingGamePresenter implements BowlingGamePresenter {

    private final BowlingGame game;

    public TerminalBowlingGamePresenter(BowlingGame game) {
        this.game = game;
    }

    @Override
    public void present() {
        final Map<String, Frames> scores = game.getGameScores();


        printHeader();
        scores.forEach((player, frames) -> {
            printNameRow(player);
            printPinfallsRow(frames);
            printScoreRows(frames);
        });
    }

    private void printHeader() {
        System.out.println(join("\t\t", "Frame", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
    }

    private void printNameRow(String player) {
        System.out.println(player);
    }

    private void printPinfallsRow(Frames frames) {
        System.out.print("Pinfalls\t");
        for (int i = 1; i <= 10; i++) {
            if (i < 10) {
                printNormalFrame(frames.frame(i));
            } else {
                printLastFrame(frames.frame(i));
            }
        }
        System.out.println();
    }

    private void printNormalFrame(Frame frame) {
        if (frame.hasStrike()) {
            System.out.print("\tX");
        } else if (frame.hasSpare()) {
            System.out.print(frame.getThrows().get(0) + "\t/");
        } else {
            final String openFrame = frame.getThrows()
                    .stream()
                    .map(Object::toString)
                    .collect(Collectors.joining("\t"));
            System.out.print(openFrame);
        }
        System.out.print("\t");
    }

    private void printLastFrame(Frame frame) {
        final String openFrame = frame.getThrows()
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining("\t"));
        System.out.print(openFrame);
        System.out.print("\t");
    }

    private void printScoreRows(Frames frames) {
        System.out.print("Score\t\t");
        for (int i = 1; i <= 10; i++) {
            final Frame frame = frames.frame(i);
            final int score = frame.frameScore();
            System.out.print(score + (i < 10 ? "\t\t" : "\n"));
        }
    }
}
