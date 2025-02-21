public class findSquare {
    static int findSquareRootOf (int x){
        int start = 0;
        int end = x;
        int result =0;
        while (start<=end) {
            // find mid
            int mid = start + (end-start)/2;

            if (Math.pow(mid, 2) < x){
                result = mid;
                start = mid+1;
            }
            else if (Math.pow(mid, 2) > x){
                end = mid -1;
            }
            else if (Math.pow(mid, 2) == x){
                return mid;
            }
        }
        return result;


    }
    static int SearchInsertPosition (int[] arr, int target){
        int start=0;
        int end= arr.length-1;

        while(start<=end){
            
            int mid = start + (end-start)/2;

            if(arr[mid] > target){
                end= mid -1;
            }
            else if (arr[mid] < target){
                start = mid +1;
            }
            else if (arr[mid] == target){
                return mid;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        // System.out.println(findSquareRootOf(12)); // Imperfect square
        // System.out.println(findSquareRootOf(25));   // Perfect square
        // System.out.println(findSquareRootOf(10));   // Imperfect square

        int[] arr = {1,2,5,6};
        System.out.println(SearchInsertPosition(arr, 3));
        
    }    
}
