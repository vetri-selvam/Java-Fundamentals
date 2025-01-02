import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*; // static import to use CONSTANTS from ShortMessage

class MiniMiniMusicApp {
    public static void main(String[] args) {

        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();

    }

    public void play() {
        try {
            // 1. Create a Sequencer object
            Sequencer player = MidiSystem.getSequencer();
            // 2. open sequencer
            player.open();

            // 3. create Sequence object
            Sequence seq = new Sequence(Sequence.PPQ, 4);

            // 4. create a track object
            Track track = seq.createTrack();

            // 5. Add 2 MidiEvents to the Track
            /**
             * Procedure:
             * 
             * create ShortMessage object.
             * use setMessage on the ShortMessage object. NOTE_ON & NOTE_OFF are 
             * constants from ShortMessage class.
             * 
             * Now, create a MidiEvent object by passing the ShortMessage as one 
             * of the args.
             * Then, add that MidiEvent into the track.
             * 
             */
            ShortMessage msg1 = new ShortMessage();
            msg1.setMessage(NOTE_ON, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(msg1, 1);
            track.add(noteOn);
            ShortMessage msg2 = new ShortMessage();
            msg2.setMessage(NOTE_OFF, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(msg2, 16);
            track.add(noteOff);

            // 6. Give the sequence to the Sequencer 
            // (like selecting the song to play)
            player.setSequence(seq);

            // 7. start() the Sequencer (play the song)
            player.start(); 

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}