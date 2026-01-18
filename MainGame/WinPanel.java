package MainGame;

import java.io.IOException;
import java.io.InputStream;
import javax.swing.JPanel;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class WinPanel extends JPanel{
    // Properties
    BufferedImage WinImage;

    // Methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(WinImage, 0, 0, null);
    }

    // Constructor
    public WinPanel(){
        super();
        InputStream imageStream = null;
        imageStream = this.getClass().getResourceAsStream("TheWinScreen.png");
        try{
            WinImage = ImageIO.read(imageStream);
        }catch(IOException e){
            System.out.println("Error loading image");
        }
    }
}
