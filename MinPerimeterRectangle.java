// you can also use imports, for example:
// import java.math.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        
        int max_to_check = (int)Math.sqrt(N);
        
        for(int cand= max_to_check; cand>1;cand--) {
            if(N % cand == 0) return 2 * cand + 2*N/cand;
        }
        
        return  2*N + 2;
    }
}