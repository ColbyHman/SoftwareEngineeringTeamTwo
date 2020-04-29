import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class ComboBox extends JPanel implements ActionListener {

    MapsTest locationGenerator = new MapsTest();
    String[] tips = {"Tip 1", "Tip 2", "Tip 3"};
    String[] locs = {"Colonial Hall", "Comenius Hall", "Monocacy Hall", "Memorial Hall" , "Zinzendorf Hall","Hamiliton Hall", "Steel Field Equipment", "Steel Field Stadium including dugouts", "Steel Field Locker Bldg (Field Houses)", "Johnston Hall", "Rau Hassler Halls", "Bernhardt Wihelm Halls", "Haupert Union Building (HUB)", "1206 Main St.", "1305-07 Main St.", "1423-25 Iron St.", "120 West Greenwich St.", "1202 Main St.", "Reeves Library", "1118 Main St.", "Collier Hall of Science", "Jo Smith Hall", "Bahnson Center", "Beck Hall", "de Schweinitz House", "1412 Cortland St.", "248 West Greenwich St.", "1407-09 Iron St.", "Lenox House", "Alumni House", "Administrative Office", "Lenape House", "Burnside House", "Antes House", "Forks St.Garage", "Garage (2 car)", "1409 Bushkill Dr. (Storage)", "Anna Nitschmann House", "August Spangenburg House", "Breidegam Field House", "Campus Safety", "1309 Main St.", "1319 Main St.", "Hillside I", "Hillside II", "Hillside III", "Hillside IV", "Hillside V (Health Center)", "Hillside VI", "1434 Cortland St.", "1433 Cortland St.", "PP Hurd Academic Complex", "FMP&C Office Building", "Main Hall", "West Hall", "1848 Chapel & 1867 Chapel", "South Hall","Foy Concert Hall", "Clewell Hall", "Arts - Payne Gallery", "Single Brethrens' House", "Day House", "Frueauff House", "Widows House ", "1418-28 Cortland St.", "1028 Geissinger St.", "216 West Frankford St.", "249 West Greenwich St.", "251 West Greenwich St.", "257 West Greenwich St.", "1313 Iron St.", "1425 Iron St. Garage (2 car)", "1140 Main St.", "1300 Main St.", "1021 Monocacy St.", "1023 Monocacy St,", "1025 Monocacy St.", "1027 Monocacy St.", "214 West Frankford St.", "263 West Greenwich St.", "141 West Laurel St.","255 West Greenwich St.", "130 West Greenwich St.", "227 West Greenwich St.", "1457 Iron St.", "1414 Cortland St.","225 West Greenwich St.", "1315 Iron St.", "1417 Iron St.", "1416-1418 Monocacy St.", "128 West Greenwich St.", "223 West Greenwich St.", "127 West Laurel St.", "230 West Elizabeth Ave", "131 West Laurel St.", "135 West Laurel St.", "137 West Laurel St.", "1409 Monocacy St.", "253 West Greenwich St,", "228 West Elizabeth Ave.", "259 West Greenwich St.", "118 West Greenwich St.", "139 West Laurel St.", "HILL 370 Main St.  MCHI Owned by College", "Benigna Hall (Comeius Center)", "Breidgam Field House Fitness Center", "1136 Main St.", "1138 Main St.", "136 West Fairview St", "Sports Medicine", "125 W. Laurel St.", "Science Center", "116 W. Greenwich St.", "(423-425 Heckewelder Place)", "436 Main St.", "444 Main St.", "1019 Monocacy St.", "261 West Greenwich St ", "113-115 West Greenwich St."};

    HashMap locations = locationGenerator.generateLocationList();
    String[] location_list = (String[]) this.locations.keySet().toArray(new String[this.locations.keySet().size()]);
    JComboBox tiplist = new JComboBox(tips);
    JComboBox loc1 = new JComboBox(location_list);
    JLabel text = new JLabel();

    public ComboBox() throws FileNotFoundException {

        setLayout(new FlowLayout());
        setSize(400, 200);
        JTextField field1 = new JTextField("");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Crime Location"));
        panel.add(field1);

        tiplist.setBounds(300, 100, 100, 50);
        tiplist.setSelectedIndex(1);
        tiplist.addActionListener(this);
        loc1.setBounds(100, 100, 50, 50);
        loc1.setSelectedIndex(1);
        add(loc1);
        //add(tiplist);
        add(text);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tiplist) {
            JComboBox c = (JComboBox) e.getSource();
            String message = (String) c.getSelectedItem();
            switch (message) {
                case "Tip 1":
                    text.setText("You have selected tip 1");
                    break;
                case "Tip 2":
                    text.setText("You have selected tip 2");
                    break;
                case "Tip 3":
                    text.setText("You have selected tip 3");
                    break;
                default:
                    text.setText("Whoops: There seems to be an error");
            }
        }
    }
}
