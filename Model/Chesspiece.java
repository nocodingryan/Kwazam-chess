package Model;

import java.awt.*;
import java.util.*;
import javax.swing.ImageIcon;

public abstract class Chesspiece {
    protected ImageIcon images;
    protected Position position;
    protected Color color;

    public Chesspiece(Color color, String imagePath, Position pos) {
        System.out.println("Loading Chesspieces...");
        this.color = color;
        this.images = resizeImageIcon(new ImageIcon(getClass().getResource(imagePath)), 90, 90); // Resize to 60x60 pixels
        this.position = pos;
    }

    public Color getColor() {
        return color;
    }
    private String getColorString() {     
        return (color == Color.BLUE)? "Blue" : "Red";
    }

    public ImageIcon getImagePath() {
        return images;
    }

    public Position getPos() {
        return position;
    }

    public void setPos(Position pos) {
        this.position = pos;
    }

    public abstract Set<Position> ifValidMove(ChessModel cboard);

    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int heightreal) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, heightreal, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }

    @Override
    public String toString() {
        Position pos = getPos();
        return getColorString() + " " + getClass().getSimpleName() + " at (" + pos.getX() + ", " + pos.getY() + ")";
    }
}