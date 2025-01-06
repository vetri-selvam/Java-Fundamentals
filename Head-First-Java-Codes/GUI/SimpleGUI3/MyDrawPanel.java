import java.awt.*;
import java.util.Random;
import javax.swing.JPanel;

public class MyDrawPanel extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        // cast g (Graphics type) into it's subclass type Graphics2D
        Graphics2D g2d = (Graphics2D) g;
        
        // Generate three random numbers using Random objectand set 
        // to red, green, blue.
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        
        // create a color startColoe object with by passing RGB (Red Green Blue)
        Color startColor = new Color(red, green, blue);
        
        // repeat again for endColor
        red = random.nextInt(256);
        green = random.nextInt(256);
        blue = random.nextInt(256);
        Color endColor = new Color(red, green, blue);
        
        // Create GradientPaint object
        GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
        // set GradientPaint object with Graphics2D ref. variable
        g2d.setPaint(gradient);
        g2d.fillOval(70, 70, 100, 100);
    }
}
