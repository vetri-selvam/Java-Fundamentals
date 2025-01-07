import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGUI3 implements ActionListener {
    public JFrame frame;

    public static void main(String[] args) {
        SimpleGUI3 gui = new SimpleGUI3();
        gui.go();
    }

    public void go() {
        // create frame
        frame = new JFrame();
        // make frame exit on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create button
        JButton button = new JButton("Change colors");
        // Add the listener (this) to the button
        button.addActionListener(this);

        // make MyDrawPanel object
        MyDrawPanel drawPanel = new MyDrawPanel();

        // add widgets to the Pane
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        // setSize and make it VISIBLE
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * When the user clicks, tell the frame to repaint() itself. That means
         * paintComponent() is called on every widget in the frame!
         */
        frame.repaint();

    }

}
