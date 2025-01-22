public class FindMissingNum {
    static int findMissingNum(int[] arr){
        int N = arr.length;

        // formula to find sum of N numbers (either sorted or unsorted)
        int expectedSum = N * (N + 1)/ 2;

        int actualSum =0;
        for(int element : arr){
            actualSum += element;
        }
        int missingNumber = expectedSum - actualSum;

        return missingNumber != 0 ? missingNumber : -1;
    }
    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 5, 2, 6, 4};
        System.out.println(findMissingNum(arr));
        
    }
}
