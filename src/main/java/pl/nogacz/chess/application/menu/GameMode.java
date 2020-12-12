package pl.nogacz.chess.application.menu;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

import pl.nogacz.chess.application.Design;
import pl.nogacz.chess.board.Board;


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
            Board.setGameMode(Board.PLAYER_VS_COMPUTER);
            Design.refreshGameModeLabel();
        } else if (result.get() == playerVsPlayer){
            endGame.newGame();
            Board.setGameMode(Board.PLAYER_VS_PLAYER);
            Design.refreshGameModeLabel();
        }
    }
}
