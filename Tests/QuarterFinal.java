package Tests;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.IOException;
import java.io.InputStream;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class QuarterFinal extends JPanel{
    
    //Properties
    BufferedImage qfImage;
    JFrame theFrame = new JFrame("Quarter Finals");
    JPanel thePanel = new JPanel();


    //Methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(qfImage, 0, 0, null);
    }

    //Constructor
    public QuarterFinal(){
        super();
        InputStream imageStream = null;
        imageStream = this.getClass().getResourceAsStream("Quarters.png");
        try{
            qfImage = ImageIO.read(imageStream);
        }catch(IOException e){
            System.out.println("Error loading image");
        }
    }
}