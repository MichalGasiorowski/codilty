class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        int[] ret_candidates = new int[N + 1];
        int min_positive_value = Integer.MAX_VALUE;
        int max_val = 1;
        int el;
        /*
        for(int i = 0; i < N; i++) {
            el = A[i];
            System.out.format("\ni=%d el=%d", i, el);
            if(el > 0 && el < N) {
                ret_candidates[el] = 1;
                min_positive_value = Math.min(min_positive_value, el);
                max_val = Math.max(max_val, el);
            }
        }
        System.out.format("min_positive_value:%d, max_val:%d\n", min_positive_value, max_val); 
        for(int i = 1; i < N + 1; i++) {
           System.out.println(ret_candidates[i]); 
        }
        
        if(min_positive_value > 1) {
            for(int i = min_positive_value -1; i > 0 ; i--) {
                if(ret_candidates[i] == 0) {
                    return i+1;
                }
            }
        } else {
            for(int i = min_positive_value + 1; i < max_val; i++) {
                if(ret_candidates[i] == 0) {
                    return i+1;
                }
            }
        }
        return N;
        */
        for(int i = 0; i < N; i++) {
            el = A[i];
            //System.out.format("\ni=%d el=%d", i, el);
            if(el > 0 && el < N + 1) {
                ret_candidates[el] = 1;
                min_positive_value = Math.min(min_positive_value, el);
                max_val = Math.max(max_val, el);
            }
        }
        if(min_positive_value == Integer.MAX_VALUE) {
            return 1;
        }
        for(int i = 1; i < N; i++ ) {
            if(ret_candidates[i] == 0) {
                return i;
            }
        }
        
        return max_val + 1;
    }
}