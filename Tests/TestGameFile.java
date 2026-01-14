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
    //Format for naming buttons (First Letter of Option - Scissors is C)(Player numbers)(Round)(Button)
    JButton Rp1QFButton = new JButton("ROCK");
    JButton Pp1QFButton = new JButton("PAPER");
    JButton Cp1QFButton = new JButton("SCISSORS");
    JButton Lp1QFButton = new JButton("LIZARD");
    JButton Sp1QFButton = new JButton("SPOCK");

    JButton Rp2QFButton = new JButton("ROCK");
    JButton Pp2QFButton = new JButton("PAPER");
    JButton Cp2QFButton = new JButton("SCISSORS");
    JButton Lp2QFButton = new JButton("LIZARD");
    JButton Sp2QFButton = new JButton("SPOCK");

    JButton Rp3QFButton = new JButton("ROCK");
    JButton Pp3QFButton = new JButton("PAPER");
    JButton Cp3QFButton = new JButton("SCISSORS");
    JButton Lp3QFButton = new JButton("LIZARD");
    JButton Sp3QFButton = new JButton("SPOCK");

    JButton Rp4QFButton = new JButton("ROCK");
    JButton Pp4QFButton = new JButton("PAPER");
    JButton Cp4QFButton = new JButton("SCISSORS");
    JButton Lp4QFButton = new JButton("LIZARD");
    JButton Sp4QFButton = new JButton("SPOCK");

    JButton Rp5QFButton = new JButton("ROCK");
    JButton Pp5QFButton = new JButton("PAPER");
    JButton Cp5QFButton = new JButton("SCISSORS");
    JButton Lp5QFButton = new JButton("LIZARD");
    JButton Sp5QFButton = new JButton("SPOCK");

    JButton Rp6QFButton = new JButton("ROCK");
    JButton Pp6QFButton = new JButton("PAPER");
    JButton Cp6QFButton = new JButton("SCISSORS");
    JButton Lp6QFButton = new JButton("LIZARD");
    JButton Sp6QFButton = new JButton("SPOCK");

    JButton Rp7QFButton = new JButton("ROCK");
    JButton Pp7QFButton = new JButton("PAPER");
    JButton Cp7QFButton = new JButton("SCISSORS");
    JButton Lp7QFButton = new JButton("LIZARD");
    JButton Sp7QFButton = new JButton("SPOCK");

    JButton Rp8QFButton = new JButton("ROCK");
    JButton Pp8QFButton = new JButton("PAPER");
    JButton Cp8QFButton = new JButton("SCISSORS");
    JButton Lp8QFButton = new JButton("LIZARD");
    JButton Sp8QFButton = new JButton("SPOCK");

    // Buttons for Semi Finals
    JButton Rp1SFButton = new JButton("ROCK");
    JButton Pp1SFButton = new JButton("PAPER");
    JButton Cp1SFButton = new JButton("SCISSORS");
    JButton Lp1SFButton = new JButton("LIZARD");
    JButton Sp1SFButton = new JButton("SPOCK");

    JButton Rp3SFButton = new JButton("ROCK");
    JButton Pp3SFButton = new JButton("PAPER");
    JButton Cp3SFButton = new JButton("SCISSORS");
    JButton Lp3SFButton = new JButton("LIZARD");
    JButton Sp3SFButton = new JButton("SPOCK");

    JButton Rp5SFButton = new JButton("ROCK");
    JButton Pp5SFButton = new JButton("PAPER");
    JButton Cp5SFButton = new JButton("SCISSORS");
    JButton Lp5SFButton = new JButton("LIZARD");
    JButton Sp5SFButton = new JButton("SPOCK");

    JButton Rp7SFButton = new JButton("ROCK");
    JButton Pp7SFButton = new JButton("PAPER");
    JButton Cp7SFButton = new JButton("SCISSORS");
    JButton Lp7SFButton = new JButton("LIZARD");
    JButton Sp7SFButton = new JButton("SPOCK");
    // Buttons for Finals
    JButton Rp1FButton = new JButton("ROCK");
    JButton Pp1FButton = new JButton("PAPER");
    JButton Cp1FButton = new JButton("SCISSORS");
    JButton Lp1FButton = new JButton("LIZARD");
    JButton Sp1FButton = new JButton("SPOCK");

    JButton Rp5FButton = new JButton("ROCK");
    JButton Pp5FButton = new JButton("PAPER");
    JButton Cp5FButton = new JButton("SCISSORS");
    JButton Lp5FButton = new JButton("LIZARD");
    JButton Sp5FButton = new JButton("SPOCK");

    //temp buttons
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

        //p1 buttons
        Rp1QFButton.setSize(100,35);
        Rp1QFButton.setLocation(100,125);
        qfPanel.add(Rp1QFButton);
        Pp1QFButton.setSize(100,35);
        Pp1QFButton.setLocation(100,170);
        qfPanel.add(Pp1QFButton);
        Cp1QFButton.setSize(100,35);
        Cp1QFButton.setLocation(225,125);
        qfPanel.add(Cp1QFButton);
        Lp1QFButton.setSize(100,35);
        Lp1QFButton.setLocation(225,170);
        qfPanel.add(Lp1QFButton);
        Sp1QFButton.setSize(100,35);
        Sp1QFButton.setLocation(350,170);
        qfPanel.add(Sp1QFButton);
        //p2 buttons
        Rp2QFButton.setSize(100,35);
        Rp2QFButton.setLocation(650,125);
        qfPanel.add(Rp2QFButton);
        Pp2QFButton.setSize(100,35);
        Pp2QFButton.setLocation(525,170);
        qfPanel.add(Pp2QFButton);
        Cp2QFButton.setSize(100,35);
        Cp2QFButton.setLocation(775,125);
        qfPanel.add(Cp2QFButton);
        Lp2QFButton.setSize(100,35);
        Lp2QFButton.setLocation(650,170);
        qfPanel.add(Lp2QFButton);
        Sp2QFButton.setSize(100,35);
        Sp2QFButton.setLocation(775,170);
        qfPanel.add(Sp2QFButton);
        //p3 buttons
        Rp3QFButton.setSize(100,35);
        Rp3QFButton.setLocation(100,270);
        qfPanel.add(Rp3QFButton);
        Pp3QFButton.setSize(100,35);
        Pp3QFButton.setLocation(100,315);
        qfPanel.add(Pp3QFButton);
        Cp3QFButton.setSize(100,35);
        Cp3QFButton.setLocation(225,270);
        qfPanel.add(Cp3QFButton);
        Lp3QFButton.setSize(100,35);
        Lp3QFButton.setLocation(225,315);
        qfPanel.add(Lp3QFButton);
        Sp3QFButton.setSize(100,35);
        Sp3QFButton.setLocation(350,315);
        qfPanel.add(Sp3QFButton);
        //p4 buttons
        Rp4QFButton.setSize(100,35);
        Rp4QFButton.setLocation(650,270);
        qfPanel.add(Rp4QFButton);
        Pp4QFButton.setSize(100,35);
        Pp4QFButton.setLocation(525,315);
        qfPanel.add(Pp4QFButton);
        Cp4QFButton.setSize(100,35);
        Cp4QFButton.setLocation(775,270);
        qfPanel.add(Cp4QFButton);
        Lp4QFButton.setSize(100,35);
        Lp4QFButton.setLocation(650,315);
        qfPanel.add(Lp4QFButton);
        Sp4QFButton.setSize(100,35);
        Sp4QFButton.setLocation(775,315);
        qfPanel.add(Sp4QFButton);
        //p5 buttons
        Rp5QFButton.setSize(100,35);
        Rp5QFButton.setLocation(100,415);
        qfPanel.add(Rp5QFButton);
        Pp5QFButton.setSize(100,35);
        Pp5QFButton.setLocation(100,460);
        qfPanel.add(Pp5QFButton);
        Cp5QFButton.setSize(100,35);
        Cp5QFButton.setLocation(225,415);
        qfPanel.add(Cp5QFButton);
        Lp5QFButton.setSize(100,35);
        Lp5QFButton.setLocation(225,460);
        qfPanel.add(Lp5QFButton);
        Sp5QFButton.setSize(100,35);
        Sp5QFButton.setLocation(350,460);
        qfPanel.add(Sp5QFButton);
        //p6 buttons
        Rp6QFButton.setSize(100,35);
        Rp6QFButton.setLocation(650,415);
        qfPanel.add(Rp6QFButton);
        Pp6QFButton.setSize(100,35);
        Pp6QFButton.setLocation(525,460);
        qfPanel.add(Pp6QFButton);
        Cp6QFButton.setSize(100,35);
        Cp6QFButton.setLocation(775,415);
        qfPanel.add(Cp6QFButton);
        Lp6QFButton.setSize(100,35);
        Lp6QFButton.setLocation(650,460);
        qfPanel.add(Lp6QFButton);
        Sp6QFButton.setSize(100,35);
        Sp6QFButton.setLocation(775,460);
        qfPanel.add(Sp6QFButton);
        //p7 buttons
        Rp7QFButton.setSize(100,35);
        Rp7QFButton.setLocation(100,560);
        qfPanel.add(Rp7QFButton);
        Pp7QFButton.setSize(100,35);
        Pp7QFButton.setLocation(100,605);
        qfPanel.add(Pp7QFButton);
        Cp7QFButton.setSize(100,35);
        Cp7QFButton.setLocation(225,560);
        qfPanel.add(Cp7QFButton);
        Lp7QFButton.setSize(100,35);
        Lp7QFButton.setLocation(225,605);
        qfPanel.add(Lp7QFButton);
        Sp7QFButton.setSize(100,35);
        Sp7QFButton.setLocation(350,605);
        qfPanel.add(Sp7QFButton);
        //p8 buttons
        Rp8QFButton.setSize(100,35);
        Rp8QFButton.setLocation(650,560);
        qfPanel.add(Rp8QFButton);
        Pp8QFButton.setSize(100,35);
        Pp8QFButton.setLocation(525,605);
        qfPanel.add(Pp8QFButton);
        Cp8QFButton.setSize(100,35);
        Cp8QFButton.setLocation(775,560);
        qfPanel.add(Cp8QFButton);
        Lp8QFButton.setSize(100,35);
        Lp8QFButton.setLocation(650,605);
        qfPanel.add(Lp8QFButton);
        Sp8QFButton.setSize(100,35);
        Sp8QFButton.setLocation(775,605);
        qfPanel.add(Sp8QFButton);

        // Semi Final Screen Components
        sfPanel.setPreferredSize(new Dimension(1280, 720));
        sfPanel.setLayout(null);
        sfPanel.add(tempButton2);
        tempButton2.setSize(200,100);
        tempButton2.setLocation(900, 300);
        tempButton2.addActionListener(this);

        //p1 buttons
        Rp1SFButton.setSize(100,35);
        Rp1SFButton.setLocation(100,270);
        sfPanel.add(Rp1SFButton);
        Pp1SFButton.setSize(100,35);
        Pp1SFButton.setLocation(100,315);
        sfPanel.add(Pp1SFButton);
        Cp1SFButton.setSize(100,35);
        Cp1SFButton.setLocation(225,270);
        sfPanel.add(Cp1SFButton);
        Lp1SFButton.setSize(100,35);
        Lp1SFButton.setLocation(225,315);
        sfPanel.add(Lp1SFButton);
        Sp1SFButton.setSize(100,35);
        Sp1SFButton.setLocation(350,315);
        sfPanel.add(Sp1SFButton);
        //p3 buttons
        Rp3SFButton.setSize(100,35);
        Rp3SFButton.setLocation(650,270);
        sfPanel.add(Rp3SFButton);
        Pp3SFButton.setSize(100,35);
        Pp3SFButton.setLocation(525,315);
        sfPanel.add(Pp3SFButton);
        Cp3SFButton.setSize(100,35);
        Cp3SFButton.setLocation(775,270);
        sfPanel.add(Cp3SFButton);
        Lp3SFButton.setSize(100,35);
        Lp3SFButton.setLocation(650,315);
        sfPanel.add(Lp3SFButton);
        Sp3SFButton.setSize(100,35);
        Sp3SFButton.setLocation(775,315);
        sfPanel.add(Sp3SFButton);
        //p5 buttons
        Rp5SFButton.setSize(100,35);
        Rp5SFButton.setLocation(100,560);
        sfPanel.add(Rp5SFButton);
        Pp5SFButton.setSize(100,35);
        Pp5SFButton.setLocation(100,605);
        sfPanel.add(Pp5SFButton);
        Cp5SFButton.setSize(100,35);
        Cp5SFButton.setLocation(225,560);
        sfPanel.add(Cp5SFButton);
        Lp5SFButton.setSize(100,35);
        Lp5SFButton.setLocation(225,605);
        sfPanel.add(Lp5SFButton);
        Sp5SFButton.setSize(100,35);
        Sp5SFButton.setLocation(350,605);
        sfPanel.add(Sp5SFButton);
        //p7 buttons
        Rp7SFButton.setSize(100,35);
        Rp7SFButton.setLocation(650,560);
        sfPanel.add(Rp7SFButton);
        Pp7SFButton.setSize(100,35);
        Pp7SFButton.setLocation(525,605);
        sfPanel.add(Pp7SFButton);
        Cp7SFButton.setSize(100,35);
        Cp7SFButton.setLocation(775,560);
        sfPanel.add(Cp7SFButton);
        Lp7SFButton.setSize(100,35);
        Lp7SFButton.setLocation(650,605);
        sfPanel.add(Lp7SFButton);
        Sp7SFButton.setSize(100,35);
        Sp7SFButton.setLocation(775,605);
        sfPanel.add(Sp7SFButton);
        // Final Screen Components
        fPanel.setPreferredSize(new Dimension(1280, 720));
        fPanel.setLayout(null);
        fPanel.add(tempButton3);
        tempButton3.setSize(200,100);
        tempButton3.setLocation(900, 300);
        tempButton3.addActionListener(this);

        //p1 buttons
        Rp1FButton.setSize(100,35);
        Rp1FButton.setLocation(225,270);
        fPanel.add(Rp1FButton);
        Pp1FButton.setSize(100,35);
        Pp1FButton.setLocation(225,315);
        fPanel.add(Pp1FButton);
        Cp1FButton.setSize(100,35);
        Cp1FButton.setLocation(225,360);
        fPanel.add(Cp1FButton);
        Lp1FButton.setSize(100,35);
        Lp1FButton.setLocation(225,405);
        fPanel.add(Lp1FButton);
        Sp1FButton.setSize(100,35);
        Sp1FButton.setLocation(225,450);
        fPanel.add(Sp1FButton);
        //p5 buttons
        Rp5FButton.setSize(100,35);
        Rp5FButton.setLocation(650,270);
        fPanel.add(Rp5FButton);
        Pp5FButton.setSize(100,35);
        Pp5FButton.setLocation(650,315);
        fPanel.add(Pp5FButton);
        Cp5FButton.setSize(100,35);
        Cp5FButton.setLocation(650,360);
        fPanel.add(Cp5FButton);
        Lp5FButton.setSize(100,35);
        Lp5FButton.setLocation(650,405);
        fPanel.add(Lp5FButton);
        Sp5FButton.setSize(100,35);
        Sp5FButton.setLocation(650,450);
        fPanel.add(Sp5FButton);

        // Winner Screen Components
    }

    // Main Method
    public static void main(String[] args){
        new TestGameFile();
    }
}
