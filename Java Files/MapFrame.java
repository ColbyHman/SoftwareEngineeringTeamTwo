import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MapFrame extends JFrame {

    private BufferedImage image;

    JTextArea field1 = new JTextArea();
    JTextArea field2 = new JTextArea();
    
    public void appendText(String text) {
        field1.append(text);
    }
    public void appendTemplate(String text) {
        field2.append(text);
    }

    public MapFrame(String location) {

        MapGenerator mapsTest = new MapGenerator();
        try {
            mapsTest.createImage(location);
            image = ImageIO.read(new File("resources/image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("Email Template");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel desc = new JPanel();
        desc.setBorder(BorderFactory.createEtchedBorder());

        desc.setOpaque(true);
        desc.setLayout(new BoxLayout(desc, BoxLayout.PAGE_AXIS));
        desc.add(field1);
        desc.add(field2);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        panel.setOpaque(true);
        panel.add(desc);
        JLabel pictureLabel = new JLabel(new ImageIcon(image));
        panel.add(pictureLabel);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
