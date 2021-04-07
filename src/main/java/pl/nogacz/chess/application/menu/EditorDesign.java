package pl.nogacz.chess.application.menu;
import java.beans.EventHandler;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import pl.nogacz.chess.board.Coordinates;
import pl.nogacz.chess.pawns.Pawn;
import pl.nogacz.chess.pawns.PawnClass;
import pl.nogacz.chess.pawns.PawnColor;
import pl.nogacz.chess.application.Resources;
import javafx.stage.Stage;

public class EditorDesign {
    private static BorderPane borderPane = new BorderPane();
    private static GridPane gridPane = new GridPane();
    private static GridPane pickerPane = new GridPane();
    private VBox vBox = new VBox();
    private HBox hBox = new HBox();
    public Button  resetBtn, importBtn, closeBtn;
    private BoardEditor parent;

    public EditorDesign(BoardEditor parent) {
        this.parent = parent;
        createBoardBackground();
        generateEmptyBoard();
        createPiecePane();  // TODO Replace with piece picker

        borderPane.setCenter(gridPane);
        borderPane.setRight(vBox);
        borderPane.setTop(hBox);
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public GridPane getPickerPane() {
        return pickerPane;
    }

    private void createBoardBackground() {
        Image background = new Image(Resources.getPath("board.png"));
        BackgroundSize backgroundSize = new BackgroundSize(750, 750, false, false, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);
        gridPane.setBackground(new Background(backgroundImage));

        hBox.setPadding(new Insets(15, 12, 15, 12));
        hBox.setSpacing(10);
        hBox.setStyle("-fx-background-image: url('background.png');");
    }

    private void generateEmptyBoard() {
        gridPane.setMinSize(750, 750);
        gridPane.setMaxSize(750, 750);

        for (int i = 0; i < 8; i++) {
            ColumnConstraints column = new ColumnConstraints(84);
            column.setHgrow(Priority.ALWAYS);
            column.setHalignment(HPos.CENTER);
            gridPane.getColumnConstraints().add(column);

            RowConstraints row = new RowConstraints(84);
            row.setVgrow(Priority.ALWAYS);
            row.setValignment(VPos.CENTER);
            gridPane.getRowConstraints().add(row);
        }

        gridPane.setPadding(new Insets(37, 0, 0, 37));
    }

    private void createPiecePane() {
        addPickerPiece(new PawnClass(Pawn.KING, PawnColor.WHITE),0,0);
        addPickerPiece(new PawnClass(Pawn.QUEEN, PawnColor.WHITE),0,1);
        addPickerPiece(new PawnClass(Pawn.ROOK, PawnColor.WHITE),0,2);
        addPickerPiece(new PawnClass(Pawn.BISHOP, PawnColor.WHITE),0,3);
        addPickerPiece(new PawnClass(Pawn.KNIGHT, PawnColor.WHITE),0,4);
        addPickerPiece(new PawnClass(Pawn.PAWN, PawnColor.WHITE),0,5);
        addPickerPiece(new PawnClass(Pawn.KING, PawnColor.BLACK),1,0);
        addPickerPiece(new PawnClass(Pawn.QUEEN, PawnColor.BLACK),1,1);
        addPickerPiece(new PawnClass(Pawn.ROOK, PawnColor.BLACK),1,2);
        addPickerPiece(new PawnClass(Pawn.BISHOP, PawnColor.BLACK),1,3);
        addPickerPiece(new PawnClass(Pawn.KNIGHT, PawnColor.BLACK),1,4);
        addPickerPiece(new PawnClass(Pawn.PAWN, PawnColor.BLACK),1,5);
        pickerPane.setHgap(0.1);
        resetBtn = new Button("Reset");                     //TODO
        resetBtn.setMaxSize(155,10);
        pickerPane.add(resetBtn,0,6,2,1);
        importBtn = new Button("Import this board");        //TODO
        importBtn.setMaxSize(155,10);
        importBtn.setOnMouseClicked(e -> parent.returnToMain());
        pickerPane.add(importBtn,0,7,2,1);
        closeBtn = new Button("Close");
        closeBtn.setMaxSize(155,10);
        closeBtn.setOnMouseClicked(e -> parent.returnToMain());
        pickerPane.add(closeBtn,0,8,2,1);
        VBox.setMargin(pickerPane, new Insets(15, 15, 0, 0));
        vBox.getChildren().add(pickerPane);
    }

    private static void addPickerPiece(PawnClass pawn, int x, int y) {
        pickerPane.add(pawn.getImage(), x, y);
    }

    public static void addPawn(Coordinates coordinates, PawnClass pawn) {
        gridPane.add(pawn.getImage(), coordinates.getX(), coordinates.getY());
    }

    public static void removePawn(Coordinates coordinates) {
        gridPane.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == coordinates.getX() && GridPane.getRowIndex(node) == coordinates.getY());
    }
}
