

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.swing.border.LineBorder;


public class NumberPanel extends JPanel {



    public NumberPanel() {


        //NumberPanel layout and background color
        setLayout(new GridLayout(5, 4));
        setBackground(Color. BLACK);


        //Number buttons: Creation
        JButton button0 = new JButton("0");
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");


        //Operation - and result buttons: Creation & lambda style ActionListeners
        JButton additionButton = new JButton("+");
        additionButton.addActionListener(e -> RunApplication.resultPanel.display.setText(RunApplication.resultPanel.display.getText() + " + "));

        JButton subtractionButton = new JButton("-");
        subtractionButton.addActionListener(e -> RunApplication.resultPanel.display.setText(RunApplication.resultPanel.display.getText() + " - "));

        JButton divisionButton = new JButton("÷");
        divisionButton.addActionListener(e -> RunApplication.resultPanel.display.setText(RunApplication.resultPanel.display.getText() + " / "));

        JButton multiplicationButton = new JButton("x");
        multiplicationButton.addActionListener(e -> RunApplication.resultPanel.display.setText(RunApplication.resultPanel.display.getText() + " * "));

        JButton equalsButton = new JButton("=");
        equalsButton.addActionListener(new ShowResult());

        JButton clearButton = new JButton("CE");
        clearButton.addActionListener(e -> RunApplication.resultPanel.display.setText(""));

        JButton openParanButton = new JButton("(");
        openParanButton.addActionListener(e -> RunApplication.resultPanel.display.setText(RunApplication.resultPanel.display.getText() + " ("));

        JButton closeParanButton = new JButton(")");
        closeParanButton.addActionListener(e -> RunApplication.resultPanel.display.setText(RunApplication.resultPanel.display.getText() + ") "));


        //Adding all buttons to an Array for styling automation
        JButton[] buttonArray = new JButton[] {button0, button1, button2, button3, button4, button5, button6, button7, button8,
                                                                          button9, additionButton, subtractionButton, divisionButton,
                                                                           multiplicationButton, equalsButton, clearButton, openParanButton, closeParanButton};


        //Loop styles all buttons to look the same and adds them to the NumberPanel
        for(JButton button : buttonArray) {
            button.setFont(new Font("Verdana", Font.BOLD, 20));
            button.setBackground(Color.BLACK);
            button.setForeground(Color.WHITE);
            button.setBorder(new LineBorder(Color.GRAY));
            setPreferredSize(new Dimension(20, 65));
            add(button);
        }


        //Loop adds the same behavioral* ActionListener to all number buttons (*same behavior but different output since the buttons are numbers 1-9)
        for(int a = 0; a <= 10; a++) {
            buttonArray[a].addActionListener(new NumberButtonText(a));
        }


    }



    //ActionListener class that helps create the same behavioral* ActionListeners to the number buttons with button-specific output 1-9
    class NumberButtonText implements ActionListener
    {
        int number;

        NumberButtonText(int number)
        {
            this.number = number;
        }

        public void actionPerformed(ActionEvent e)
        {

            RunApplication.resultPanel.display.setText(RunApplication.resultPanel.display.getText() + number);

        }

    }

    //ActionListener class that displays the string-interpreted result in the ResultPanel.display
    class ShowResult implements ActionListener {

        Object evaluatedResult;

        //Method actionPerformed displays the result and is needed as this class implements ActionListener and
        public void actionPerformed(ActionEvent e) {

            if (!RunApplication.resultPanel.display.getText().equals("")) {

                try {
                    evaluatedResult = evaluateResult();
                    RunApplication.resultPanel.display.setText(String.valueOf("= " + evaluatedResult));
                }

                catch (ScriptException ex) { }

            }

        }

        //Method evaluateResult returns evaluated calculation result as instance of Object
        public Object evaluateResult() throws ScriptException {

            ScriptEngineManager script = new ScriptEngineManager();
            ScriptEngine eng = script.getEngineByName("JavaScript");
            return eng.eval(RunApplication.resultPanel.display.getText());

        }


    }

}
