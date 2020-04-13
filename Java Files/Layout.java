import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Layout extends JFrame  {
    JButton back;
    JButton next;


    public static void main(String[] args) {
        Layout mylayout = new Layout();
        mylayout.setVisible(true);
    }

  public Layout(){
       setTitle("Please Enter a Description");
       setSize(400,470);
       setLocation(100,100);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      back = new JButton("Back");
      next = new JButton("Next");
      JTextArea field1 = new JTextArea(18,32);
      //field1.setSize(300,200);

      Container myContainer = this.getContentPane();
      myContainer.setLayout(new BorderLayout(10,10));
      this.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.CYAN));

      JPanel desc = new JPanel();
      desc.setBorder(new LineBorder(Color.BLACK, 3));
      desc.setLayout(new FlowLayout());
      desc.add(field1);
      myContainer.add(desc, BorderLayout.NORTH);


      JPanel tips = new JPanel();
      ComboBox tiplist = new ComboBox();
      tips.setBorder(new LineBorder(Color.BLACK, 3));
      tips.setLayout(new FlowLayout());
      tips.add(tiplist);
      myContainer.add(tips,BorderLayout.CENTER);

      JPanel enter = new JPanel();
      desc.setBorder(new LineBorder(Color.BLACK, 3));
      desc.setLayout(new FlowLayout());
      JButton enterb = new JButton("Enter");
      enterb.setPreferredSize(new Dimension(380,50));
      enter.add(enterb);
      myContainer.add(enter, BorderLayout.SOUTH);
      enterb.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              MapFrame map = new MapFrame();
              map.setVisible(true);
          }
      });

    }



}
