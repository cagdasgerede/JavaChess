package pl.nogacz.chess.board;

import org.junit.Test;

import static org.junit.Assert.*;

public class TurnMechanismTest {

    @Test
    public void isFirstTurnWhite(){
        assertEquals(1, Board.whoseTurn());
    }

    @Test
    public void isTurnChangingDouble(){
        int turn = Board.whoseTurn();
        Board.changeTurn();
        Board.changeTurn();
        assertEquals(turn, Board.whoseTurn());
    }

    @Test
    public void isGetGameModeNotNull(){
        String gameMode = Board.getGameMode();
        assertNotNull(gameMode);
    }

    @Test
    public void isGetGameModeWorkingProperly(){
        Board.setGameMode(Board.PLAYER_VS_PLAYER);
        String gameMode = Board.getGameMode();
        assertEquals(gameMode, Board.PLAYER_VS_PLAYER);
    }

    @Test
    public void isTurnChanging(){
        Board.changeTurn();
        assertEquals(0, Board.whoseTurn());
    }

    @Test
    public void isGameModePlayerVsComputerAtStartup(){
        assertEquals(Board.PLAYER_VS_COMPUTER, Board.getGameMode());
    }

    @Test
    public void isGameModeChanging(){
        Board.setGameMode(Board.PLAYER_VS_PLAYER);
        assertEquals(Board.PLAYER_VS_PLAYER, Board.getGameMode());
    }

    @Test
    public void isGameModeCanTurnToPlayerVsComputer(){
        Board.setGameMode(Board.PLAYER_VS_PLAYER);
        Board.setGameMode(Board.PLAYER_VS_COMPUTER);
        assertEquals(Board.PLAYER_VS_COMPUTER, Board.getGameMode());
    }

    @Test
    public void isWaitingForPlayer(){
        Board.setGameMode(Board.PLAYER_VS_PLAYER);
        assertFalse(Board.isComputerRound());
    }

    @Test
    public void isWhoseTurnWorkingProperly(){
        int turn = Board.whoseTurn();
        assertEquals(1, turn);
    }

    @Test
    public void isWhoseTurnWorkingProperlyWhenChangeTurn(){
        Board.changeTurn();
        int turn = Board.whoseTurn();
        assertEquals(0, turn);
    }
}
