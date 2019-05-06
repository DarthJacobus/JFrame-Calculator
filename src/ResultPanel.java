

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class ResultPanel extends JPanel
{

    public static JTextField display;



    public ResultPanel()
    {

        display = new JTextField("");
        display.setBorder(new LineBorder(Color.GRAY));
        display.setFont(new Font("Verdana", Font.BOLD, 30));
        display.setSelectedTextColor(Color.RED);
        display.setHorizontalAlignment(JTextField.CENTER);
        display.setEditable(false);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        add(display);

    }




}
