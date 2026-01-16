package MainGame;


public class winningMethods {
   public static String isWinner(String playerChoice, String opponentChoice) {
       if (playerChoice.equals(opponentChoice)) {
           return "T";
       }


       switch (playerChoice) {
           case "ROCK":
               return (opponentChoice.equals("SCISSORS")) ? "W" : "L";
           case "PAPER":
               return (opponentChoice.equals("ROCK")) ? "W" : "L";
           case "SCISSORS":
               return (opponentChoice.equals("PAPER")) ? "W" : "L";
           case "LIZARD":
               return (opponentChoice.equals("SPOCK") || opponentChoice.equals("PAPER")) ? "W" : "L";
           case "SPOCK":
               return (opponentChoice.equals("SCISSORS") || opponentChoice.equals("ROCK")) ? "W" : "L";
           default:
               return "Invalid choice!";
       }
   }
}



