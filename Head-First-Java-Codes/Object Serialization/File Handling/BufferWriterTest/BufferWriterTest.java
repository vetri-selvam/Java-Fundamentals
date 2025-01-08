import java.io.BufferedWriter;
import java.io.FileWriter;

class BufferWriterTest {
    public static void main(String[] args) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("BufferedWriterTestFile.txt"));
            writer.write("Writing using BufferedWriter. Storing in buffer...");
            writer.flush();
            writer.close();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}