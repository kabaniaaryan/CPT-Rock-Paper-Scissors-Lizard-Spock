package Tests;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ChatBar {
    // Properties
    JFrame theFrame = new JFrame("GAME");
    QuarterFinal qfPanel = new QuarterFinal();
    JButton serverButton = new JButton("Host Game");
    JButton clientButton = new JButton("Join Game");
    JTextField ipField = new JTextField();

    // Methods

    // Constructor
    public ChatBar(){
        // Frame & Panel
        qfPanel.setPreferredSize(new Dimension(1280,720));
        qfPanel.setLayout(null);
        theFrame.setContentPane(qfPanel);
        theFrame.pack();
        theFrame.setVisible(true);

        // Buttons, TextFields, TextAreas, ScrollPanes
        serverButton.setSize(100, 100);
        serverButton.setLocation(0, 620);
        qfPanel.add(serverButton);

        clientButton.setSize(100, 100);
        clientButton.setLocation(100, 620);
        qfPanel.add(clientButton);

        ipField.setSize(100, 100);
        ipField.setLocation(200, 620);
        qfPanel.add(ipField);
    }

    // Main Method
    public static void main(String[] args){
        ChatBar CB = new ChatBar();
    }
}
