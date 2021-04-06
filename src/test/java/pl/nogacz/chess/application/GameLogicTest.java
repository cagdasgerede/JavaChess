package pl.nogacz.chess.application;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import pl.nogacz.chess.application.Computer;
import pl.nogacz.chess.board.Board;
import pl.nogacz.chess.board.Coordinates;
import pl.nogacz.chess.pawns.Pawn;
import pl.nogacz.chess.pawns.PawnClass;
import pl.nogacz.chess.pawns.PawnColor;
import pl.nogacz.chess.pawns.moves.PawnMoves;

import java.util.HashMap;

/**
 * @author Dawid Nogacz on 05.05.2019
 */
@RunWith(PowerMockRunner.class)
public class GameLogicTest {
    @PrepareForTest({Board.class})
    @Test
    public void isMovePossibleIfBoardIsEmpty() {
        //Given
        PowerMockito.mockStatic(Board.class);
        GameLogic gameLogic = new GameLogic();

        HashMap<Coordinates, PawnClass> board = new HashMap<>();

        //When
        PowerMockito.when(Board.getBoard()).thenReturn(board);
        gameLogic.prepareData();
        boolean isMovePossible = gameLogic.isMovePossible();

        //Then
        Assert.assertEquals(false, isMovePossible);
    }

    @PrepareForTest({Board.class})
    @Test
    public void isMovePossibleIfBoardIsFull() {
        //Given
        PowerMockito.mockStatic(Board.class);
        GameLogic gameLogic = new GameLogic();

        PawnClass pawnWhite = new PawnClass(Pawn.PAWN, PawnColor.WHITE);
        PawnClass pawnBlack = new PawnClass(Pawn.PAWN, PawnColor.BLACK);

        HashMap<Coordinates, PawnClass> board = new HashMap<>();
        board.put(new Coordinates(0, 0), pawnBlack);
        board.put(new Coordinates(0, 6), pawnWhite);
        board.put(new Coordinates(0, 1), pawnBlack);
        board.put(new Coordinates(1, 6), pawnWhite);

        //When
        PowerMockito.when(Board.getBoard()).thenReturn(board);
        PowerMockito.when(Board.getPawn(new Coordinates(0,0))).thenReturn(pawnBlack);
        PowerMockito.when(Board.getPawn(new Coordinates(0,6))).thenReturn(pawnWhite);
        PowerMockito.when(Board.getPawn(new Coordinates(0,1))).thenReturn(pawnBlack);
        PowerMockito.when(Board.getPawn(new Coordinates(1,6))).thenReturn(pawnWhite);

        gameLogic.prepareData();
        boolean isMovePossible = gameLogic.isMovePossible();

        //Then
        Assert.assertTrue(isMovePossible);
    }

    @PrepareForTest({Board.class})
    @Test
    public void isMovePossibleIfBoardIsOnlyKing() {
        //Given
        PowerMockito.mockStatic(Board.class);
        GameLogic gameLogic = new GameLogic();

        PawnClass pawnWhite = new PawnClass(Pawn.KING, PawnColor.WHITE);
        PawnClass pawnBlack = new PawnClass(Pawn.KING, PawnColor.BLACK);

        HashMap<Coordinates, PawnClass> board = new HashMap<>();
        board.put(new Coordinates(0, 0), pawnBlack);
        board.put(new Coordinates(0, 6), pawnWhite);

        //When
        PowerMockito.when(Board.getBoard()).thenReturn(board);
        PowerMockito.when(Board.getPawn(new Coordinates(0,0))).thenReturn(pawnBlack);
        PowerMockito.when(Board.getPawn(new Coordinates(0,6))).thenReturn(pawnWhite);

        gameLogic.prepareData();
        boolean isMovePossible = gameLogic.isMovePossible();

        //Then
        Assert.assertEquals(false, isMovePossible);
    }

    @PrepareForTest({Board.class})
    @Test
    public void isMoveSuggestorSuggestsCorrectly() {
        //Given
        Board.getBoard().clear();
        
        PawnClass kingWhite = new PawnClass(Pawn.KING, PawnColor.WHITE);
        PawnClass queenWhite = new PawnClass(Pawn.QUEEN, PawnColor.WHITE);

        PawnClass kingBlack = new PawnClass(Pawn.KING, PawnColor.BLACK);
        PawnClass queenBlack = new PawnClass(Pawn.QUEEN, PawnColor.BLACK);
        PawnClass pawn1Black = new PawnClass(Pawn.PAWN, PawnColor.BLACK);
        PawnClass pawn2Black = new PawnClass(Pawn.PAWN, PawnColor.BLACK);

        Board.getBoard().put(new Coordinates(0, 1), queenBlack);
        Board.getBoard().put(new Coordinates(7, 1), kingBlack);
        Board.getBoard().put(new Coordinates(6, 2), pawn1Black);
        Board.getBoard().put(new Coordinates(7, 2), pawn2Black);
        Board.getBoard().put(new Coordinates(0, 7), queenWhite);
        Board.getBoard().put(new Coordinates(7, 7), kingWhite);

        Computer computer = new Computer();

        PawnMoves queenMoves = new PawnMoves(queenWhite, new Coordinates(0, 7));

        //Then
        Assert.assertEquals(new Coordinates(0, 1), computer.suggestMove(queenMoves.getPossibleMoves(), queenMoves.getPossibleKick(), queenWhite));
    }
}