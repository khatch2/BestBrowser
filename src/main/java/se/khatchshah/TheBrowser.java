package se.khatchshah;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TheBrowser extends JFrame {

    private JTextField addressBar;
    private JEditorPane display;

    TheBrowser(){
        super("The Male Man");

        addressBar = new JTextField("Enter the URL ?");
        addressBar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        loadHtml(actionEvent.getActionCommand());
                        System.out.println("\tJesus\t");
                    }
                }
        );
        add(addressBar, BorderLayout.NORTH);

        display = new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(
                new HyperlinkListener() {
                    @Override
                    public void hyperlinkUpdate(HyperlinkEvent hyperlinkEvent) {
                        if (hyperlinkEvent.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                            loadHtml(hyperlinkEvent.getURL().toString());
                        }
                    }
                }
        );
        add(new JScrollPane(display), BorderLayout.CENTER);
        setSize(500, 300);
        setVisible(true);
    }

    private void loadHtml(String userText) {
        try {
            display.setPage(userText);
            addressBar.setText(userText);
        } catch (Exception e) {
            try {
                display.setPage(e.toString());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

}
