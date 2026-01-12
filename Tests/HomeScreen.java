

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class HomeScreen implements ActionListener {

        // Properties
        JFrame theFrame = new JFrame("Rock Paper Scissors Lizard Spock");
        JPanel thePanel = new JPanel();
        JTextField PlayerTextField1 = new JTextField("P1");
        JButton theButton1 = new JButton("Rock");
        JButton theButton2 = new JButton("Paper");
        JButton theButton3 = new JButton("Scissors");
        JButton theButton4 = new JButton("Lizard");
        JButton theButton5 = new JButton("Spock");

        // Array
        String[] strChoiceNames = {"Rock", "Paper", "Scissors", "Lizard", "Spock"};

        // Math


        // Methods
        public void actionPerformed(ActionEvent evt) {
            if(evt.getSource() == theButton1) {


            } else if(evt.getSource() == theButton2) {

                
            } else if(evt.getSource() == theButton3) {

                
            } else if(evt.getSource() == theButton4) {

                
            } else if(evt.getSource() == theButton5) {

                
            }
        }
        // Constructor
        public HomeScreen() {
            new HomeScreen();

        }
        
    }

   
    
