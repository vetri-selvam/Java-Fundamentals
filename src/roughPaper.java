import java.util.Arrays;

public class roughPaper {
    public static void main(String[] args) {

        // int[] hi = new int[5];
        // hi[0] = (byte) 4;
        // hi[1] = 5;
        // hi[2] = 6;
        // hi[3] = 7;
        // hi[4] = 8;

        Object[] elements = { (byte) 128, "Hello", 3.14, true };

        for (Object element : elements) {
            System.out.println(element.getClass().getSimpleName());
        }
        for (Object element : elements) {
            System.out.println(element);
        }
        System.out.println(Integer.MAX_VALUE);
        // System.out.println(Arrays.toString(hi));

    }
}
