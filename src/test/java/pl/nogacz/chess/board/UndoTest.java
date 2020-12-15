package pl.nogacz.chess.board;

import org.junit.Test;

import org.junit.Assert;
import java.util.ArrayList;
import static org.junit.Assert.*;

import pl.nogacz.chess.application.menu.Undo;

public class UndoTest{

    @Test
    public void testCoordinate(){
        Coordinates coordinate = new Coordinates(0,0);

        assertEquals(coordinate, Undo.getCoordinate("a8"));
    }

    @Test (expected = NullPointerException.class)
    public void testNullCoordinate(){
        Undo.getCoordinate(null);
        fail();
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testEmptyString(){
        Undo.getCoordinate("");
        fail();
    }
}