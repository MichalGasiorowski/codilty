class Solution {
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        
        int[] fallen = new int[X + 1];
        int early_time = 0;
        int filled_pos = 0;
        for(int i = 0; i<N; i++) {
            if(fallen[A[i]] == 0) {// this is first time this leave falls
                filled_pos++;
            }
            fallen[A[i]] += 1;
            //System.out.format("\nA[%d]=%d\tfallen[%d]=%d", i, A[i], A[i], fallen[A[i]] );
            if(filled_pos == X)
                return i;
        }
        return -1;
    }
}