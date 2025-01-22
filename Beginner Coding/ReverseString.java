public class ReverseString {
    static String reverString (String str){
        char[] charArray = new char[str.length()];

        // add each charater of input(String) into charArray
        for ( int i =0; i < str.length(); i++){
            charArray[i]= str.charAt(i);
        }

        // swape elements in charArray
        for (int i =0; i<charArray.length/2; i++){
           char temp = charArray[i];
           charArray[i]= charArray[charArray.length -1 -i];
           charArray[charArray.length -1 -i] = temp;
        }
        
        // 
        // String result="";
        // for(char element : charArray){
        //     result += element;
        // }

        // return as String type
        return new String(charArray);
    }
    public static void main(String[] args) {
       
        System.out.println(reverString("Pranav H"));

    }
}
