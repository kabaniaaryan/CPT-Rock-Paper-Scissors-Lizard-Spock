package MainGame;

import java.io.IOException;
import java.io.InputStream;
import javax.swing.JPanel;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class fHelp extends JPanel{
    // Properties
    BufferedImage fHelp;

    // Methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fHelp, 0, 0, null);
    }

    // Constructor
    public fHelp(){
        super();
        InputStream imageStream = null;
        imageStream = this.getClass().getResourceAsStream("fHelp.png");
        try{
            fHelp = ImageIO.read(imageStream);
        }catch(IOException e){
            System.out.println("Error loading image");
        }
    }
}
