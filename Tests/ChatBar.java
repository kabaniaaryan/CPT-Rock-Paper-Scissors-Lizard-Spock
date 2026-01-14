package Tests;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ChatBar implements ActionListener{
    // Properties
    JFrame theFrame = new JFrame("GAME");
    HomeScreen homePanel = new HomeScreen();
    JButton serverButton = new JButton("Host Game");
    JButton clientButton = new JButton("Join Game");
    JTextField ipField = new JTextField();
    JTextField messageField = new JTextField();
    JTextArea chatArea = new JTextArea();
    JScrollPane theScroll = new JScrollPane(chatArea);

    // Methods
    public void actionPerformed(ActionEvent evt) {
        // To be implemented
    }

    // Constructor
    public ChatBar(){
        // Frame & Panel
        homePanel.setPreferredSize(new Dimension(1280,720));
        homePanel.setLayout(null);
        theFrame.setContentPane(homePanel);
        theFrame.pack();
        theFrame.setVisible(true);

        // Buttons, TextFields, TextAreas, ScrollPanes
        serverButton.setSize(100, 100);
        serverButton.setLocation(0, 620);
        homePanel.add(serverButton);

        clientButton.setSize(100, 100);
        clientButton.setLocation(100, 620);
        homePanel.add(clientButton);

        ipField.setSize(100, 100);
        ipField.setLocation(200, 620);
        homePanel.add(ipField);

        messageField.setSize(300, 40);
        messageField.setLocation(980, 680);
        homePanel.add(messageField);

        theScroll.setSize(300, 500);
        theScroll.setLocation(980, 100);
        chatArea.setEditable(false);
        homePanel.add(theScroll);
    }

    // Main Method
    public static void main(String[] args){
        ChatBar CB = new ChatBar();
    }
}
