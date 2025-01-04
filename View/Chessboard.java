package View;

import Model.ChessModel;
import Model.Chesspiece;
import java.awt.*;
import javax.swing.*;

public class Chessboard extends JFrame {

    private JLabel[][] boardLabels;
    private int height = 8; // Number of rows
    private int width = 5;  // Number of columns

    public Chesspiece selectedPiece;
    
    public Chessboard() {
        this.boardLabels = new JLabel[height][width];
        setTitle("Kwazam Chess");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 800);
        setLayout(new GridLayout(height, width));
    }

    public void initializeBoard(ChessModel model) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                JLabel label = new JLabel();
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);

                // Add a checkerboard background
                if ((i + j) % 2 == 0) {
                    label.setBackground(Color.WHITE);
                } else {
                    label.setBackground(Color.GRAY);
                }

                label.setOpaque(true);
                Chesspiece piece = model.getPiece(i, j);
                if (piece != null) {
                    label.setIcon(piece.getImagePath());
                }

                boardLabels[i][j] = label;
                add(label);
            }
        }
    }
    public void refreshBoard(ChessModel model) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Chesspiece piece = model.getPiece(i, j);
                JLabel label = boardLabels[i][j];
                label.setIcon(piece != null ? piece.getImagePath() : null);
            }
        }
    }
}
