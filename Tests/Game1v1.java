package Tests;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Game1v1{
    public static void main(String[] args){
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
        String strP1Choice;
        String strP2Choice;
        System.out.println("P1, Pick one: Rock, Paper, Scissors, Lizard, Spock");
        try{
            strP1Choice = kb.readLine();
        }catch(Exception e){
            System.out.println("Error");
            strP1Choice = null;
        }
        System.out.println("P2, Pick one: Rock, Paper, Scissors, Lizard, Spock");
        try{
            strP2Choice = kb.readLine();
        }catch(Exception e){
            System.out.println("Error");
            strP2Choice = null;
        }

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
        }else if(strP1Choice == null && strP2Choice != null){
            System.out.println("P1 chose nothing, P2 Wins");
        }else if(strP2Choice == null && strP1Choice != null){
            System.out.println("P2 chose nothing, P1 Wins");
        }else{
            System.out.println("Both players chose nothing, TIE");
        }

        }
    }
}