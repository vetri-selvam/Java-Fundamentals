import javax.swing.*;
class SimpleGUI1{
    /**
     * few simple steps to a GUI
     * <ul>
     *  1. Make a frame.
     *  2. Make a widget (eg. button).
     *  3. Add the widget to the frame.
     *  4. Display it.
     * </ul>
     */
    public static void main(String[] args) {
        // Make a frame
        JFrame frame = new JFrame();

        // Make a button
        JButton button = new JButton("click me");
        
        // Make a closable window. program quits as soon as one closes the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add button to the frame's content pane
        frame.getContentPane().add(button);

        // set frame size, in pixels
        frame.setSize(300,300);

        // make it VISIBLE. 
        //if you forget this, you wo't see anything when this code runs.
        frame.setVisible(true);
    }
}