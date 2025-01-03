import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*;

public class MiniMusicCmdLine {
    public static void main(String[] args) {
        MiniMusicCmdLine mini = new MiniMusicCmdLine();
        // play only if we pass two values in cmd line
        if (args.length < 2) {
            System.out.println("Don't forget the instrument and note args");
        } else {
            /**
             * since args is an Array of Strings, the number inputs we give in 
             * cmd line are considered String. So we have to convert into int 
             * using Integer.parseInt
             */
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            // play
            mini.play(instrument, note);
        }
    }

    public void play(int instrument, int note) {
        try {
            // Sequencer
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            // Sequence and Track
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();
            // ShortMessage 1 and MidiEvent 1
            ShortMessage msg1 = new ShortMessage();
            msg1.setMessage(PROGRAM_CHANGE, 1, instrument, 0);
            MidiEvent changeInstrument = new MidiEvent(msg1, 1);
            //Add MidiEvent1 to track
            track.add(changeInstrument);
            // ShortMessage 2 and MidiEvent 2
            ShortMessage msg2 = new ShortMessage();
            msg2.setMessage(NOTE_ON, 1, note, 100);
            MidiEvent noteOn = new MidiEvent(msg2, 1);
            //Add MidiEvent2 to track            
            track.add(noteOn);
            // ShortMessage 3 and MidiEvent 3
            ShortMessage msg3 = new ShortMessage();
            msg3.setMessage(NOTE_OFF, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(msg3, 16);
            //Add MidiEvent3 to track
            track.add(noteOff);
            // set the Sequence in Sequencer and start the Sequencer
            player.setSequence(seq);
            player.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}