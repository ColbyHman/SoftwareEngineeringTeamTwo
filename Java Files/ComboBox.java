import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class ComboBox extends JPanel implements ActionListener {

    MapGenerator locationGenerator = new MapGenerator();
    String[] tips = {"Suspicious Person", "Crime", "Parking", "General"};
    String[] temp = {"Suspicious Activity", "Power Outage", "Severe Weather", "Early Closing", "Two Hour Delay", "Parking Lot Closure", "Timely Notification"};

    HashMap locations = locationGenerator.generateLocationList();
    String[] location_list = (String[]) this.locations.keySet().toArray(new String[this.locations.keySet().size()]);
    JComboBox tiplist = new JComboBox(tips);
    JComboBox loc1 = new JComboBox(location_list);
    JComboBox template = new JComboBox(temp);
    String desiredLocation = "";
    String desiredTemplate = "";
    JLabel temptext = new JLabel("Template");
    JLabel crimetext = new JLabel("Crime Location");
    JLabel safety = new JLabel("Safety Tip");

    public ComboBox() throws FileNotFoundException {

        setLayout(new FlowLayout());
        setSize(400, 200);

        tiplist.setBounds(300, 100, 100, 50);
        tiplist.setSelectedIndex(1);
        tiplist.addActionListener(this);
        loc1.setBounds(100, 100, 50, 50);
        loc1.setSelectedIndex(1);
        loc1.addActionListener(this);
        template.addActionListener(this);
        template.setSelectedIndex(1);
        add(temptext);
        add(template);
        add(crimetext);
        add(loc1);
        add(safety);
        add(tiplist);


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loc1) {
            JComboBox c = (JComboBox) e.getSource();
            this.desiredLocation = c.getSelectedItem().toString();
            System.out.println("Selected : "+this.desiredLocation);
        }
        else if (e.getSource() == template) {
            JComboBox c = (JComboBox) e.getSource();
            this.desiredTemplate = (String) c.getSelectedItem();
            System.out.println("Selected :"+this.desiredTemplate);
        }
        else if (e.getSource() == tiplist) {
            JComboBox c = (JComboBox) e.getSource();
            String tip = (String) c.getSelectedItem();
            System.out.println("Selected :"+tip);
        }
    }








//        if (e.getSource() == tiplist) {
//            JComboBox c = (JComboBox) e.getSource();
//            String message = (String) c.getSelectedItem();
//            switch (message) {
//                case "Suspicious":
//                    text.setText("If anyone has seen anything or has any information regarding this incident, please call Bethlehem PD at 610-746-1555. Remember to always be alert and vigilant and report anything suspicious. More information will be passed on as we are updated.");
//                    break;
//                case "Tip 2":
//                    text.setText("You have selected tip 2");
//                    break;
//                case "Tip 3":
//                    text.setText("You have selected tip 3");
//                    break;
//                default:
//                    text.setText("Whoops: There seems to be an error");
//            }
//        }

}
