import java.util.ArrayList;
import java.util.List;

public class JukeBox {
    public static void main(String[] args) {
        new JukeBox().go();
    }

    public void go(){
        // Storing songs in List songList
        List<SongV3> songList = MockSongs.getSongStrings();
        System.out.println(songList);
        
        // sort by artist name. Using Comparator Interface 
        
            /* FYI Comparator is a functional interface and can therefore be used as the assignment target for a lambda expression 
            or method reference. */

        songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
        System.out.println(songList);
        
        // compareTo Logic
        /*
         * the compareTo return a negative integer, zero, or a positive integer as THIS object (first param) is less than, equal to, or greater than the specified object (second param).
        */
        /*As per asecending logic (5, 10), compare 5 with 10. 5 is < than 10,  return NEGATIVE. Since negative, first param is smaller than second. so, 5 comes before 10. O/P: 5,10. 
             *                 If (10, 5),  compare 10 with 5. 10 is > than 5, return POSITIVE. since positive, first param is greater than second. so, 10 comes AFTER 5. O/P: 5,10.*/

        // sort by artist name (DESCENDING)
        songList.sort((one, two) -> two.getTitle().compareTo(one.getTitle()));
        System.out.println(songList);

            // DESCENDING LOGIC
            /*
             * the compareTo return a negative integer, zero, or a positive integer
             *  as THIS object (first param) is less than, equal to, or greater than the specified object (second param).
             * Example:
             * As per asecending logic (5, 10), compare 5 with 10. If 5 is < than 10,  return NEGATIVE. Since negative, first param is smaller than second. so, 5 comes before 10. O/P: 5,10. 
             *                         (10, 5)  compare 10 with 5. If 10 is > than 5, return POSITIVE. since positive, first param is greater than second. so, 10 comes AFTER 5. O/P: 5,10.
             * For descending logic (First param, Second param),
             * we pass the input as (5, 10) but inside compare method, we swap them to trick that to return OPPOSITE value. 
             *                     compare 10 with 5. 
             *                     10 is > than 5,  
             *                     return POSITIVE. 
             *                     since POSITIVE, sort() ASSUMES that first param(5) is GREATER than second(10). so, 10 comes before 5. o/p: 10, 5. 
             * In a way, it indirectly returns in DESCENDING ORDER.  
            */

        // sort by BPM
        /*BPM is int, so*/
        songList.sort((one,two)-> one.getBpm() - two.getBpm());  // if positive, first arg is greater. if zero, same. if negative, first arg is smaller. 
        System.out.println(songList);

        // check hashcode
        System.out.println(songList.get(0).hashCode());

        // comparing two objects equality with hashCode
        System.out.println(songList.get(0) == songList.get(1));

        System.out.println(songList.get(0).equals(songList.get(1)));

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
        return title +" "+bpm;
    }
}