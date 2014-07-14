// you can also use imports, for example:
// import java.math.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        if(N ==1) return 1; // special case
        int max_to_check = (int)Math.sqrt(N);
        int factor_count = 2;
        
        for(int i = max_to_check; i > 1; i--) {
            //System.out.format("\ni=%d, max_to_check=%d", i, max_to_check);
            if(N % i == 0) factor_count += ( (N/i == i) ? 1 : 2 );
        }
        return factor_count;
        
    }
}
