package Controller;

import Model.*;
import View.*;
import java.awt.event.*;

public class ChessController {

    private ChessModel model;
    private Chessboard board;
    private Position selectedPos = null;

    public ChessController(ChessModel model, Chessboard board) {
        System.out.println("Loading ChessController..");
        this.model = model;
        this.board = board;
        model.initializeChesspiece();
        board.initializeBoard(model);
        board.setVisible(true);
        InputHandler inputHandler = new InputHandler(board, model);
        board.addMouseListener(inputHandler);
        board.addMouseMotionListener(inputHandler);
    }

    private class InputHandler extends MouseAdapter {
        private ChessModel model;
        private Chessboard board;

        public InputHandler(Chessboard board, ChessModel model) {
            this.board = board;
            this.model = model;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            int col = mapToBoardCoordinate(e.getX(), board.getWidth(), model.getBoardWidth());
            int row = mapToBoardCoordinate(e.getY(), board.getHeight(), model.getBoardHeight());
            selectedPos = new Position(col, row);

            Chesspiece piece = model.getPiece(col, row);
            if (piece != null) {
                board.selectedPiece = piece;
                System.out.println("Piece selected at: " + col + ", " + row);
            } else {
                System.out.println("No piece selected.");
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (board.selectedPiece != null) {
                int col = mapToBoardCoordinate(e.getX(), board.getWidth(), model.getBoardWidth());
                int row = mapToBoardCoordinate(e.getY(), board.getHeight(), model.getBoardHeight());
                Position targetPos = new Position(col, row);

                if (model.movePiece(selectedPos.getX(), selectedPos.getY(), col, row)) {
                    board.refreshBoard(model);
                    selectedPos = targetPos; // Update selectedPos to the new position
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            board.selectedPiece = null;
            selectedPos = null;
            System.out.println("Mouse released.");
        }

        /**
         * Maps a pixel coordinate to a board array index.
         *
         * @param pixel       The pixel coordinate (x or y).
         * @param dimension   The full width or height of the chessboard.
         * @param boardSize   The number of columns or rows on the chessboard.
         * @return The board array index.
         */
        private int mapToBoardCoordinate(int pixel, int dimension, int boardSize) {
            return pixel * boardSize / dimension;
        }
    }
}