// you can also use imports, for example:
// import java.math.*;

// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        if(N == 0) return -1;
        
        int leader = A[0], l_idx = 0, counter = 1;
        int candidate;
        
        for(int i=1; i<N; i++) {
            candidate = A[i];
            //System.out.format("\ni:%d\tleader=%d, candidate=%d, counter=%d, N/2=%d", i, leader, candidate, counter, N/2);
            if( counter == 0 ) { l_idx = i; leader = candidate; counter++;  }
            else if(leader == candidate) { counter++; } 
            else { counter--; }
        }
        counter = 0;
        for(int i =0;i<N;i++) {
            if(A[i] == leader) counter++;
        }
        return (counter > N/2) ? l_idx : -1;
    }
}