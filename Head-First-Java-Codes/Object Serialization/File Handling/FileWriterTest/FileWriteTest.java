import java.io.FileWriter;

public class FileWriteTest {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("FileWriterTestFile.txt");

            writer.write("Hello I am writing using a FileWriter");
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
