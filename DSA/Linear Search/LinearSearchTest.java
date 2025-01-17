import java.util.Arrays;

class LinearSearchTest{

    // linearSearch (an_array, target_element)
    static int linearSearch (int[] arr, int target){
        // return -1 if the array size is 0
        if (arr.length == 0){
            return -1;
        }
        // iterate the arr and compare each element with
        // the target element and  return target index if found.
        for ( int index=0; index < arr.length; index++){
            if ( arr[index] == target){
                return index;
            }
        }

        // return the element itself using forEach
        // for(int element: arr){
        //     if ( element == target){
        //         return element;
        //     }
        // }


        // if target element is not in array, return -1
        return -1;
    }
    /**
     * Incase, -1 IS a target element, make the linearSearch
     * return a Boolean. 
     * 
     */

     static int findMin(int[] arr){
        // if array size is 0, return "empty array"
        if ( arr.length == 0){
            System.out.println("empty array");
        }
        // assume the first element as the min value at first.
        int min_value = arr[0];

        // compare each element with min_value
        // if an element is smaller than min_value, update min_value
        // with that element, else leave as such.
        for (int element : arr){
            if (element < min_value){
                min_value = element;
            }
        }
        return min_value;
     }
    

    public static void main(String[] args) {
        // unsorted array
        int[] nums = {-2, 78, 23, 6, -1, 35, 8};

        int result = findMin(nums);

        System.out.println(result);
    }
}