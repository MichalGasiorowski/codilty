// you can also use imports, for example:
// import java.math.*;
import java.util.Arrays;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        if(N < 3)
            return 0;
        Arrays.sort(A);
        long run_sum = A[0] + A[1];
        for(int i=2; i<N; i++) {
            if(run_sum > A[i])
                return 1;
            run_sum = run_sum - A[i - 2] + A[i];
        }
            
        return 0;
    }
}