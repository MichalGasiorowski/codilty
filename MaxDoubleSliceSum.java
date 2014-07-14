// you can also use imports, for example:
// import java.math.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        
        int[] max_slices_norm = new int[N];
        int[] max_slices_rev = new int[N];
        
        int max_slice = 0;
        int curr_slice = 0;
        int max_idx = 0;
        
        for(int i=2; i<N-1; i++) {
            //System.out.format("\ni=%d, N=%d, N-i-1=%d, m1=%d, m2=%d", i, N, N-i-1, max_slices_norm[N-i+1], A[N-i] );
            max_slices_norm[i] = Math.max(0, max_slices_norm[i-1] + A[i-1] );
            max_slices_rev[N-i-1] = Math.max(0, max_slices_rev[N-i] + A[N-i] );
        }
        /*
        System.out.print("\nA:[");
        for(int i =0;i<N;i++) {
            System.out.format("%d,",A[i]);
        }
        System.out.print("]");
        System.out.print("\nmax_slices_norm:[");
        for(int i =0;i<N;i++) {
            System.out.format("%d,",max_slices_norm[i]);
        }
        System.out.print("]");
        System.out.print("\nmax_slices_rev:[");
        for(int i =0;i<N;i++) {
            System.out.format("%d,",max_slices_rev[i]);
        }
        System.out.print("]");
        */
        
        for(int i =1;i<N-1;i++) {
            curr_slice = max_slices_norm[i] + max_slices_rev[i];
            if(curr_slice > max_slice) {
                max_slice = curr_slice;
                max_idx = i;
            }
        }
        
        return max_slice;
    }
}
