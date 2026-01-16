package MainGame;

import java.io.IOException;
import java.io.InputStream;
import javax.swing.JPanel;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class HomePanel extends JPanel{
    // Properties
    BufferedImage HomeImage;

    // Methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(HomeImage, 0, 0, null);
    }

    // Constructor
    public HomePanel(){
        super();
        InputStream imageStream = null;
        imageStream = this.getClass().getResourceAsStream("TheHomeScreen.png");
        try{
            HomeImage = ImageIO.read(imageStream);
        }catch(IOException e){
            System.out.println("Error loading image");
        }
    }
}
