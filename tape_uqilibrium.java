// you can also use imports, for example:
import java.math.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int min_split;
        System.out.format("\nA[%d]=%d", 0, A[0]);
        for(int i=1;i<A.length;i++) {
            A[i] = A[i - 1] + A[i];
            System.out.format("\nA[%d]=%d", i, A[i]);
        }
        int allSum = A[A.length - 1];
        min_split = Math.abs( A[0] - (allSum - A[0]));
        for(int p=1;p<A.length - 1;p++) {
            min_split = Math.min(min_split, Math.abs( A[p] - (allSum - A[p]) ) );
            System.out.format("\np=%d , min_split=%d" , p, min_split);
        }
        System.out.format("\nSOLUTION IS=%d\n\n" , min_split);
        return min_split;
    }
}