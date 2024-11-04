public class binaryToDecimal {
    public static void main(String[] args) {
        String numBits = Integer.toBinaryString(10);

        String toggleBits =""; 
        for (int i=0; i<numBits.length();i++){
            if (numBits.charAt(i)=='0'){
                toggleBits += '1';
            }
            else{
                toggleBits += '0';
        } 
   
    }
    // System.out.println(toggleBits);
     int decimal= Integer.parseInt(toggleBits,2);
     System.out.println(decimal);

    }
} 
