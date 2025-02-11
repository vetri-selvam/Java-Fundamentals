import java.util.Arrays;

public class InsertionSort{

    static void insertionSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            // compare the right element with immediate left 
            // if smaller, swap and then compare the swapped element
            // from the new position to immediate left (if condition is true) 
            // swap as long as current is smaller than left.
            for(int j=i+1; j>0;j--){
                if(arr[j]<arr[j-1]){
                    swap(arr, j-1, j);
                }
            }
        }
    }

    static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}