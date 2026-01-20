import javax.swing.JPanel;
import java.io.IOException;
import java.io.InputStream;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class SemiPanel extends JPanel{
    //Properties
    BufferedImage sfImage;

    //Methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(sfImage, 0, 0, null);
    }

    //Constructor
    public SemiPanel(){
        super();
        InputStream imageStream = null;
        imageStream = this.getClass().getResourceAsStream("SemiFinals.png");
        try{
            sfImage = ImageIO.read(imageStream);
        }catch(IOException e){
            System.out.println("Error loading image");
        }
    }
}
