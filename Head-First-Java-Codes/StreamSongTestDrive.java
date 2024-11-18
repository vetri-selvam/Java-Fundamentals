class StreamingSong {
    String title;
    String artist;
    String duration;

    void play() {
        System.out.println("Playing song");
    }

    void printDetails() {
        System.out.println("This is " + title + " by " + artist);
    }
}

class StreamSongTestDrive {
    public static void main(String[] args) {
        StreamingSong song = new StreamingSong();
        song.artist = "The Beattles";
        song.title = "Come together";
        song.play();
        song.printDetails();

    }
}
