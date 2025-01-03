
// Create a custom Exception `MyEx`
class MyEx extends Exception { 

}

public class ExTestDrive {
    /**
     * code logic:
     * print "t"
     * print "h"
     * 
     * if test = "yes", throw MyEx exception.
     * goes to catch.
     * print "a" in catch
     * goes to finally.
     * print "w"
     * print "s"
     * 
     * if test="no", if condition failes.
     * run remaining code in doRisky i.e.
     * print "r" 
     * print "o".
     * then, goes to try block. No remaing code in try.
     * goes to finally block,
     * print "w"
     * print "s".
     * 
     */
    public static void main(String[] args) {
            String test = args[0];
            try{
                System.out.print("t");
                doRisky(test);
            }
            catch(MyEx e){
                System.out.print("a");  
            }
            finally{
                System.out.print("w");
                System.out.println("s");
            }
    }
    public static void doRisky(String t) throws MyEx{
        System.out.print("h");
        if ("yes".equals(t)) {
            throw new MyEx();
        }
        System.out.print("r");
        System.out.print("o");

    }
}
