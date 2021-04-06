package pl.nogacz.chess.application.menu;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pl.nogacz.chess.board.Board;

public class BoardEditor {
    public EditorDesign editorDesign;
    public Board editorBoard;
    public BoardEditor(){
        editorBoard = new Board();
        editorDesign = new EditorDesign();
        Scene editorScene = new Scene(editorDesign.getBorderPane(), 900, 790, Color.BLACK);
        editorDesign.getGridPane().setOnMouseClicked(event -> editorBoard.readMouseEvent(event));
        //editorScene.setOnKeyReleased(event -> editorBoard.readKeyboard(event));
        Stage editorStage = new Stage();

        editorStage.setTitle("JavaChess");
        editorStage.setScene(editorScene);
        editorStage.setResizable(false);
        editorStage.show();
    }
}
