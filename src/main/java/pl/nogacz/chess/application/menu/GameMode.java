package pl.nogacz.chess.application.menu;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import pl.nogacz.chess.board.Board;

import java.util.Optional;



public class GameMode{

    public GameMode(){
    Alert alert = new Alert(Alert.AlertType.NONE);
    alert.setTitle("JavaChess");
    alert.setContentText("Select game mode");

    ButtonType playervsplayer = new ButtonType("Player vs Player");
    ButtonType playervscomputer = new ButtonType("Player vs Computer");
 
    alert.getButtonTypes().setAll(playervsplayer, playervscomputer);

    Optional<ButtonType> result = alert.showAndWait();
    
    if (result.get() == playervsplayer){
        Board.changeModePlayerVsPlayer();
    } else if (result.get() == playervscomputer){
        Board.changeModeComputerVsPlayer();
    }
    


    }
}