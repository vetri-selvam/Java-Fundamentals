public class rotateArray {

    static int[] rotate(int array[], int n, int k)
{
    if(k>n)
    k=k%n;
    int[] finalans=new int[n];
    
    for(int i=0;i<k;i++)
    
    finalans[i]=array[n-k+i];
    
    int index=0;
    for(int i=k;i<n;i++){
        finalans[i]=array[index++];
    }
    return finalans;
}




    public static void main(String[] args) {
        {
            int array[]={10,20,30,40,50};
            int n=5;
            int k=1;
            int [] finalans=rotate(array,n,k);
            for(int i=0;i<n;i++)
            
            System. out.print (" "+finalans[i]);
        }
    }

}
