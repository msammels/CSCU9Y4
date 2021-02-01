import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *     <b><u>CSCU9Y4 - Practical 2</u></b>
 *     <br />
 *     <b><u>ExtendedTokenTest.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 03.02.2021
 */

public class ExtendedListTokenTest extends JFrame implements ActionListener {
    private JTextField txt1 = new JTextField(50);
    private JTextField expression = new JTextField(10);
    private JButton reading = new JButton("Split");
    private JTextArea result = new JTextArea(20, 50);

    public static void main(String[] args) {
        ArrTokenTest applic = new ArrTokenTest();
    } // main

    // Set up the layout
    public ExtendedListTokenTest() {
        super("Tokens");
        setLayout(new FlowLayout());
        add(txt1);
        txt1.setEditable(true);

        JLabel labd = new JLabel("Regular Expression");
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
            String[] arrayOfTokens = s.split(delims);

            result.setText("");
            arrayPrint(arrayOfTokens);
            java.util.List<String> listOfTokens = convertArrayToList(arrayOfTokens);

            listOfTokens.remove(0);
            listPrint(listOfTokens);
            iteratedPrintList(listOfTokens);
        }
    } // actionPerformed

    // Take an array of String and construct a linked list of String from it
    public java.util.List<String> convertArrayToList(String[] stringArray) {

        return new LinkedList<>(Arrays.asList(stringArray));
    } // convertArrayToList

    // Print the list of Strings
    public void iteratedPrintList(java.util.List<String> stringList) {
        Iterator<String> iter = stringList.iterator();
        System.out.println("Size of stringList:\t"+stringList.size());

        while (iter.hasNext()) {
            String temp = iter.next();
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
    public void listPrint(List<String> stringList) {
        System.out.println("----List Print----");
        for (int i = 0; i < stringList.size() && stringList.get(i) != null; i++) {
            result.append(stringList.get(i)+"\n");
        }

        System.out.println("Input: '" + txt1.getText() + "'");
        System.out.println("Regular Expression: '" + expression.getText() +"'");
        System.out.println("Output (array method):\n" + result.getText());
    } // listPrint
} // ArrTokenTest
