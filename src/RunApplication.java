


import java.awt.*;
import javax.swing.*;



//The purpose of this class is A) to provide a main method that adds all panels to a master panel and
                                             //B) to run the application
public class RunApplication
{

    static Frame frame;
    static Container contentPane;
    static NumberPanel numberPanel;
    static JPanel displayPanel;
    static ResultPanel resultPanel;



    public static void main(String args[])
    {

        //Create Frame and set Content Pane
        frame = new Frame();
        contentPane = frame.getContentPane();
        contentPane.setBackground(Color.BLACK);


        //Create Master Panel displayPanel with BoxLayout and add to Content Pane
        displayPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(displayPanel, BoxLayout.Y_AXIS);
        displayPanel.setLayout(boxLayout);
        contentPane.add(displayPanel);


        //Create resultPanel & numberPanel and add those to the Master Panel displayPanel
        resultPanel = new ResultPanel();
        displayPanel.add(resultPanel);

        numberPanel = new NumberPanel();
        displayPanel.add(numberPanel);


        //Set resultPanel size
        resultPanel.display.setPreferredSize(new Dimension(400, 200));


        //Pack the frame and set it visible
        frame.pack();
        frame.setVisible(true);


}














}
