import javax.swing.*;
import java.awt.event.*;

/**
 * NOTE: You wouldn't usually make your main GUI class 
 * implement ActionListener like this; this is just the simplest way 
 * to get started.
 */
public class SimpleGUI2 implements ActionListener { 
// the above class declaration says " an instance of SimpleGUI2 IS-A ActionLister"
    private JButton button;

    public static void main(String[] args) {
        // create a SimpleGUI2 instance
        SimpleGUI2 gui = new SimpleGUI2();
        gui.go();
        
    }
    public void go(){
        // create a frame
        JFrame frame = new JFrame();
        //create a button object and assign it to `button` reference variable
        button = new JButton("click me");

        /**
         * Register your interest with the button. This says to the button, 
         * “Add me to your list of listeners.” The argument you pass MUST be
         *  an object from a class that implements ActionListener!!
         */
        button.addActionListener(this);  // "this" is the object of SimpleGUI2
        
        // add button to the frame's contentPane
        frame.getContentPane().add(button);
        // make the window closable 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    // THE actionPerformed method
    // we MUST implement this method that is in ActionListener Interface.
    /**
     * The button calls this method to let you know an event happened. 
     * It sends you an ActionEvent object as the  argument.
     */
    @Override //  from ActionLister interface
    public void actionPerformed(ActionEvent e) {
        button.setText("I've been clicked!");
    }
}
