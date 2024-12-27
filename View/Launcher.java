package View;

import Model.*;
import Controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Launcher extends JFrame {

    private static JFrame popupframe;

    public Launcher() {
        setTitle("Kwazam Chess Launcher");
        JPanel frame = new JPanel(new GridLayout(3, 1));
        add(frame);
        setSize(500, 500);
        setLocation(800, 350);

        JButton launchButton = new JButton("Play Kwazam Chess");
        frame.add(launchButton);
        launchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chessModel model = new chessModel();
                Chessboard view = new Chessboard(model);
                view.setVisible(true); // Display the chessboard
            }
        });

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
}
