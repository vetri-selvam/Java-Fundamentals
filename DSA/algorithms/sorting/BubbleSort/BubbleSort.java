public class BubbleSort{
    
    static void bubbleSort(int[] arr){
        boolean swap;

        //run the steps n-1 times
        for(int i=0; i<arr.length; i++){
            swap = false;
            //for each step, the max element will come
            //  at the last respective index
            for(int j=1; j<=arr.length-i-1; j++){
                
                if(arr[j]<arr[j-1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    // swap = true, means there are still 
                    // elements to be swapped 
                    swap = true;
                }
            }
            // break from the loop. 
            // No need to check further for i.
            if(!swap){
                break;
            }         
        }
    }  
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5, 2};
        bubbleSort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}