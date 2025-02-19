import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    static void quickSort(int[] array, int minIndex, int maxIndex){

        // base condition for recursion
        if(minIndex >= maxIndex){
            return;
        }

        // PARTITION

        // take a random index for pivot
        int pivotIndex = new Random().nextInt((maxIndex - minIndex))+minIndex;
        int pivot = array[pivotIndex];

        // firstly swap the element at random index with the last element  in array
        swap(array, pivotIndex, maxIndex);
        int leftPointer = minIndex;
        int rightPointer = maxIndex;

        /*
         * As long as the leftPointer less than rightPointer, perform another
         * while which decrements leftPointer as long as the element at leftPointer is
         * less than or equal to the pivot element.
         * Another while loop decrement rightPointer as long as the element at rightPointer
         * is larger than pivot element.
         */
        while (leftPointer < rightPointer){

            while (array[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }

            while (array[rightPointer] >= pivot && rightPointer > leftPointer){
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }
        /*
         * when the above while condition fails, leftPointer and rightPointer
         * points the same index.
         * swap the element at leftPointer with the pivot element which is at
         * the maxIndex.
         * Now pivot is moved to a NEW index.
         */
        swap(array, leftPointer, maxIndex);

        /*
         * after the above swap, do the quicksort again,
         * but this time, minIndex is the minimum index of
         * actual array but the maxIndex is element left of the
         * pivot.
         *
         * Another quickSort does the sorting from element next to
         * the pivot to the maxIndex of the actual array.
         *
         */
        quickSort(array, minIndex, leftPointer-1);
        quickSort(array, leftPointer+1, maxIndex);

    }

    static void swap(int[] array, int index1,int index2){
        int temp = array[index1];
        array[index1]= array[index2];
        array[index2]= temp;
    }



    public static void main(String[] args) {
        int[] array = {34,1,22,657,89,4,1};
        quickSort(array, 0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
