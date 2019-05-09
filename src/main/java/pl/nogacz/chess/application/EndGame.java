package pl.nogacz.chess.application;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import pl.nogacz.chess.Chess;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Dawid Nogacz on 07.05.2019
 */
public class EndGame {

    public EndGame(String message) {
        printDialog(message);
    }

    private void printDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Sloenthran :: Chess");
        alert.setContentText(message);

        ButtonType newGameButton = new ButtonType("New game");
        ButtonType exitButton = new ButtonType("Exit");

        alert.getButtonTypes().setAll(newGameButton, exitButton);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == newGameButton){
            newGame();
        } else {
            System.exit(0);
        }
    }

    private void newGame() {
        restartApplication();
    }

    public void restartApplication()
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
