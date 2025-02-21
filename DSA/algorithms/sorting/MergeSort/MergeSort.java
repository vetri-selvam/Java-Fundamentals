import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right){

        if (left < right){
            // find middle
            int middle = left + (right-left)/2;

            // sort two sub arrays
            mergeSort(arr,left,middle);
            mergeSort(arr,middle+1,right);

            // then perform merge
            merge(arr,left, middle,right);
        }

    }

    static void merge (int[] arr, int left, int middle, int right){

        // calculate size of two temp arrays
        int n1= middle - left + 1;
        int n2 = right - middle;

        // create two temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // add elements from arr into l1 and l2 respectively
        for(int i=0; i<n1;++i){
            L[i]=arr[left+i];
        }
        for(int i=0; i<n2;++i){
            R[i]=arr[middle + 1 +i];
        }

        int i=0;
        int j=0;
        int k=left;

        // compare and sort
        // add the sorted elements into arr

        while (i<n1 && j<n2){
            if (L[i] <= R[j]){
                arr[k]=L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // add remaining elements in either l1 or l2
        // into arr
        while (i<n1){
            arr[k]=L[i];
            i++;
            k++;
        }
        while (j<n2){
            arr[k]=R[j];
            j++;
            k++;
        }
    }


    public static void main(String[] args) {

        int[] arr = {5,6,45,2,56};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
