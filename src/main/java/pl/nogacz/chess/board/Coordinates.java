package pl.nogacz.chess.board;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Dawid Nogacz on 01.05.2019
 */
public class Coordinates implements Serializable {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Coordinates(Coordinates coordinate){
        this.x=coordinate.getX();
        this.y=coordinate.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isValid() {
        return x <= 7 && x >=0 && y <= 7 && y >= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}