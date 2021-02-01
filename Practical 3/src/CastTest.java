import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;

/**
 * <p>
 *     <b><u>CSCU9Y4 - Practical 3</u></b>
 *     <br />
 *     <b><u>Cast.java</u></b>
 * </p>
 *
 * @author Michael Sammels
 * @version 08.02.2021
 */

public class CastTest extends JFrame implements ActionListener {
    private JButton reading = new JButton("Do it");
    private JTextArea result = new JTextArea(20, 50);
    private boolean OK = false;

    public static void main(String[] args) {
        CastTest applic = new CastTest();
    } // main

    // Set up a basic layout
    public CastTest() {
        super("Playing with Lists and Casts");
        setLayout(new FlowLayout());

        add(reading);
        reading.addActionListener(this);

        add(result);

        setSize(600,500);
        setVisible(true);
    } // Constructor

    // When the button is pressed, do this rather pointless sequence of actions
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == reading) {
            LinkedList a = new LinkedList();
            a.add("Bill");
            a.add("Ben");
            String s = (String) a.get(1);               // step 3a - uncomment this line only first
            s = (String) a.get(1);
            a.add(42);
            Integer i = (Integer) a.get(2);    // step 3b
            a.set(2, (Integer) a.get(2)+1);    // step 3c - what happens if you delete the cast?
            
            result.append("First element " + a.get(0) + "\n");
            result.append("Second element " + a.get(1) + "\n");
            result.append("Third element " + a.get(2) + "\n");

            a.set(2,"George");    // step 3e
            Integer j = (Integer) a.get(0);  // step 3d - uncomment these lines in turn
            String t = (String) a.get(2);  // step 3d
        }
    } // actionPerformed
} // CastTest
