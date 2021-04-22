package pl.nogacz.chess.application.menu;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar.ButtonData;
import pl.nogacz.chess.application.Design;
import pl.nogacz.chess.board.Board;

import java.util.Optional;

/**
 * @author Dawid Nogacz on 12.05.2019
 */

 
public class Difficulty {
    public String currentLevel;
    public Difficulty() {
        
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("JavaChess");
        alert.setContentText("Select difficulty");

        ButtonType easy = new ButtonType("Easy");
        ButtonType normal = new ButtonType("Normal");
        ButtonType hard = new ButtonType("Hard");
        ButtonType insane = new ButtonType("Insane");
        ButtonType cancel = new ButtonType("Cancel",ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(easy, normal, hard, insane, cancel);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == easy){
            Board.setComputerSkill(1);
            currentLevel = "Easy";
        } else if (result.get() == hard){
            Board.setComputerSkill(2);
            currentLevel = "Hard";
        } else if (result.get() == normal){
            Board.setComputerSkill(0);
            currentLevel = "Normal";
        }else if(result.get()== insane){
            Board.setComputerSkill(3);
            currentLevel = "Insane";
        }else{
            alert.close();
        }

        Design.setTextInDifficulty(currentLevel);
    }
 
}
