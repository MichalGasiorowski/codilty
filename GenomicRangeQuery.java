class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        int N = S.length();
        int M = P.length;
        
        int[][] counter_arr = new int[N+1][];
        int[] impact_arr = new int[M];
        
        counter_arr[0] = new int[4];
        
        //compute prefix array
        for(int i=1; i<N+1 ;i++) {
           counter_arr[i] = calcArr(S.charAt(i-1));
           addPrevArr(counter_arr[i-1], counter_arr[i]);
        }
        //print_counter(counter_arr);
        
        for(int k=0; k<M ;k++) {
            //System.out.format("\nk=%d, P[k]=%d, Q[k]=%d",k,P[k],Q[k]);
            if(P[k] == Q[k]) { impact_arr[k] = factor(S.charAt(P[k])); }
            else { impact_arr[k] = calcMinImpact(P[k]+1, Q[k]+1, counter_arr); }     
        }
        return impact_arr;
    }
    
    private int factor(char c) {
        switch(c) {
            case 'A':
                return 1;
            case 'C':
                return 2;
            case 'G':
                return 3;
            case 'T':
                return 4;
            default:
                return 1;
        }
    }
    
    private int[] calcArr(char c) {
        int[] arr = new int[4];
        arr[factor(c) - 1] = 1;
        return arr;
    }
    
    private void addPrevArr(int[] prev, int[] curr) {
        curr[0] = prev[0] + curr[0];
        curr[1] = prev[1] + curr[1];
        curr[2] = prev[2] + curr[2];
        curr[3] = prev[3] + curr[3];
    }
    
    private int calcMinImpact(int pk, int qk, int[][] counter_arr) {
        // pk < qk
        for(int i =0;i<4;i++) {
            //System.out.format("\n\tpk=%d, qk=%d, i=%d, a_arr_p=%d, a_arr_q=%d", pk, qk, i, counter_arr[pk][i], counter_arr[qk][i]);
            
            if(counter_arr[pk][i] < counter_arr[qk][i] || counter_arr[pk-1][i] < counter_arr[pk][i] ) {
                //System.out.format(" counter_arr[pk][i] < counter_arr[qk][i] ! %d, %d", counter_arr[pk][i] , counter_arr[qk][i]);
                //System.out.format(" returning %d", i + 1);
                return i + 1;
            }
        }
        return 4;
        
    }
    
    private void print_counter(int[][] counter_arr) {
        for (int i=0;i<counter_arr.length;i++) {
            System.out.format("\ncounter_arr[%d]= [%d, %d, %d, %d] ", i,counter_arr[i][0], counter_arr[i][1], counter_arr[i][2], counter_arr[i][3]);
        }
    }
}