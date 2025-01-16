package Model;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Tor extends Chesspiece {

    protected String name = "Tor";
    private int turn = 0;
    private int moveDirection;

    public Tor(Color color, String imagePath, Position pos) {
        super(color, imagePath, pos);
        this.moveDirection = (color == Color.BLUE) ? -1 : 1;
    }

    // Movement logic ONLY, actual moving or capturing will not be implemented here
    @Override
    public Set<Position> ifValidMove(ChessModel model) {
        Set<Position> validMoves = new HashSet<>();
        int currentX = position.getX();
        int currentY = position.getY();
    
        // Define the four possible directions for a rook
        int[][] directions = {
            {1, 0},  // Right
            {-1, 0}, // Left
            {0, 1},  // Down
            {0, -1}  // Up
        };
    
        for (int[] direction : directions) {
            int tempX = direction[0];
            int tempY = direction[1];
            int nextX = currentX + tempX;
            int nextY = currentY + tempY;
    
            // Move in the current direction until hitting the edge or a piece
            while (nextX >= 0 && nextX < model.getBoardWidth() &&
                   nextY >= 0 && nextY < model.getBoardHeight()) {
    
                Chesspiece targetPiece = model.getPiece(nextX, nextY);
    
                if (targetPiece != null) { 
                    // If an opponent's piece, capture is possible
                    if (!targetPiece.getColor().equals(this.getColor())) {
                        validMoves.add(new Position(nextX, nextY));
                    }
                    break; // Stop moving in this direction after hitting a piece
                }
    
                // No piece, add the move and continue in the direction
                validMoves.add(new Position(nextX, nextY));
                nextX += tempX;
                nextY += tempY;
            }
        }
    
        return validMoves;
    }   
}