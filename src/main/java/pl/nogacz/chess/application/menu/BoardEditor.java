package pl.nogacz.chess.application.menu;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BoardEditor {
    Scene oldScene;
    Scene editorScene;
    Stage stage;
    public BoardEditor(Stage stage, Scene oldScene){
        this.stage = stage;
        this.oldScene = oldScene;
        EditorDesign editorDesign = new EditorDesign(this);
        editorScene = new Scene(editorDesign.getBorderPane(),900,790,Color.BLACK);
    }
    public void switchToEditor() {
        stage.setTitle("Board Editor");
        stage.setResizable(false);
        stage.setScene(editorScene);
        stage.show();
    }
    public void returnToMain(){
        stage.setTitle("JavaChess");
        stage.setResizable(false);
        stage.setScene(oldScene);
        stage.show();

    }
}
