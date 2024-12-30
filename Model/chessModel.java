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
}
