// to find ceiling and flooring of a target element in a *sorted* array.
// we could use binary search to find the element since array is sorted.
 
 
 
public class CeilingAndFlooring{
    static int findCeilingOf(int[] arr, int target){
        // intiate start and end
        int start = 0;
        int end = arr.length -1;

        // !! logic explanation pending
        
        while (start<=end) { 
            //find the middle value index
            int middle = start + (end-start)/2;
            
            if(target < arr[middle]){
                end = middle-1;
            }            
            else if (target > arr[middle]){
                start = middle +1;
            }
            else if (target == arr[middle]){
                return arr[middle];  // return the index
            }
            /**
         * the while loop find the closed value to the target element. 
         * afer finding the closed value, the while condition fails in 
         * next iteration, that time return value AFTER the closest value
         * to know the ceiling value.
         */
        }
        return arr[start];
    }

    static int findFlooringOf(int[] arr, int target){
        // intiate start and end
        int start = 0;
        int end = arr.length -1;
    
        // !! logic explanation pending
        
        while (start<=end) { 
            //find the middle value index
            int middle = start + (end-start)/2;
            
            if(arr[middle] < target){
                end = middle-1;
            }            
            else if (target > arr[middle]){
                start = middle +1;
            }
            else if (target == arr[middle]){
                return arr[middle];  // return the index
            }
        }
        /**
         * the while loop find the closed value to the target element. 
         * afer finding the closed value, the while condition fails in 
         * next iteration, that time return value BEFORE the closest value
         * to know the floor value.
         */
        return arr[end];
    }
 
    public static void main(String[] args) {
        // int[] arr = {2,7,9, 54, 99, 467, 898};
        // System.out.println(findFlooringOf(arr, 98));

        boolean val = 'x'<'n';
        System.out.println(val);
    }
}