package pl.nogacz.chess.application.menu;

import pl.nogacz.chess.application.ChessNotation;
import pl.nogacz.chess.board.Board;
import pl.nogacz.chess.board.Coordinates;

public class Undo {
    public static boolean isPawnPlayer=true;
    public static boolean isPawnComputer=true;

    public Undo(){
        Coordinates oldC;
        Coordinates neuC;
        Coordinates oldP;
        Coordinates neuP;
        boolean didCEat=false;
        boolean didPEat=false;
        if (ChessNotation.getMovesList().size()!=0) {
            isPawnPlayer=true;
            isPawnComputer=true;
            String lastMove = ChessNotation.removeFromMovesList(ChessNotation.getMovesList());
            String playerMove = lastMove.substring(0, lastMove.indexOf(" "));
            String computerMove = lastMove.substring(lastMove.indexOf(" ") + 1);
            if (Character.isUpperCase(computerMove.charAt(0))) {
                isPawnComputer = false;
                computerMove = computerMove.substring(1);
            }
            if (computerMove.charAt(0) == 'x') {
                computerMove = computerMove.substring(1);
                didCEat = true;
            }
            if (Character.isUpperCase(playerMove.charAt(0))) {
                isPawnPlayer = false;
                playerMove = playerMove.substring(1);
            }
            if (playerMove.charAt(0) == 'x') {
                playerMove = playerMove.substring(1);
                didPEat = true;
            }
            oldC = getCoordinate(computerMove.substring(0, 2));
            neuC = getCoordinate(computerMove.substring(2, 4));
            oldP = getCoordinate(playerMove.substring(0, 2));
            neuP = getCoordinate(playerMove.substring(2, 4));

            Board.undo(neuC, oldC);
            if (didCEat) {
                Board.undo(neuC, ChessNotation.removeFromEaten(ChessNotation.getEatenList()));
            }
            Board.undo(neuP, oldP);
            if (didPEat) {
                Board.undo(neuP, ChessNotation.removeFromEaten(ChessNotation.getEatenList()));
            }
        }
    }
    public static Coordinates getCoordinate(String coordinate){
        char positionletter = coordinate.charAt(0);
        int x = 8;
        int y = 7-((coordinate.charAt(1)-'0')-1); //In normal chess boards indexing starts with 1 on the left bottom corner. To make it more understandable substraction from 7 is required
        switch (positionletter){
            case 'a':
                x=0;
                break;
            case 'b':
                x=1;
                break;
            case 'c':
                x=2;
                break;
            case 'd':
                x=3;
                break;
            case 'e':
                x=4;
                break;
            case 'f':
                x=5;
                break;
            case 'g':
                x=6;
                break;
            case 'h':
                x=7;
                break;
        }
        return new Coordinates(x,y);
    }
}
