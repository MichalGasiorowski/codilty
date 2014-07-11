class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        
        int[] prefixSum = new int[N+1];
        int[] minSlice = new int[2];
        double minSliceAvg;
        double currSliceAvg;
        
        for(int i =1; i< N+1; i++) {
            prefixSum[i] = prefixSum[i-1] + A[i-1];
        }
        //printPrefixArr(prefixSum);
        
        minSlice[0] = 0;
        minSlice[1] = 1;
        minSliceAvg = calculateSliceSum(0, 1, prefixSum) / 2.0;
        double cand_slice_avg;
        int p=0;
        int q=2;
        int counter = 1;
        while( q < N) {
            currSliceAvg = calculateSliceSum(p, q, prefixSum) / (q - p + 1.0);
            if(currSliceAvg < minSliceAvg) {
               minSlice[0] = p;
               minSlice[1] = q;
               minSliceAvg = currSliceAvg;
            }
            cand_slice_avg = calculateSliceSum(q -1, q, prefixSum) / (2.0);
            if(cand_slice_avg < minSliceAvg) {
                minSliceAvg = cand_slice_avg;
                minSlice[0] = p = q-1;
                minSlice[1] = q;
            } 
            q++;
            
        }
        //System.out.format("minSlice=[%d,%d], minSliceAvg=%f", minSlice[0],minSlice[1], minSliceAvg);
        //System.out.format("\n%d",calculateSliceSum(1,4, prefixSum));
        //return 0;
        return minSlice[0];
        
    }
    
    private void printPrefixArr(int[] arr) {
        System.out.println("arr");
        for(int pre: arr){
            System.out.format("%d,",pre);
        }
    }
    
    private int calculateSliceSum(int p, int q, int[] sliceArr) {
        // 0 <= p < q <= N 
        // moved by one, slicedArr is starting at 0 and ending at N +1
        return sliceArr[q+1] - sliceArr[p]; 
    }