package pl.nogacz.chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pl.nogacz.chess.application.Design;
import pl.nogacz.chess.application.Resources;
import pl.nogacz.chess.application.menu.AuthorInfo;
import pl.nogacz.chess.board.Board;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

/**
 * @author Dawid Nogacz on 01.05.2019
 */
public class Chess extends Application {
    Design design = new Design();
    Board board = new Board();

    public static void main(String[] args) {
        
        try{
            backgroundMusic();}
        catch(Exception e){System.out.println(e);}
        launch(args);
        
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(design.getBorderPane(), 900, 790, Color.BLACK);
        design.getGridPane().setOnMouseClicked(event -> board.readMouseEvent(event));
        scene.setOnKeyReleased(event -> board.readKeyboard(event));

        primaryStage.setTitle("JavaChess");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void backgroundMusic() throws UnsupportedAudioFileException,IOException,LineUnavailableException{
        
        File file =new File(".\\src\\main\\resources\\background.wav");
        AudioInputStream audioStream= AudioSystem.getAudioInputStream(file);
        Clip clip =AudioSystem.getClip();
        clip.open(audioStream);     
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
