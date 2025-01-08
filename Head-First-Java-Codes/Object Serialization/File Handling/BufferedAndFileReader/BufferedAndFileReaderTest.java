import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BufferedAndFileReaderTest {
    public static void main(String[] args) {
        try {
            File myFile = new File("MyText.txt");
            FileReader fileReader = new FileReader(myFile);

            BufferedReader reader = new BufferedReader(fileReader);

            // System.out.println(reader.readLine());

            String line;

            // Print all lines
            /**
             * As long as the readLine() returns a String and not nothing (Null),
             * print that line.
             */
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
