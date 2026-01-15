package Tests;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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
    JTextField messageField2 = new JTextField();
    JTextArea chatArea2 = new JTextArea();
    JScrollPane theScroll2 = new JScrollPane(chatArea2);

    SuperSocketMaster ssm = null;
    int intPNumber = 0;
    int intPNumberTemp = 0;
    String strName = "";
    int intPlayerCount = 0;
    int intFinalPlayer = 0;
    boolean blnIsHost = false;
    boolean blnHostPass = false;
    boolean blnNAssigned = false;
    boolean blnLastPlayer = false;
    boolean blnGameStarted = false;

    // Methods
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == serverButton){
            ssm = new SuperSocketMaster(8765, this);
            System.out.println("Hosting Game");
            serverButton.setVisible(false);
            startButton.setVisible(true);
            clientButton.setVisible(false);
            ssm.connect();
            blnIsHost = true;
            blnHostPass = true;
            blnNAssigned = true;
            intPlayerCount = 1;
            intPNumber = 1;
            intPNumberTemp = 2;
            strName = "[P1]";
        }else if(evt.getSource() == clientButton){
            ssm = new SuperSocketMaster(ipField.getText(), 8765, this);
            ipField.setText("");
            serverButton.setVisible(false);
            clientButton.setVisible(false);
            ssm.connect();
            System.out.println("Joining Game");
            blnNAssigned = false;
            blnLastPlayer = true;
            ssm.sendText("SERVER_NEW_PLAYER");
        }else if(evt.getSource() == startButton){
            System.out.println("Starting Game");
            if(intPlayerCount % 2 == 0){
                ssm.sendText("GAME_START_EVEN");
            }else{
                ssm.sendText("GAME_START_ODD");
            }
            homePanel.setVisible(false);
            theFrame.setContentPane(qfPanel);
            theFrame.pack();
            blnGameStarted = true;
        }else if(evt.getSource() == messageField){
            String strMessage = messageField.getText();
            ssm.sendText("[" + intPNumber + "] " + strMessage);
            chatArea.append("[" + intPNumber + "] " + strMessage + "\n");
            messageField.setText("");
        }else if(evt.getSource() == messageField2){
            String strMessage = messageField2.getText();
            ssm.sendText("[" + intPNumber + "] " + strMessage);
            chatArea2.append("[" + intPNumber + "] " + strMessage + "\n");
            messageField2.setText("");
        }else if(evt.getSource() == ssm){
            String strMessage = ssm.readText();
            if(strMessage.equals("SERVER_NEW_PLAYER")){
                if(blnIsHost == true){
                    intPNumberTemp++;
                    intPlayerCount++;
                    ssm.sendText(intPNumberTemp+"");
                }else{
                    blnLastPlayer = false;
                }
            }else if(blnNAssigned == false){
                intPNumber = Integer.parseInt(strMessage);
                blnNAssigned = true;
            }else if(strMessage.equals("GAME_START_ODD")){
                homePanel.setVisible(false);
                theFrame.setContentPane(qfPanel);
                theFrame.pack();
                blnGameStarted = true;
            }else if(strMessage.equals("GAME_START_EVEN")){
                if(blnLastPlayer == true){
                    intPNumber = 2;
                }
                homePanel.setVisible(false);
                theFrame.setContentPane(qfPanel);
                theFrame.pack();
                blnGameStarted = true;
            }else{
                if(blnGameStarted == false){
                    chatArea.append(strMessage + "\n");
                }else{
                    chatArea2.append(strMessage + "\n");
                }
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

        // Quarter Final Panel Chat Components
        messageField2.setSize(300, 40);
        messageField2.setLocation(980, 680);
        qfPanel.add(messageField2);
        messageField2.addActionListener(this);

        theScroll2.setSize(300, 500);
        theScroll2.setLocation(980, 100);
        chatArea2.setEditable(false);
        qfPanel.add(theScroll2);
    }

    // Main Method
    public static void main(String[] args){
        new ChatBar();
    }
}
