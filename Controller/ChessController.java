package Controller;

import Model.*;
import View.*;

public class ChessController {
    private ChessModel model;
    private Chessboard board;
    private Position selectedPosition = null;
    
    public ChessController(ChessModel model, Chessboard board) {
        System.out.println("Loading ChessController..");
        this.model = model;
        this.board = board;
        model.initializeChesspiece();
        board.initializeBoard(model);
        board.setVisible(true);
    }
}


