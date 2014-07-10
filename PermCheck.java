class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        int[] perm = new int[N];
        
        for(int i = 0; i < N; i++) {
            \\System.out.format("\nA[%d]=%d", i, A[i]);
            if( A[i]  >= N + 1 || A[i] <= 0 || perm[A[i] - 1] != 0 )
                return 0;
            perm[A[i] - 1] = A[i];
        }
        return 1;
    }
}