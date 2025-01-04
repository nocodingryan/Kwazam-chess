package Model;

import java.awt.*;

public class ChessModel {

    private Color currentPlayer;
    private int round = 0;
    private Chesspiece[][] board;

    public ChessModel() {
        System.out.println("Loading Model..");
        board = new Chesspiece[8][5];
        currentPlayer = Color.blue;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getRound() {
        return round;
    }

    public void setCurrentPlayer(Color currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public Chesspiece[][] getBoard() {
        return board;
    }

    public int getBoardWidth() {
        return board.length;
    }

    public int getBoardHeight() {
        return board[0].length;
    }

    public void setPiece(int col, int row, Chesspiece cp) {
        if (cp != null && col >= 0 && row >= 0 && col < board.length && row < board[col].length) {
            board[col][row] = cp;
        }
    }

    public Chesspiece getPiece(int col, int row) {
        if (col >= 0 && row >= 0 && col < board.length && row < board[col].length) {
            return board[col][row];
        }
        return null;
    }

    public void initializeChesspiece() {
        for (int col = 0; col < 5; col++) {
            board[6][col] = new Ram(Color.BLUE, "/images/RamBlue.png", new Position(1, col));
            switch (col) {
                case 0:
                    board[7][col] = new Xor(Color.BLUE, "/images/XorBlue.png", new Position(0, col));
                    break;
                case 1:
                    board[7][col] = new Biz(Color.BLUE, "/images/BizBlue.png", new Position(0, col));
                    break;
                case 2:
                    board[7][col] = new Sau(Color.BLUE, "/images/SauBlue.png", new Position(0, col));
                    break;
                case 3:
                    board[7][col] = new Biz(Color.BLUE, "/images/BizBlue.png", new Position(0, col));
                    break;
                case 4:
                    board[7][col] = new Tor(Color.BLUE, "/images/TorBlue.png", new Position(0, col));
                    break;
            }
        }

        for (int col = 0; col < 5; col++) {
            board[1][col] = new Ram(Color.RED, "/images/Ram.png", new Position(6, col));
            switch (col) {
                case 0:
                    board[0][col] = new Tor(Color.BLUE, "/images/Tor.png", new Position(7, col));
                    break;
                case 1:
                    board[0][col] = new Biz(Color.BLUE, "/images/Biz.png", new Position(7, col));
                    break;
                case 2:
                    board[0][col] = new Sau(Color.BLUE, "/images/Sau.png", new Position(7, col));
                    break;
                case 3:
                    board[0][col] = new Biz(Color.BLUE, "/images/Biz.png", new Position(7, col));
                    break;
                case 4:
                    board[0][col] = new Xor(Color.BLUE, "/images/Xor.png", new Position(7, col));
                    break;
            }
        }
    }
    // Added Method: Move a piece and handle capturing

    public boolean movePiece(int fromCol, int fromRow, int toCol, int toRow) {
        if (!isValidPosition(fromCol, fromRow) || !isValidPosition(toCol, toRow)) {
            return false;
        }

        Chesspiece movingPiece = getPiece(fromCol, fromRow);
        if (movingPiece == null) {
            System.out.println("No piece at the selected position.");
            return false;
        }

        Chesspiece targetPiece = getPiece(toCol, toRow);
        if (targetPiece != null) {
            if (targetPiece.getColor().equals(movingPiece.getColor())) {
                System.out.println("Cannot move to a position occupied by your own piece.");
                return false;
            } else {
                System.out.println("Capturing opponent's piece.");
                board[toCol][toRow] = null; // Remove opponent's piece
            }
        }

        // Move the piece
        board[toCol][toRow] = movingPiece;
        board[fromCol][fromRow] = null;

        // Update the position of the moving piece
        movingPiece.setPos(new Position(toCol, toRow));
        System.out.println("Moved piece to (" + toCol + ", " + toRow + ")");
        return true;
    }

// Added Method: Validate board positions
    private boolean isValidPosition(int col, int row) {
        return col >= 0 && row >= 0 && col < getBoardWidth() && row < getBoardHeight();
    }
}
