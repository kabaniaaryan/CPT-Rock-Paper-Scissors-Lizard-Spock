package MainGame;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class trackingWins {
   public static void Outcome(String strResult){
       PrintWriter winFile = null;
       try{
           winFile = new PrintWriter(new FileWriter("winTracker.txt", true));
       }catch(IOException e){
           System.out.println(e.toString());
       }
       winFile.println(strResult);
       winFile.close();
   }
}




