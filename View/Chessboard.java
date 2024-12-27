package View;

import Model.*;
import Controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class Chessboard extends JFrame {

    private JButton[][] boardButtons;
    private chessModel model;


    public Chessboard(chessModel model) {
        this.model = model;
        this.boardButtons = new JButton[model.getBoardWidth()][model.getBoardHeight()];

        setTitle("Kwazam Chess");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 800);
        setLayout(new GridLayout(model.getBoardWidth(), model.getBoardHeight()));

        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < model.getBoardWidth(); i++) {
            for (int j = 0; j < model.getBoardHeight(); j++) {
                JButton button = new JButton();
                button.setActionCommand(i + "," + j);
                boardButtons[i][j] = button;
                add(button);
            }
        }
        updateBoard();
    }

    public void updateBoard() {
        for (int i = 0; i < model.getBoardWidth(); i++) {
            for (int j = 0; j < model.getBoardHeight(); j++) {
                JButton button = boardButtons[i][j];
                chesspiece piece = model.getPiece(i, j);
                if (piece != null) {
                    button.setIcon(piece.getImage());
                } else {
                    button.setIcon(null);
                }
                button.setBackground(Color.WHITE);
            }
        }
        repaint();
    }

    public void highlightValidMoves(Set<Position> validMoves) {
        for (Position pos : validMoves) {
            boardButtons[pos.getX()][pos.getY()].setBackground(Color.YELLOW);
        }
    }

    public void addBoardClickListener(ActionListener listener) {
        for (int i = 0; i < model.getBoardWidth(); i++) {
            for (int j = 0; j < model.getBoardHeight(); j++) {
                boardButtons[i][j].addActionListener(listener);
            }
        }
    }
}
