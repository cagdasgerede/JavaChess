package pl.nogacz.chess.board;

import org.junit.Test;

import org.junit.Assert;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.*;

import pl.nogacz.chess.application.ChessNotation;
import pl.nogacz.chess.application.menu.Undo;
import pl.nogacz.chess.pawns.Pawn;
import pl.nogacz.chess.pawns.PawnClass;
import pl.nogacz.chess.pawns.PawnColor;

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

    @Test
    public void testEmptyRemoveMovement() {
        assertEquals("", ChessNotation.removeMovement());
    }

    @Test
    public void testKickedPawn() {
        PawnClass pawn = new PawnClass(Pawn.PAWN, PawnColor.WHITE);
        ChessNotation.addKicked(pawn);
        assertEquals(pawn, ChessNotation.removeKicked());
    }

    @Test
    public void testKickedNotPawn() {
        PawnClass pawn = new PawnClass(Pawn.QUEEN, PawnColor.WHITE);
        ChessNotation.addKicked(pawn);
        assertEquals(pawn, ChessNotation.removeKicked());
    }

}