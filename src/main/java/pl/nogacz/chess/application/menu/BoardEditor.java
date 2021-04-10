package pl.nogacz.chess.application.menu;
import java.util.HashMap;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pl.nogacz.chess.application.Resources;
import pl.nogacz.chess.board.Board;
import pl.nogacz.chess.board.Coordinates;
import pl.nogacz.chess.pawns.Pawn;
import pl.nogacz.chess.pawns.PawnClass;
import pl.nogacz.chess.pawns.PawnColor;

public class BoardEditor {
    private static Scene primaryScene;
    private static Scene editorScene;
    private static Stage stage;
    private PawnClass currSelection;
    private EditorDesign editorDesign;
    private int lastX = -1, lastY = -1;

    private HashMap<Coordinates, PawnClass> editorBoard = new HashMap<>();

    public BoardEditor(Stage currStage, Scene oldScene){
        stage = currStage;
        primaryScene = oldScene;
        editorDesign = new EditorDesign(this);
        editorDesign.getGridPane().setOnMouseClicked(this::readMouseEvent);
        editorDesign.getPickerPane().setOnMouseClicked(this::readPickerMouseEvent);
        editorScene = new Scene(editorDesign.getBorderPane(),900,790,Color.BLACK);
    }
    public static void switchToEditor() {
        stage.setTitle("Board Editor");
        stage.setResizable(false);
        stage.setScene(editorScene);
        stage.show();
    }

    public static void returnToMain() {
        stage.setTitle("JavaChess");
        stage.setResizable(false);
        stage.setScene(primaryScene);
        stage.show();
    }

    public void readMouseEvent(MouseEvent event) {
        Coordinates eventCoordinates = new Coordinates((int) ((event.getX() - 37) / 84), (int) ((event.getY() - 37) / 84));
        if(!eventCoordinates.isValid()) {
            return;
        }
        if (currSelection == null) {
            editorBoard.remove(eventCoordinates);
            EditorDesign.removePawn(eventCoordinates);
        } else {
            if (editorBoard.get(eventCoordinates) != null) {                    
                editorBoard.remove(eventCoordinates);
                EditorDesign.removePawn(eventCoordinates);
            }
            editorBoard.put(eventCoordinates, currSelection);
            EditorDesign.addPawn(eventCoordinates, currSelection);
        }
    }

    public void clearSelections(){
        editorDesign.getPickerPane().getChildren().clear(); 
        editorDesign.initPickerPieces();
        this.currSelection = null;
    }

    public void clearBoard(){
        editorBoard.clear();
        EditorDesign.clear();
    }

    public HashMap<Coordinates,PawnClass> getBoard() {
        return this.editorBoard;
    }

    public void setBoard(HashMap<Coordinates,PawnClass> board) {
        this.editorBoard = board;
    }

