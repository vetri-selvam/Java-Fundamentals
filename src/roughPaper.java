class Hobbits {
    String name;
}

public class roughPaper {
    public static void main(String[] args) {
        Hobbits[] hob = new Hobbits[4];
        int z = 0;

        while (z > 3) {
            hob[z] = new Hobbits();
            hob[z].name = "Bilbo";
            if (z == 1) {
                hob[z].name = "Fredo";
            }
            if (z == 2) {
                hob[z].name = "Sam";
            }
            System.out.println(hob[z].name + "is a good hobbit");
            z = z + 1;
        }
    }
}