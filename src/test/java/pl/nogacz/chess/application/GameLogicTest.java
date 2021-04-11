package pl.nogacz.chess.application;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import pl.nogacz.chess.board.Board;
import pl.nogacz.chess.board.Coordinates;
import pl.nogacz.chess.pawns.Pawn;
import pl.nogacz.chess.pawns.PawnClass;
import pl.nogacz.chess.pawns.PawnColor;

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
    public void isDefaultGameModeComputerVsPlayer() { // check if default game mode is true
        //Given
        PowerMockito.mockStatic(Board.class);
        GameLogic gameLogic = new GameLogic();

        //When
        PowerMockito.when(Board.isGameModePlayervsPlayer()).thenReturn(false); // default game mode is player vs computer
        boolean isDefaultGameModeTrue = Board.isGameModePlayervsPlayer();

        //Then 
        Assert.assertEquals(false, isDefaultGameModeTrue);
    }


    @PrepareForTest({Board.class})
    @Test
    public void isGameModeSuccessfullyChangedToPlayerVsPlayer() { // check if this method can successfully changed the value.
        //Given
        PowerMockito.mockStatic(Board.class);
        GameLogic gameLogic = new GameLogic();

        //When
        Board.changeModePlayerVsPlayer();
        PowerMockito.when(Board.isGameModePlayervsPlayer()).thenReturn(true);
        boolean isGameModeChangedToPlayerVsPlayer = Board.isGameModePlayervsPlayer();

        //Then
        Assert.assertEquals(true, isGameModeChangedToPlayerVsPlayer);

    }



    @PrepareForTest({Board.class})
    @Test
    public void isGameModeSuccessfullyChangedToPlayerVsComputer() { // check if this method can successfully changed the value.
         //Given
         PowerMockito.mockStatic(Board.class);
         GameLogic gameLogic = new GameLogic();
 
         //When
         Board.changeModeComputerVsPlayer();
         PowerMockito.when(Board.isGameModeComputervsPlayer()).thenReturn(true);
         boolean isGameModeChangedToComputerVsPlayer = Board.isGameModeComputervsPlayer();
 
         //Then
         Assert.assertEquals(true, isGameModeChangedToComputerVsPlayer);


    }




}