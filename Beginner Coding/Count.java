public class Count {
    // Count words in a string
    public static void main(String[] args) {
        String str = "Enaku andha comedy romba pudikkum dfgdf";
        System.out.println(countNoOfWords(str));
        System.out.println(str.length());
        System.out.println(str.trim().length());
        System.out.println(str.length());
        System.out.println();
    }
    static int countNoOfWords(String str){
       
        // split the sentence string whenever a space comes
        // store each word part into a Array of Strings
        String[] strArray= str.split("\s");
   
        return strArray.length;
    } 
}
