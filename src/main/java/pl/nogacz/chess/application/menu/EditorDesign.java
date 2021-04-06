package pl.nogacz.chess.application.menu;
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

public class EditorDesign {
    private static BorderPane borderPane = new BorderPane();
    private static GridPane gridPane = new GridPane();
    private static GridPane piecesPane = new GridPane();
    private VBox vBox = new VBox();
    private HBox hBox = new HBox();
    private static Image lightMove = new Image(Resources.getPath("light.png"));

    public EditorDesign() {
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

    public GridPane getPiecesPane() {
        return piecesPane;
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
        addPiece(new PawnClass(Pawn.KING, PawnColor.WHITE),0,0);
        addPiece(new PawnClass(Pawn.QUEEN, PawnColor.WHITE),0,1);
        addPiece(new PawnClass(Pawn.ROOK, PawnColor.WHITE),0,2);
        addPiece(new PawnClass(Pawn.BISHOP, PawnColor.WHITE),0,3);
        addPiece(new PawnClass(Pawn.KNIGHT, PawnColor.WHITE),0,4);
        addPiece(new PawnClass(Pawn.PAWN, PawnColor.WHITE),0,5);
        addPiece(new PawnClass(Pawn.KING, PawnColor.BLACK),1,0);
        addPiece(new PawnClass(Pawn.QUEEN, PawnColor.BLACK),1,1);
        addPiece(new PawnClass(Pawn.ROOK, PawnColor.BLACK),1,2);
        addPiece(new PawnClass(Pawn.BISHOP, PawnColor.BLACK),1,3);
        addPiece(new PawnClass(Pawn.KNIGHT, PawnColor.BLACK),1,4);
        addPiece(new PawnClass(Pawn.PAWN, PawnColor.BLACK),1,5);
        piecesPane.setHgap(0.1);
        Button reset = new Button("Reset");
        reset.setMaxSize(1000,1000);
        piecesPane.add(reset,0,6,2,1);
        VBox.setMargin(piecesPane, new Insets(15, 15, 0, 0));
        vBox.getChildren().add(piecesPane);
    }

    private static void addPiece(PawnClass pawn, int x, int y) {
        piecesPane.add(pawn.getImage(), x, y);
    }

    public static void addPawn(Coordinates coordinates, PawnClass pawn) {
        gridPane.add(pawn.getImage(), coordinates.getX(), coordinates.getY());
    }

    public static void addLightPawn(Coordinates coordinates, PawnClass pawn) {
        gridPane.add(pawn.getLightImage(), coordinates.getX(), coordinates.getY());
    }

    public static void addCheckedPawn(Coordinates coordinates, PawnClass pawn) {
        gridPane.add(pawn.getCheckedImage(), coordinates.getX(), coordinates.getY());
    }

    public static void addLightMove(Coordinates coordinates) {
        gridPane.add(new ImageView(lightMove), coordinates.getX(), coordinates.getY());
    }

    public static void removePawn(Coordinates coordinates) {
        gridPane.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == coordinates.getX() && GridPane.getRowIndex(node) == coordinates.getY());
    }
}
