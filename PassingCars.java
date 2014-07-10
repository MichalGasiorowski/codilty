class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        final int MAX_PASSING = 1000000000; 
        int N = A.length;
        int num_passing = 0;
        
        A[0] = flip(A[0]);
        for(int i=1; i < N; i++) {
            //in A[i-1] is number of cars passing EAST
            if(A[i] == 1) { // car passing WEST is meeting with A[i-1] cars going EAST
                num_passing += A[i-1];
            }
            A[i] = A[i-1] + flip(A[i]); // if passing EAST it increments
            if(num_passing > MAX_PASSING) return -1;
        }
        return num_passing;
     
    }
    
    private int flip(int a) {
        return (a == 0) ? 1 : 0;
    }
}