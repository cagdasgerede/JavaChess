package pl.nogacz.chess.application.menu;

import java.util.ArrayList;
import pl.nogacz.chess.application.ChessNotation;
import pl.nogacz.chess.board.Board;
import pl.nogacz.chess.board.Coordinates;
import pl.nogacz.chess.pawns.PawnClass;

public class Undo {

    private final char QUEEN = 'H';
    private final char KING = 'K';
    private final char KNIGHT = 'S';
    private final char BISHOP = 'G';
    private final char ROOK = 'W';

    public Undo() {
        String lastMove=ChessNotation.removeMovement();

        if(lastMove.equals("")) {
            System.out.println("No moves detected!");
        }
        else {
            String computer = lastMove.substring(lastMove.indexOf(" ") + 1);
            String player = lastMove.substring(0,lastMove.indexOf(" "));

            removeMovement(computer);
            removeMovement(player);
        }
    }

    public static Coordinates getCoordinate(String s){
        char letter = s.charAt(0);
        int y = Integer.parseInt(s.substring(1));
        int x = -1;
        y--;
        switch(letter){
            case 'a':
                x = 0;
                break;
            case 'b':
                x = 1;
                break;
            case 'c':
                x = 2;
                break;
            case 'd':
                x = 3;
                break;
            case 'e':
                x = 4;
                break;
            case 'f':
                x = 5;
                break;
            case 'g':
                x = 6;
                break;
            case 'h':
                x = 7;
                break;
        }
        y = 7 - y;
        Coordinates coordinate = new Coordinates(x,y);
        return coordinate;
    }
    
    private void removeMovement(String movement){

        ArrayList<Character> pawnCodes = new ArrayList();

        pawnCodes.add(QUEEN);
        pawnCodes.add(KING);
        pawnCodes.add(KNIGHT);
        pawnCodes.add(ROOK);
        pawnCodes.add(BISHOP);

        Coordinates oldCoordinate;
        Coordinates newCoordinate;
        boolean pieceRemoved = false;

        if(pawnCodes.contains(movement.charAt(0))){
            movement = movement.substring(1);
        }
        if(movement.charAt(0) == 'x'){
            pieceRemoved = true;
            movement = movement.substring(1);
        }
        String movementOld = movement.substring(0, 2);
        String movementNew = movement.substring(2);
        oldCoordinate = getCoordinate(movementOld);
        newCoordinate = getCoordinate(movementNew);
        Board.undo(oldCoordinate, newCoordinate);
        if(pieceRemoved){
            PawnClass pawn = ChessNotation.removeKicked();
            Board.resurrection(pawn, newCoordinate);
        }

    }

}