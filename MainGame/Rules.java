import java.io.IOException;
import java.io.InputStream;
import javax.swing.JPanel;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class Rules extends JPanel{
    // Properties
    BufferedImage rules;

    // Methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(rules, 0, 0, null);
    }

    // Constructor
    public Rules(){
        super();
        InputStream imageStream = null;
        imageStream = this.getClass().getResourceAsStream("Rules.png");
        try{
            rules = ImageIO.read(imageStream);
        }catch(IOException e){
            System.out.println("Error loading image");
        }
    }
}
