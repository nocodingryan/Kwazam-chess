package Model;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public abstract class chesspiece {

    protected ImageIcon images;
    protected Position position;
    protected Color color;

    public chesspiece(Color color, String imagePath, Position pos) {
        this.color = color;
        this.images = new ImageIcon(getClass().getResource(imagePath));
        this.position = pos;
    }

    public Color getColor() {
        return color;
    }

    public ImageIcon getImage() {
        return images;
    }

    public Position getPosition() {
        return position;
    }

    public Set<Position> getCaptureMoves(Set<Position> validMoves, chessModel cboard) {
        Set<Position> captureMoves = new HashSet<>();
        for (Position move : validMoves) {
            if (cboard.isEnemyPieceAtPosition(move, this.getColor())) {
                captureMoves.add(move);
            }
        }
        return captureMoves;
    }

    public void setPos(Position pos) {
        this.position = pos;
    }

    public abstract Set<Position> calculateValidMoves(chessModel cboard);

    protected boolean isValidMovePos(int col, int row, chessModel cboard) {
        return col >= 0 && row >= 0 && col < cboard.getBoardWidth() && row < cboard.getBoardHeight();
    }

}
