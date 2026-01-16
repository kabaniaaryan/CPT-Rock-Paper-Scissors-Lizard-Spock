package Tests;


public class winningMethodsTests {
   public static String isWinner(String playerA, String playerB) {
       if (playerA.equals(playerB)) {
           return "T";
       }
       switch (playerA) {
           case "ROCK":
               return (playerB.equals("SCISSORS")) ? "W" : "L";
           case "PAPER":
               return (playerB.equals("ROCK")) ? "W" : "L";
           case "SCISSORS":
               return (playerB.equals("PAPER")) ? "W" : "L";
           case "LIZARD":
               return (playerB.equals("SPOCK") || playerB.equals("PAPER")) ? "W" : "L";
           case "SPOCK":
               return (playerB.equals("SCISSORS") || playerB.equals("ROCK")) ? "W" : "L";
           default:
               return "Invalid choice!";
       }
   }
}



