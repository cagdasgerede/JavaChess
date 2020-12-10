package pl.nogacz.chess.board;

import org.junit.Test;

import static org.junit.Assert.*;

public class TurnMechanismTest {

    @Test
    public void isFirstTurnWhite(){
        assertEquals(1, Board.whoseTurn());
    }

    @Test
    public void isTurnChanging(){
        Board.changeTurn();
        assertEquals(0, Board.whoseTurn());
    }

    @Test
    public void isGameModePlayerVsComputerAtStartup(){
        assertEquals("playerVsComputer", Board.getGameMode());
    }

    @Test
    public void isGameModeChanging(){
        Board.setGameMode(0);
        assertEquals("playerVsPlayer", Board.getGameMode());
    }
}
