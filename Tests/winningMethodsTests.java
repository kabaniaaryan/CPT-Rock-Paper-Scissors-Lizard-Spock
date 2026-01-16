package Tests;


public class winningMethodsTests {
   public static String isWinner(String playerA, String playerB) {
       if (playerA.equals(playerB)) {
           return "t";
       }
       switch (playerA) {
           case "ROCK":
               return (playerB.equals("SCISSORS")) ? "w" : "l";
           case "PAPER":
               return (playerB.equals("ROCK")) ? "w" : "l";
           case "SCISSORS":
               return (playerB.equals("PAPER")) ? "w" : "l";
           case "LIZARD":
               return (playerB.equals("SPOCK") || playerB.equals("PAPER")) ? "w" : "l";
           case "SPOCK":
               return (playerB.equals("SCISSORS") || playerB.equals("ROCK")) ? "w" : "l";
           default:
               return "Invalid choice!";
       }
   }
}



