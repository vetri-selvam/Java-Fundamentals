// All imports
import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// static import
import static javax.sound.midi.ShortMessage.*;

public class BeatBox{
    // declare a variable that stored List of JCheckBox objects
    private ArrayList<JCheckBox> checkboxList;
    
    // Sequencer, Sequence, Track references declaration
    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;

    // Create Array of Instrument Names (String)
    /**
     * These are the names of the instruments, as a String array, for 
     * building the GUI labels (on each row).
     */
    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat",
          "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap",
          "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
          "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo",
          "Open Hi Conga"};
    
    // Drum Keys
    /**
     * The below line represent the actual drum “keys.” The drum channel is like a piano, 
     * except  each “key” on the piano is a different drum. 
     * So the number “35” is the key for the Bass drum, 42 is Closed Hi-Hat, 
     * etc.
     */
    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    // MAIN METHOD
    public static void main(String[] args) {
        // create a BeatBox object and use it to run buildGUI() method
        new BeatBox().buildGUI();
    }

    public void buildGUI(){
        /**
         * Create Frame.
         * Make the frame Exit on close.
         * Create a BorderLayout.
         * Create a JPanel with the BorderLayout object.
         * Set border for the JPanel object.
         */
        JFrame frame = new JFrame("Cyber BeatBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // create buttonBox
        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        
        // Start Button
        /**
         * Create a JButton named "start".
         * Add actionListener to the button that calls buildTrackAndStart().
         * Add the "start" JButton object to the buttonBox object.
         */
        JButton start = new JButton("Start");
        start.addActionListener(e -> buildTrackAndStart());
        buttonBox.add(start);

        // Stop Button
        /**
         * Create a JButton named "stop".
         * Add actionListener to the button that calls sequencer.stop().
         * Add the "stop" JButton object to the buttonBox object.
         */
        JButton stop = new JButton("Stop");
        stop.addActionListener(e -> sequencer.stop());
        buttonBox.add(stop);

        // upTempo Button
        /**
         * Create a JButton "upTempo".
         * Add actionListener to the button that calls changeTempo(1.03f).
         * The default tempo is 1.0, so we’re adjusting +3% per click.
         * Add this button to buttonBox.
         */
        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(e -> changeTempo(1.03f));
        buttonBox.add(upTempo);        

        // downTempo Button
        /**
         * Create a JButton "downTempo".
         * Add actionListener to the button that calls changeTempo(0.97f).
         * We’re adjusting -3% per click.
         * Add this button to buttonBox.
         */
        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(e -> changeTempo(0.97f));
        buttonBox.add(downTempo);

        /**
         * Create a nameBox.
         * For every instrument in instrumentNames (Array), create an instrumentLabel
         * (JLabel) and setBorder on each instrument in a way that helps them line up
         * with the checkboxes. i.e. createEmptyBorder(4, 1, 4, 1)
         */
        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (String instrumentName : instrumentNames) {
          JLabel instrumentLabel = new JLabel(instrumentName);
          instrumentLabel.setBorder(BorderFactory.createEmptyBorder(4, 1, 4, 1));
          nameBox.add(instrumentLabel);
        }

        // Add butonBox to the EAST and nameBox to the WEST of background(JPanel)
        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        // Add background to the frame(JFrame)
        frame.getContentPane().add(background);

        // Create a grid(GridLayout)
        /**
         * Another layout manager, this one lets you put the components in a grid 
         * with rows and columns.
         */
        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);

        // Create a mainPanel(JPanel) which takes the above grid layout.
        JPanel mainPanel = new JPanel(grid);
        // Add mainPanel to the background at CENTRE.
        background.add(BorderLayout.CENTER, mainPanel);

        /**
         * Create an ArrayList object on checkBoxList(ArrayList<JCheckBox>) reference.
         * Create 255 JCheckBoxes.
         * Set them to ‘false’ (so they aren’t checked), and add them to the ArrayList 
         * AND to the GUI panel.
         */
        checkboxList = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);
        }

        // call setUpMidi(); method
        setUpMidi();

        // setBounds on frame. Pack frame. setVisible true on Frame.
        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }
    // end buildGUI()

    private void setUpMidi() {
        // MIDI setup
        /**
         * getSequencer, open sequencer.
         * create sequence.
         * createTrack using sequence.
         * setTempoInBPM on sequencer.
        */        
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }

        /**
         * This is where it all happens! Where we turn checkbox state into MIDI events
         * and add them to the Track.
         */

    private void buildTrackAndStart(){
        /**
         * We’ll make a 16-element array to hold the values for one instrument, 
         * across all 16 beats. If the instrument is supposed to play on that beat,
         * the value at that element  will be the key. If that instrument is NOT 
         * supposed to play on that beat, put in a zero.
        */
        //declare an array of int: trackList
        int[] trackList; 

        // Get rid of the old track, make a fresh one.
        sequence.deleteTrack(track);
        track = sequence.createTrack();

        // do this for each of the 16 ROWS (i.e., Bass, Congo, etc.)
        for (int i = 0; i < 16; i++) {
            
            trackList = new int[16];
            
            /**
             * Set the “key” that represents which instrument this is (Bass, Hi-Hat, 
             * etc.). The instruments array holds the actual MIDI numbers for each 
             * instrument.
             */
            int key = instruments[i];

            //  Do this for each of the BEATS for this row.
            for (int j = 0; j < 16; j++) {
                /**
                 * Is the checkbox at this beat selected? If yes, put the key value in
                 *  this slot in the array (the slot that represents this beat). 
                 * Otherwise, the instrument is NOT supposed to play at this beat, 
                 * so set it to zero.
                 */
                JCheckBox jc = checkboxList.get(j + 16 * i);
                if (jc.isSelected()) {
                  trackList[j] = key;
                } else {
                  trackList[j] = 0;
                }
              }
            
              /**
               * For this instrument, and for all 16 beats,  make events and add them
               * to the track.
               */
            makeTracks(trackList);
            track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, 16));
        }

        /**
         * We always want to make sure that there IS an event at beat 16 
         * (it goes 0 to 15). Otherwise, the BeatBox might not go the full 16 beats
         *  before it  starts over.
         */
        track.add(makeEvent(PROGRAM_CHANGE, 9, 1, 0, 15));

        /**
         * The below specify the number of loop iterations, or in this case, 
         * continuous looping.
         */
        try{
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.setTempoInBPM(120);
            sequencer.start();
        }
        catch (Exception e) {
            e.printStackTrace();
          }
    }
    /**
     * The Tempo Factor scales the sequencer’s tempo by the factor provided, 
     * slowing the beat down or speeding it up.
     */
    private void changeTempo(float tempoMultiplier) {
        float tempoFactor = sequencer.getTempoFactor();
        sequencer.setTempoFactor(tempoFactor * tempoMultiplier);
    }

    private void makeTracks(int[] list) {
        /**
         * This makes events for one instrument at a time, for all 16 beats. So it might 
         * get an int[ ] for the Bass drum, and each index in the array will hold either
         *  the key of that instrument or a zero. If it’s a zero, the instrument isn’t 
         * supposed to play at that beat. Otherwise, make an event and add it to the track.
         */
        for (int i = 0; i < 16; i++) {
          int key = list[i];
          
          if (key != 0) {
            // Make the NOTE ON and NOTE OFF events, and add them to the Track.
            track.add(makeEvent(NOTE_ON, 9, key, 100, i));
            track.add(makeEvent(NOTE_OFF, 9, key, 100, i + 1));
          }
        }
    }
    
    /**
     * A utility method (makeEvent) to create and return MidiEvent reducing the tedious
     * process of write code for creating ShortMessage, setting message and creating 
     * MidiEvent everytime.
     */ 
    public static MidiEvent makeEvent(int cmd, int chnl, int one, int two, int tick) {
        MidiEvent event = null;
        try {
          ShortMessage msg = new ShortMessage();
          msg.setMessage(cmd, chnl, one, two);
          event = new MidiEvent(msg, tick);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return event;
      }
}