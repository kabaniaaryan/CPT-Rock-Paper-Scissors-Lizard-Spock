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
    SuperSocketMaster ssm = null;

    // Methods
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == serverButton){
            ssm = new SuperSocketMaster(8765, this);
            System.out.println("Hosting Game");
            serverButton.setVisible(false);
            startButton.setVisible(true);
            clientButton.setVisible(false);
            ipField.setVisible(false);
        }else if(evt.getSource() == clientButton){
            ssm = new SuperSocketMaster(ipField.getText(), 8765, this);
            ipField.setText("");
            System.out.println("Joining Game");
        }else if(evt.getSource() == startButton){
            System.out.println("Starting Game");
        }
    }

    // Constructor
    public TestGameFile(){
        thePanel.setPreferredSize(new Dimension(1280, 720));
        thePanel.setLayout(null);
        theFrame.setContentPane(thePanel);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theFrame.pack();
        theFrame.setVisible(true);

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

        thePanel.add(serverButton);
        thePanel.add(clientButton);
        thePanel.add(ipField);
        thePanel.add(startButton);
    }

    // Main Method
    public static void main(String[] args){
        TestGameFile tgf = new TestGameFile();
    }
}
