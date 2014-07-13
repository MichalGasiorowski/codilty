// you can also use imports, for example:
// import java.math.*;
import java.util.Stack;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] H) {
        // write your code in Java SE 8
        int N = H.length;
        int curr, top, elNum  = 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0;i < N;i++) {
            curr = H[i];
            if(stack.isEmpty()) { stack.push(curr); continue; }

            while(true) {
                if(stack.isEmpty()) { stack.push(curr); break; }
                top = stack.peek();
                if(curr > top) { stack.push(curr); break; }
                else if(curr == top) { break; }
                else { elNum++; stack.pop(); continue; }
            }
            
        }
        
        return elNum + stack.size();
    }
}
