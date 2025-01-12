import java.io.Serializable;
import java.io.*;

class DungeonTest {
    public static void main(String[] args) {
        DungeonGame d = new DungeonGame();

    }

    class DungeonGame implements Serializable {
        public int x = 3;
        transient long y = 4;
        private short z = 5;

    }
}