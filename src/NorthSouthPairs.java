import java.util.Scanner;

public class NorthSouthPairs {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter T:");
        int T = in.nextInt();
        int arr[]=new int[T];
        int count=0;
        for(int i=0;i<T;i++){
            
            int n=in.nextInt();
            if(n==0 || n==1){
                arr[i]=n;
                
            }
            else{
                System.out.println("Invalid Input");
                break;
            }
        }
// [1,0,0,1,1]
        for (int i = 0; i < T-1; i++) {
            for (int j = i+1; j < T; j++) {
                if(arr[i]==0 && arr[j]==1){
                    count++;
                }       
            }
        }

        System.out.println("Output:"+count);
        in.close();
    }
    
}