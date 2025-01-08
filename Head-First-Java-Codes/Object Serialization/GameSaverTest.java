import java.io.*;

class GameCharacter implements Serializable {
    int power;
    String type;
    String[] weapons;

    // constructor
    GameCharacter(int power, String type, String[] weapons) {
        this.power = power;
        this.type = type;
        this.weapons = weapons;
    }

    // type getter
    public String getType() {
        return type;
    }

}

public class GameSaverTest {
    public static void main(String[] args) {

        // make some charaters
        GameCharacter one = new GameCharacter(50, "Elf",
                new String[] { "bow", "sword", "dust" });

        GameCharacter two = new GameCharacter(200, "Troll",
                new String[] { "bare hands", "big ax" });

        GameCharacter three = new GameCharacter(120, "Magician",
                new String[] { "spells", "invisibility" });

        // imagine code that does things with the characters that changes their state
        // values

        try {
            // Serialize the characters
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            // Deserialize the characters by reading them back in from file: Game.ser
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));

            // Restore the characters
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();

            // check to see if states are same as when it was serialized.
            System.out.println("One's type: " + oneRestore.getType());
            System.out.println("Two's type: " + twoRestore.getType());
            System.out.println("Three's type: " + threeRestore.getType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}