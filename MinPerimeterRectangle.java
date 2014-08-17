// you can also use imports, for example:
// import java.util.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        
        //System.out.format("sqrt(N) = %f", Math.sqrt(N));
        int start = (int)Math.sqrt(N);
        
        for(int div = start; div > 1; div--) {
            if(N % div == 0) { return 2*(div + N/div); }
        }
        
        return 2 * N + 2;
    }
}