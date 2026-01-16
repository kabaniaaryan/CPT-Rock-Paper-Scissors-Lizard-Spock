package Tests;


public class winningMethodsTests {
   public static String isWinner(String playerChoice, String opponentChoice) {
       if (playerChoice.equals(opponentChoice)) {
           return "t";
       }


       switch (playerChoice) {
           case "ROCK":
               return (opponentChoice.equals("SCISSORS")) ? "w" : "l";
           case "PAPER":
               return (opponentChoice.equals("ROCK")) ? "w" : "l";
           case "SCISSORS":
               return (opponentChoice.equals("PAPER")) ? "w" : "l";
           case "LIZARD":
               return (opponentChoice.equals("SPOCK") || opponentChoice.equals("PAPER")) ? "w" : "l";
           case "SPOCK":
               return (opponentChoice.equals("SCISSORS") || opponentChoice.equals("ROCK")) ? "w" : "l";
           default:
               return "Invalid choice!";
       }
   }
}



