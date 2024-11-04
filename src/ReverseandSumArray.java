import java.util.Arrays;

    public class ReverseandSumArray {
    // Method to display the array in the desired format
    public static void display(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 44, 3, 5};
        
        // Step 1: Sort arr in descending order
        Arrays.sort(arr);
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        // Step 2: Calculate and display the cumulative sums, reducing the array each time
        int cumulativeSum = 0;
        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            // Create a temporary array to store the remaining elements after each step
            int[] tempArray = new int[arr.length - i];
            tempArray[0] = cumulativeSum;

            // Copy the remaining elements into tempArray
            for (int j = 1; j < tempArray.length; j++) {
                tempArray[j] = arr[i + j];
            }

            // Display the current state of tempArray
            display(tempArray);
        }
    }
}