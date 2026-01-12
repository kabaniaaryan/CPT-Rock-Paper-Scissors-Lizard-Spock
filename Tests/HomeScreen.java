package Tests;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class HomeScreen implements ActionListener {

        // Properties
        JFrame theFrame = new JFrame("Rock Paper Scissors Lizard Spock");
        JPanel thePanel = new JPanel();
        JButton serverButton = new JButton("Host Game");
        JButton clientButton = new JButton("Join Game");

        // Methods
        public void actionPerformed(ActionEvent evt) {
            if(evt.getSource() == serverButton){
                System.out.println("Hosting Game");
            }else if(evt.getSource() == clientButton){
                System.out.println("Joining Game");
            }
        }

        // Constructor
        public HomeScreen(){
            thePanel.setPreferredSize(new Dimension(1280, 720));
            thePanel.setLayout(null);
            theFrame.setContentPane(thePanel);
            theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            theFrame.pack();
            theFrame.setVisible(true);

            serverButton.setSize(880, 100);
            serverButton.setLocation(200, 500);
            serverButton.addActionListener(this);

            clientButton.setSize(880, 100);
            clientButton.setLocation(200, 610);
            clientButton.addActionListener(this);

            thePanel.add(serverButton);
            thePanel.add(clientButton);
        }

        // Main Method
        public static void main(String[] args){
            HomeScreen hs = new HomeScreen();
        }
        
    }

   
    
