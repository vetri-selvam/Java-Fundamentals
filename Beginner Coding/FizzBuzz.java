public class FizzBuzz {
    /**
     * This Java program iterates through numbers from 1 to 100 and 
     * prints “Fizz” for multiples of 3, “Buzz” for multiples of 5, 
     * and “FizzBuzz” for numbers that are multiples of both 3 and 5. 
     * Otherwise, it prints the number itself.
     */
    public static void main(String[] args) {
        
        // iterate 1 to 100
        for ( int num=1; num<=100; num++){
            // if the num is divisible by both 3 and 5, print "FizzBuzz"
            if(num % 3 ==0 && num  % 5 ==0){
                System.out.println("FizzBuzz");
            }
            else if(num % 3 ==0){
                System.out.println("Fizz");
            }
            else if(num % 5 ==0){
                System.out.println("Buzz");
            }
            else{
                System.out.println(num);
            }
        }
    }
}