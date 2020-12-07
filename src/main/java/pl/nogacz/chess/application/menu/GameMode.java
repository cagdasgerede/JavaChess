package pl.nogacz.chess.application.menu;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import pl.nogacz.chess.board.Board;
import pl.nogacz.chess.application.menu.EndGame;
import java.util.Optional;

/**
 *
 * @author : Doğukan Doğru on 07.12.2020
 */

public class GameMode {
    private EndGame endGame = new EndGame("Game mode changed.");

    public GameMode(){
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("JavaChess");
        alert.setContentText("Select game mode");

        ButtonType playerVsComputer = new ButtonType("Player vs Computer");
        ButtonType playerVsPlayer = new ButtonType("Player vs Player");

        alert.getButtonTypes().setAll(playerVsComputer, playerVsPlayer);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == playerVsComputer){
            endGame.newGame();
            Board.setGameMode(1);
        } else if (result.get() == playerVsPlayer){
            endGame.newGame();
            Board.setGameMode(0);
        }
    }
}
