package pl.nogacz.chess.application.menu;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import pl.nogacz.chess.application.BoardPoint;

public class EvaluationBar extends VBox {
    private Canvas canvas;
    private BoardPoint boardPoint;
    private double size;
    public EvaluationBar(BoardPoint boardPoint, double size) {
        this.boardPoint = boardPoint;
        this.size = size;
        setMinSize(20, size);
        setMaxSize(20, size);
        this.canvas = new Canvas(20, size);
        this.getChildren().addAll(canvas);
    }

    public void draw() {
        GraphicsContext g = this.canvas.getGraphicsContext2D();

        double currentScore = calculateScoreOverSize();

        g.setFill(Color.BLACK);
        g.fillRect(0, 0, 20, (size / 2) + currentScore);

        g.setFill(Color.WHITE);
        g.fillRect(0, (size / 2) + currentScore, 20, size - ((size / 2) + currentScore));

    }

    public double calculateScoreOverSize() {
        double currentScore = size * 0.025 * boardPoint.calculateBoard();
        if (currentScore < -1 * (size / 2.0)) return -1 * (size / 2.0); // Bar does not exceed the boundaries on check
        else return Math.min((size / 2.0), currentScore); // Bar does not exceed the boundaries on check
    }
}
