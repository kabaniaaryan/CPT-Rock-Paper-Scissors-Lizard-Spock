// Aidan Brown, Aaryan Kabani, Carter Lee
// RPSGame.java
// January 21, 2026
// Version 5.3

package MainGame;

// Importing Libraries
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RPSGame implements ActionListener{
    // Properties
    // Home Screen Components
    JFrame theFrame = new JFrame("Rock Paper Scissors Lizard Spock Tournament");
    HomePanel thePanel = new HomePanel();
    JButton serverButton = new JButton("Host Game");
    JButton clientButton = new JButton("Join Game");
    JButton startButton = new JButton("Start Game");
    JButton helpButton = new JButton("Help");
    JTextField ipField = new JTextField();

    // Home Screen Chat Components
    JTextField messageField = new JTextField();
    JTextArea chatArea = new JTextArea();
    JScrollPane theScroll = new JScrollPane(chatArea);
    // Quarter Final Screen Chat Components
    JTextField messageField2 = new JTextField();
    JTextArea chatArea2 = new JTextArea();
    JScrollPane theScroll2 = new JScrollPane(chatArea2);
    // Semi Final Screen Chat Components
    JTextField messageField3 = new JTextField();
    JTextArea chatArea3 = new JTextArea();
    JScrollPane theScroll3 = new JScrollPane(chatArea3);
    // Final Screen Chat Components
    JTextField messageField4 = new JTextField();
    JTextArea chatArea4 = new JTextArea();
    JScrollPane theScroll4 = new JScrollPane(chatArea4);
    // Winner Screen Chat Components
    JTextField messageField5 = new JTextField();
    JTextArea chatArea5 = new JTextArea();
    JScrollPane theScroll5 = new JScrollPane(chatArea5);

    // SuperSocketMaster
    SuperSocketMaster ssm = null;
    
    // Game Variables
    int intPNumber = 0;
    int intPNumberTemp = 0;
    int intR2Number = 0;
    int intR3Number = 0;
    String strName = "";
    int intPlayerCount = 0;
    int intFinalPlayer = 0;
    boolean blnIsHost = false;
    boolean blnHostPass = false;
    boolean blnNAssigned = false;
    boolean blnLastPlayer = false;

    // Pass Variables
    boolean blnR1Pass = false;
    boolean blnR2Pass = false;
    boolean blnR3Pass = false;
    // Win Variables
    boolean blnWinR1 = false;
    boolean blnWinR2 = false;
    boolean blnWinR3 = false;
    // Round Start Variables
    boolean blnRound1Start = false;
    boolean blnRound2Start = false;
    boolean blnRound3Start = false;
    boolean blnGameEnd = false;
    // Choice Variables & Outcomes
    String strChoiceR1a = "";
    String strChoiceR1aOPP = "";
    String strChoiceR1b = "";
    String strChoiceR1bOPP = "";
    String strChoiceR1c = "";
    String strChoiceR1cOPP = "";
    String strChoiceR1d = "";
    String strChoiceR1dOPP = "";

    String strChoiceR2a = "";
    String strChoiceR2aOPP = "";
    String strChoiceR2b = "";
    String strChoiceR2bOPP = "";

    String strChoiceR3 = "";
    String strChoiceR3OPP = "";

    String strOutcomeQfA = "";
    String strOutcomeQfB = "";
    String strOutcomeQfC = "";
    String strOutcomeQfD = "";

    String strOutcomeSfA = "";
    String strOutcomeSfB = "";

    String strOutcomeF = "";

    // Match Counters
    int intR1MatchesDone = 0;
    int intR2MatchesDone = 0;
    int intR3MatchesDone = 0;
    // Score Counters
    int intR2aScore = 0;
    int intR2aOPPScore = 0;
    int intR2bScore = 0;
    int intR2bOPPScore = 0;
    int intR3Score = 0;
    int intR3OPPScore = 0;
    // Winner Trackers
    String strWinnerR1a = "";
    String strWinnerR1b = "";
    String strWinnerR1c = "";
    String strWinnerR1d = "";
    String strWinnerR2a = "";
    String strWinnerR2b = "";
    String strFinalWinner = "";

    // Panels

    //Help Panels 
    homeHelp homeHelpPanel = new homeHelp();
    qfHelp qfHelpPanel = new qfHelp();
    sfHelp sfHelpPanel = new sfHelp();
    fHelp fHelpPanel = new fHelp();
    Rules rulesPanel = new Rules();
    //Help panel buttons 
    JButton QFHelpButton = new JButton("QF Help");
    JButton SFHelpButton = new JButton("SF Help");
    JButton FHelpButton = new JButton("F Help");
    JButton RulesButton = new JButton("Rules");
    JButton backHomeButton = new JButton("Back Home");

    // Game Panels
    QuarterPanel qfPanel = new QuarterPanel();
    SemiPanel sfPanel = new SemiPanel();
    FinalPanel fPanel = new FinalPanel();
    // Winner Panel
    WinPanel wPanel = new WinPanel();
    JLabel winLabel = new JLabel();

    // Timer & Countdown Components
    // Repaint Timer
    Timer repaintTimer = new Timer(17, this);
    // Countdown Timers
    Timer qfTimer = new Timer(1000, this);
    Timer sfTimer = new Timer(1000, this);
    Timer fTimer = new Timer(1000, this);
    // Timer Trackers
    int intTime = 5;
    int intPause = 5;
    // Countdown Titles
    JLabel qfCountTitle = new JLabel();
    JLabel sfCountTitle = new JLabel();
    JLabel fCountTitle = new JLabel();
    // Countdown Text
    JLabel qfCountLabel = new JLabel();
    JLabel sfCountLabel = new JLabel();
    JLabel fCountLabel = new JLabel();

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
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == serverButton){
            // If the server button is pressed
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
            ipField.setVisible(false);
        }else if(evt.getSource() == clientButton){
            // If the join button is pressed
            ssm = new SuperSocketMaster(ipField.getText(), 8765, this);
            ipField.setText("");
            serverButton.setVisible(false);
            clientButton.setVisible(false);
            ssm.connect();
            System.out.println("Joining Game");
            blnNAssigned = false;
            blnLastPlayer = true;
            ssm.sendText("SERVER_NEW_PLAYER");
            ipField.setVisible(false);
        }else if(evt.getSource() == repaintTimer){
            // Repaint the panel at 60fps
            if(blnRound3Start == true){
                fPanel.repaint();
            }else if(blnRound2Start == true){
                sfPanel.repaint();
            }else if(blnRound1Start == true){
                qfPanel.repaint();
            }
        }else if(evt.getSource() == qfTimer){
            // Timer for Quarter Finals
            qfTimer.stop();
            if(intTime == 5){
                qfCountLabel.setText("5");
                intTime--;
                qfTimer.start();
            }else if(intTime == 4){
                qfCountLabel.setText("5 4");
                intTime--;
                qfTimer.start();
            }else if(intTime == 3){
                qfCountLabel.setText("5 4 3");
                intTime--;
                qfTimer.start();
            }else if(intTime == 2){
                qfCountLabel.setText("5 4 3 2");
                intTime--;
                qfTimer.start();
            }else if(intTime == 1){
                qfCountLabel.setText("5 4 3 2 1");
                intTime--;
                qfTimer.start();
            }else if(intTime == 0 && intPause == 5){
                qfCountLabel.setText("");
                if(blnWinR1 == false){
                    // Send choices to opponents
                    if(intPNumber == 2){
                        ssm.sendText("2_R1_" + strChoiceR1aOPP);
                        Rp2QFButton.setVisible(false);
                        Pp2QFButton.setVisible(false);
                        Cp2QFButton.setVisible(false);
                        Lp2QFButton.setVisible(false);
                        Sp2QFButton.setVisible(false);
                    }else if(intPNumber == 4){
                        ssm.sendText("4_R1_" + strChoiceR1bOPP);
                        Rp4QFButton.setVisible(false);
                        Pp4QFButton.setVisible(false);
                        Cp4QFButton.setVisible(false);
                        Lp4QFButton.setVisible(false);
                        Sp4QFButton.setVisible(false);
                    }else if(intPNumber == 6){
                        ssm.sendText("6_R1_" + strChoiceR1cOPP);
                        Rp6QFButton.setVisible(false);
                        Pp6QFButton.setVisible(false);
                        Cp6QFButton.setVisible(false);
                        Lp6QFButton.setVisible(false);
                        Sp6QFButton.setVisible(false);
                    }else if(intPNumber == 8){
                        ssm.sendText("8_R1_" + strChoiceR1cOPP);
                        Rp8QFButton.setVisible(false);
                        Pp8QFButton.setVisible(false);
                        Cp8QFButton.setVisible(false);
                        Lp8QFButton.setVisible(false);
                        Sp8QFButton.setVisible(false);
                    }
                }
                // R1 p1 buttons not visible
                Rp1QFButton.setVisible(false);
                Pp1QFButton.setVisible(false);
                Cp1QFButton.setVisible(false);
                Lp1QFButton.setVisible(false);
                Sp1QFButton.setVisible(false);
                // R1 p3 buttons not visible
                Rp3QFButton.setVisible(false);
                Pp3QFButton.setVisible(false);
                Cp3QFButton.setVisible(false);
                Lp3QFButton.setVisible(false);
                Sp3QFButton.setVisible(false);
                // R1 p5 buttons not visible
                Rp5QFButton.setVisible(false);
                Pp5QFButton.setVisible(false);
                Cp5QFButton.setVisible(false);
                Lp5QFButton.setVisible(false);
                Sp5QFButton.setVisible(false);
                // R1 p7 buttons not visible
                Rp7QFButton.setVisible(false);
                Pp7QFButton.setVisible(false);
                Cp7QFButton.setVisible(false);
                Lp7QFButton.setVisible(false);
                Sp7QFButton.setVisible(false);
                if(blnR1Pass == true && blnWinR1 == false){
                    // If P1 has a pass for r1
                    if(intPNumber == 1){
                        intR2Number = 1;
                        blnWinR1 = true;
                        ssm.sendText("Winner is [P1]");
                        chatArea2.append("Winner is [P1] \n");
                        intR1MatchesDone++;
                        trackingWins.Outcome("Player 1 Won Round 1a");
                    }
                }
                intPause--;
                qfTimer.start();
            }else if(intTime == 0 & intPause == 4){
                intPause--;
                qfTimer.start();
            }else if(intTime == 0 & intPause == 3){
                intPause--;
                qfTimer.start();
            }else if(intTime == 0 & intPause == 2){
                intPause--;
                qfTimer.start();
            }else if(intTime == 0 & intPause == 1){
                intPause--;
                qfTimer.start();
                if(intPNumber == 1){
                    // Check if round 2 should start
                    if((intPlayerCount % 2 == 1 && intR1MatchesDone == (intPlayerCount + 1) / 2) || (intPlayerCount % 2 == 0 && intR1MatchesDone == intPlayerCount / 2)){
                        if(intPlayerCount % 2 == 1 && intR1MatchesDone == (intPlayerCount + 1) / 2){
                            ssm.sendText("ROUND_2_START_ODD");
                        }else if(intPlayerCount % 2 == 0 && intR1MatchesDone == intPlayerCount / 2){
                            ssm.sendText("ROUND_2_START_EVEN");
                        }
                        qfPanel.setVisible(false);
                        theFrame.setContentPane(sfPanel);
                        theFrame.pack();
                        blnRound2Start = true;
                        sfTimer.start();
                        if(intR2Number == 1){
                            Rp1SFButton.setVisible(true);
                            Pp1SFButton.setVisible(true);
                            Cp1SFButton.setVisible(true);
                            Lp1SFButton.setVisible(true);
                            Sp1SFButton.setVisible(true);
                        }
                    }
                }
            }else if(intTime == 0 & intPause == 0){
                intTime = 5;
                intPause = 5;
                if(blnRound2Start == false){
                    // If round 2 does not start, restart round 1
                    strChoiceR1a = "";
                    strChoiceR1aOPP = "";
                    strChoiceR1b = "";
                    strChoiceR1bOPP = "";
                    strChoiceR1c = "";
                    strChoiceR1cOPP = "";
                    strChoiceR1d = "";
                    strChoiceR1dOPP = "";
                    // set buttons to visible again
                    if(blnWinR1 == false){
                        if(intPNumber == 1){
                            Rp1QFButton.setVisible(true);
                            Pp1QFButton.setVisible(true);
                            Cp1QFButton.setVisible(true);
                            Lp1QFButton.setVisible(true);
                            Sp1QFButton.setVisible(true);
                        }else if(intPNumber == 2){
                            Rp2QFButton.setVisible(true);
                            Pp2QFButton.setVisible(true);
                            Cp2QFButton.setVisible(true);
                            Lp2QFButton.setVisible(true);
                            Sp2QFButton.setVisible(true);
                        }else if(intPNumber == 3){
                            Rp3QFButton.setVisible(true);
                            Pp3QFButton.setVisible(true);
                            Cp3QFButton.setVisible(true);
                            Lp3QFButton.setVisible(true);
                            Sp3QFButton.setVisible(true);
                        }else if(intPNumber == 4){
                            Rp4QFButton.setVisible(true);
                            Pp4QFButton.setVisible(true);
                            Cp4QFButton.setVisible(true);
                            Lp4QFButton.setVisible(true);
                            Sp4QFButton.setVisible(true);
                        }else if(intPNumber == 5){
                            Rp5QFButton.setVisible(true);
                            Pp5QFButton.setVisible(true);
                            Cp5QFButton.setVisible(true);
                            Lp5QFButton.setVisible(true);
                            Sp5QFButton.setVisible(true);
                        }else if(intPNumber == 6){
                            Rp6QFButton.setVisible(true);
                            Pp6QFButton.setVisible(true);
                            Cp6QFButton.setVisible(true);
                            Lp6QFButton.setVisible(true);
                            Sp6QFButton.setVisible(true);
                        }else if(intPNumber == 7){
                            Rp7QFButton.setVisible(true);
                            Pp7QFButton.setVisible(true);
                            Cp7QFButton.setVisible(true);
                            Lp7QFButton.setVisible(true);
                            Sp7QFButton.setVisible(true);
                        }else if(intPNumber == 8){
                            Rp8QFButton.setVisible(true);
                            Pp8QFButton.setVisible(true);
                            Cp8QFButton.setVisible(true);
                            Lp8QFButton.setVisible(true);
                            Sp8QFButton.setVisible(true);
                        }
                    }
                    qfTimer.start();
                }
            }
        }else if(evt.getSource() == sfTimer){
            // Timer for Semi Finals
            sfTimer.stop();
            if(intTime == 5){
                sfCountLabel.setText("5");
                intTime--;
                sfTimer.start();
            }else if(intTime == 4){
                sfCountLabel.setText("5 4");
                intTime--;
                sfTimer.start();
            }else if(intTime == 3){
                sfCountLabel.setText("5 4 3");
                intTime--;
                sfTimer.start();
            }else if(intTime == 2){
                sfCountLabel.setText("5 4 3 2");
                intTime--;
                sfTimer.start();
            }else if(intTime == 1){
                sfCountLabel.setText("5 4 3 2 1");
                intTime--;
                sfTimer.start();
            }else if(intTime == 0 && intPause == 5){
                sfCountLabel.setText("");
                if(blnWinR2 == false){
                    // Send choices to opponents
                    if(intR2Number == 3){
                        ssm.sendText("3_R2_" + strChoiceR2aOPP);
                        Rp3SFButton.setVisible(false);
                        Pp3SFButton.setVisible(false);
                        Cp3SFButton.setVisible(false);
                        Lp3SFButton.setVisible(false);
                        Sp3SFButton.setVisible(false);
                    }else if(intR2Number == 7){
                        ssm.sendText("7_R2_" + strChoiceR2bOPP);
                        Rp7SFButton.setVisible(false);
                        Pp7SFButton.setVisible(false);
                        Cp7SFButton.setVisible(false);
                        Lp7SFButton.setVisible(false);
                        Sp7SFButton.setVisible(false);
                    }
                }
                // R2 p1 buttons not visible
                Rp1SFButton.setVisible(false);
                Pp1SFButton.setVisible(false);
                Cp1SFButton.setVisible(false);
                Lp1SFButton.setVisible(false);
                Sp1SFButton.setVisible(false);
                // R2 p5 buttons not visible
                Rp5SFButton.setVisible(false);
                Pp5SFButton.setVisible(false);
                Cp5SFButton.setVisible(false);
                Lp5SFButton.setVisible(false);
                Sp5SFButton.setVisible(false);
                if(blnR2Pass == true && (intR2Number == 1 || intR2Number == 5) && blnWinR2 == false){
                    // If P1, P2, P3, or P4 have a pass for r2
                    if(intPNumber == 1){
                        intR3Number = 1;
                        blnWinR2 = true;
                        ssm.sendText("Winner is [P1]");
                        chatArea3.append("Winner is [P1] \n");
                        intR2MatchesDone++;
                        trackingWins.Outcome("Player 1 Won Round 2a");
                    }else if(intPNumber == 2){
                        intR3Number = 1;
                        blnWinR2 = true;
                        ssm.sendText("Winner is [P2]");
                        chatArea3.append("Winner is [P2] \n");
                        ssm.sendText("INTR2MATCHES_INCREASE");
                        trackingWins.Outcome("Player 2 Won Round 2a");
                    }else if(intPNumber == 3){
                        intR3Number = 5;
                        blnWinR2 = true;
                        ssm.sendText("Winner is [P3]");
                        chatArea3.append("Winner is [P3] \n");
                        ssm.sendText("INTR2MATCHES_INCREASE");
                        trackingWins.Outcome("Player 3 Won Round 2b");
                    }else if(intPNumber == 4){
                        intR3Number = 5;
                        blnWinR2 = true;
                        ssm.sendText("Winner is [P4]");
                        chatArea3.append("Winner is [P4] \n");
                        ssm.sendText("INTR2MATCHES_INCREASE");
                        trackingWins.Outcome("Player 4 Won Round 2b");
                    }
                }
                intPause--;
                sfTimer.start();
            }else if(intTime == 0 & intPause == 4){
                intPause--;
                sfTimer.start();
            }else if(intTime == 0 & intPause == 3){
                intPause--;
                sfTimer.start();
            }else if(intTime == 0 & intPause == 2){
                intPause--;
                sfTimer.start();
            }else if(intTime == 0 & intPause == 1){
                intPause--;
                sfTimer.start();
                if(intPNumber == 1){
                    // Check if round 3 should start
                    if((blnR2Pass == false && ((intR1MatchesDone % 2 == 1 && intR2MatchesDone == (intR1MatchesDone - 1) / 2) || (intR1MatchesDone % 2 == 0 && intR2MatchesDone == intR1MatchesDone / 2))) || (blnR2Pass == true && ((intR1MatchesDone % 2 == 1 && intR2MatchesDone == (intR1MatchesDone + 1) / 2) || (intR1MatchesDone % 2 == 0 && intR2MatchesDone == intR1MatchesDone))) || (intPlayerCount == 2)){
                        if((blnR2Pass == false)){
                            if(intR1MatchesDone % 2 == 1 && intR2MatchesDone == (intR1MatchesDone - 1) / 2){
                                ssm.sendText("ROUND_3_START_ODD");
                            }else if(intR1MatchesDone % 2 == 0 && intR2MatchesDone == intR1MatchesDone / 2){
                                ssm.sendText("ROUND_3_START_EVEN");
                            }
                        }else if(blnR2Pass == true){
                            if(intPlayerCount != 2){
                                if(intR1MatchesDone % 2 == 1 && intR2MatchesDone == (intR1MatchesDone + 1) / 2){
                                    ssm.sendText("ROUND_3_START_ODD");
                                }else if(intR1MatchesDone % 2 == 0 && intR2MatchesDone == intR1MatchesDone){
                                    ssm.sendText("ROUND_3_START_EVEN");
                                }
                            }else if(intPlayerCount == 2 && intR2MatchesDone == 1){
                                ssm.sendText("ROUND_3_START_ODD");
                            }
                        }
                        sfPanel.setVisible(false);
                        theFrame.setContentPane(fPanel);
                        theFrame.pack();
                        blnRound3Start = true;
                        fTimer.start();
                        if(intR3Number == 1){
                            Rp1FButton.setVisible(true);
                            Pp1FButton.setVisible(true);
                            Cp1FButton.setVisible(true);
                            Lp1FButton.setVisible(true);
                            Sp1FButton.setVisible(true);
                        }
                    }
                }
            }else if(intTime == 0 & intPause == 0){
                intTime = 5;
                intPause = 5;
                if(blnRound3Start == false){
                    // If round 3 does not start, restart round 2
                    strChoiceR2a = "";
                    strChoiceR2aOPP = "";
                    strChoiceR2b = "";
                    strChoiceR2bOPP = "";
                    if(blnWinR2 == false){
                        if(intR2Number == 1){
                            Rp1SFButton.setVisible(true);
                            Pp1SFButton.setVisible(true);
                            Cp1SFButton.setVisible(true);
                            Lp1SFButton.setVisible(true);
                            Sp1SFButton.setVisible(true);
                        }else if(intR2Number == 3){
                            Rp3SFButton.setVisible(true);
                            Pp3SFButton.setVisible(true);
                            Cp3SFButton.setVisible(true);
                            Lp3SFButton.setVisible(true);
                            Sp3SFButton.setVisible(true);
                        }else if(intR2Number == 5){
                            Rp5SFButton.setVisible(true);
                            Pp5SFButton.setVisible(true);
                            Cp5SFButton.setVisible(true);
                            Lp5SFButton.setVisible(true);
                            Sp5SFButton.setVisible(true);
                        }else if(intR2Number == 7){
                            Rp7SFButton.setVisible(true);
                            Pp7SFButton.setVisible(true);
                            Cp7SFButton.setVisible(true);
                            Lp7SFButton.setVisible(true);
                            Sp7SFButton.setVisible(true);
                        }
                    }
                    sfTimer.start();
                }
            }
        }else if(evt.getSource() == fTimer){
            // Timer for Finals
            fTimer.stop();
            if(intTime == 5){
                fCountLabel.setText("5");
                intTime--;
                fTimer.start();
            }else if(intTime == 4){
                fCountLabel.setText("5 4");
                intTime--;
                fTimer.start();
            }else if(intTime == 3){
                fCountLabel.setText("5 4 3");
                intTime--;
                fTimer.start();
            }else if(intTime == 2){
                fCountLabel.setText("5 4 3 2");
                intTime--;
                fTimer.start();
            }else if(intTime == 1){
                fCountLabel.setText("5 4 3 2 1");
                intTime--;
                fTimer.start();
            }else if(intTime == 0 && intPause == 5){
                fCountLabel.setText("");
                if(intR3Number == 5 && blnGameEnd == false){
                    // Send choice to opponents
                    ssm.sendText("5_R3_" + strChoiceR3OPP);
                    Rp5FButton.setVisible(false);
                    Pp5FButton.setVisible(false);
                    Cp5FButton.setVisible(false);
                    Lp5FButton.setVisible(false);
                    Sp5FButton.setVisible(false);
                }
                // R3 p1 buttons not visible
                Rp1FButton.setVisible(false);
                Pp1FButton.setVisible(false);
                Cp1FButton.setVisible(false);
                Lp1FButton.setVisible(false);
                Sp1FButton.setVisible(false);
                if(blnR3Pass == true && intR3Number == 1){
                    // Check if P1 or P2 has a pass for r3
                    if(intPNumber == 1){
                        blnGameEnd = true;
                        ssm.sendText("Winner is [P" + intPNumber + "]");
                        chatArea4.append("Winner is [P" + intPNumber + "] \n");
                        intR3MatchesDone = 1;
                        strFinalWinner = "1";
                        trackingWins.Outcome("Player " + intPNumber + " Won Round 3");
                    }else if(intPNumber == 2){
                        blnGameEnd = true;
                        ssm.sendText("Winner is [P" + intPNumber + "]");
                        chatArea4.append("Winner is [P" + intPNumber + "] \n");
                        ssm.sendText("WINNER_"  + intPNumber);
                        trackingWins.Outcome("Player " + intPNumber + " Won Round 3");
                    }
                } 
                intPause--;
                fTimer.start();
            }else if(intTime == 0 && intPause == 4){
                intPause--;
                fTimer.start();
            }else if(intTime == 0 && intPause == 3){
                intPause--;
                fTimer.start();
            }else if(intTime == 0 && intPause == 2){
                intPause--;
                fTimer.start();
            }else if(intTime == 0 && intPause == 1){
                intPause--;
                fTimer.start();
                if(intPNumber == 1 && intR3MatchesDone == 1){
                    // Check if game has ended
                    winLabel.setText("[P" + strFinalWinner + "]");
                    fTimer.stop();
                    fPanel.setVisible(false);
                    theFrame.setContentPane(wPanel);
                    theFrame.pack();
                    ssm.sendText("WIN_SCREEN_" + strFinalWinner);
                    blnGameEnd = true;
                }
            }else if(intTime == 0 && intPause == 0){
                intTime = 5;
                intPause = 5;
                if(blnGameEnd == false){
                    // If game has not ended, restart round 3
                    strChoiceR3 = "";
                    strChoiceR3OPP = "";
                    if(intR3Number == 1){
                        Rp1FButton.setVisible(true);
                        Pp1FButton.setVisible(true);
                        Cp1FButton.setVisible(true);
                        Lp1FButton.setVisible(true);
                        Sp1FButton.setVisible(true);
                    }else if(intR3Number == 5){
                        Rp5FButton.setVisible(true);
                        Pp5FButton.setVisible(true);
                        Cp5FButton.setVisible(true);
                        Lp5FButton.setVisible(true);
                        Sp5FButton.setVisible(true);
                    }
                    fTimer.start();
                }
            }
        }else if(evt.getSource() == startButton){
            // Start the game if the start button is pressed
            intPNumberTemp = 0;
            if(intPlayerCount % 2 == 0){
                ssm.sendText("GAME_START_EVEN");
            }else{
                ssm.sendText("GAME_START_ODD");
            }
            ssm.sendText("PLAYER_COUNT_" + intPlayerCount);
            // Set up round passes based on player count
            if(intPlayerCount == 1){
                blnR1Pass = true;
                blnR2Pass = true;
                blnR3Pass = true;
            }else if(intPlayerCount == 2){
                blnR2Pass = true;
                blnR3Pass = true;
            }else if(intPlayerCount == 3 || intPlayerCount == 5){
                blnR1Pass = true;
                blnR2Pass = true;
            }else if(intPlayerCount == 4 || intPlayerCount == 6){
                blnR2Pass = true;
            }else if(intPlayerCount == 7){
                blnR1Pass = true;
            }
            thePanel.setVisible(false);
            theFrame.setContentPane(qfPanel);
            theFrame.pack();
            blnRound1Start = true;
            intTime = 5;
            intPause = 5;
            qfTimer.start();
            Rp1QFButton.setVisible(true);
            Pp1QFButton.setVisible(true);
            Cp1QFButton.setVisible(true);
            Lp1QFButton.setVisible(true);
            Sp1QFButton.setVisible(true);
        }else if(evt.getSource() == messageField){
            // Send chat message to home screen chat
            String strMessage = messageField.getText();
            ssm.sendText("[P" + intPNumber + "] " + strMessage);
            chatArea.append("[P" + intPNumber + "] " + strMessage + "\n");
            messageField.setText("");
        }else if(evt.getSource() == messageField2){
            // Send chat message to quarter finals chat
            String strMessage = messageField2.getText();
            ssm.sendText("[P" + intPNumber + "] " + strMessage);
            chatArea2.append("[P" + intPNumber + "] " + strMessage + "\n");
            messageField2.setText("");
        }else if((evt.getSource() == messageField3)){
            // Send chat message to semi finals chat
            String strMessage = messageField3.getText();
            ssm.sendText("[P" + intPNumber + "] " + strMessage);
            chatArea3.append("[P" + intPNumber + "] " + strMessage + "\n");
            messageField3.setText("");
        }else if((evt.getSource() == messageField4)){
            // Send chat message to finals chat
            String strMessage = messageField4.getText();
            ssm.sendText("[P" + intPNumber + "] " + strMessage);
            chatArea4.append("[P" + intPNumber + "] " + strMessage + "\n");
            messageField4.setText("");
        }else if((evt.getSource() == messageField5)){
            // Send chat message to win screen chat
            String strMessage = messageField5.getText();
            ssm.sendText("[P" + intPNumber + "] " + strMessage);
            chatArea5.append("[P" + intPNumber + "] " + strMessage + "\n");
            messageField5.setText("");
        }else if(evt.getSource() == ssm){
            String strMessage = ssm.readText();
            if(strMessage.equals("SERVER_NEW_PLAYER")){
                // If a new player joins, assign them a player number
                if(blnIsHost == true){
                    intPNumberTemp++;
                    intPlayerCount++;
                    ssm.sendText("NUMBER_" + intPNumberTemp);
                }else{
                    blnLastPlayer = false;
                }
            }else if(strMessage.startsWith("NUMBER_")){
                // New player gets assigned a player number
                if(blnNAssigned == false){
                    intPNumber = Integer.parseInt(strMessage.substring(7));
                    blnNAssigned = true;
                }
            }else if(strMessage.startsWith("PLAYER_COUNT_")){
                // Set up passes based on player count
                intPlayerCount = Integer.parseInt(strMessage.substring(13));
                if(intPlayerCount == 2){
                    blnR2Pass = true;
                    blnR3Pass = true;
                }else if(intPlayerCount == 3){
                    blnR2Pass = true;
                }else if(intPlayerCount == 4){
                    blnR2Pass = true;
                }else if(intPlayerCount == 5){
                    // No Pass except for P1
                }else if(intPlayerCount == 6){
                    if(intPNumber == 2){
                        blnR2Pass = true;
                    }
                }else if(intPlayerCount == 7){
                    // No Pass except for P1
                }
            }else if(strMessage.startsWith("GAME_START_")){
                if(strMessage.equals("GAME_START_EVEN")){
                    // Balance player numbers if the player count is even
                    // Start round 1
                    if(blnLastPlayer == true){
                        intPNumber = 2;
                    }
                }
                thePanel.setVisible(false);
                theFrame.setContentPane(qfPanel);
                theFrame.pack();
                blnRound1Start = true;
                if(intPNumber == 2){
                    Rp2QFButton.setVisible(true);
                    Pp2QFButton.setVisible(true);
                    Cp2QFButton.setVisible(true);
                    Lp2QFButton.setVisible(true);
                    Sp2QFButton.setVisible(true);
                }else if(intPNumber == 3){
                    Rp3QFButton.setVisible(true);
                    Pp3QFButton.setVisible(true);
                    Cp3QFButton.setVisible(true);
                    Lp3QFButton.setVisible(true);
                    Sp3QFButton.setVisible(true);
                }else if(intPNumber == 4){
                    Rp4QFButton.setVisible(true);
                    Pp4QFButton.setVisible(true);
                    Cp4QFButton.setVisible(true);
                    Lp4QFButton.setVisible(true);
                    Sp4QFButton.setVisible(true);
                }else if(intPNumber == 5){
                    Rp5QFButton.setVisible(true);
                    Pp5QFButton.setVisible(true);
                    Cp5QFButton.setVisible(true);
                    Lp5QFButton.setVisible(true);
                    Sp5QFButton.setVisible(true);
                }else if(intPNumber == 6){
                    Rp6QFButton.setVisible(true);
                    Pp6QFButton.setVisible(true);
                    Cp6QFButton.setVisible(true);
                    Lp6QFButton.setVisible(true);
                    Sp6QFButton.setVisible(true);
                }else if(intPNumber == 7){
                    Rp7QFButton.setVisible(true);
                    Pp7QFButton.setVisible(true);
                    Cp7QFButton.setVisible(true);
                    Lp7QFButton.setVisible(true);
                    Sp7QFButton.setVisible(true);
                }else if(intPNumber == 8){
                    Rp8QFButton.setVisible(true);
                    Pp8QFButton.setVisible(true);
                    Cp8QFButton.setVisible(true);
                    Lp8QFButton.setVisible(true);
                    Sp8QFButton.setVisible(true);
                }
                qfTimer.start();
            }else if(strMessage.startsWith("ROUND_2_START_")){
                // Start round 2
                qfPanel.setVisible(false);
                theFrame.setContentPane(sfPanel);
                theFrame.pack();
                blnRound2Start = true;
                intTime = 5;
                intPause = 5;
                qfTimer.stop();
                sfTimer.start();
                if(intR2Number == 1){
                    Rp1SFButton.setVisible(true);
                    Pp1SFButton.setVisible(true);
                    Cp1SFButton.setVisible(true);
                    Lp1SFButton.setVisible(true);
                    Sp1SFButton.setVisible(true);
                }else if(intR2Number == 3){
                    Rp3SFButton.setVisible(true);
                    Pp3SFButton.setVisible(true);
                    Cp3SFButton.setVisible(true);
                    Lp3SFButton.setVisible(true);
                    Sp3SFButton.setVisible(true);
                }else if(intR2Number == 5){
                    Rp5SFButton.setVisible(true);
                    Pp5SFButton.setVisible(true);
                    Cp5SFButton.setVisible(true);
                    Lp5SFButton.setVisible(true);
                    Sp5SFButton.setVisible(true);
                }else if(intR2Number == 7){
                    Rp7SFButton.setVisible(true);
                    Pp7SFButton.setVisible(true);
                    Cp7SFButton.setVisible(true);
                    Lp7SFButton.setVisible(true);
                    Sp7SFButton.setVisible(true);
                }
            }else if(strMessage.startsWith("ROUND_3_START_")){
                // Start round 3
                sfPanel.setVisible(false);
                theFrame.setContentPane(fPanel);
                theFrame.pack();
                blnRound3Start = true;
                intTime = 5;
                intPause = 5;
                sfTimer.stop();
                fTimer.start();
                if(intR3Number == 1){
                    Rp1FButton.setVisible(true);
                    Pp1FButton.setVisible(true);
                    Cp1FButton.setVisible(true);
                    Lp1FButton.setVisible(true);
                    Sp1FButton.setVisible(true);
                }else if(intR3Number == 5){
                    Rp5FButton.setVisible(true);
                    Pp5FButton.setVisible(true);
                    Cp5FButton.setVisible(true);
                    Lp5FButton.setVisible(true);
                    Sp5FButton.setVisible(true);
                }
            }else if(strMessage.startsWith("WINNER_")){
                // Declare the winner of round 3
                if(intPNumber == 1){
                    intR3MatchesDone = 1;
                    blnGameEnd = true;
                    strFinalWinner = strMessage.substring(7);
                }
            }else if(strMessage.startsWith("WIN_SCREEN_")){
                // Send all players to win screen
                blnGameEnd = true;
                strFinalWinner = strMessage.substring(11);
                fTimer.stop();
                winLabel.setText("[P" + strFinalWinner + "]");
                fPanel.setVisible(false);
                theFrame.setContentPane(wPanel);
                theFrame.pack();
            }else if(strMessage.startsWith("1_R1_")){
                // Send choices, outcomes and messages for R1a
                if(intPNumber == 2){
                    strOutcomeQfA = strMessage.substring(5);
                    if(strOutcomeQfA.equals("W")){
                        ssm.sendText("Winner is [P1]");
                        chatArea2.append("Winner is [P1] \n");
                        ssm.sendText("INTR1MATCHES_INCREASE");
                    }else if(strOutcomeQfA.equals("L")){
                        intR2Number = 1;
                        blnWinR1 = true;
                        ssm.sendText("Winner is [P2]");
                        chatArea2.append("Winner is [P2] \n");
                        ssm.sendText("INTR1MATCHES_INCREASE");
                    }else if(strOutcomeQfA.equals("T")){
                        ssm.sendText("Tie between [P1] and [P2]");
                        chatArea2.append("Tie between [P1] and [P2] \n");
                    }else if(strOutcomeQfA.equals("WX")){
                        ssm.sendText("[P2] did not play, [P1] wins by default");
                        chatArea2.append("[P2] did not play, [P1] wins by default \n");
                        ssm.sendText("INTR1MATCHES_INCREASE");
                    }else if(strOutcomeQfA.equals("LX")){
                        intR2Number = 1;
                        blnWinR1 = true;
                        ssm.sendText("[P1] did not play, [P2] wins by default");
                        chatArea2.append("[P1] did not play, [P2] wins by default \n");
                        ssm.sendText("INTR1MATCHES_INCREASE");
                    }
                }
            }else if(strMessage.startsWith("2_R1_")){
                // Send choices, outcomes and messages for R1a
                if(intPNumber == 1){
                    strChoiceR1aOPP = strMessage.substring(5);
                    strOutcomeQfA = winningMethods.isWinner(strChoiceR1a, strChoiceR1aOPP);
                    if(strOutcomeQfA.equals("W")){
                        intR2Number = 1;
                        blnWinR1 = true;
                        ssm.sendText("1_R1_W");
                        trackingWins.Outcome("Player 1 Won Round 1a");
                    }else if(strOutcomeQfA.equals("L")){
                        ssm.sendText("1_R1_L");
                        trackingWins.Outcome("Player 2 Won Round 1a");
                    }else if(strOutcomeQfA.equals("T")){
                        ssm.sendText("1_R1_T");
                    }else if(strOutcomeQfA.equals("WX")){
                        intR2Number = 1;
                        blnWinR1 = true;
                        ssm.sendText("1_R1_WX");
                        trackingWins.Outcome("Player 1 Won Round 1a");
                    }else if(strOutcomeQfA.equals("LX")){
                        ssm.sendText("1_R1_LX");
                        trackingWins.Outcome("Player 2 Won Round 1a");
                    }
                }
            }else if(strMessage.startsWith("3_R1_")){
                // Send choices, outcomes and messages for R1b
                if(intPNumber == 4){
                    strOutcomeQfB = strMessage.substring(5);
                    if(strOutcomeQfB.equals("W")){
                        ssm.sendText("Winner is [P3]");
                        chatArea2.append("Winner is [P3] \n");
                        ssm.sendText("INTR1MATCHES_INCREASE");
                    }else if(strOutcomeQfB.equals("L")){
                        if(intPlayerCount >= 3 && intPlayerCount <= 6){
                            intR2Number = 5;
                        }else{
                            intR2Number = 3;
                        }
                        blnWinR1 = true;
                        ssm.sendText("Winner is [P4]");
                        chatArea2.append("Winner is [P4] \n");
                        ssm.sendText("INTR1MATCHES_INCREASE");
                    }else if(strOutcomeQfB.equals("T")){
                        ssm.sendText("Tie between [P3] and [P4]");
                        chatArea2.append("Tie between [P3] and [P4] \n");
                    }else if(strOutcomeQfB.equals("WX")){
                        ssm.sendText("[P4] did not play, [P3] wins by default");
                        chatArea2.append("[P4] did not play, [P3] wins by default \n");
                        ssm.sendText("INTR1MATCHES_INCREASE");
                    }else if(strOutcomeQfB.equals("LX")){
                        if(intPlayerCount >= 3 && intPlayerCount <= 6){
                            intR2Number = 5;
                        }else{
                            intR2Number = 3;
                        }
                        blnWinR1 = true;
                        ssm.sendText("[P3] did not play, [P4] wins by default");
                        chatArea2.append("[P3] did not play, [P4] wins by default \n");
                        ssm.sendText("INTR1MATCHES_INCREASE");
                    }
                }
            }else if(strMessage.startsWith("4_R1_")){
                // Send choices, outcomes and messages for R1b
                if(intPNumber == 3){
                    strChoiceR1bOPP = strMessage.substring(5);
                    strOutcomeQfB = winningMethods.isWinner(strChoiceR1b, strChoiceR1bOPP);
                    if(strOutcomeQfB.equals("W")){
                        if(intPlayerCount >= 3 && intPlayerCount <= 6){
                            intR2Number = 5;
                        }else{
                            intR2Number = 3;
                        }
                        blnWinR1 = true;
                        ssm.sendText("3_R1_W");
                        trackingWins.Outcome("Player 3 Won Round 1b");
                    }else if(strOutcomeQfB.equals("L")){
                        ssm.sendText("3_R1_L");
                        trackingWins.Outcome("Player 4 Won Round 1b");
                    }else if(strOutcomeQfB.equals("T")){
                        ssm.sendText("3_R1_T");
                    }else if(strOutcomeQfB.equals("WX")){
                        if(intPlayerCount >= 3 && intPlayerCount <= 6){
                            intR2Number = 5;
                        }else{
                            intR2Number = 3;
                        }
                        blnWinR1 = true;
                        ssm.sendText("3_R1_WX");
                        trackingWins.Outcome("Player 3 Won Round 1b");
                    }else if(strOutcomeQfB.equals("LX")){
                        ssm.sendText("3_R1_LX");
                        trackingWins.Outcome("Player 4 Won Round 1b");
                    }
                }
            }else if(strMessage.startsWith("5_R1_")){
                // Send choices, outcomes and messages for R1c
                if(intPNumber == 6){
                    strOutcomeQfC = strMessage.substring(5);
                    if(strOutcomeQfC.equals("W")){
                        ssm.sendText("Winner is [P5]");
                        chatArea2.append("Winner is [P5] \n");
                        ssm.sendText("INTR1MATCHES_INCREASE");
                    }else if(strOutcomeQfC.equals("L")){
                        if(intPlayerCount == 5){
                            intR2Number = 7;
                        }else{
                            intR2Number = 5;
                        }
                        blnWinR1 = true;
                        ssm.sendText("Winner is [P6]");
                        chatArea2.append("Winner is [P6] \n");
                        ssm.sendText("INTR1MATCHES_INCREASE");
                    }else if(strOutcomeQfC.equals("T")){
                        ssm.sendText("Tie between [P5] and [P6]");
                        chatArea2.append("Tie between [P5] and [P6] \n");
                    }else if(strOutcomeQfC.equals("WX")){
                        ssm.sendText("[P6] did not play, [P5] wins by default");
                        chatArea2.append("[P6] did not play, [P5] wins by default \n");
                        ssm.sendText("INTR1MATCHES_INCREASE");
                    }else if(strOutcomeQfC.equals("LX")){
                        if(intPlayerCount == 5){
                            intR2Number = 7;
                        }else{
                            intR2Number = 5;
                        }
                        blnWinR1 = true;
                        ssm.sendText("[P5] did not play, [P6] wins by default");
                        chatArea2.append("[P5] did not play, [P6] wins by default \n");
                        ssm.sendText("INTR1MATCHES_INCREASE");
                    }
                }
            }else if(strMessage.startsWith("6_R1_")){
                // Send choices, outcomes and messages for R1c
                if(intPNumber == 5){
                    strChoiceR1cOPP = strMessage.substring(5);
                    strOutcomeQfC = winningMethods.isWinner(strChoiceR1c, strChoiceR1cOPP);
                    if(strOutcomeQfC.equals("W")){
                        if(intPlayerCount == 5){
                            intR2Number = 7;
                        }else{
                            intR2Number = 5;
                        }
                        blnWinR1 = true;
                        ssm.sendText("5_R1_W");
                        trackingWins.Outcome("Player 5 Won Round 1c");
                    }else if(strOutcomeQfC.equals("L")){
                        ssm.sendText("5_R1_L");
                        trackingWins.Outcome("Player 6 Won Round 1c");
                    }else if(strOutcomeQfC.equals("T")){
                        ssm.sendText("5_R1_T");
                    }else if(strOutcomeQfC.equals("WX")){
                        if(intPlayerCount == 5){
                            intR2Number = 7;
                        }else{
                            intR2Number = 5;
                        }
                        blnWinR1 = true;
                        ssm.sendText("5_R1_WX");
                        trackingWins.Outcome("Player 5 Won Round 1c");
                    }else if(strOutcomeQfC.equals("LX")){
                        ssm.sendText("5_R1_LX");
                        trackingWins.Outcome("Player 6 Won Round 1c");
                    }
                }
            }else if(strMessage.startsWith("7_R1_")){
                // Send choices, outcomes and messages for R1d
                if(intPNumber == 8){
                    strOutcomeQfD = strMessage.substring(5);
                    if(strOutcomeQfD.equals("W")){
                        blnWinR1 = false;
                        ssm.sendText("Winner is [P7]");
                        chatArea2.append("Winner is [P7] \n");
                        ssm.sendText("INTR1MATCHES_INCREASE");
                    }else if(strOutcomeQfD.equals("L")){
                        intR2Number = 7;
                        ssm.sendText("Winner is [P8]");
                        chatArea2.append("Winner is [P8] \n");
                        ssm.sendText("INTR1MATCHES_INCREASE");
                    }else if(strOutcomeQfD.equals("T")){
                        ssm.sendText("Tie between [P7] and [P8]");
                        chatArea2.append("Tie between [P7] and [P8] \n");
                    }else if(strOutcomeQfD.equals("WX")){
                        blnWinR1 = false;
                        ssm.sendText("[P8] did not play, [P7] wins by default");
                        chatArea2.append("[P8] did not play, [P7] wins by default \n");
                        ssm.sendText("INTR1MATCHES_INCREASE");
                    }else if(strOutcomeQfD.equals("LX")){
                        intR2Number = 7;
                        ssm.sendText("[P7] did not play, [P8] wins by default");
                        chatArea2.append("[P7] did not play, [P8] wins by default \n");
                        ssm.sendText("INTR1MATCHES_INCREASE");
                    }
                }
            }else if(strMessage.startsWith("8_R1_")){
                // Send choices, outcomes and messages for R1d
                if(intPNumber == 7){
                    strChoiceR1dOPP = strMessage.substring(5);
                    strOutcomeQfD = winningMethods.isWinner(strChoiceR1d, strChoiceR1dOPP);
                    if(strOutcomeQfD.equals("W")){
                        intR2Number = 7;
                        ssm.sendText("7_R1_W");
                        trackingWins.Outcome("Player 7 Won Round 1d");
                    }else if(strOutcomeQfD.equals("L")){
                        blnWinR1 = false;
                        ssm.sendText("7_R1_L");
                        trackingWins.Outcome("Player 8 Won Round 1d");
                    }else if(strOutcomeQfD.equals("T")){
                        ssm.sendText("7_R1_T");
                    }else if(strOutcomeQfD.equals("WX")){
                        intR2Number = 7;
                        ssm.sendText("7_R1_WX");
                        trackingWins.Outcome("Player 7 Won Round 1d");
                    }else if(strOutcomeQfD.equals("LX")){
                        blnWinR1 = false;
                        ssm.sendText("7_R1_LX");
                        trackingWins.Outcome("Player 8 Won Round 1d");
                    }
                }
            }else if(strMessage.equals("INTR1MATCHES_INCREASE")){
                // When a match in round 1 is completed, increase r1 match count
                if(intPNumber == 1){
                    intR1MatchesDone++;
                }
            }else if(strMessage.equals("INTR2MATCHES_INCREASE")){
                // When a match in round 2 is completed, increase r2 match count
                if(intPNumber == 1){
                    intR2MatchesDone++;
                }
            }else if(strMessage.startsWith("1_R2_")){
                // Send choices, outcomes and messages for R2a
                if(intR2Number == 3){
                    strOutcomeSfA = strMessage.substring(8);
                    String strR2NumberOPP = strMessage.substring(6,7);
                    if(strOutcomeSfA.equals("W")){
                        intR2aScore++;
                        ssm.sendText("Winner is [P" + strR2NumberOPP + "]");
                        chatArea3.append("Winner is [P" + strR2NumberOPP + "] \n");
                    }else if(strOutcomeSfA.equals("L")){
                        intR2aOPPScore++;
                        ssm.sendText("Winner is [P" + intPNumber + "]");
                        chatArea3.append("Winner is [P" + intPNumber + "] \n");
                    }else if(strOutcomeSfA.equals("T")){
                        ssm.sendText("Tie between [P" + strR2NumberOPP + "] and [P" + intPNumber + "]");
                        chatArea3.append("Tie between [P" + strR2NumberOPP + "] and [P" + intPNumber + "] \n");
                    }else if(strOutcomeSfA.equals("WX")){
                        intR2aScore++;
                        ssm.sendText("[P" + intPNumber + "] did not play, [P" + strR2NumberOPP + "] wins by default");
                        chatArea3.append("[P" + intPNumber + "] did not play, [P" + strR2NumberOPP + "] wins by default \n");
                    }else if(strOutcomeSfA.equals("LX")){
                        intR2aOPPScore++;
                        ssm.sendText("[P" + strR2NumberOPP + "] did not play, [P" + intPNumber + "] wins by default");
                        chatArea3.append("[P" + strR2NumberOPP + "] did not play, [P" + intPNumber + "] wins by default \n");
                    }
                    if(intR2aScore == 2){
                        ssm.sendText("INTR2MATCHES_INCREASE");
                        trackingWins.Outcome("Player " + strR2NumberOPP + " Won Round 2a");
                    }else if(intR2aOPPScore == 2){
                        intR3Number = 1;
                        blnWinR2 = true;
                        ssm.sendText("INTR2MATCHES_INCREASE");
                        trackingWins.Outcome("Player " + intPNumber + " Won Round 2a");
                    }
                }
            }else if(strMessage.startsWith("3_R2_")){
                // Send choices, outcomes and messages for R2a
                if(intR2Number == 1){
                    strChoiceR2aOPP = strMessage.substring(5);
                    strOutcomeSfA = winningMethods.isWinner(strChoiceR2a, strChoiceR2aOPP);
                    if(strOutcomeSfA.equals("W")){
                        intR2aScore++;
                        ssm.sendText("1_R2_-" + intPNumber + "-W");
                    }else if(strOutcomeSfA.equals("L")){
                        ssm.sendText("1_R2_-" + intPNumber + "-L");
                    }else if(strOutcomeSfA.equals("T")){
                        ssm.sendText("1_R2_-" + intPNumber + "-T");
                    }else if(strOutcomeSfA.equals("WX")){
                        intR2aScore++;
                        ssm.sendText("1_R2_-" + intPNumber + "-WX");
                    }else if(strOutcomeSfA.equals("LX")){
                        ssm.sendText("1_R2_-" + intPNumber + "-LX");
                    }
                    if(intR2aScore == 2){
                        intR3Number = 1;
                        blnWinR2 = true;
                    }
                }
            }else if(strMessage.startsWith("5_R2_")){
                // Send choices, outcomes and messages for R2b
                if(intR2Number == 7){
                    strOutcomeSfB = strMessage.substring(8);
                    String strR2NumberOPP = strMessage.substring(6,7);
                    if(strOutcomeSfB.equals("W")){
                        intR2bScore++;
                        ssm.sendText("Winner is [P" + strR2NumberOPP + "]");
                        chatArea3.append("Winner is [P" + strR2NumberOPP + "] \n");
                    }else if(strOutcomeSfB.equals("L")){
                        intR2bOPPScore++;
                        ssm.sendText("Winner is [P" + intPNumber + "]");
                        chatArea3.append("Winner is [P" + intPNumber + "] \n");
                    }else if(strOutcomeSfB.equals("T")){
                        ssm.sendText("Tie between [P" + strR2NumberOPP + "] and [P" + intPNumber + "]");
                        chatArea3.append("Tie between [P" + strR2NumberOPP + "] and [P" + intPNumber + "] \n");
                    }else if(strOutcomeSfB.equals("WX")){
                        intR2bScore++;
                        ssm.sendText("[P" + intPNumber + "] did not play, [P" + strR2NumberOPP + "] wins by default");
                        chatArea3.append("[P" + intPNumber + "] did not play, [P" + strR2NumberOPP + "] wins by default \n");
                    }else if(strOutcomeSfB.equals("LX")){
                        intR2bOPPScore++;
                        ssm.sendText("[P" + strR2NumberOPP + "] did not play, [P" + intPNumber + "] wins by default");
                        chatArea3.append("[P" + strR2NumberOPP + "] did not play, [P" + intPNumber + "] wins by default \n");
                    }
                    if(intR2bScore == 2){
                        ssm.sendText("INTR2MATCHES_INCREASE");
                        trackingWins.Outcome("Player " + strR2NumberOPP + " Won Round 2b");
                    }else if(intR2bOPPScore == 2){
                        intR3Number = 5;
                        blnWinR2 = true;
                        ssm.sendText("INTR2MATCHES_INCREASE");
                        trackingWins.Outcome("Player " + intPNumber + " Won Round 2b");
                    }
                }
            }else if(strMessage.startsWith("7_R2_")){
                // Send choices, outcomes and messages for R2b
                if(intR2Number == 5){
                    strChoiceR2bOPP = strMessage.substring(5);
                    strOutcomeSfB = winningMethods.isWinner(strChoiceR2b, strChoiceR2bOPP);
                    if(strOutcomeSfB.equals("W")){
                        intR2bScore++;
                        ssm.sendText("5_R2_-" + intPNumber + "-W");
                    }else if(strOutcomeSfB.equals("L")){
                        ssm.sendText("5_R2_-" + intPNumber + "-L");
                    }else if(strOutcomeSfB.equals("T")){
                        ssm.sendText("5_R2_-" + intPNumber + "-T");
                    }else if(strOutcomeSfB.equals("WX")){
                        intR2bScore++;
                        ssm.sendText("5_R2_-" + intPNumber + "-WX");
                    }else if(strOutcomeSfB.equals("LX")){
                        ssm.sendText("5_R2_-" + intPNumber + "-LX");
                    }
                    if(intR2bScore == 2){
                        intR3Number = 5;
                        blnWinR2 = true;
                    }
                }
            }else if(strMessage.startsWith("1_R3_")){
                // Send choices, outcomes and messages for R3
                if(intR3Number == 5){
                    strOutcomeF = strMessage.substring(8);
                    String strR3NumberOPP = strMessage.substring(6,7);
                    if(strOutcomeF.equals("W")){
                        ssm.sendText("Winner is [P" + strR3NumberOPP + "]");
                        chatArea4.append("Winner is [P" + strR3NumberOPP + "] \n");
                        intR3Score++;
                    }else if(strOutcomeF.equals("L")){
                        ssm.sendText("Winner is [P" + intPNumber + "]");
                        chatArea4.append("Winner is [P" + intPNumber + "] \n");
                        intR3OPPScore++;
                    }else if(strOutcomeF.equals("T")){
                        ssm.sendText("Tie between [P" +strR3NumberOPP + "] and [P" + intPNumber + "]");
                        chatArea4.append("Tie between [P" +strR3NumberOPP + "] and [P" + intPNumber + "] \n");
                    }else if(strOutcomeF.equals("WX")){
                        ssm.sendText("[P" + intPNumber + "] did not play, [P" + strR3NumberOPP + "] wins by default");
                        chatArea4.append("[P" + intPNumber + "] did not play, [P" + strR3NumberOPP + "] wins by default \n");
                        intR3Score++;
                    }else if(strOutcomeF.equals("LX")){
                        ssm.sendText("[P" + strR3NumberOPP + "] did not play, [P" + intPNumber + "] wins by default");
                        chatArea4.append("[P" + strR3NumberOPP + "] did not play, [P" + intPNumber + "] wins by default \n");
                        intR3OPPScore++;
                    }
                    if(intR3Score == 3){
                        blnGameEnd = true;
                        ssm.sendText("WINNER_" + strR3NumberOPP);
                        trackingWins.Outcome("Player " + strR3NumberOPP + " Won Round 3");
                    }else if(intR3OPPScore == 3){
                        blnGameEnd = true;
                        ssm.sendText("WINNER_"  + intPNumber);
                        trackingWins.Outcome("Player " + intPNumber + " Won Round 3");
                    }
                }
            }else if(strMessage.startsWith("5_R3_")){
                // Send choices, outcomes and messages for R3
                if(intR3Number == 1){
                    strChoiceR3OPP = strMessage.substring(5);
                    strOutcomeF = winningMethods.isWinner(strChoiceR3, strChoiceR3OPP);
                    if(strOutcomeF.equals("W")){
                        ssm.sendText("1_R3_-" + intPNumber + "-W");
                        intR3Score++;
                    }else if(strOutcomeF.equals("L")){
                        ssm.sendText("1_R3_-" + intPNumber + "-L");
                        intR3OPPScore++;
                    }else if(strOutcomeF.equals("T")){
                        ssm.sendText("1_R3_-" + intPNumber + "-T");
                    }else if(strOutcomeF.equals("WX")){
                        ssm.sendText("1_R3_-" + intPNumber + "-WX");
                        intR3Score++;
                    }else if(strOutcomeF.equals("LX")){
                        ssm.sendText("1_R3_-" + intPNumber + "-LX");
                        intR3OPPScore++;
                    }
                    if(intR3Score == 3 || intR3OPPScore == 3){
                        blnGameEnd = true;
                    }
                }
            }else{
                // Append messages to different chat areas based on game round
                if(blnRound1Start == false && blnRound2Start == false && blnRound3Start == false && blnGameEnd == false){
                    chatArea.append(strMessage + "\n");
                }else if(blnRound1Start == true && blnRound2Start == false && blnRound3Start == false && blnGameEnd == false){
                    chatArea2.append(strMessage + "\n");
                }else if(blnRound1Start == true && blnRound2Start == true && blnRound3Start == false && blnGameEnd == false){
                    chatArea3.append(strMessage + "\n");
                }else if(blnRound1Start == true && blnRound2Start == true && blnRound3Start == true && blnGameEnd == false){
                    chatArea4.append(strMessage + "\n");
                }else if(blnRound1Start == true && blnRound2Start == true && blnRound3Start == true && blnGameEnd == true){
                    chatArea5.append(strMessage + "\n");
                }
            }
        }else if(evt.getSource() == Rp1QFButton || evt.getSource() == Pp1QFButton || evt.getSource() == Cp1QFButton || evt.getSource() == Lp1QFButton || evt.getSource() == Sp1QFButton){
            // P1 Round 1 choices
            if(evt.getSource() == Rp1QFButton){
                strChoiceR1a = "ROCK";
            }else if(evt.getSource() == Pp1QFButton){
                strChoiceR1a = "PAPER";
            }else if(evt.getSource() == Cp1QFButton){
                strChoiceR1a = "SCISSORS";
            }else if(evt.getSource() == Lp1QFButton){
                strChoiceR1a = "LIZARD";
            }else if(evt.getSource() == Sp1QFButton){
                strChoiceR1a = "SPOCK";
            }
            chatArea2.append("YOU chose " + strChoiceR1a + "\n");
        }else if(evt.getSource() == Rp2QFButton || evt.getSource() == Pp2QFButton || evt.getSource() == Cp2QFButton || evt.getSource() == Lp2QFButton || evt.getSource() == Sp2QFButton){
            // P2 Round 1 choices
            if(evt.getSource() == Rp2QFButton){
                strChoiceR1aOPP = "ROCK";
            }else if(evt.getSource() == Pp2QFButton){
                strChoiceR1aOPP = "PAPER";
            }else if(evt.getSource() == Cp2QFButton){
                strChoiceR1aOPP = "SCISSORS";
            }else if(evt.getSource() == Lp2QFButton){
                strChoiceR1aOPP = "LIZARD";
            }else if(evt.getSource() == Sp2QFButton){
                strChoiceR1aOPP = "SPOCK";
            }
            chatArea2.append("YOU chose " + strChoiceR1aOPP + "\n");
        }else if(evt.getSource() == Rp3QFButton || evt.getSource() == Pp3QFButton || evt.getSource() == Cp3QFButton || evt.getSource() == Lp3QFButton || evt.getSource() == Sp3QFButton){
            // P3 Round 1 choices
            if(evt.getSource() == Rp3QFButton){
                strChoiceR1b = "ROCK";
            }else if(evt.getSource() == Pp3QFButton){
                strChoiceR1b = "PAPER";
            }else if(evt.getSource() == Cp3QFButton){
                strChoiceR1b = "SCISSORS";
            }else if(evt.getSource() == Lp3QFButton){
                strChoiceR1b = "LIZARD";
            }else if(evt.getSource() == Sp3QFButton){
                strChoiceR1b = "SPOCK";
            }
            chatArea2.append("YOU chose " + strChoiceR1b + "\n");
        }else if(evt.getSource() == Rp4QFButton || evt.getSource() == Pp4QFButton || evt.getSource() == Cp4QFButton || evt.getSource() == Lp4QFButton || evt.getSource() == Sp4QFButton){
            // P4 Round 1 choices
            if(evt.getSource() == Rp4QFButton){
                strChoiceR1bOPP = "ROCK";
            }else if(evt.getSource() == Pp4QFButton){
                strChoiceR1bOPP = "PAPER";
            }else if(evt.getSource() == Cp4QFButton){
                strChoiceR1bOPP = "SCISSORS";
            }else if(evt.getSource() == Lp4QFButton){
                strChoiceR1bOPP = "LIZARD";
            }else if(evt.getSource() == Sp4QFButton){
                strChoiceR1bOPP = "SPOCK";
            }
            chatArea2.append("YOU chose " + strChoiceR1bOPP + "\n");
        }else if(evt.getSource() == Rp5QFButton || evt.getSource() == Pp5QFButton || evt.getSource() == Cp5QFButton || evt.getSource() == Lp5QFButton || evt.getSource() == Sp5QFButton){
            // P5 Round 1 choices
            if(evt.getSource() == Rp5QFButton){
                strChoiceR1c = "ROCK";
            }else if(evt.getSource() == Pp5QFButton){
                strChoiceR1c = "PAPER";
            }else if(evt.getSource() == Cp5QFButton){
                strChoiceR1c = "SCISSORS";
            }else if(evt.getSource() == Lp5QFButton){
                strChoiceR1c = "LIZARD";
            }else if(evt.getSource() == Sp5QFButton){
                strChoiceR1c = "SPOCK";
            }
            chatArea2.append("YOU chose " + strChoiceR1c + "\n");
        }else if(evt.getSource() == Rp6QFButton || evt.getSource() == Pp6QFButton || evt.getSource() == Cp6QFButton || evt.getSource() == Lp6QFButton || evt.getSource() == Sp6QFButton){
            // P6 Round 1 choices
            if(evt.getSource() == Rp6QFButton){
                strChoiceR1cOPP = "ROCK";
            }else if(evt.getSource() == Pp6QFButton){
                strChoiceR1cOPP = "PAPER";
            }else if(evt.getSource() == Cp6QFButton){
                strChoiceR1cOPP = "SCISSORS";
            }else if(evt.getSource() == Lp6QFButton){
                strChoiceR1cOPP = "LIZARD";
            }else if(evt.getSource() == Sp6QFButton){
                strChoiceR1cOPP = "SPOCK";
            }
            chatArea2.append("YOU chose " + strChoiceR1cOPP + "\n");
        }else if(evt.getSource() == Rp7QFButton || evt.getSource() == Pp7QFButton || evt.getSource() == Cp7QFButton || evt.getSource() == Lp7QFButton || evt.getSource() == Sp7QFButton){
            // P7 Round 1 choices
            if(evt.getSource() == Rp7QFButton){
                strChoiceR1d = "ROCK";
            }else if(evt.getSource() == Pp7QFButton){
                strChoiceR1d = "PAPER";
            }else if(evt.getSource() == Cp7QFButton){
                strChoiceR1d = "SCISSORS";
            }else if(evt.getSource() == Lp7QFButton){
                strChoiceR1d = "LIZARD";
            }else if(evt.getSource() == Sp7QFButton){
                strChoiceR1d = "SPOCK";
            }
            chatArea2.append("YOU chose " + strChoiceR1d + "\n");
        }else if(evt.getSource() == Rp8QFButton || evt.getSource() == Pp8QFButton || evt.getSource() == Cp8QFButton || evt.getSource() == Lp8QFButton || evt.getSource() == Sp8QFButton){
            // P8 Round 1 choices
            if(evt.getSource() == Rp8QFButton){
                strChoiceR1dOPP = "ROCK";
            }else if(evt.getSource() == Pp8QFButton){
                strChoiceR1dOPP = "PAPER";
            }else if(evt.getSource() == Cp8QFButton){
                strChoiceR1dOPP = "SCISSORS";
            }else if(evt.getSource() == Lp8QFButton){
                strChoiceR1dOPP = "LIZARD";
            }else if(evt.getSource() == Sp8QFButton){
                strChoiceR1dOPP = "SPOCK";
            }
            chatArea2.append("YOU chose " + strChoiceR1dOPP + "\n");
        }else if(evt.getSource() == Rp1SFButton || evt.getSource() == Pp1SFButton || evt.getSource() == Cp1SFButton || evt.getSource() == Lp1SFButton || evt.getSource() == Sp1SFButton){
            // Round 2a choices
            if(evt.getSource() == Rp1SFButton){
                strChoiceR2a = "ROCK";
            }else if(evt.getSource() == Pp1SFButton){
                strChoiceR2a = "PAPER";
            }else if(evt.getSource() == Cp1SFButton){
                strChoiceR2a = "SCISSORS";
            }else if(evt.getSource() == Lp1SFButton){
                strChoiceR2a = "LIZARD";
            }else if(evt.getSource() == Sp1SFButton){
                strChoiceR2a = "SPOCK";
            }
            chatArea3.append("YOU chose " + strChoiceR2a + "\n");
        }else if(evt.getSource() == Rp3SFButton || evt.getSource() == Pp3SFButton || evt.getSource() == Cp3SFButton || evt.getSource() == Lp3SFButton || evt.getSource() == Sp3SFButton){
            // Round 2a choices
            if(evt.getSource() == Rp3SFButton){
                strChoiceR2aOPP = "ROCK";
            }else if(evt.getSource() == Pp3SFButton){
                strChoiceR2aOPP = "PAPER";
            }else if(evt.getSource() == Cp3SFButton){
                strChoiceR2aOPP = "SCISSORS";
            }else if(evt.getSource() == Lp3SFButton){
                strChoiceR2aOPP = "LIZARD";
            }else if(evt.getSource() == Sp3SFButton){
                strChoiceR2aOPP = "SPOCK";
            }
            chatArea3.append("YOU chose " + strChoiceR2aOPP + "\n");
        }else if(evt.getSource() == Rp5SFButton || evt.getSource() == Pp5SFButton || evt.getSource() == Cp5SFButton || evt.getSource() == Lp5SFButton || evt.getSource() == Sp5SFButton){
            // Round 2b choices
            if(evt.getSource() == Rp5SFButton){
                strChoiceR2b = "ROCK";
            }else if(evt.getSource() == Pp5SFButton){
                strChoiceR2b = "PAPER";
            }else if(evt.getSource() == Cp5SFButton){
                strChoiceR2b = "SCISSORS";
            }else if(evt.getSource() == Lp5SFButton){
                strChoiceR2b = "LIZARD";
            }else if(evt.getSource() == Sp5SFButton){
                strChoiceR2b = "SPOCK";
            }
            chatArea3.append("YOU chose " + strChoiceR2b + "\n");
        }else if(evt.getSource() == Rp7SFButton || evt.getSource() == Pp7SFButton || evt.getSource() == Cp7SFButton || evt.getSource() == Lp7SFButton || evt.getSource() == Sp7SFButton){
            // Round 2b choices
            if(evt.getSource() == Rp7SFButton){
                strChoiceR2bOPP = "ROCK";
            }else if(evt.getSource() == Pp7SFButton){
                strChoiceR2bOPP = "PAPER";
            }else if(evt.getSource() == Cp7SFButton){
                strChoiceR2bOPP = "SCISSORS";
            }else if(evt.getSource() == Lp7SFButton){
                strChoiceR2bOPP = "LIZARD";
            }else if(evt.getSource() == Sp7SFButton){
                strChoiceR2bOPP = "SPOCK";
            }
            chatArea3.append("YOU chose " + strChoiceR2bOPP + "\n");
        }else if(evt.getSource() == Rp1FButton || evt.getSource() == Pp1FButton || evt.getSource() == Cp1FButton || evt.getSource() == Lp1FButton || evt.getSource() == Sp1FButton){
            // Round 3 choices
            if(evt.getSource() == Rp1FButton){
                strChoiceR3 = "ROCK";
            }else if(evt.getSource() == Pp1FButton){
                strChoiceR3 = "PAPER";
            }else if(evt.getSource() == Cp1FButton){
                strChoiceR3 = "SCISSORS";
            }else if(evt.getSource() == Lp1FButton){
                strChoiceR3 = "LIZARD";
            }else if(evt.getSource() == Sp1FButton){
                strChoiceR3 = "SPOCK";
            }
            chatArea4.append("YOU chose " + strChoiceR3 + "\n");
        }else if(evt.getSource() == Rp5FButton || evt.getSource() == Pp5FButton || evt.getSource() == Cp5FButton || evt.getSource() == Lp5FButton || evt.getSource() == Sp5FButton){
            // Round 3 choices
            if(evt.getSource() == Rp5FButton){
                strChoiceR3OPP = "ROCK";
            }else if(evt.getSource() == Pp5FButton){
                strChoiceR3OPP = "PAPER";
            }else if(evt.getSource() == Cp5FButton){
                strChoiceR3OPP = "SCISSORS";
            }else if(evt.getSource() == Lp5FButton){
                strChoiceR3OPP = "LIZARD";
            }else if(evt.getSource() == Sp5FButton){
                strChoiceR3OPP = "SPOCK";
            }
            chatArea4.append("YOU chose " + strChoiceR3OPP + "\n");
        }else if(evt.getSource() == helpButton){
            // Go to help screen
            thePanel.setVisible(false);
            homeHelpPanel.setVisible(true);
            theFrame.setContentPane(homeHelpPanel);
            theFrame.pack();
        }else if(evt.getSource() == QFHelpButton){
            // Go to quarterfinals help screen
            homeHelpPanel.setVisible(false);
            qfHelpPanel.setVisible(true);
            theFrame.setContentPane(qfHelpPanel);
            theFrame.pack();
        }else if(evt.getSource() == SFHelpButton){
            // Go to semifinals help screen
            qfHelpPanel.setVisible(false);
            sfHelpPanel.setVisible(true);
            theFrame.setContentPane(sfHelpPanel);
            theFrame.pack();
        }else if(evt.getSource() == FHelpButton){
            // Go to finals help screen
            sfHelpPanel.setVisible(false);
            fHelpPanel.setVisible(true);
            theFrame.setContentPane(fHelpPanel);
            theFrame.pack();
        }else if(evt.getSource() == RulesButton){
            // Go to rules screen
            fHelpPanel.setVisible(false);
            rulesPanel.setVisible(true);
            theFrame.setContentPane(rulesPanel);
            theFrame.pack();
        }else if(evt.getSource() == backHomeButton){
            // Go back to home screen
            rulesPanel.setVisible(false);
            thePanel.setVisible(true);
            theFrame.setContentPane(thePanel);
            theFrame.pack();
        }
    }
    // Constructor
    public RPSGame(){

        // Help Screen Components

        // Home help
        homeHelpPanel.setPreferredSize(new Dimension(1280, 720));
        homeHelpPanel.setLayout(null);

        QFHelpButton.setSize(100,35);
        QFHelpButton.setLocation(870,25);
        QFHelpButton.setVisible(true);
        homeHelpPanel.add(QFHelpButton);
        QFHelpButton.addActionListener(this);

        // Quarterfinals help
        qfHelpPanel.setPreferredSize(new Dimension(1280, 720));
        qfHelpPanel.setLayout(null);

        SFHelpButton.setSize(100,35);
        SFHelpButton.setLocation(870,25);
        SFHelpButton.setVisible(true);
        qfHelpPanel.add(SFHelpButton);
        SFHelpButton.addActionListener(this);
        // Semifinals help
        sfHelpPanel.setPreferredSize(new Dimension(1280, 720));
        sfHelpPanel.setLayout(null);

        FHelpButton.setSize(100,35);
        FHelpButton.setLocation(870,25);
        FHelpButton.setVisible(true);
        sfHelpPanel.add(FHelpButton);
        FHelpButton.addActionListener(this);
        // Finals help
        fHelpPanel.setPreferredSize(new Dimension(1280, 720));
        fHelpPanel.setLayout(null);

        RulesButton.setSize(100,35);
        RulesButton.setLocation(870,25);
        RulesButton.setVisible(true);
        fHelpPanel.add(RulesButton);
        RulesButton.addActionListener(this);

        // Rules 
        rulesPanel.setPreferredSize(new Dimension(1280, 720));
        rulesPanel.setLayout(null);

        backHomeButton.setSize(100,35);
        backHomeButton.setLocation(50,650);
        backHomeButton.setVisible(true);
        rulesPanel.add(backHomeButton);
        backHomeButton.addActionListener(this);

        // Quarter Final Screen Components
        qfPanel.setPreferredSize(new Dimension(1280, 720));
        qfPanel.setLayout(null);

        qfCountTitle.setSize(300, 50);
        qfCountTitle.setLocation(980, 0);
        qfCountTitle.setFont(new Font("SansSerif", Font.PLAIN, 30));
        qfCountTitle.setText("COUNTDOWN");
        qfCountTitle.setHorizontalAlignment(JLabel.CENTER);
        qfPanel.add(qfCountTitle);

        qfCountLabel.setSize(300, 50);
        qfCountLabel.setLocation(980, 40);
        qfCountLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        qfCountLabel.setText("");
        qfCountLabel.setHorizontalAlignment(JLabel.CENTER);
        qfPanel.add(qfCountLabel);

        //p1 buttons
        Rp1QFButton.setSize(100,35);
        Rp1QFButton.setLocation(100,125);
        Rp1QFButton.setVisible(false);
        qfPanel.add(Rp1QFButton);
        Rp1QFButton.addActionListener(this);

        Pp1QFButton.setSize(100,35);
        Pp1QFButton.setLocation(100,170);
        Pp1QFButton.setVisible(false);
        qfPanel.add(Pp1QFButton);
        Pp1QFButton.addActionListener(this);

        Cp1QFButton.setSize(100,35);
        Cp1QFButton.setLocation(225,125);
        Cp1QFButton.setVisible(false);
        qfPanel.add(Cp1QFButton);
        Cp1QFButton.addActionListener(this);

        Lp1QFButton.setSize(100,35);
        Lp1QFButton.setLocation(225,170);
        Lp1QFButton.setVisible(false);
        qfPanel.add(Lp1QFButton);
        Lp1QFButton.addActionListener(this);

        Sp1QFButton.setSize(100,35);
        Sp1QFButton.setLocation(350,170);
        Sp1QFButton.setVisible(false);
        qfPanel.add(Sp1QFButton);
        Sp1QFButton.addActionListener(this);
        //p2 buttons
        Rp2QFButton.setSize(100,35);
        Rp2QFButton.setLocation(650,125);
        Rp2QFButton.setVisible(false);
        qfPanel.add(Rp2QFButton);
        Rp2QFButton.addActionListener(this);

        Pp2QFButton.setSize(100,35);
        Pp2QFButton.setLocation(525,170);
        Pp2QFButton.setVisible(false);
        qfPanel.add(Pp2QFButton);
        Pp2QFButton.addActionListener(this);

        Cp2QFButton.setSize(100,35);
        Cp2QFButton.setLocation(775,125);
        Cp2QFButton.setVisible(false);
        qfPanel.add(Cp2QFButton);
        Cp2QFButton.addActionListener(this);

        Lp2QFButton.setSize(100,35);
        Lp2QFButton.setLocation(650,170);
        Lp2QFButton.setVisible(false);
        qfPanel.add(Lp2QFButton);
        Lp2QFButton.addActionListener(this);

        Sp2QFButton.setSize(100,35);
        Sp2QFButton.setLocation(775,170);
        Sp2QFButton.setVisible(false);
        qfPanel.add(Sp2QFButton);
        Sp2QFButton.addActionListener(this);
        //p3 buttons
        Rp3QFButton.setSize(100,35);
        Rp3QFButton.setLocation(100,270);
        Rp3QFButton.setVisible(false);
        qfPanel.add(Rp3QFButton);
        Rp3QFButton.addActionListener(this);

        Pp3QFButton.setSize(100,35);
        Pp3QFButton.setLocation(100,315);
        Pp3QFButton.setVisible(false);
        qfPanel.add(Pp3QFButton);
        Pp3QFButton.addActionListener(this);

        Cp3QFButton.setSize(100,35);
        Cp3QFButton.setLocation(225,270);
        Cp3QFButton.setVisible(false);
        qfPanel.add(Cp3QFButton);
        Cp3QFButton.addActionListener(this);

        Lp3QFButton.setSize(100,35);
        Lp3QFButton.setLocation(225,315);
        Lp3QFButton.setVisible(false);
        qfPanel.add(Lp3QFButton);
        Lp3QFButton.addActionListener(this);

        Sp3QFButton.setSize(100,35);
        Sp3QFButton.setLocation(350,315);
        Sp3QFButton.setVisible(false);
        qfPanel.add(Sp3QFButton);
        Sp3QFButton.addActionListener(this);
        //p4 buttons
        Rp4QFButton.setSize(100,35);
        Rp4QFButton.setLocation(650,270);
        Rp4QFButton.setVisible(false);
        qfPanel.add(Rp4QFButton);
        Rp4QFButton.addActionListener(this);

        Pp4QFButton.setSize(100,35);
        Pp4QFButton.setLocation(525,315);
        Pp4QFButton.setVisible(false);
        qfPanel.add(Pp4QFButton);
        Pp4QFButton.addActionListener(this);

        Cp4QFButton.setSize(100,35);
        Cp4QFButton.setLocation(775,270);
        Cp4QFButton.setVisible(false);
        qfPanel.add(Cp4QFButton);
        Cp4QFButton.addActionListener(this);

        Lp4QFButton.setSize(100,35);
        Lp4QFButton.setLocation(650,315);
        Lp4QFButton.setVisible(false);
        qfPanel.add(Lp4QFButton);
        Lp4QFButton.addActionListener(this);

        Sp4QFButton.setSize(100,35);
        Sp4QFButton.setLocation(775,315);
        Sp4QFButton.setVisible(false);
        qfPanel.add(Sp4QFButton);
        Sp4QFButton.addActionListener(this);
        //p5 buttons
        Rp5QFButton.setSize(100,35);
        Rp5QFButton.setLocation(100,415);
        Rp5QFButton.setVisible(false);
        qfPanel.add(Rp5QFButton);
        Rp5QFButton.addActionListener(this);

        Pp5QFButton.setSize(100,35);
        Pp5QFButton.setLocation(100,460);
        Pp5QFButton.setVisible(false);
        qfPanel.add(Pp5QFButton);
        Pp5QFButton.addActionListener(this);

        Cp5QFButton.setSize(100,35);
        Cp5QFButton.setLocation(225,415);
        Cp5QFButton.setVisible(false);
        qfPanel.add(Cp5QFButton);
        Cp5QFButton.addActionListener(this);

        Lp5QFButton.setSize(100,35);
        Lp5QFButton.setLocation(225,460);
        Lp5QFButton.setVisible(false);
        qfPanel.add(Lp5QFButton);
        Lp5QFButton.addActionListener(this);

        Sp5QFButton.setSize(100,35);
        Sp5QFButton.setLocation(350,460);
        Sp5QFButton.setVisible(false);
        qfPanel.add(Sp5QFButton);
        Sp5QFButton.addActionListener(this);
        //p6 buttons
        Rp6QFButton.setSize(100,35);
        Rp6QFButton.setLocation(650,415);
        Rp6QFButton.setVisible(false);
        qfPanel.add(Rp6QFButton);
        Rp6QFButton.addActionListener(this);

        Pp6QFButton.setSize(100,35);
        Pp6QFButton.setLocation(525,460);
        Pp6QFButton.setVisible(false);
        qfPanel.add(Pp6QFButton);
        Pp6QFButton.addActionListener(this);

        Cp6QFButton.setSize(100,35);
        Cp6QFButton.setLocation(775,415);
        Cp6QFButton.setVisible(false);
        qfPanel.add(Cp6QFButton);
        Cp6QFButton.addActionListener(this);

        Lp6QFButton.setSize(100,35);
        Lp6QFButton.setLocation(650,460);
        Lp6QFButton.setVisible(false);
        qfPanel.add(Lp6QFButton);
        Lp6QFButton.addActionListener(this);

        Sp6QFButton.setSize(100,35);
        Sp6QFButton.setLocation(775,460);
        Sp6QFButton.setVisible(false);
        qfPanel.add(Sp6QFButton);
        Sp6QFButton.addActionListener(this);
        //p7 buttons
        Rp7QFButton.setSize(100,35);
        Rp7QFButton.setLocation(100,560);
        Rp7QFButton.setVisible(false);
        qfPanel.add(Rp7QFButton);
        Rp7QFButton.addActionListener(this);

        Pp7QFButton.setSize(100,35);
        Pp7QFButton.setLocation(100,605);
        Pp7QFButton.setVisible(false);
        qfPanel.add(Pp7QFButton);
        Pp7QFButton.addActionListener(this);

        Cp7QFButton.setSize(100,35);
        Cp7QFButton.setLocation(225,560);
        Cp7QFButton.setVisible(false);
        qfPanel.add(Cp7QFButton);
        Cp7QFButton.addActionListener(this);

        Lp7QFButton.setSize(100,35);
        Lp7QFButton.setLocation(225,605);
        Lp7QFButton.setVisible(false);
        qfPanel.add(Lp7QFButton);
        Lp7QFButton.addActionListener(this);

        Sp7QFButton.setSize(100,35);
        Sp7QFButton.setLocation(350,605);
        Sp7QFButton.setVisible(false);
        qfPanel.add(Sp7QFButton);
        Sp7QFButton.addActionListener(this);
        //p8 buttons
        Rp8QFButton.setSize(100,35);
        Rp8QFButton.setLocation(650,560);
        Rp8QFButton.setVisible(false);
        qfPanel.add(Rp8QFButton);
        Rp8QFButton.addActionListener(this);

        Pp8QFButton.setSize(100,35);
        Pp8QFButton.setLocation(525,605);
        Pp8QFButton.setVisible(false);
        qfPanel.add(Pp8QFButton);
        Pp8QFButton.addActionListener(this);

        Cp8QFButton.setSize(100,35);
        Cp8QFButton.setLocation(775,560);
        Cp8QFButton.setVisible(false);
        qfPanel.add(Cp8QFButton);
        Cp8QFButton.addActionListener(this);

        Lp8QFButton.setSize(100,35);
        Lp8QFButton.setLocation(650,605);
        Lp8QFButton.setVisible(false);
        qfPanel.add(Lp8QFButton);
        Lp8QFButton.addActionListener(this);

        Sp8QFButton.setSize(100,35);
        Sp8QFButton.setLocation(775,605);
        Sp8QFButton.setVisible(false);
        qfPanel.add(Sp8QFButton);
        Sp8QFButton.addActionListener(this);

        // Semi Final Screen Components
        sfPanel.setPreferredSize(new Dimension(1280, 720));
        sfPanel.setLayout(null);

        sfCountTitle.setSize(300, 50);
        sfCountTitle.setLocation(980, 0);
        sfCountTitle.setFont(new Font("SansSerif", Font.PLAIN, 30));
        sfCountTitle.setText("COUNTDOWN");
        sfCountTitle.setHorizontalAlignment(JLabel.CENTER);
        sfPanel.add(sfCountTitle);

        sfCountLabel.setSize(300, 50);
        sfCountLabel.setLocation(980, 40);
        sfCountLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        sfCountLabel.setText("");
        sfCountLabel.setHorizontalAlignment(JLabel.CENTER);
        sfPanel.add(sfCountLabel);

        //p1 buttons
        Rp1SFButton.setSize(100,35);
        Rp1SFButton.setLocation(100,270);
        Rp1SFButton.setVisible(false);
        sfPanel.add(Rp1SFButton);
        Rp1SFButton.addActionListener(this);

        Pp1SFButton.setSize(100,35);
        Pp1SFButton.setLocation(100,315);
        Pp1SFButton.setVisible(false);
        sfPanel.add(Pp1SFButton);
        Pp1SFButton.addActionListener(this);

        Cp1SFButton.setSize(100,35);
        Cp1SFButton.setLocation(225,270);
        Cp1SFButton.setVisible(false);
        sfPanel.add(Cp1SFButton);
        Cp1SFButton.addActionListener(this);

        Lp1SFButton.setSize(100,35);
        Lp1SFButton.setLocation(225,315);
        Lp1SFButton.setVisible(false);
        sfPanel.add(Lp1SFButton);
        Lp1SFButton.addActionListener(this);

        Sp1SFButton.setSize(100,35);
        Sp1SFButton.setLocation(350,315);
        Sp1SFButton.setVisible(false);
        sfPanel.add(Sp1SFButton);
        Sp1SFButton.addActionListener(this);
        //p3 buttons
        Rp3SFButton.setSize(100,35);
        Rp3SFButton.setLocation(650,270);
        Rp3SFButton.setVisible(false);
        sfPanel.add(Rp3SFButton);
        Rp3SFButton.addActionListener(this);

        Pp3SFButton.setSize(100,35);
        Pp3SFButton.setLocation(525,315);
        Pp3SFButton.setVisible(false);
        sfPanel.add(Pp3SFButton);
        Pp3SFButton.addActionListener(this);

        Cp3SFButton.setSize(100,35);
        Cp3SFButton.setLocation(775,270);
        Cp3SFButton.setVisible(false);
        sfPanel.add(Cp3SFButton);
        Cp3SFButton.addActionListener(this);

        Lp3SFButton.setSize(100,35);
        Lp3SFButton.setLocation(650,315);
        Lp3SFButton.setVisible(false);
        sfPanel.add(Lp3SFButton);
        Lp3SFButton.addActionListener(this);

        Sp3SFButton.setSize(100,35);
        Sp3SFButton.setLocation(775,315);
        Sp3SFButton.setVisible(false);
        sfPanel.add(Sp3SFButton);
        Sp3SFButton.addActionListener(this);
        //p5 buttons
        Rp5SFButton.setSize(100,35);
        Rp5SFButton.setLocation(100,560);
        Rp5SFButton.setVisible(false);
        sfPanel.add(Rp5SFButton);
        Rp5SFButton.addActionListener(this);
        
        Pp5SFButton.setSize(100,35);
        Pp5SFButton.setLocation(100,605);
        Pp5SFButton.setVisible(false);
        sfPanel.add(Pp5SFButton);
        Pp5SFButton.addActionListener(this);

        Cp5SFButton.setSize(100,35);
        Cp5SFButton.setLocation(225,560);
        Cp5SFButton.setVisible(false);
        sfPanel.add(Cp5SFButton);
        Cp5SFButton.addActionListener(this);

        Lp5SFButton.setSize(100,35);
        Lp5SFButton.setLocation(225,605);
        Lp5SFButton.setVisible(false);
        sfPanel.add(Lp5SFButton);
        Lp5SFButton.addActionListener(this);

        Sp5SFButton.setSize(100,35);
        Sp5SFButton.setLocation(350,605);
        Sp5SFButton.setVisible(false);
        sfPanel.add(Sp5SFButton);
        Sp5SFButton.addActionListener(this);
        //p7 buttons
        Rp7SFButton.setSize(100,35);
        Rp7SFButton.setLocation(650,560);
        Rp7SFButton.setVisible(false);
        sfPanel.add(Rp7SFButton);
        Rp7SFButton.addActionListener(this);

        Pp7SFButton.setSize(100,35);
        Pp7SFButton.setLocation(525,605);
        Pp7SFButton.setVisible(false);
        sfPanel.add(Pp7SFButton);
        Pp7SFButton.addActionListener(this);

        Cp7SFButton.setSize(100,35);
        Cp7SFButton.setLocation(775,560);
        Cp7SFButton.setVisible(false);
        sfPanel.add(Cp7SFButton);
        Cp7SFButton.addActionListener(this);

        Lp7SFButton.setSize(100,35);
        Lp7SFButton.setLocation(650,605);
        Lp7SFButton.setVisible(false);
        sfPanel.add(Lp7SFButton);
        Lp7SFButton.addActionListener(this);

        Sp7SFButton.setSize(100,35);
        Sp7SFButton.setLocation(775,605);
        Sp7SFButton.setVisible(false);
        sfPanel.add(Sp7SFButton);
        Sp7SFButton.addActionListener(this);
        // Final Screen Components
        fPanel.setPreferredSize(new Dimension(1280, 720));
        fPanel.setLayout(null);

        fCountTitle.setSize(300, 50);
        fCountTitle.setLocation(980, 0);
        fCountTitle.setFont(new Font("SansSerif", Font.PLAIN, 30));
        fCountTitle.setText("COUNTDOWN");
        fCountTitle.setHorizontalAlignment(JLabel.CENTER);
        fPanel.add(fCountTitle);

        fCountLabel.setSize(300, 50);
        fCountLabel.setLocation(980, 40);
        fCountLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        fCountLabel.setText("");
        fCountLabel.setHorizontalAlignment(JLabel.CENTER);
        fPanel.add(fCountLabel);

        //p1 buttons
        Rp1FButton.setSize(100,35);
        Rp1FButton.setLocation(225,270);
        Rp1FButton.setVisible(false);
        fPanel.add(Rp1FButton);
        Rp1FButton.addActionListener(this);

        Pp1FButton.setSize(100,35);
        Pp1FButton.setLocation(225,315);
        Pp1FButton.setVisible(false);
        fPanel.add(Pp1FButton);
        Pp1FButton.addActionListener(this);

        Cp1FButton.setSize(100,35);
        Cp1FButton.setLocation(225,360);
        Cp1FButton.setVisible(false);
        fPanel.add(Cp1FButton);
        Cp1FButton.addActionListener(this);

        Lp1FButton.setSize(100,35);
        Lp1FButton.setLocation(225,405);
        Lp1FButton.setVisible(false);
        fPanel.add(Lp1FButton);
        Lp1FButton.addActionListener(this);

        Sp1FButton.setSize(100,35);
        Sp1FButton.setLocation(225,450);
        Sp1FButton.setVisible(false);
        fPanel.add(Sp1FButton);
        Sp1FButton.addActionListener(this);
        //p5 buttons
        Rp5FButton.setSize(100,35);
        Rp5FButton.setLocation(650,270);
        Rp5FButton.setVisible(false);
        fPanel.add(Rp5FButton);
        Rp5FButton.addActionListener(this);

        Pp5FButton.setSize(100,35);
        Pp5FButton.setLocation(650,315);
        Pp5FButton.setVisible(false);
        fPanel.add(Pp5FButton);
        Pp5FButton.addActionListener(this);

        Cp5FButton.setSize(100,35);
        Cp5FButton.setLocation(650,360);
        Cp5FButton.setVisible(false);
        fPanel.add(Cp5FButton);
        Cp5FButton.addActionListener(this);

        Lp5FButton.setSize(100,35);
        Lp5FButton.setLocation(650,405);
        Lp5FButton.setVisible(false);
        fPanel.add(Lp5FButton);
        Lp5FButton.addActionListener(this);

        Sp5FButton.setSize(100,35);
        Sp5FButton.setLocation(650,450);
        Sp5FButton.setVisible(false);
        fPanel.add(Sp5FButton);
        Sp5FButton.addActionListener(this);
        // Winner Screen Components
        wPanel.setPreferredSize(new Dimension(1280,720));
        wPanel.setLayout(null);

        winLabel.setSize(200, 100);
        winLabel.setFont(new Font("SansSerif", Font.PLAIN, 50));
        winLabel.setText("");
        winLabel.setLocation(390, 300);
        winLabel.setHorizontalAlignment(JLabel.CENTER);
        wPanel.add(winLabel);

        // Chat Components
        // Frame & Panel
        thePanel.setPreferredSize(new Dimension(1280,720));
        thePanel.setLayout(null);
        theFrame.setContentPane(thePanel);
        theFrame.pack();
        theFrame.setVisible(true);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Buttons, TextFields, TextAreas, ScrollPanes
        serverButton.setSize(100, 100);
        serverButton.setLocation(0, 620);
        thePanel.add(serverButton);
        serverButton.addActionListener(this);

        clientButton.setSize(100, 100);
        clientButton.setLocation(100, 620);
        thePanel.add(clientButton);
        clientButton.addActionListener(this);

        startButton.setSize(100, 100);
        startButton.setLocation(0, 520);
        startButton.setVisible(false);
        thePanel.add(startButton);
        startButton.addActionListener(this);

        helpButton.setSize(100, 100);
        helpButton.setLocation(200, 520);
        helpButton.setVisible(true);
        thePanel.add(helpButton);
        helpButton.addActionListener(this);

        ipField.setSize(100, 100);
        ipField.setLocation(200, 620);
        thePanel.add(ipField);

        messageField.setSize(300, 40);
        messageField.setLocation(980, 680);
        thePanel.add(messageField);
        messageField.addActionListener(this);

        theScroll.setSize(300, 500);
        theScroll.setLocation(980, 100);
        chatArea.setEditable(false);
        thePanel.add(theScroll);

        // Quarter Final Panel Chat Components
        messageField2.setSize(300, 40);
        messageField2.setLocation(980, 680);
        qfPanel.add(messageField2);
        messageField2.addActionListener(this);

        theScroll2.setSize(300, 500);
        theScroll2.setLocation(980, 100);
        chatArea2.setEditable(false);
        qfPanel.add(theScroll2);

        // Semi Final Panel Chat Components
        messageField3.setSize(300, 40);
        messageField3.setLocation(980, 680);
        sfPanel.add(messageField3);
        messageField3.addActionListener(this);

        theScroll3.setSize(300, 500);
        theScroll3.setLocation(980, 100);
        chatArea3.setEditable(false);
        sfPanel.add(theScroll3);

        // Final Panel Chat Components
        messageField4.setSize(300, 40);
        messageField4.setLocation(980, 680);
        fPanel.add(messageField4);
        messageField4.addActionListener(this);

        theScroll4.setSize(300, 500);
        theScroll4.setLocation(980, 100);
        chatArea4.setEditable(false);
        fPanel.add(theScroll4);

        // Win Panel Chat Components
        messageField5.setSize(300, 40);
        messageField5.setLocation(980, 680);
        wPanel.add(messageField5);
        messageField5.addActionListener(this);

        theScroll5.setSize(300, 500);
        theScroll5.setLocation(980, 100);
        chatArea5.setEditable(false);
        wPanel.add(theScroll5);
    }

    // Main Method
    public static void main(String[] args){
        new RPSGame();
    }
}