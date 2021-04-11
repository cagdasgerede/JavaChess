package pl.nogacz.chess.application;

import org.junit.Test;
import pl.nogacz.chess.application.menu.Undo;
import pl.nogacz.chess.board.Coordinates;

import static org.junit.Assert.*;

public class UndoFeatureTest {
    @Test
    public void convertingCoordinate(){
        Coordinates coordinate0 = new Coordinates(7,7);
        Coordinates coordinate1 = new Coordinates(6,6);
        Coordinates coordinate2 = new Coordinates(1,4);
        Coordinates coordinate3 = new Coordinates(2,3);
        Coordinates coordinate4 = new Coordinates(5,4);
        Coordinates coordinate5 = new Coordinates(3,1);
        assertEquals(coordinate0, Undo.getCoordinate("h1"));
        assertEquals(coordinate1,Undo.getCoordinate("g2"));
        assertEquals(coordinate2,Undo.getCoordinate("b4"));
        assertEquals(coordinate3,Undo.getCoordinate("c5"));
        assertEquals(coordinate4,Undo.getCoordinate("f4"));
        assertEquals(coordinate5,Undo.getCoordinate("d7"));
    }
    @Test (expected = NullPointerException.class)
    public void nullMovesListTest(){
        ChessNotation.setMovesList(null);
        fail();
    }
    @Test (expected = NullPointerException.class)
    public void nullCoordinateTest(){
        Undo.getCoordinate(null);
        fail();
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void indexOutOfBoundsTest(){
        Undo.getCoordinate("a");
        fail();
    }
    @Test (expected = AssertionError.class)
    public void invalidYCoordinateTest(){
        Undo.getCoordinate("a9");
        fail();
    }
    @Test (expected = AssertionError.class)
    public void invalidXCoordinateTest(){
        Undo.getCoordinate("k1");
        fail();
    }
}