    public void readPickerMouseEvent(MouseEvent event) {
        clearSelections();
        int pickerX = (int)(event.getX() / 64);
        int pickerY = (int) (event.getY() / 64);
        switch(pickerY) {
            case 0:
                currSelection = new PawnClass(Pawn.KING, pickerX == 0 ? PawnColor.WHITE : PawnColor.BLACK);
                if (lastX == pickerX && lastY == pickerY ){ // deselect
                    EditorDesign.removePickerPawn(pickerX, pickerY);
                    editorDesign.getPickerPane().add(currSelection.getImage(), pickerX, pickerY);
                    currSelection = null;
                    lastX = -1;
                    lastY = -1;
                } else {    // select
                    EditorDesign.removePickerPawn(pickerX, pickerY);
                    editorDesign.getPickerPane().add(currSelection.getLightImage(), pickerX, pickerY);
                    lastX = pickerX;
                    lastY = pickerY;
                }
                break;
            case 1:
                currSelection = new PawnClass(Pawn.QUEEN, pickerX == 0 ? PawnColor.WHITE : PawnColor.BLACK);
                if (lastX == pickerX && lastY == pickerY ){ // deselect
                    EditorDesign.removePickerPawn(pickerX, pickerY);
                    editorDesign.getPickerPane().add(currSelection.getImage(), pickerX, pickerY);
                    currSelection = null;
                    lastX = -1;
                    lastY = -1;
                } else {    // select
                    EditorDesign.removePickerPawn(pickerX, pickerY);
                    editorDesign.getPickerPane().add(currSelection.getLightImage(), pickerX, pickerY);
                    lastX = pickerX;
                    lastY = pickerY;
                }
                break;
            case 2:
                currSelection = new PawnClass(Pawn.ROOK, pickerX == 0 ? PawnColor.WHITE : PawnColor.BLACK);
                if (lastX == pickerX && lastY == pickerY ){ // deselect
                    EditorDesign.removePickerPawn(pickerX, pickerY);
                    editorDesign.getPickerPane().add(currSelection.getImage(), pickerX, pickerY);
                    currSelection = null;
                    lastX = -1;
                    lastY = -1;
                } else {    // select
                    EditorDesign.removePickerPawn(pickerX, pickerY);
                    editorDesign.getPickerPane().add(currSelection.getLightImage(), pickerX, pickerY);
                    lastX = pickerX;
                    lastY = pickerY;
                }
                break;
            case 3:
                currSelection = new PawnClass(Pawn.BISHOP, pickerX == 0 ? PawnColor.WHITE : PawnColor.BLACK);
                if (lastX == pickerX && lastY == pickerY ){ // deselect
                    EditorDesign.removePickerPawn(pickerX, pickerY);
                    editorDesign.getPickerPane().add(currSelection.getImage(), pickerX, pickerY);
                    currSelection = null;
                    lastX = -1;
                    lastY = -1;
                } else {    // select
                    EditorDesign.removePickerPawn(pickerX, pickerY);
                    editorDesign.getPickerPane().add(currSelection.getLightImage(), pickerX, pickerY);
                    lastX = pickerX;
                    lastY = pickerY;
                }
                break;
            case 4:
                currSelection = new PawnClass(Pawn.KNIGHT, pickerX == 0 ? PawnColor.WHITE : PawnColor.BLACK);
                if (lastX == pickerX && lastY == pickerY ){ // deselect
                    EditorDesign.removePickerPawn(pickerX, pickerY);
                    editorDesign.getPickerPane().add(currSelection.getImage(), pickerX, pickerY);
                    currSelection = null;
                    lastX = -1;
                    lastY = -1;
                } else {    // select
                    EditorDesign.removePickerPawn(pickerX, pickerY);
                    editorDesign.getPickerPane().add(currSelection.getLightImage(), pickerX, pickerY);
                    lastX = pickerX;
                    lastY = pickerY;
                }
                break;
            case 5:
                currSelection = new PawnClass(Pawn.PAWN, pickerX == 0 ? PawnColor.WHITE : PawnColor.BLACK);
                if (lastX == pickerX && lastY == pickerY ){ // deselect
                    EditorDesign.removePickerPawn(pickerX, pickerY);
                    editorDesign.getPickerPane().add(currSelection.getImage(), pickerX, pickerY);
                    currSelection = null;
                    lastX = -1;
                    lastY = -1;
                } else {    // select
                    EditorDesign.removePickerPawn(pickerX, pickerY);
                    editorDesign.getPickerPane().add(currSelection.getLightImage(), pickerX, pickerY);
                    lastX = pickerX;
                    lastY = pickerY;
                }
                break;
            case 6:
                currSelection = null;
                if (lastX == pickerX && lastY == pickerY ){ // deselect
                    EditorDesign.removePickerPawn(pickerX, pickerY);
                    editorDesign.getPickerPane().add(new ImageView(new Image(Resources.getPath("pawns/TRASH.png"),64,64,false,false)), pickerX, pickerY);
                    lastX = -1;
                    lastY = -1;
                } else {    // select
                    EditorDesign.removePickerPawn(pickerX, pickerY);
                    editorDesign.getPickerPane().add(new ImageView(new Image(Resources.getPath("pawns/light_TRASH.png"),64,64,false,false)), pickerX, pickerY);
                    lastX = pickerX;
                    lastY = pickerY;
                }
                break;
            default:
                currSelection = null;
                break;
        }
    }
}
