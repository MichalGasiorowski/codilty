// you can also use imports, for example:
// import java.math.*;
import java.util.Stack;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        int N = S.length();
        if(N == 0)
            return 1;
        if(N % 2 != 0)
            return 0;
        Stack<Character> stack = new Stack<Character>();
        char a, c;
        for(int i =0;i<N;i++) {
            c = S.charAt(i);
            if(isOpeningBracket(c)) {
                stack.push(c);
            } else {
                if(stack.isEmpty()) { return 0; }
                a = stack.pop();
                //System.out.format("curr=%c, pop=%c, matchingBracket(c)=%c ", c, a, matchingBracket(c) );
                if(!isMatchingBracket(a, c)) { return 0; }
            }
        }
        return stack.isEmpty() ? 1 : 0;
        
    }
    
    private boolean isMatchingBracket(char c1, char c2) {
        return (c1 == '(' && c2 == ')' ) ||
                (c1 == '[' && c2 == ']' ) ||
                (c1 == '{' && c2 == '}' );
    }
    
    private boolean isOpeningBracket(char c) {
        return c == '(' || c == '[' || c == '{';
    }
    
    private boolean isClosingBracket(char c) {
        return c == ')' || c == ']' || c == '}';
    }
}
