package org.imerljak.ten_pin_bowling;

import org.imerljak.ten_pin_bowling.game.BowlingGame;
import org.imerljak.ten_pin_bowling.game.BowlingGameFactory;
import org.imerljak.ten_pin_bowling.io.BowlingGamePresenter;
import org.imerljak.ten_pin_bowling.io.InputFileReader;
import org.imerljak.ten_pin_bowling.io.TerminalBowlingGamePresenter;

import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        final BowlingGame bowlingGame = BowlingGameFactory.makeGame();

        final InputFileReader fileReader = new InputFileReader();

        final Map<String, List<String>> parsedInput = fileReader.readForMap(Paths.get("./test_file.txt"));

        parsedInput.forEach((player, throwList) -> {
            bowlingGame.registerPlayer(player);
            throwList.forEach(score -> bowlingGame.addThrow(player, score));
        });

        final BowlingGamePresenter presenter = new TerminalBowlingGamePresenter(bowlingGame);
        presenter.present();
    }
}
