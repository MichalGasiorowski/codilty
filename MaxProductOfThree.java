// you can also use imports, for example:
// import java.math.*;
import java.util.Arrays;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        Arrays.sort(A);
        
        return Math.max(A[N-1]*A[N-2]*A[N-3], 
                        A[0]*A[1]*A[N-1]);
    }
}