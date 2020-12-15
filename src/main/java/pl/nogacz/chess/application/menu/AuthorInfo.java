package pl.nogacz.chess.application.menu;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * @author Dawid Nogacz on 12.05.2019
 */
public class AuthorInfo {
    SoundEffect sound;
    public AuthorInfo() {
        sound = new SoundEffect("./src/main/resources/Audio/click.wav");
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("JavaChess");
        alert.setContentText("Dawid \"Sloenthran\" Nogacz\n" +
                "dawid@nogacz.pl\n\n" +
                "SourceCode: https://github.com/sloenthran/JavaChess");
        ButtonType exitButton = new ButtonType("OK");
        sound.play(false); //Sound for Author button
        alert.getButtonTypes().setAll(exitButton);
        alert.show();     
    }
}