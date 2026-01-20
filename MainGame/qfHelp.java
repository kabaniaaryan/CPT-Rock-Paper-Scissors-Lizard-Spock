import java.io.IOException;
import java.io.InputStream;
import javax.swing.JPanel;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class qfHelp extends JPanel{
    // Properties
    BufferedImage qfHelp;

    // Methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(qfHelp, 0, 0, null);
    }

    // Constructor
    public qfHelp(){
        super();
        InputStream imageStream = null;
        imageStream = this.getClass().getResourceAsStream("qfHelp.png");
        try{
            qfHelp = ImageIO.read(imageStream);
        }catch(IOException e){
            System.out.println("Error loading image");
        }
    }
}
