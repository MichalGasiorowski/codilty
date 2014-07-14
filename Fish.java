// you can also use imports, for example:
// import java.math.*;
import java.util.Stack;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        int N = A.length;
        // A - sizes of fish
        // B - direction of fish 0 - UP , 1 - DOWN
        Stack<Integer> stack = new Stack<Integer>();
        int curr, curr_dir, top;
        int aliveAtEnd = 0;
        
        for(int i=0; i<N; i++) {
            curr = A[i];
            curr_dir = B[i];
            while(true) {

                if(!isUpstream(curr_dir)) { stack.push(curr); break; }
                else if(stack.isEmpty()) {
                    aliveAtEnd++; break;
                } else {
                    top = stack.pop();
                    if(top > curr) { stack.push(top); break; }
                }
            }
        }
        
        return aliveAtEnd + stack.size();
    }
    
    private boolean isUpstream(int dir) {
        return dir == 0;
    }
}