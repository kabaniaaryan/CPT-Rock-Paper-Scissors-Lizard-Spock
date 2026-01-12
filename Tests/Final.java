package Tests;

import java.io.IOException;
import java.io.InputStream;
import javax.swing.JPanel;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.Graphics;
public class Final extends JPanel{
     //Properties
    BufferedImage fImage;

    //Methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fImage, 0, 0, null);
    }

    //Constructor
    public Final(){
        super();
        InputStream imageStream = null;
        imageStream = this.getClass().getResourceAsStream("Finals.png");
        try{
            fImage = ImageIO.read(imageStream);
        }catch(IOException e){
            System.out.println("Error loading image");
        }
    }
}