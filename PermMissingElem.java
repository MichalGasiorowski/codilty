// you can also use imports, for example:
// import java.math.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        long N = A.length;
        long running_sum = 0;
        long all_sum = (long) ( (N + 1) * (N + 2) )/2;
        for (int i=0; i < N; i++) {
            running_sum = running_sum + A[i];
        }
        return (int) (all_sum - running_sum);
    }
}