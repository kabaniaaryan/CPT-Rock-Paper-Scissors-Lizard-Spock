import javax.swing.JPanel;
import java.io.IOException;
import java.io.InputStream;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class QuarterPanel extends JPanel{
    //Properties
    BufferedImage qfImage;

    //Methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(qfImage, 0, 0, null);
    }

    //Constructor
    public QuarterPanel(){
        super();
        InputStream imageStream = null;
        imageStream = this.getClass().getResourceAsStream("QuarterFinals.png");
        try{
            qfImage = ImageIO.read(imageStream);
        }catch(IOException e){
            System.out.println("Error loading image");
        }
    }
}
