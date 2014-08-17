// you can also use imports, for example:
// import java.util.*;
import java.util.*;
// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int N = A.length;
        if(N <= 2) return 0; // 2-element arrays have no peaks -> fail fast!
        
        TreeSet<Integer> peaks = new TreeSet<Integer>();
        int peakNum = 0;
        
        //add peaks to TreeSet
        for(int i=1;i<N-1;i++) {
            if(A[i-1] < A[i] && A[i] > A[i+1]) {
                peaks.add(i);
                peakNum++;  
            }
        }
        /*
        System.out.format("peakNum=%d", peakNum);
        System.out.println();
        for(Integer peak: peaks) {
            System.out.println(peak);
        }
        */
        
        if(peakNum <=1 ) { return peakNum; } // obvious answer
        
        int blockNum; // number of blocks 
        int low, high;
        Integer lower, higher;
        for(blockNum = peakNum; blockNum > 1; blockNum-- ) {
            // check if every block has at least 1 peak, 
            // using TreeSet of peaks
            //System.out.format("blockNum=%d\n", blockNum);
            if( N % blockNum != 0 ) { continue; } // can't divide equally 
            
            int blockCount = N / blockNum; // number of elements in each block
            boolean isGood = true;
            for(int iBlock = 0; iBlock < blockNum; iBlock++) {
                // current block is in range <iBlock * blockCount, (iBlock + 1 )* blockCount - 1>
                // check if in this region is at least 1 peak
                low = iBlock * blockCount;
                high = low + blockCount - 1;
                //System.out.format("low:%d, high:%d\n", low, high);
                lower = peaks.lower( high + 1); // O(log(#peakNum)) complexity ??
                higher = peaks.higher( low - 1); // O(log(#peakNum)) complexity ??
                //System.out.format("lower:%d, higher:%d\n", lower, higher);
                
                if(lower == null || lower < low) { isGood = false; break; }
                if(higher == null || higher > high) { isGood = false; break; }
                
            }
            if(isGood) return blockNum;
            
        }
        
        return 1; // if passed the loop, we can return one block answer
    }
}
