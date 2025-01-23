import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {

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
        for(int i=0; i<arr.length; i++){
            if (!set.add(arr[i])){
                duplicateArray.add(arr[i]);
            }
        }
        return duplicateArray;
    }

    public static void main(String[] args) {
       int[] arr = {1,2,3,3,3,4,8,10,10};
       System.out.println(findDuplicate(arr));
    }
}
