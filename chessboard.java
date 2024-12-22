
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class chessboard implements ActionListener {

    private static JFrame boardframe;

    @Override
    public void actionPerformed(ActionEvent e) {
        showChessboard();
    }

    private static void showChessboard() {
        boardframe = new JFrame("Chessboard");
        boardframe.setSize(500, 800);
        boardframe.setLayout(new GridLayout(8,5));

        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 5; row++) {
                JButton cell = new JButton();
                cell.setBackground((row + col) % 2 == 0 ? Color.WHITE : Color.WHITE);
                boardframe.add(cell);
            }
        }
        boardframe.setVisible(true);
    }
}
