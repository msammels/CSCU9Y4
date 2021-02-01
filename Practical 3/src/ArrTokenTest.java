import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * <p>
 *     <b><u>CSCU9Y4 - Practical 3</u></b>
 *     <br />
 *     <b><u>ArrTokenTest.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 08.02.2021
 */

public class ArrTokenTest extends JFrame implements ActionListener {
    private JTextField txt1 = new JTextField(50);
    private JTextField expression = new JTextField(10);
    private JLabel labd = new JLabel("Regular Expression");
    private JButton reading = new JButton("Split");
    private JTextArea result = new JTextArea(20, 50);

    public static void main(String[] args) {
        ArrTokenTest applic = new ArrTokenTest();
    } // main

    // Set up the layout
    public ArrTokenTest() {
        super("Tokens");
        setLayout(new FlowLayout());

        add(txt1);
        txt1.setEditable(true);

        add(labd);

        add(expression);
        expression.setEditable(true);

        add(reading);
        reading.addActionListener(this);

        add(result);

        setSize(600,500);
        setVisible(true);
    } // Constructor

    // Read a string, apply split and store the result in an array of Strings
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == reading) {
            String s = txt1.getText();
            String delims = expression.getText();
            s = s.replaceAll("X+.*?X+"," ");
            s = s.replaceAll("\\{.*?\\}"," ");
            String[] arrayOfTokens = s.split(delims);

            result.setText("");
            arrayPrint(arrayOfTokens);
        }
    } // actionPerformed

    // Take an array of String and construct a linked list of String from it
    public LinkedList<String> convertArrayToList(String[] stringArray) {
        LinkedList<String> stringList = new LinkedList<String>();

        return stringList;
    } // convertArrayToList


     // {p}rint the list of Strings
     public void iteratedPrintList(java.util.List<String> stringList) {

         for (String temp : stringList) {
             result.append(temp + "\n");
         }

      // Log the results to the terminal
      System.out.println("Input: '" + txt1.getText() + "'");
      System.out.println("Regular Expression: '" + expression.getText() +"'");
      System.out.println("Output (iterator method):\n" + result.getText());

     } // iteratedPrintList

    // Print the array of strings
    public void arrayPrint(String[] stringArray) {
        for (int i = 0; i < stringArray.length && stringArray[i] != null; i++)
            result.append(stringArray[i] + "\n");

        // Log the results to the terminal
        System.out.println("Input: '" + txt1.getText() + "'");
        System.out.println("Regular Expression: '" + expression.getText() +"'");
        System.out.println("Output (array method):\n" + result.getText());
    } // arrayPrint

    // Print the list of strings
    public void listPrint(LinkedList<String> stringList) {
    } // listPrint
} // ArrTokenTest
