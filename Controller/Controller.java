package Controller;

import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class Controller {
    private chessModel model;
    private Chessboard view;
    private Position selectedPosition = null;
    
    public Controller(chessModel model, Chessboard view) {
        this.model = model;
        this.view = view;

        // Register button click events
        view.addBoardClickListener(new BoardClickListener());
    }

    private class BoardClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Parse button position
            String[] coords = e.getActionCommand().split(",");
            int col = Integer.parseInt(coords[0]);
            int row = Integer.parseInt(coords[1]);

            if (selectedPosition == null) {
                // Select a piece
                chesspiece piece = model.getPiece(col, row);
                if (piece != null && piece.getColor().equals(model.getCurrentPlayer())) {
                    selectedPosition = new Position(col, row);
                    view.highlightValidMoves(piece.calculateValidMoves(model));
                }
            } else {
                // Move selected piece
                Position target = new Position(col, row);
                chesspiece selectedPiece = model.getPiece(selectedPosition.getX(), selectedPosition.getY());
                if (selectedPiece != null && model.movePiece(selectedPiece, target)) {
                    model.switchSides();
                }
                selectedPosition = null;
                view.updateBoard();
            }
        }
    }
}


