package pl.nogacz.chess.evaluation_bar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import pl.nogacz.chess.application.GameLogic;
import pl.nogacz.chess.application.menu.EvaluationBar;
import pl.nogacz.chess.board.Board;
import pl.nogacz.chess.board.Coordinates;
import pl.nogacz.chess.pawns.Pawn;
import pl.nogacz.chess.pawns.PawnClass;
import pl.nogacz.chess.pawns.PawnColor;

import java.util.HashMap;


@RunWith(PowerMockRunner.class)
public class EvaluationTest {
    @PrepareForTest({Board.class})
    @Test
    public void doesCalculateThePointTrueWhenInBoundaries() {
        //Given
        PowerMockito.mockStatic(Board.class);

        HashMap<Coordinates, PawnClass> board = new HashMap<>();

        board.put(new Coordinates(0,0), new PawnClass(Pawn.ROOK, PawnColor.BLACK));
        board.put(new Coordinates(1,0), new PawnClass(Pawn.KNIGHT, PawnColor.BLACK));
        board.put(new Coordinates(2,0), new PawnClass(Pawn.BISHOP, PawnColor.BLACK));
        board.put(new Coordinates(3,0), new PawnClass(Pawn.QUEEN, PawnColor.BLACK));
        board.put(new Coordinates(4,0), new PawnClass(Pawn.KING, PawnColor.BLACK));
        board.put(new Coordinates(5,0), new PawnClass(Pawn.BISHOP, PawnColor.BLACK));
        board.put(new Coordinates(6,0), new PawnClass(Pawn.KNIGHT, PawnColor.BLACK));
        board.put(new Coordinates(7,0), new PawnClass(Pawn.ROOK, PawnColor.BLACK));

        board.put(new Coordinates(0,7), new PawnClass(Pawn.ROOK, PawnColor.WHITE));
        board.put(new Coordinates(1,7), new PawnClass(Pawn.KNIGHT, PawnColor.WHITE));
        board.put(new Coordinates(2,7), new PawnClass(Pawn.BISHOP, PawnColor.WHITE));
        board.put(new Coordinates(3,7), new PawnClass(Pawn.QUEEN, PawnColor.WHITE));
        board.put(new Coordinates(4,7), new PawnClass(Pawn.KING, PawnColor.WHITE));
        board.put(new Coordinates(5,7), new PawnClass(Pawn.BISHOP, PawnColor.WHITE));
        board.put(new Coordinates(6,7), new PawnClass(Pawn.KNIGHT, PawnColor.WHITE));
        board.put(new Coordinates(7,7), new PawnClass(Pawn.ROOK, PawnColor.WHITE));

        //When
        PowerMockito.when(Board.getBoard()).thenReturn(board);

        EvaluationBar evaluationBar = new EvaluationBar();

        //Then
        Assert.assertEquals(375, evaluationBar.calculateScoreOverSize(750), 0);
    }
}

