
import java.awt.*;
import javax.swing.*;

public class kclauncher extends JFrame {

    public kclauncher() {
        super("Kwazam Chess Launcher");
        JPanel frame = new JPanel(new FlowLayout());
        add(frame);
        setSize(500, 500);


        JButton launchButton = new JButton("Play Kwazam Chess");
        frame.add(launchButton);
        launchButton.addActionListener(new chessboard());



        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new kclauncher();
    }
}
