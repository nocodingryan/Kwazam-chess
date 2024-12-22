
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class kclauncher extends JFrame {

    public static JFrame popupframe;

    public kclauncher() {
        super("Kwazam Chess Launcher");
        JPanel frame = new JPanel(new GridLayout(3, 1));
        add(frame);
        setSize(500, 500);
        setLocation(800, 350);

        JButton launchButton = new JButton("Play Kwazam Chess");
        frame.add(launchButton);
        launchButton.addActionListener(new chessboard());

        JButton rulesbutton = new JButton("Rules");
        frame.add(rulesbutton);
        rulesbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRulesWindow();
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    private static void showRulesWindow() {
        popupframe = new JFrame("Rules");
        popupframe.setSize(400, 400);
        popupframe.setLayout(new BorderLayout());

        JTextArea rules = new JTextArea("test");
        rules.setEditable(false);
        rules.setFont(new Font("Century Gothic", Font.CENTER_BASELINE, 20));
        rules.setBackground(popupframe.getBackground());
        popupframe.add(new JScrollPane(rules), BorderLayout.NORTH);
        popupframe.setVisible(true);


    }

    public static void main(String[] args) {
        new kclauncher();
    }
}
