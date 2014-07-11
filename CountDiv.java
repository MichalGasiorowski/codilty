class Solution {
    public int solution(int A, int B, int K) {
        // write your code in Java SE 8
        if( K == 1)
            return B - A + 1; 
        if ( A == B )
            return (A % K == 0) ? 1 : 0;
        int A_t=A, B_t=B;
        if(A % K != 0) {
            A_t = ((int)A/K + 1) * K;
        }
        if(B % K != 0) {
            B_t = ((int)B/K) * K;
        }
        //System.out.format("\nA=%d, A_t=%d, B=%d, B_t=%d", A, A_t, B, B_t);
        if( B_t < A_t )
            return 0;
        return (int)( ( B_t - A_t ) / (1.0*K) + 1 );
    }
}