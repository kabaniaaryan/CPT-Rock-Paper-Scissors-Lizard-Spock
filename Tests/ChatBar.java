package Tests;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ChatBar implements ActionListener{
    // Properties
    JFrame theFrame = new JFrame("GAME");
    HomeScreen homePanel = new HomeScreen();
    QuarterFinal qfPanel = new QuarterFinal();
    JButton serverButton = new JButton("Host Game");
    JButton clientButton = new JButton("Join Game");
    JButton startButton = new JButton("Start Game");
    JTextField ipField = new JTextField();
    JTextField messageField = new JTextField();
    JTextArea chatArea = new JTextArea();
    JScrollPane theScroll = new JScrollPane(chatArea);
    SuperSocketMaster ssm = null;
    int intPNumber = 0;
    String strName = "";
    int intPlayerCount = 0;

    // Methods
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == serverButton){
            ssm = new SuperSocketMaster(8765, this);
            System.out.println("Hosting Game");
            serverButton.setVisible(false);
            startButton.setVisible(true);
            clientButton.setVisible(false);
            chatArea.setEditable(true);
            ssm.connect();
            //intPNumber = 1;
            //strName = "P"+intPNumber;
            //System.out.println(strName+" connected");
        }else if(evt.getSource() == clientButton){
            ssm = new SuperSocketMaster(ipField.getText(), 8765, this);
            ipField.setText("");
            System.out.println("Joining Game");
            serverButton.setVisible(false);
            clientButton.setVisible(false);
            ssm.connect();
            //intPNumber = Integer.parseInt(ssm.readText());
            //intPNumber++;
            //strName = "P"+intPNumber;
            //System.out.println(strName+" connected");
            //ssm.sendText(intPNumber+"");
        }else if(evt.getSource() == startButton){
            System.out.println("Starting Game");
            ssm.sendText("START_GAME");
            homePanel.setVisible(false);
            theFrame.setContentPane(qfPanel);
            theFrame.pack();
        }else if(evt.getSource() == messageField){
            String strMessage = messageField.getText();
            ssm.sendText(strMessage);
            chatArea.append(strMessage + "\n");
            messageField.setText("");
        }else if(evt.getSource() == ssm){
            System.out.println("MESSAGE RECEIVED");
            String strMessage = ssm.readText();
            if(strMessage.equals("START_GAME")){
                homePanel.setVisible(false);
                theFrame.setContentPane(qfPanel);
                theFrame.pack();
            }else{
                chatArea.append(strMessage + "\n");
            }
        }
    }

    // Constructor
    public ChatBar(){
        // Frame & Panel
        homePanel.setPreferredSize(new Dimension(1280,720));
        homePanel.setLayout(null);
        theFrame.setContentPane(homePanel);
        theFrame.pack();
        theFrame.setVisible(true);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        qfPanel.setPreferredSize(new Dimension(1280,720));
        qfPanel.setLayout(null);

        // Buttons, TextFields, TextAreas, ScrollPanes
        serverButton.setSize(100, 100);
        serverButton.setLocation(0, 620);
        homePanel.add(serverButton);
        serverButton.addActionListener(this);

        clientButton.setSize(100, 100);
        clientButton.setLocation(100, 620);
        homePanel.add(clientButton);
        clientButton.addActionListener(this);

        startButton.setSize(100, 100);
        startButton.setLocation(0, 520);
        startButton.setVisible(false);
        homePanel.add(startButton);
        startButton.addActionListener(this);

        ipField.setSize(100, 100);
        ipField.setLocation(200, 620);
        homePanel.add(ipField);

        messageField.setSize(300, 40);
        messageField.setLocation(980, 680);
        homePanel.add(messageField);
        messageField.addActionListener(this);

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
