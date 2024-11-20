// Chapter 2, Page 63

class Hobbits {
    String name;
}

public class HobbitTestDrive {
    public static void main(String[] args) {
        Hobbits[] hob = new Hobbits[4];
        int z = 0; // or z = -1

        while (z < 3) { // or (z < 2)
            hob[z] = new Hobbits();
            hob[z].name = "Bilbo";
            if (z == 1) {
                hob[z].name = "Fredo";
            }
            if (z == 2) {
                hob[z].name = "Sam";
            }
            System.out.println(hob[z].name + " is a good hobbit");
            z = z + 1;
        }
    }
}