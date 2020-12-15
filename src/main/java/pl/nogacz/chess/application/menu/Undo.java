package pl.nogacz.chess.application.menu;

import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import jdk.internal.net.http.common.SubscriberWrapper;
import pl.nogacz.chess.board.Board;
import pl.nogacz.chess.board.Coordinates;
import pl.nogacz.chess.application.ChessNotation;
import pl.nogacz.chess.pawns.PawnClass;

public class Undo{

    public Undo(){
        String lastMove=ChessNotation.removeMovement();

        String computer = lastMove.substring(lastMove.indexOf(" ")+1);
        String player = lastMove.substring(0,lastMove.indexOf(" "));

        removeMovement(computer);
        removeMovement(player);
    }

    public static Coordinates getCoordinate(String s){
        char letter = s.charAt(0);
        int y = Integer.parseInt(s.substring(1));
        int x = -1;
        y--;
        if(letter == 'a'){
            x = 0;
        }
        else if(letter == 'b'){
            x = 1;
        }
        else if(letter == 'c'){
            x = 2;
        }
        else if(letter == 'd'){
            x = 3;
        }
        else if(letter == 'e'){
            x = 4;
        }
        else if(letter == 'f'){
            x = 5;
        }
        else if(letter == 'g'){
            x = 6;
        }
        else if(letter == 'h'){
            x = 7;
        }
        y = 7-y;
        Coordinates coordinate = new Coordinates(x,y);
        return coordinate;
    }
    
    public void removeMovement(String movement){

        ArrayList<Character> pawnCodes = new ArrayList();

        pawnCodes.add('H');
        pawnCodes.add('S');
        pawnCodes.add('K');
        pawnCodes.add('W');
        pawnCodes.add('G');


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
        String movementOld = movement.substring(0,2);
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