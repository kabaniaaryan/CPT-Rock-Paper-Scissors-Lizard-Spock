package MainGame;

import java.io.IOException;
import java.io.InputStream;
import javax.swing.JPanel;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class sfHelp extends JPanel{
    // Properties
    BufferedImage sfHelp;

    // Methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(sfHelp, 0, 0, null);
    }

    // Constructor
    public sfHelp(){
        super();
        InputStream imageStream = null;
        imageStream = this.getClass().getResourceAsStream("sfHelp.png");
        try{
            sfHelp = ImageIO.read(imageStream);
        }catch(IOException e){
            System.out.println("Error loading image");
        }
    }
}
