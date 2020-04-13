import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBox extends JPanel implements ActionListener {

    String[] tips = {"Tip 1", "Tip 2", "Tip 3"};
    JComboBox tiplist = new JComboBox(tips);
    JLabel text = new JLabel();

    public ComboBox() {
        setLayout(new FlowLayout());
        setSize(400, 200);
        JTextField field1 = new JTextField("");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Field 1:"));
        panel.add(field1);

        tiplist.setBounds(300, 100, 100, 50);
        tiplist.setSelectedIndex(1);
        tiplist.addActionListener(this);
        add(tiplist);
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
