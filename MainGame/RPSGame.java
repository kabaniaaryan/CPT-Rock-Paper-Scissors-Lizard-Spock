package MainGame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RPSGame implements ActionListener{
    // Properties
    JFrame theFrame = new JFrame("Rock Paper Scissors Lizard Spock Tournament");
    HomePanel thePanel = new HomePanel();
    JButton serverButton = new JButton("Host Game");
    JButton clientButton = new JButton("Join Game");
    JButton startButton = new JButton("Start Game");
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

    SuperSocketMaster ssm = null;
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

    boolean blnWinR1 = true;
    boolean blnWinR2 = true;
    boolean blnWinR3 = true;

    boolean blnRound1Start = false;
    boolean blnRound2Start = false;
    boolean blnRound3Start = false;

    String strChoiceR1a = null;
    String strChoiceR1aOPP = null;
    String strChoiceR1b = null;
    String strChoiceR1bOPP = null;
    String strChoiceR1c = null;
    String strChoiceR1cOPP = null;
    String strChoiceR1d = null;
    String strChoiceR1dOPP = null;

    String strChoiceR2a = null;
    String strChoiceR2aOPP = null;
    String strChoiceR2b = null;
    String strChoiceR2bOPP = null;

    String strChoiceR3 = null;
    String strChoiceR3OPP = null;

    String strOutcomeQfA = "";
    String strOutcomeQfB = "";
    String strOutcomeQfC = "";
    String strOutcomeQfD = "";

    String strOutcomeSfA = "";
    String strOutcomeSfB = "";

    int intR1MatchesDone = 0;
    int intR2MatchesDone = 0;
    int intR3MatchesDone = 0;

    String strWinnerR1a = "";
    String strWinnerR1b = "";
    String strWinnerR1c = "";
    String strWinnerR1d = "";
    String strWinnerR2a = "";
    String strWinnerR2b = "";
    String strFinalWinner = "";

    // Game Panels
    QuarterPanel qfPanel = new QuarterPanel();
    SemiPanel sfPanel = new SemiPanel();
    FinalPanel fPanel = new FinalPanel();

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
        }else if(evt.getSource() == startButton){
            System.out.println("Starting Game");
            intPNumberTemp = 0;
            if(intPlayerCount % 2 == 0){
                ssm.sendText("GAME_START_EVEN");
            }else{
                ssm.sendText("GAME_START_ODD");
            }
            thePanel.setVisible(false);
            theFrame.setContentPane(qfPanel);
            theFrame.pack();
            blnRound1Start = true;
            Rp1QFButton.setVisible(true);
            Pp1QFButton.setVisible(true);
            Cp1QFButton.setVisible(true);
            Lp1QFButton.setVisible(true);
            Sp1QFButton.setVisible(true);
        }else if(evt.getSource() == messageField){
            String strMessage = messageField.getText();
            ssm.sendText("[P" + intPNumber + "] " + strMessage);
            chatArea.append("[P" + intPNumber + "] " + strMessage + "\n");
            messageField.setText("");
        }else if(evt.getSource() == messageField2){
            String strMessage = messageField2.getText();
            ssm.sendText("[P" + intPNumber + "] " + strMessage);
            chatArea2.append("[P" + intPNumber + "] " + strMessage + "\n");
            messageField2.setText("");
        }else if((evt.getSource() == messageField3)){
            String strMessage = messageField3.getText();
            ssm.sendText("[P" + intPNumber + "] " + strMessage);
            chatArea3.append("[P" + intPNumber + "] " + strMessage + "\n");
            messageField3.setText("");
        }else if((evt.getSource() == messageField4)){
            String strMessage = messageField4.getText();
            ssm.sendText("[P" + intPNumber + "] " + strMessage);
            chatArea4.append("[P" + intPNumber + "] " + strMessage + "\n");
            messageField4.setText("");
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
            }else if(strMessage.startsWith("GAME_START_")){
                if(strMessage.equals("GAME_START_EVEN")){
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
            }else if(strMessage.startsWith("ROUND_2_START_")){
                qfPanel.setVisible(false);
                theFrame.setContentPane(sfPanel);
                theFrame.pack();
                blnRound2Start = true;
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
            }else if(strMessage.startsWith("1_R1_")){
                if(intPNumber == 2){
                    strOutcomeQfA = strMessage.substring(5);
                    if(strOutcomeQfA.equals("W")){
                        blnWinR1 = false;
                        ssm.sendText("Winner is [P1]");
                        chatArea2.append("Winner is [P1] \n");
                    }else if(strOutcomeQfA.equals("L")){
                        intR2Number = 1;
                        ssm.sendText("Winner is [P2]");
                        chatArea2.append("Winner is [P2] \n");
                    }else if(strOutcomeQfA.equals("T")){
                        ssm.sendText("Tie between [P1] and [P2]");
                        chatArea2.append("Tie between [P1] and [P2] \n");
                    }
                }
            }else if(strMessage.startsWith("2_R1_")){
                if(intPNumber == 1){
                    strChoiceR1aOPP = strMessage.substring(5);
                    strOutcomeQfA = winningMethods.isWinner(strChoiceR1a, strChoiceR1aOPP);
                    if(strOutcomeQfA.equals("W")){
                        intR2Number = 1;
                        ssm.sendText("1_R1_W");
                        intR1MatchesDone++;
                    }else if(strOutcomeQfA.equals("L")){
                        blnWinR1 = false;
                        ssm.sendText("1_R1_L");
                        intR1MatchesDone++;
                    }else if(strOutcomeQfA.equals("T")){
                        ssm.sendText("1_R1_T");
                    }
                    if((intPlayerCount % 2 == 1 && intR1MatchesDone == (intPlayerCount - 1) / 2) || (intPlayerCount % 2 == 0 && intR1MatchesDone == intPlayerCount / 2)){
                        if(intPlayerCount % 2 == 1 && intR1MatchesDone == (intPlayerCount - 1) / 2){
                            ssm.sendText("ROUND_2_START_ODD");
                        }else if(intPlayerCount % 2 == 0 && intR1MatchesDone == intPlayerCount / 2){
                            ssm.sendText("ROUND_2_START_EVEN");
                        }
                        qfPanel.setVisible(false);
                        theFrame.setContentPane(sfPanel);
                        theFrame.pack();
                        blnRound2Start = true;
                        if(intR2Number == 1){
                            Rp1SFButton.setVisible(true);
                            Pp1SFButton.setVisible(true);
                            Cp1SFButton.setVisible(true);
                            Lp1SFButton.setVisible(true);
                            Sp1SFButton.setVisible(true);
                        }
                    }
                }
            }else if(strMessage.startsWith("3_R1_")){
                if(intPNumber == 4 || intPNumber == 1){
                    strOutcomeQfB = strMessage.substring(5);
                    if(intPNumber == 4){
                        if(strOutcomeQfB.equals("W")){
                            blnWinR1 = false;
                            ssm.sendText("Winner is [P3]");
                            chatArea2.append("Winner is [P3] \n");
                        }else if(strOutcomeQfB.equals("L")){
                            intR2Number = 3;
                            ssm.sendText("Winner is [P4]");
                            chatArea2.append("Winner is [P4] \n");
                        }else if(strOutcomeQfB.equals("T")){
                            ssm.sendText("Tie between [P3] and [P4]");
                            chatArea2.append("Tie between [P3] and [P4] \n");
                        }
                    }else if(intPNumber == 1){
                        if(strOutcomeQfB.equals("W")){
                            intR1MatchesDone++;
                            strWinnerR1b = "3";
                        }else if(strOutcomeQfB.equals("L")){
                            intR1MatchesDone++;
                            strWinnerR1b = "4";
                        }
                        if((intPlayerCount % 2 == 1 && intR1MatchesDone == (intPlayerCount - 1) / 2) || (intPlayerCount % 2 == 0 && intR1MatchesDone == intPlayerCount / 2)){
                            if(intPlayerCount % 2 == 1 && intR1MatchesDone == (intPlayerCount - 1) / 2){
                                ssm.sendText("ROUND_2_START_ODD");
                            }else if(intPlayerCount % 2 == 0 && intR1MatchesDone == intPlayerCount / 2){
                                ssm.sendText("ROUND_2_START_EVEN");
                            }
                            qfPanel.setVisible(false);
                            theFrame.setContentPane(sfPanel);
                            theFrame.pack();
                            blnRound2Start = true;
                            if(intR2Number == 1){
                                Rp1SFButton.setVisible(true);
                                Pp1SFButton.setVisible(true);
                                Cp1SFButton.setVisible(true);
                                Lp1SFButton.setVisible(true);
                                Sp1SFButton.setVisible(true);
                            }
                        }
                    }
                }
            }else if(strMessage.startsWith("4_R1_")){
                if(intPNumber == 3){
                    strChoiceR1bOPP = strMessage.substring(5);
                    strOutcomeQfB = winningMethods.isWinner(strChoiceR1b, strChoiceR1bOPP);
                    if(strOutcomeQfB.equals("W")){
                        intR2Number = 3;
                        ssm.sendText("3_R1_W");
                    }else if(strOutcomeQfB.equals("L")){
                        blnWinR1 = false;
                        ssm.sendText("3_R1_L");
                    }else if(strOutcomeQfB.equals("T")){
                        ssm.sendText("3_R1_T");
                    }
                }
            }else if(strMessage.startsWith("5_R1_")){
                if(intPNumber == 6 || intPNumber == 1){
                    strOutcomeQfC = strMessage.substring(5);
                    if(intPNumber == 6){
                        if(strOutcomeQfC.equals("W")){
                            blnWinR1 = false;
                            ssm.sendText("Winner is [P5]");
                            chatArea2.append("Winner is [P5] \n");
                        }else if(strOutcomeQfC.equals("L")){
                            intR2Number = 5;
                            ssm.sendText("Winner is [P6]");
                            chatArea2.append("Winner is [P6] \n");
                        }else if(strOutcomeQfC.equals("T")){
                            ssm.sendText("Tie between [P5] and [P6]");
                            chatArea2.append("Tie between [P5] and [P6] \n");
                        }
                    }else if(intPNumber == 1){
                        if(strOutcomeQfC.equals("W")){
                            intR1MatchesDone++;
                            strWinnerR1c = "5";
                        }else if(strOutcomeQfC.equals("L")){
                            intR1MatchesDone++;
                            strWinnerR1c = "6";
                        }
                        if((intPlayerCount % 2 == 1 && intR1MatchesDone == (intPlayerCount - 1) / 2) || (intPlayerCount % 2 == 0 && intR1MatchesDone == intPlayerCount / 2)){
                            if(intPlayerCount % 2 == 1 && intR1MatchesDone == (intPlayerCount - 1) / 2){
                                ssm.sendText("ROUND_2_START_ODD");
                            }else if(intPlayerCount % 2 == 0 && intR1MatchesDone == intPlayerCount / 2){
                                ssm.sendText("ROUND_2_START_EVEN");
                            }
                            qfPanel.setVisible(false);
                            theFrame.setContentPane(sfPanel);
                            theFrame.pack();
                            blnRound2Start = true;
                            if(intR2Number == 1){
                                Rp1SFButton.setVisible(true);
                                Pp1SFButton.setVisible(true);
                                Cp1SFButton.setVisible(true);
                                Lp1SFButton.setVisible(true);
                                Sp1SFButton.setVisible(true);
                            }
                        }
                    }
                }
            }else if(strMessage.startsWith("6_R1_")){
                if(intPNumber == 5){
                    strChoiceR1cOPP = strMessage.substring(5);
                    strOutcomeQfC = winningMethods.isWinner(strChoiceR1c, strChoiceR1cOPP);
                    if(strOutcomeQfC.equals("W")){
                        intR2Number = 5;
                        ssm.sendText("5_R1_W");
                    }else if(strOutcomeQfC.equals("L")){
                        blnWinR1 = false;
                        ssm.sendText("5_R1_L");
                    }else if(strOutcomeQfC.equals("T")){
                        ssm.sendText("5_R1_T");
                    }
                }
            }else if(strMessage.startsWith("7_R1_")){
                if(intPNumber == 8 || intPNumber == 1){
                    strOutcomeQfD = strMessage.substring(5);
                    if(intPNumber == 8){
                        if(strOutcomeQfD.equals("W")){
                            blnWinR1 = false;
                            ssm.sendText("Winner is [P7]");
                            chatArea2.append("Winner is [P7] \n");
                        }else if(strOutcomeQfD.equals("L")){
                            intR2Number = 7;
                            ssm.sendText("Winner is [P8]");
                            chatArea2.append("Winner is [P8] \n");
                        }else if(strOutcomeQfD.equals("T")){
                            ssm.sendText("Tie between [P7] and [P8]");
                            chatArea2.append("Tie between [P7] and [P8] \n");
                        }
                    }else if(intPNumber == 1){
                        if(strOutcomeQfD.equals("W")){
                            intR1MatchesDone++;
                            strWinnerR1d = "7";
                        }else if(strOutcomeQfD.equals("L")){
                            intR1MatchesDone++;
                            strWinnerR1d = "8";
                        }
                        if((intPlayerCount % 2 == 1 && intR1MatchesDone == (intPlayerCount - 1) / 2) || (intPlayerCount % 2 == 0 && intR1MatchesDone == intPlayerCount / 2)){
                            if(intPlayerCount % 2 == 1 && intR1MatchesDone == (intPlayerCount - 1) / 2){
                                ssm.sendText("ROUND_2_START_ODD");
                            }else if(intPlayerCount % 2 == 0 && intR1MatchesDone == intPlayerCount / 2){
                                ssm.sendText("ROUND_2_START_EVEN");
                            }
                            qfPanel.setVisible(false);
                            theFrame.setContentPane(sfPanel);
                            theFrame.pack();
                            blnRound2Start = true;
                            if(intR2Number == 1){
                                Rp1SFButton.setVisible(true);
                                Pp1SFButton.setVisible(true);
                                Cp1SFButton.setVisible(true);
                                Lp1SFButton.setVisible(true);
                                Sp1SFButton.setVisible(true);
                            }
                        }
                    }
                }
            }else if(strMessage.startsWith("8_R1_")){
                if(intPNumber == 7){
                    strChoiceR1dOPP = strMessage.substring(5);
                    strOutcomeQfD = winningMethods.isWinner(strChoiceR1d, strChoiceR1dOPP);
                    if(strOutcomeQfD.equals("W")){
                        intR2Number = 7;
                        ssm.sendText("7_R1_W");
                    }else if(strOutcomeQfD.equals("L")){
                        blnWinR1 = false;
                        ssm.sendText("7_R1_L");
                    }else if(strOutcomeQfD.equals("T")){
                        ssm.sendText("7_R1_T");
                    }
                }
            }else if(strMessage.startsWith("1_R2_")){
                if(intR2Number == 3){
                    strOutcomeSfA = strMessage.substring(8);
                    String strR2NumberOPP = strMessage.substring(6,7);
                    if(strOutcomeSfA.equals("W")){
                        blnWinR2 = false;
                        ssm.sendText("Winner is [P" + strR2NumberOPP + "]");
                        chatArea3.append("Winner is [P" + strR2NumberOPP + "] \n");
                    }else if(strOutcomeSfA.equals("L")){
                        intR3Number = 1;
                        ssm.sendText("Winner is [P" + intPNumber + "]");
                        chatArea3.append("Winner is [P" + intPNumber + "] \n");
                    }else if(strOutcomeSfA.equals("T")){
                        ssm.sendText("Tie between [P" + strR2NumberOPP + "] and [P" + intPNumber + "]");
                        chatArea3.append("Tie between [P" + strR2NumberOPP + "] and [P" + intPNumber + "] \n");
                    }
                }
            }else if(strMessage.startsWith("3_R2_")){
                if(intR2Number == 1){
                    strChoiceR2aOPP = strMessage.substring(5);
                    strOutcomeSfA = winningMethods.isWinner(strChoiceR2a, strChoiceR2aOPP);
                    if(strOutcomeSfA.equals("W")){
                        intR3Number = 1;
                        ssm.sendText("1_R2_-" + intPNumber + "-W");
                        //intR2MatchesDone++;
                    }else if(strOutcomeSfA.equals("L")){
                        blnWinR2 = false;
                        ssm.sendText("1_R2_-" + intPNumber + "-L");
                        //intR2MatchesDone++;
                    }else if(strOutcomeSfA.equals("T")){
                        ssm.sendText("1_R2_-" + intPNumber + "-T");
                    }
                }
            }else if(strMessage.startsWith("5_R2_")){
                if(intR2Number == 7){
                    strOutcomeSfA = strMessage.substring(5);
                    String strR2NumberOPP = strMessage.substring(6,7);
                    if(strOutcomeSfA.equals("W")){
                        blnWinR2 = false;
                        ssm.sendText("Winner is [P" + strR2NumberOPP + "]");
                        chatArea3.append("Winner is [P" + strR2NumberOPP + "] \n");
                    }else if(strOutcomeSfA.equals("L")){
                        intR3Number = 5;
                        ssm.sendText("Winner is [P" + intPNumber + "]");
                        chatArea3.append("Winner is [P" + intPNumber + "] \n");
                    }else if(strOutcomeSfA.equals("T")){
                        ssm.sendText("Tie between [P" + strR2NumberOPP + "] and [P" + intPNumber + "]");
                        chatArea3.append("Tie between [P" + strR2NumberOPP + "] and [P" + intPNumber + "] \n");
                    }
                }
            }else if(strMessage.startsWith("7_R2_")){
                if(intR2Number == 5){
                    strChoiceR2bOPP = strMessage.substring(5);
                    strOutcomeSfB = winningMethods.isWinner(strChoiceR2b, strChoiceR2bOPP);
                    if(strOutcomeSfB.equals("W")){
                        intR3Number = 5;
                        ssm.sendText("5_R2_-" + intPNumber + "-W");
                    }else if(strOutcomeSfB.equals("L")){
                        blnWinR2 = false;
                        ssm.sendText("5_R2_-" + intPNumber + "-W");
                    }else if(strOutcomeSfB.equals("T")){
                        ssm.sendText("5_R2_-" + intPNumber + "-W");
                    }
                }
            }else{
                if(blnRound1Start == false && blnRound2Start == false && blnRound3Start == false){
                    chatArea.append(strMessage + "\n");
                }else if(blnRound1Start == true && blnRound2Start == false && blnRound3Start == false){
                    chatArea2.append(strMessage + "\n");
                }else if(blnRound1Start == true && blnRound2Start == true && blnRound3Start == false){
                    chatArea3.append(strMessage + "\n");
                }else if(blnRound1Start == true && blnRound2Start == true && blnRound3Start == true){
                    chatArea4.append(strMessage + "\n");
                }
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
        }else if(evt.getSource() == Rp1QFButton || evt.getSource() == Pp1QFButton || evt.getSource() == Cp1QFButton || evt.getSource() == Lp1QFButton || evt.getSource() == Sp1QFButton){
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
            chatArea2.append("[P1] chose " + strChoiceR1a + "\n");
            ssm.sendText("[P1] chose " + strChoiceR1a);
        }else if(evt.getSource() == Rp2QFButton || evt.getSource() == Pp2QFButton || evt.getSource() == Cp2QFButton || evt.getSource() == Lp2QFButton || evt.getSource() == Sp2QFButton){
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
            chatArea2.append("[P2] chose " + strChoiceR1aOPP + "\n");
            ssm.sendText("[P2] chose " + strChoiceR1aOPP);
            ssm.sendText("2_R1_" + strChoiceR1aOPP);
        }else if(evt.getSource() == Rp3QFButton || evt.getSource() == Pp3QFButton || evt.getSource() == Cp3QFButton || evt.getSource() == Lp3QFButton || evt.getSource() == Sp3QFButton){
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
            chatArea2.append("[P3] chose " + strChoiceR1b + "\n");
            ssm.sendText("[P3] chose " + strChoiceR1b);
        }else if(evt.getSource() == Rp4QFButton || evt.getSource() == Pp4QFButton || evt.getSource() == Cp4QFButton || evt.getSource() == Lp4QFButton || evt.getSource() == Sp4QFButton){
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
            chatArea2.append("[P4] chose " + strChoiceR1bOPP + "\n");
            ssm.sendText("[P4] chose " + strChoiceR1bOPP);
            ssm.sendText("4_R1_" + strChoiceR1bOPP);
        }else if(evt.getSource() == Rp5QFButton || evt.getSource() == Pp5QFButton || evt.getSource() == Cp5QFButton || evt.getSource() == Lp5QFButton || evt.getSource() == Sp5QFButton){
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
            chatArea2.append("[P5] chose " + strChoiceR1c + "\n");
            ssm.sendText("[P5] chose " + strChoiceR1c);
        }else if(evt.getSource() == Rp6QFButton || evt.getSource() == Pp6QFButton || evt.getSource() == Cp6QFButton || evt.getSource() == Lp6QFButton || evt.getSource() == Sp6QFButton){
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
            chatArea2.append("[P6] chose " + strChoiceR1cOPP + "\n");
            ssm.sendText("[P6] chose " + strChoiceR1cOPP);
            ssm.sendText("6_R1_" + strChoiceR1cOPP);
        }else if(evt.getSource() == Rp7QFButton || evt.getSource() == Pp7QFButton || evt.getSource() == Cp7QFButton || evt.getSource() == Lp7QFButton || evt.getSource() == Sp7QFButton){
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
            chatArea2.append("[P7] chose " + strChoiceR1d + "\n");
            ssm.sendText("[P7] chose " + strChoiceR1d);
        }else if(evt.getSource() == Rp8QFButton || evt.getSource() == Pp8QFButton || evt.getSource() == Cp8QFButton || evt.getSource() == Lp8QFButton || evt.getSource() == Sp8QFButton){
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
            chatArea2.append("[P8] chose " + strChoiceR1dOPP + "\n");
            ssm.sendText("[P8] chose " + strChoiceR1dOPP);
            ssm.sendText("8_R1_" + strChoiceR1dOPP);
        }else if(evt.getSource() == Rp1SFButton || evt.getSource() == Pp1SFButton || evt.getSource() == Cp1SFButton || evt.getSource() == Lp1SFButton || evt.getSource() == Sp1SFButton){
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
            chatArea3.append("[P" + intPNumber + "] chose " + strChoiceR2a + "\n");
            ssm.sendText("[P" + intPNumber + "] chose " + strChoiceR2a);
        }else if(evt.getSource() == Rp3SFButton || evt.getSource() == Pp3SFButton || evt.getSource() == Cp3SFButton || evt.getSource() == Lp3SFButton || evt.getSource() == Sp3SFButton){
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
            chatArea3.append("[P" + intPNumber + "] chose " + strChoiceR2aOPP + "\n");
            ssm.sendText("[P" + intPNumber + "] chose " + strChoiceR2aOPP);
            ssm.sendText("3_R2_" + strChoiceR2aOPP);
        }else if(evt.getSource() == Rp5SFButton || evt.getSource() == Pp5SFButton || evt.getSource() == Cp5SFButton || evt.getSource() == Lp5SFButton || evt.getSource() == Sp5SFButton){
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
            chatArea3.append("[P" + intPNumber + "] chose " + strChoiceR2b + "\n");
            ssm.sendText("[P" + intPNumber + "] chose " + strChoiceR2b);
        }else if(evt.getSource() == Rp7SFButton || evt.getSource() == Pp7SFButton || evt.getSource() == Cp7SFButton || evt.getSource() == Lp7SFButton || evt.getSource() == Sp7SFButton){
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
            chatArea3.append("[P" + intPNumber + "] chose " + strChoiceR2bOPP + "\n");
            ssm.sendText("[P" + intPNumber + "] chose " + strChoiceR2bOPP);
            ssm.sendText("7_R2_" + strChoiceR2aOPP);
        }
    }
    // Constructor
    public RPSGame(){
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
        sfPanel.add(tempButton2);
        tempButton2.setSize(200,100);
        tempButton2.setLocation(900, 300);
        tempButton2.addActionListener(this);

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
    }

    // Main Method
    public static void main(String[] args){
        new RPSGame();
    }
}
