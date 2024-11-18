public class Episode extends StreamingSong {
    int serialNumber;
    int episodeNumber;

    void skipIntro() {
        System.out.println("Skipping Intro...");
    }

    void skipToNext() {
        System.out.println("Loading next episode...");
    }

}

class EpisodeTestDrive {

    public static void main(String[] args) {
        Episode episode = new Episode();
        episode.serialNumber = 4;
        episode.play();
        episode.skipIntro();
    }
}
