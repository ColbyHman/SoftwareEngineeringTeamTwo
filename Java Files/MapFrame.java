import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MapFrame extends JFrame {

    private BufferedImage image;

    JTextArea fieldd = new JTextArea();
    JTextArea field2 = new JTextArea();




    public void appendText(String text) {
        fieldd.append(text);
    }
    public void appendTemplate(String text) {
        field2.append(text);
    }

    public MapFrame(String location) {

        MapsTest mapsTest = new MapsTest();
        try {
            mapsTest.createImage(location);
            image = ImageIO.read(new File("/Users/mecia@moravian.edu/Documents/DropDown/src/image.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("Email Template");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel desc = new JPanel();
        desc.setBorder(BorderFactory.createEtchedBorder());
        //desc.setSize(50,100);
        //desc.setLocation(900,50);
        desc.setOpaque(false);
        //desc.setLayout(new BoxLayout(desc, BoxLayout.PAGE_AXIS));
        desc.add(fieldd);
        desc.add(field2);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(true);
        panel.add(desc);
        JLabel pictureLabel = new JLabel(new ImageIcon(image));
        panel.add(pictureLabel);
        JTextArea textArea = new JTextArea(15, 50);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setFont(Font.getFont(Font.SANS_SERIF));
        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        JPanel inputpanel = new JPanel();
        inputpanel.setLayout(new FlowLayout());
        DefaultCaret caret = (DefaultCaret) textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        panel.add(scroller);
        panel.add(inputpanel);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
