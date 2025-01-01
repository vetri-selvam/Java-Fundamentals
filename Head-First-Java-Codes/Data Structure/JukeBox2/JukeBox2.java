import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class JukeBox2 {
    public static void main(String[] args) {
        new JukeBox2().go();
    }

    public void go(){

        // LIST - ArrayList

        // Storing songs in List songList
        List<SongV3> songList = MockSongs.getSongStrings();
        System.out.println(songList);
        
        // SET - HashSet

        // Putting songList into a HashSet "songSet" to avoid duplicates.
        Set<SongV3> songSet = new HashSet<>(songList);
        System.out.println(songSet);

        // TreetSet

        Set<SongV3> songTreeSet = new TreeSet<>((o1, o2)-> o1.getBpm() - o2.getBpm());    // passsed a Comparator in form of lambda expr. into the TreeSet constructor. The logic sort by Bpm asc.
        songTreeSet.addAll(songList);
        System.out.println(songTreeSet);


        String h1= "Hello";
        String h2= "Hello";
        System.out.println(h1.equals(h2));
        System.out.println(h1.hashCode() +" "+h2.hashCode());
        System.out.println(h1.hashCode() == h2.hashCode());




    }
}

class MockSongs {
    public static List<SongV3> getSongStrings() {

        // Creating a songs list in an ArrayList. Adding songs and returning the songs.
        List<SongV3> songs = new ArrayList<SongV3>();
        songs.add(new SongV3("somersault", "zero 7", 147));    // new song object is created and added.
        songs.add(new SongV3("cassidy", "grateful dead", 158));
        songs.add(new SongV3("$10", "hitchhiker", 140));
        songs.add(new SongV3("havana", "cabello", 105));
        songs.add(new SongV3("Cassidy", "grateful dead", 158));
        songs.add(new SongV3("50 ways", "simon", 102));
        return songs;
        
      }
}

class SongV3 {
    //instance variables
    private String title;
    private String artist;
    private int bpm;

    // constructor
    SongV3 (String title, String artist, int bpm){
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    // getters
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public int getBpm() {
        return bpm;
    }

    @Override // from Object class
    public String toString() {   // toString() is invoked when we want to print the object or list of objects.
        return title +" by "+artist+ " (bpm: "+bpm+")   ";
    }

    @Override  // from Object class
    public boolean equals(Object obj) {   // taking argument of ANY TYPE
        SongV3 other = (SongV3) obj;    // converting that into SongV3 type
        return title.equals(other.getTitle());
    }

    @Override // from Object class
    public int hashCode() {
        return title.toLowerCase().hashCode();
    }
}