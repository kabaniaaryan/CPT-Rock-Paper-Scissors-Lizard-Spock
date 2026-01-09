package Tests;

public class Game1v1{
    public static void main(String[] args){
        String strP1Choice;
        String strP2Choice;
        System.out.println("Pick one: Rock, Paper, Scissors, Lizard, Spock");
        strP1Choice = "Rock";
        strP2Choice = "Scissors";
        if(strP1Choice.equals(strP2Choice)){
            System.out.println("TIE");
        }else if(strP1Choice.equals("Rock") && (strP2Choice.equals("Scissors") || strP2Choice.equals("Lizard"))){
            System.out.println("P1 Wins");
        }else if(strP1Choice.equals("Rock") && (strP2Choice.equals("Paper") || strP2Choice.equals("Spock"))){
            System.out.println("P2 Wins");
        }else if(strP1Choice.equals("Paper") && (strP2Choice.equals("Rock") || strP2Choice.equals("Spock"))){
            System.out.println("P1 Wins");
        }else if(strP1Choice.equals("Paper") && (strP2Choice.equals("Scissors")|| strP2Choice.equals("Lizard"))){
            System.out.println("P2 Wins");
        }else if(strP1Choice.equals("Scissors") && (strP2Choice.equals("Paper") || strP2Choice.equals("Lizard"))){
            System.out.println("P1 Wins");
        }else if(strP1Choice.equals("Scissors") && (strP2Choice.equals("Rock") || strP2Choice.equals("Spock"))){
            System.out.println("P2 Wins");
        }else if(strP1Choice.equals("Lizard") && (strP2Choice.equals("Spock") || strP2Choice.equals("Paper"))){
            System.out.println("P1 Wins");
        }else if(strP1Choice.equals("Lizard") && (strP2Choice.equals("Rock") || strP2Choice.equals("Scissors"))){
            System.out.println("P2 Wins");
        }else if(strP1Choice.equals("Spock") && (strP2Choice.equals("Scissors") || strP2Choice.equals("Rock"))){
            System.out.println("P1 Wins");
        }else if(strP1Choice.equals("Spock") && (strP2Choice.equals("Paper") || strP2Choice.equals("Lizard"))){
            System.out.println("P2 Wins");
        }
    }
}