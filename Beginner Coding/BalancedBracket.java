import java.util.Stack;

public class BalancedBracket {
    static Boolean isBalanced (String str){
        if(str.isEmpty()){
            return false;
        }

        Stack<Character> bracketStack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='{' || str.charAt(i)=='[' || str.charAt(i)=='('){
                bracketStack.push(str.charAt(i));
            } else if (!bracketStack.empty() &&
                    ( (bracketStack.peek() == '(' && str.charAt(i) == ')') || (bracketStack.peek() == '[' && str.charAt(i) == ']') || (bracketStack.peek() == '{' && str.charAt(i) == '}')))
            {
                bracketStack.pop();
            }
            else {
                return false;
            }
        }

        return bracketStack.empty();
    }

    public static void main(String[] args) {
        String s = "{([])}";
        if (isBalanced(s))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
