// you can also use imports, for example:
// import java.util.*;
import java.util.*;
// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int N = A.length;
        if(N <= 2) return 0; // 2-element arrays have no peaks -> fail fast!
        
        int[] distances = new int[N];
        int peakNum = 0;
        int prevPeak =0;
        int peakDist = 0;
        for(int i=1;i<N-1;i++) {
            if(A[i-1] < A[i] && A[i] > A[i+1]) {
                peakNum++; 
                if(prevPeak != 0) {
                    peakDist = i - prevPeak;
                    distances[peakDist] += 1;
                }
                prevPeak = i;
            }
        }
        
        //for(int i = 0; i<N; i++) {
        //    System.out.format("distanceCount[%d]=%d\n", i, distances[i]);
        //}
        
        for(int i = N - 2; i >= 0; i--) {
            distances[i] = distances[i] + distances[i+1];
        }
        
        for(int i = 0; i<N; i++) {
            System.out.format("distanceCount[%d]=%d\n", i, distances[i]);
        }
        
        for(int K = peakNum; K > 1; K--) {
            if(distances[K - 1] >= K) return K;    
        }
        
        return 1; // if passed the loop, we can return one block answer
    }
}
