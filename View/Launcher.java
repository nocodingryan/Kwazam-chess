package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Launcher extends JFrame {

    private static JFrame popupframe;
    private JButton launchButton;
    private JButton rulesButton;

    public Launcher() {
        setTitle("Kwazam Chess Launcher");
        JPanel frame = new JPanel(new GridLayout(3, 1));
        add(frame);
        setSize(500, 500);
        setLocation(800, 350);

        launchButton = new JButton("Play Kwazam Chess");
        frame.add(launchButton);

        rulesButton = new JButton("Rules");
        frame.add(rulesButton);
        rulesButton.addActionListener(new ActionListener() {
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

    public JButton getLaunchButton() {
        return launchButton;
    }
}
