package Model;

import java.awt.*;
import java.util.Set;

public class ChessModel {

    private Color currentPlayer;
    private int round = 0;
    private Chesspiece[][] board;

    public ChessModel() {
        board = new Chesspiece[8][5];
        currentPlayer = Color.blue;

        initializeBoard();
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

    public void clearBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = null;
            }
        }
    }

    public void initializeBoard() {
        for (int col = 0; col < 5; col++) {
            board[6][col] = new Ram(Color.BLUE, "/images/RamBlue.png", new Position(1, col));
            switch(col) {
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
            switch(col) {
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

    public void reset() {
        clearBoard();
        initializeBoard();
        currentPlayer = Color.blue;
        round = 0;
    }

    public void switchSides() {
        currentPlayer = (currentPlayer == Color.blue) ? Color.red : Color.blue;
    }

    public boolean isEnemyPieceAtPosition(Position pos, Color currentPlayer) {
        Chesspiece pieceAtPos = getPiece(pos.getX(), pos.getY());
        return pieceAtPos != null && !pieceAtPos.getColor().equals(currentPlayer);
    }

    public boolean movePiece(Chesspiece piece, Position newPos) {
        Set<Position> validMoves = piece.ifValidMove(this);
        if (validMoves.contains(newPos)) {
            board[piece.getPosition().getX()][piece.getPosition().getY()] = null;
            piece.setPos(newPos);

            //add an instance when ram reach end of board for it to change direction
            board[newPos.getX()][newPos.getY()] = piece;
            return true;
        } else {
            return false;
        }
    }
}
