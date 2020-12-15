package pl.nogacz.chess.application.menu;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import pl.nogacz.chess.Chess;
import pl.nogacz.chess.application.SaveGame;
import java.io.File;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Dawid Nogacz on 07.05.2019
 */
public class EndGame {
    private SaveGame saveGame = new SaveGame();
    private String message;
    SoundEffect sound;
    public EndGame(String message) {
        sound = new SoundEffect("./src/main/resources/Audio/click.wav");
        this.message = message;
    }

    public void printDialog() {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("JavaChess");
        alert.setContentText(message);

        ButtonType newGameButton = new ButtonType("New game");
        ButtonType exitButton = new ButtonType("Exit");

        alert.getButtonTypes().setAll(newGameButton, exitButton);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == newGameButton){
            newGame();
        } else {
            saveGame.remove();
            System.exit(0);
        }
    }

    public void newGame() {
        saveGame.remove();
        restartApplication();
        sound.play(false); //Sound for New Game button.
    }

    private void restartApplication()
    {
        try {
            final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
            final File currentJar = new File(Chess.class.getProtectionDomain().getCodeSource().getLocation().toURI());

            /* is it a jar file? */
            if(!currentJar.getName().endsWith(".jar"))
                return;

            /* Build command: java -jar application.jar */
            final ArrayList<String> command = new ArrayList<String>();
            command.add(javaBin);
            command.add("-jar");
            command.add(currentJar.getPath());

            final ProcessBuilder builder = new ProcessBuilder(command);
            builder.start();
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}