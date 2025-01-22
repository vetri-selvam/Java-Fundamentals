public class Fibo {
    static int fibo(int num){
        if ( num <2){
            return num;
        }
        return fibo(num-1) + fibo(num-2);
    }
    public static void main(String[] args) {
        System.out.println(fibo(5));
    }
}
