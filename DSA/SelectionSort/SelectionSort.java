import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr){

        for ( int i =0; i<arr.length-1;i++){

            // Assume the current position holds
            // the minimum element
            int min_idx =i;

            for (int j=i+1; j<arr.length;j++){
                if (arr[j]<arr[min_idx]){
                    min_idx = j;
                }
            }
            // Move minimum element to its
            // correct position
            int temp = arr[i];
            arr[i]=arr[min_idx];
            arr[min_idx]=temp;

        }
    }
    public static void main(String[] args) {
        int[] arr = {54,11,23,-1,2};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
