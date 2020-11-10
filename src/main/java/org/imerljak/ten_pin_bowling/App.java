package org.imerljak.ten_pin_bowling;

import org.imerljak.ten_pin_bowling.game.BowlingGame;
import org.imerljak.ten_pin_bowling.game.BowlingGameFactory;
import org.imerljak.ten_pin_bowling.io.BowlingGamePresenter;
import org.imerljak.ten_pin_bowling.io.InputFileReader;
import org.imerljak.ten_pin_bowling.io.TerminalBowlingGamePresenter;

import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static org.imerljak.ten_pin_bowling.game.rules.ScoreStrategyType.TRADITIONAL;

public class App {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please supply an input file.");
            System.out.println("Usage: java -jar ten-pin-bowling.java <inputfile_path>");
            return;
        }

        final InputFileReader fileReader = new InputFileReader();

        final Map<String, List<String>> parsedInput = fileReader.readForMap(Paths.get(args[0]));

        final BowlingGame bowlingGame = BowlingGameFactory.makeGame(TRADITIONAL);

        parsedInput.forEach((player, throwList) -> {
            bowlingGame.registerPlayer(player);
            throwList.forEach(score -> bowlingGame.addThrow(player, score));
        });

        final BowlingGamePresenter presenter = new TerminalBowlingGamePresenter(bowlingGame);
        presenter.present();
    }
}
