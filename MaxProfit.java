// you can also use imports, for example:
// import java.math.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        if( N<2 ) return 0;
        
        int max_profit = 0;
        int lowest = A[0];
        //int[] profit_idx = new int[2];
        
        for(int i =1; i<N; i++) {
            max_profit = Math.max(max_profit, A[i] - lowest);
            lowest = Math.min(lowest, A[i]);
        }
        return max_profit;
    }
}