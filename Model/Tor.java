package Model;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Tor extends Chesspiece {

    public Tor(Color color, String imagePath, Position pos) {
        super(color, imagePath, pos);
    }

    @Override
    public Set<Position> ifValidMove(ChessModel cboard) {
        Set<Position> validMoves = new HashSet<>();
        int direction = (this.color == Color.BLUE) ? 1 : -1; // Blue moves down, Red moves up

        int currentCol = position.getX();
        int currentRow = position.getY();

        // Implement movement
        return validMoves;
    }
}
