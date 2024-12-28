package Model;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public abstract class Chesspiece {

    protected ImageIcon images;
    protected Position position;
    protected Color color;

    public Chesspiece(Color color, String imagePath, Position pos) {
        this.color = color;
        this.images = resizeImageIcon(new ImageIcon(getClass().getResource(imagePath)), 90, 90); // Resize to 60x60 pixels
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

    public Set<Position> getCaptureMoves(Set<Position> validMoves, ChessModel cboard) {
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

    public abstract Set<Position> ifValidMove(ChessModel cboard);

    protected boolean ifInsideBorder(int col, int row, ChessModel cboard) { // Ensure Chesspiece dont go out of bounds
        return col >= 0 && row >= 0 && col < cboard.getBoardWidth() && row < cboard.getBoardHeight();
    }

    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }

}
