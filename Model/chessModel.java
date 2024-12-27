package Model;

import java.awt.*;
import java.util.Set;

public class chessModel {

    private Color currentPlayer;
    private int round = 0;
    private chesspiece[][] board;

    public chessModel() {
        board = new chesspiece[8][5];
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

    public chesspiece[][] getBoard() {
        return board;
    }

    public int getBoardWidth() {
        return board.length;
    }

    public int getBoardHeight() {
        return board[0].length;
    }

    public void setPiece(int col, int row, chesspiece cp) {
        if (cp != null && col >= 0 && row >= 0 && col < board.length && row < board[col].length) {
            board[col][row] = cp;
        }
    }

    public chesspiece getPiece(int col, int row) {
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

    public void initializeBoard()
    {
        //add chess pieces
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
        chesspiece pieceAtPos = getPiece(pos.getX(), pos.getY());
        return pieceAtPos != null && !pieceAtPos.getColor().equals(currentPlayer);
    }

    public boolean movePiece(chesspiece piece, Position newPos) {
        Set<Position> validMoves = piece.calculateValidMoves(this);
        if(validMoves.contains(newPos))
        {
            board[piece.getPosition().getX()][piece.getPosition().getY()] = null;
            piece.setPos(newPos);


            //add an instance when ram reach end of board for it to change direction

            board[newPos.getX()][newPos.getY()] = piece;
            return true;
        }
        else{
            return false;
        }
    }
}
