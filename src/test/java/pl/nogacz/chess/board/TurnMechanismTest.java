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
        try{
            Thread.sleep(3);
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
        assertEquals(Board.PLAYER_VS_PLAYER, Board.getGameMode());
    }
}
