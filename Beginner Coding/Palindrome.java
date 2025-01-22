public class Palindrome {
    
    static boolean checkPalindromeString(String strArg){
        strArg = strArg.toLowerCase();
    
         for ( int i=0; i<strArg.length()/2; i++){
            // compare first and last, second and second from last and so on
            // if the character does not match, String is not palindrome.
            // return false
            if(strArg.charAt(i)!=strArg.charAt(strArg.length()-1-i)){
                return false;
            }
         }
        // if not comparison returns false, then the string is Palindrome, so return true
        return true;
    }

    static boolean checkPalindromeNumber(int intArg){
        int originalNum = intArg;
        int reversedNum=0;

        while(intArg>0){
            // The line `reversedNum =(reversedNum*10) + remainder` kinda does an integer concatination. 
            /**
             * Eg: Integer concatination
             * int a = 3;
             * int b = 5;
             * we need the above two ints to get 35. we cannot just add (3+5), 
             * because + is considered addition for int unlike concatination for String.
             * The solution is (a*10)+b ==> (3*10)+5 = 35. 3 and 5 becomes 35 and not 8. 
             * So becasilly use the above formula to concatinate integers that keeps them
             * as integer without making them type String.
             */
                                                        //1st pass                   //2nd pass                    //3rd pass
            int remainder= intArg%10;                   //remainder=352%10=2               //rem=35%10=5                 //rem3%10=3   
            reversedNum =(reversedNum*10) + remainder;  //reversed=(0*10)+2=2        //reversed=(2*10)+5=25        //reversed=(25*10)+3=25
            intArg = intArg/10;                         //num=352/10=35              //num=35/10=3                 //3/10=0
        }
    
        // return true if the original number is equal to the reversed number
        return reversedNum==originalNum;
    }
}