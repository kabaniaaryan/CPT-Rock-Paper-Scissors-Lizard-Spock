package MainGame;


public class winningMethods {
   public static String isWinner(String playerChoice, String opponentChoice) {
       if (playerChoice.equals(opponentChoice)) {
           return "t";
       }


       switch (playerChoice) {
           case "Rock":
               return (opponentChoice.equals("Scissors")) ? "w" : "l";
           case "Paper":
               return (opponentChoice.equals("Rock")) ? "w" : "l";
           case "Scissors":
               return (opponentChoice.equals("Paper")) ? "w" : "l";
           case "Lizard":
               return (opponentChoice.equals("Spock") || opponentChoice.equals("Paper")) ? "w" : "l";
           case "Spock":
               return (opponentChoice.equals("Scissors") || opponentChoice.equals("Rock")) ? "w" : "l";
           default:
               return "Invalid choice!";
       }
   }
}



