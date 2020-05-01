import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;


public class Layout extends JFrame  {

  public Layout() throws FileNotFoundException {
       setTitle("Please Enter a Description");
       setSize(950,470);
       setLocation(100,100);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JTextArea field1 = new JTextArea(18,75);

      Container myContainer = this.getContentPane();
      myContainer.setLayout(new BorderLayout(10,10));
      //this.getRootPane().setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.BLACK));

      JPanel desc = new JPanel();
      desc.setBorder(BorderFactory.createEtchedBorder());
      desc.setOpaque(false);
      desc.setLayout(new FlowLayout());
      desc.add(field1);
      myContainer.add(desc, BorderLayout.CENTER);


      JPanel tips = new JPanel();
      ComboBox loc1 = new ComboBox();
      tips.setSize(700, 300);
      tips.add(loc1);
      myContainer.add(tips,BorderLayout.NORTH);

      JPanel enter = new JPanel();
      desc.setLayout(new FlowLayout());
      JButton enterb = new JButton("Enter");
      enterb.setPreferredSize(new Dimension(380,50));
      enter.add(enterb);
      myContainer.add(enter, BorderLayout.SOUTH);
      enterb.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              String desiredLocation = loc1.desiredLocation;
              MapFrame map = new MapFrame(desiredLocation);
              map.setVisible(true);
          }
      });

    }



}
