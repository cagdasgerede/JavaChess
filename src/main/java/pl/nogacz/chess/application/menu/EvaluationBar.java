package pl.nogacz.chess.application.menu;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import pl.nogacz.chess.application.BoardPoint;

public class EvaluationBar extends VBox {
    Canvas canvas;
    BoardPoint boardPoint = new BoardPoint();
    public EvaluationBar() {
        setMinSize(20, 750);
        setMaxSize(20, 750);
        this.canvas = new Canvas(20, 750);
        this.getChildren().addAll(canvas);
        draw();
    }

    public void draw() {
        GraphicsContext g = this.canvas.getGraphicsContext2D();

        int currentScore = boardPoint.calculateBoard() * 10;

        g.setFill(Color.BLACK);
        g.fillRect(0, 0, 20, 375 + currentScore); // Bar length: 400

        g.setFill(Color.WHITE);
        g.fillRect(0, 375 + currentScore, 20, 750 - (375 + currentScore));

    }

}
