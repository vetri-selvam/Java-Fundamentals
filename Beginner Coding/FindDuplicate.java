import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {

    // METHOD 1 (Efficient)

    static Set<Integer> findDuplicate ( int[] arr){

        // store duplicate elements in a HashSet
        // Using HashSet avoids adding same duplicates again and again.
        Set<Integer> duplicateArray=new HashSet<>();;
        
        
        Set<Integer> set = new HashSet<>();
        /**
         * Add arr elemets into the above `set`.
         * As long as there's no duplicate, go one.
         * When fails, add that element into the
         * duplicateArray.
         */
        for(int element : arr){
            if (!set.add(element)){
                duplicateArray.add(element);
            }
        }
        System.out.println(set);
        return duplicateArray;
    }

    // METHOD 2 (If an array must be retured)
    
    /**
     * static Set<Integer> findDuplicates(int[] arr) {
            //To store the duplicate elements in the array use this,
            // int j = 0;
            // int[] duplicateArray = new int[arr.length];

            Set<Integer> set = new HashSet<>();

            //To avoid trailing 0's and same duplicate elements added to the array use HashSet to store it
            Set<Integer> duplicateElements = new HashSet<>();
            for (int num : arr) {
                if (!set.add(num)) {
                    duplicateArray[j]=num;
                    // j++;  //for array

                }
            }
            // return Arrays.copyOfRange(duplicateArray, 0, j); //To trim the trailing 0's in the duplicate elements array
            return duplicateElements;
        }
     * 
     */


    public static void main(String[] args) {
       int[] arr = {1,2,3,3,3,4,8,10,10, 4, 0,0};
       System.out.println(findDuplicate(arr));
    }
}

