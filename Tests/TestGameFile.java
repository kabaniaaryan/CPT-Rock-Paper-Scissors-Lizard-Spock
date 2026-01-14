package Tests;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class TestGameFile implements ActionListener{
    // Properties
    JFrame theFrame = new JFrame("Rock Paper Scissors Lizard Spock");
    HomeScreen thePanel = new HomeScreen();
    JButton serverButton = new JButton("Host Game");
    JButton clientButton = new JButton("Join Game");
    JTextField ipField = new JTextField();
    JButton startButton = new JButton("Start Game");
    JTextArea chatArea = new JTextArea();
    JScrollPane theScroll = new JScrollPane(chatArea);
    SuperSocketMaster ssm = null;
    int intPNumber = 0;
    String strName = "";

    // Game Panels
    QuarterFinal qfPanel = new QuarterFinal();
    SemiFinal sfPanel = new SemiFinal();
    Final fPanel = new Final();
    // Buttons For Quarter Finals
    //Format for naming buttons (Player numbers)(Round)(First Letter of Option - Scissors is C)(Button)
    JButton p1QFRButton = new JButton("ROCK");
    // Buttons for Semi Finals
    // Buttons for Finals

    JButton tempButton1 = new JButton("TO SF");
    JButton tempButton2 = new JButton("to F");
    JButton tempButton3 = new JButton("to QF");


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
            ssm.sendText("THIS IS A TEST");
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
            System.out.println(ssm.readText());
        }else if(evt.getSource() == startButton){
            System.out.println("Starting Game");
            ssm.sendText("START_GAME");
            thePanel.setVisible(false);
            theFrame.setContentPane(qfPanel);
            theFrame.pack();
        }else if(evt.getSource() == ipField){
            String strMessage = ipField.getText();
            ssm.sendText(strMessage);
            chatArea.append(strMessage + "\n");
            ipField.setText("");
        }else if(evt.getSource() == ssm){
            System.out.println("MESSAGE RECEIVED");
            String strMessage = ssm.readText();
            if(strMessage.equals("START_GAME")){
                thePanel.setVisible(false);
            }else{
                chatArea.append(strMessage + "\n");
            }
        }else if(evt.getSource() == tempButton1){
            qfPanel.setVisible(false);
            sfPanel.setVisible(true);
            theFrame.setContentPane(sfPanel);
            theFrame.pack();
        }else if(evt.getSource() == tempButton2){
            sfPanel.setVisible(false);
            fPanel.setVisible(true);
            theFrame.setContentPane(fPanel);
            theFrame.pack();
        }else if(evt.getSource() == tempButton3){
            fPanel.setVisible(false);
            qfPanel.setVisible(true);
            theFrame.setContentPane(qfPanel);
            theFrame.pack();
        }
    }

    // Constructor
    public TestGameFile(){
        // Frames & Panels
        thePanel.setPreferredSize(new Dimension(1280, 720));
        thePanel.setLayout(null);
        theFrame.setContentPane(thePanel);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.pack();
        theFrame.setVisible(true);

        qfPanel.setPreferredSize(new Dimension(1280, 720));
        qfPanel.setLayout(null);

        // Home Screen Components
        serverButton.setSize(680, 100);
        serverButton.setLocation(200, 500);
        serverButton.addActionListener(this);

        clientButton.setSize(680, 100);
        clientButton.setLocation(200, 610);
        clientButton.addActionListener(this);

        ipField.setSize(200, 100);
        ipField.setLocation(900, 610);
        ipField.addActionListener(this);

        startButton.setSize(200, 100);
        startButton.setLocation(900, 500);
        startButton.setVisible(false);
        startButton.addActionListener(this);

        theScroll.setSize(200, 100);
        theScroll.setLocation(900, 300);
        chatArea.setEditable(false);

        thePanel.add(serverButton);
        thePanel.add(clientButton);
        thePanel.add(ipField);
        thePanel.add(startButton);
        thePanel.add(theScroll);

        // Quarter Final Screen Components
        qfPanel.setPreferredSize(new Dimension(1280, 720));
        qfPanel.setLayout(null);
        qfPanel.add(tempButton1);
        tempButton1.setSize(200,100);
        tempButton1.setLocation(900, 300);
        tempButton1.addActionListener(this);
        // Semi Final Screen Components
        sfPanel.setPreferredSize(new Dimension(1280, 720));
        sfPanel.setLayout(null);
        sfPanel.add(tempButton2);
        tempButton2.setSize(200,100);
        tempButton2.setLocation(900, 300);
        tempButton2.addActionListener(this);
        // Final Screen Components
        fPanel.setPreferredSize(new Dimension(1280, 720));
        fPanel.setLayout(null);
        fPanel.add(tempButton3);
        tempButton3.setSize(200,100);
        tempButton3.setLocation(900, 300);
        tempButton3.addActionListener(this);

        // Winner Screen Components
    }

    // Main Method
    public static void main(String[] args){
        TestGameFile tgf = new TestGameFile();
    }
}
