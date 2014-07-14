// you can also use imports, for example:
// import java.math.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        
        int max_slice = A[0];
        
        for(int i=1;i<N;i++) {
            A[i] = Math.max(A[i], A[i-1] + A[i]);
            max_slice = Math.max(max_slice, A[i]); 
        }
        
        /*
        for(int i=0;i<N;i++) {
            System.out.format("\nA[%d]=%d", i, A[i] );
        }
        */
        return max_slice;
        
    }
}