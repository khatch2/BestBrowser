package se.khatchshah;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TheBrowser extends JFrame {

    private JTextField addressBar;
    private JEditorPane display;

    TheBrowser(){
        super("The Male Man");

        addressBar = new JTextField("Enter the URL ?");
        addressBar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("\tJesus\t");
                    }
                }
        );
    }

}
