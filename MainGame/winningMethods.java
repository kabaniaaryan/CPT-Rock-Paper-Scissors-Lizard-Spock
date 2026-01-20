public class winningMethods{
    public static String isWinner(String playerChoice, String opponentChoice){
        if(playerChoice.equals("") && opponentChoice.equals("")){
            return "T";
        }else if(!playerChoice.equals("") && opponentChoice.equals("")){
            return "WX";
        }else if(playerChoice.equals("") && !opponentChoice.equals("")){
            return "LX";
        }else if(playerChoice.equals(opponentChoice)) {
            return "T";
        }
        

        switch(playerChoice){
            case "ROCK":
                return(opponentChoice.equals("SCISSORS") || opponentChoice.equals("LIZARD")) ? "W" : "L";
            case "PAPER":
                return(opponentChoice.equals("ROCK") || opponentChoice.equals("SPOCK")) ? "W" : "L";
            case "SCISSORS":
                return(opponentChoice.equals("PAPER") || opponentChoice.equals("LIZARD")) ? "W" : "L";
            case "LIZARD":
                return(opponentChoice.equals("SPOCK") || opponentChoice.equals("PAPER")) ? "W" : "L";
            case "SPOCK":
                return(opponentChoice.equals("SCISSORS") || opponentChoice.equals("ROCK")) ? "W" : "L";
            default:
                return "ERROR!";
        }
    }
}



