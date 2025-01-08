import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        // make a new Folder
        File dir = new File("New Folder");
        // create another inside "New Folder"
        File dir2 = new File("New Folder/new");
        dir.mkdir();

    }

}
